/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.EventoFacadeLocal;
import com.softbox.ejb.Notificacion_EventoFacadeLocal;
import com.softbox.ejb.SocioFacadeLocal;
import com.softbox.entity.Evento;
import com.softbox.entity.Notificacion_Evento;
import com.softbox.entity.Seccion;
import com.softbox.entity.Socio;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import javax.inject.Inject;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Borja Delgado
 */
@Named(value = "eventosBB")
@SessionScoped
public class eventosBB implements Serializable {

    private Evento evento = new Evento();
    
    @Inject
    private EventoFacadeLocal eventoEJB;
    
    @Inject
    private SocioFacadeLocal socioEJB;
    
    @Inject
    private Notificacion_EventoFacadeLocal notEJB;
    
    @Inject
    private notificacionesBB notifBB;

    /**
     * Creates a new instance of sociosBB
     */
    public eventosBB() {
    }

    public List<Evento> getEventos() {
        return eventoEJB.findAll();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    //Accede a la vista de creación de eventos
    public String newEvento() {
        evento = new Evento();
        Seccion seccion = new Seccion();
        evento.setSeccion(seccion);
        return "crearEvento.xhtml";
    }

    //Crea el evento con los datos proporcionado en la vista de creación
    public String createEvento() {
        evento.setId_evento(eventoEJB.getNextId());
        Long id_Seccion = evento.getSeccion().getId_seccion();

        eventoEJB.crear(evento);
        
            List<Socio> socios= socioEJB.findAll();
            if(!socios.isEmpty()){
                
                for(Socio soc : socios){
                    if(Objects.equals(soc.getSeccion().getId_seccion(), id_Seccion)){
                        Notificacion_Evento notif = new Notificacion_Evento();
                        notif.setSocio(soc);
                        notif.setFechaNotificacion(Date.valueOf(LocalDate.now()));
                        notif.setEstado("False");
                        notif.setEvento(evento);
                        notEJB.create(notif);
                    }

    
                }                
            }

        
        return "listarEventos.xhtml";
    }

    public String modEvento(Evento soc) {
        evento = soc;
        return "modificarEvento.xhtml";
    }
    
    public String updateEvento() {
        eventoEJB.modificar(evento);
        return "listarEventos.xhtml";
    }

    public String readEvento(Evento soc) {
        evento = soc;
        return "consultarEvento.xhtml";
    }

    public String deleteEvento(Evento soc) {
        eventoEJB.borrar(soc);
        return "listarEventos.xhtml";
    }

 public String getDireccionDescarga(int modo) throws UnsupportedEncodingException {
        String nombreArchivo = "";
        if (modo == 0) {
            nombreArchivo = "Asistentes.xlsx";
        } else {
            nombreArchivo = "Inscritos.xlsx";
        }
        eventosBB demo = new eventosBB();
        String path2 = demo.getClass().getResource("").getPath();
        String fullPath = URLDecoder.decode(path2, "UTF-8");

        //String pathArr[] = fullPath.split("/WEB-INF/classes/backingBeans/");
        String pathArr[] = fullPath.split("/GrupoSA-ear/target/gfdeploy/GrupoSA-ear/GrupoSA-web-1.0-SNAPSHOT_war/WEB-INF/classes/com/softbox/backingBeans/");
        fullPath = pathArr[0];

        String reponsePath = "";
        //reponsePath = new File(fullPath).getPath() + File.separatorChar + "resources"+File.separatorChar+nombreArchivo;
        reponsePath = new File(fullPath).getPath() + File.separatorChar + "GrupoSA-web" + File.separatorChar + "src" + File.separatorChar + "main" + File.separatorChar + "webapp" + File.separatorChar + "resources" + File.separatorChar + nombreArchivo;
        return reponsePath;
    }

    public void descargaEvento(Evento evento, int modo) throws UnsupportedEncodingException, IOException {
        String FILE_NAME = getDireccionDescarga(modo);

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet;
        List<Socio> socios;
        if (modo == 0) {
            sheet = workbook.createSheet("Asistentes");
            socios = evento.getAsistentes();
        } else {
            sheet = workbook.createSheet("Inscritos");
            socios = evento.getInscritos();
        }
        int rowNum = 0;

        Row rowInicial = sheet.createRow(rowNum++);
        Cell cellInicial = rowInicial.createCell(0);
        cellInicial.setCellValue("ID_SOCIO");

        cellInicial = rowInicial.createCell(1);
        cellInicial.setCellValue("NOMBRE");

        cellInicial = rowInicial.createCell(2);
        cellInicial.setCellValue("APELLIDOS");

        if (socios != null) {
            for (Socio socio : socios) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;

                Cell cell = row.createCell(colNum++);
                cell.setCellValue(socio.getId_Socio());

                cell = row.createCell(colNum++);
                cell.setCellValue(socio.getNombre());

                cell = row.createCell(colNum++);
                cell.setCellValue(socio.getApellidos());
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context
                .getExternalContext().getResponse();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        int tamaño=10240;
        response.reset();
        response.setBufferSize(tamaño);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "attachment;filename=\""
                + evento.getNombre()+file.getName() + "\"");
        BufferedInputStream input = null;
        BufferedOutputStream output = null;
        try {
            input = new BufferedInputStream(new FileInputStream(file),
                    tamaño);
            output = new BufferedOutputStream(response.getOutputStream(),
                    tamaño);
            byte[] buffer = new byte[tamaño];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } finally {
            input.close();
            output.close();
        }
        context.responseComplete();
    }
}