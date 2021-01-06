/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Tilted-Shugar
 */
@Entity
@PrimaryKeyJoinColumn(name="id_Usuario")
@DiscriminatorValue("S")
public class Socio extends Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id_Socio", length=30, nullable=false)
    private Long id_Socio;
    private String dni;
    @Column(name = "nombre", nullable = false, length=30)
    private String nombre;
    @Column(name = "apellidos", nullable = false, length=30)
    private String apellidos;
    private String grupo;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fecha_nacimiento;
    @Column(name = "sexo", nullable = false)
    private String sexo;
    @Column(name = "direccion", nullable = false, length=30)
    private String direccion;
    @Column(name = "telefono", nullable = false, length=10)
    private Integer telefono;
    @Column(name = "telefono_movil", nullable = false, length=10)
    private Integer telefono_movil;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ingreso", nullable = false)
    private Date fecha_ingreso;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_baja")
    private Date fecha_baja;
    private String cargo;
    private String ambito;
    private String info_tutores;
    @Temporal(TemporalType.DATE)
    private Date fecha_firma;


//--NACHO    
    @OneToMany(mappedBy="socio")
    private List <Transaccion> transacciones;
    
    @OneToMany(mappedBy="socio")
    private List <Pago_Cuota> pago_cuotas;

//--BROJA
    @ManyToMany(mappedBy = "asistentes")
    private List <Evento> asistentes;
    
    @ManyToMany(mappedBy = "inscritos")
    private List <Evento> inscritos;
    
    @ManyToOne
    private Seccion seccion;
    
    @OneToMany(mappedBy="socio")
    private List <Notificacion_Evento> notificacionEvento;
//--
    @OneToMany(mappedBy="socio")
    private List <Entrada_Calendario> entradaCalendarios;
    @OneToMany(mappedBy="socio")
    private List <Documento> documentos;
    @OneToMany(mappedBy="socio")
    private List <Pago_Evento> pago_eventos;
    @OneToMany(mappedBy="socio")
    private List <Notificacion_Documento> notificacionDocumento;
    @OneToMany(mappedBy="socio")
    private List <Comentario> comentario;

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public List<Pago_Cuota> getPago_cuotas() {
        return pago_cuotas;
    }

    public void setPago_cuotas(List<Pago_Cuota> pago_cuotas) {
        this.pago_cuotas = pago_cuotas;
    }

    public List<Evento> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Evento> asistentes) {
        this.asistentes = asistentes;
    }

    public List<Evento> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<Evento> inscritos) {
        this.inscritos = inscritos;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public List<Notificacion_Evento> getNotificacionEvento() {
        return notificacionEvento;
    }

    public void setNotificacionEvento(List<Notificacion_Evento> notificacionEvento) {
        this.notificacionEvento = notificacionEvento;
    }

    public List<Entrada_Calendario> getEntradaCalendarios() {
        return entradaCalendarios;
    }

    public void setEntradaCalendarios(List<Entrada_Calendario> entradaCalendarios) {
        this.entradaCalendarios = entradaCalendarios;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<Pago_Evento> getPago_eventos() {
        return pago_eventos;
    }

    public void setPago_eventos(List<Pago_Evento> pago_eventos) {
        this.pago_eventos = pago_eventos;
    }

    public List<Notificacion_Documento> getNotificacionDocumento() {
        return notificacionDocumento;
    }

    public void setNotificacionDocumento(List<Notificacion_Documento> notificacionDocumento) {
        this.notificacionDocumento = notificacionDocumento;
    }

    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }

    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(Integer telefono_movil) {
        this.telefono_movil = telefono_movil;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getInfo_tutores() {
        return info_tutores;
    }

    public void setInfo_tutores(String info_tutores) {
        this.info_tutores = info_tutores;
    }

    public Date getFecha_firma() {
        return fecha_firma;
    }

    public void setFecha_firma(Date fecha_firma) {
        this.fecha_firma = fecha_firma;
    }
    
    public Long getId_Socio() {
        return id_Socio;
    }

    public void setId_Socio(Long id_Socio) {
        this.id_Socio = id_Socio;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        return super.equals(object);
    }

    @Override
    public String toString() {
        return "entrega_1.Socio[ id_usuario=" + getId_Usuario() + ", id_socio=" + id_Socio + " ]";
    }
    
}
