/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luisf
 */
public class Cliente {
    private Integer id;
    private String nombres_razonsocial;
    private String tipo_documentoidentidad;
    private String numero_documentoidentidad;
    private String direccion;
    private String pais;
    private String email;
    private String telefono;    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres_razonsocial() {
        return nombres_razonsocial;
    }

    public void setNombres_razonsocial(String nombres_razonsocial) {
        this.nombres_razonsocial = nombres_razonsocial;
    }

    public String getTipo_documentoidentidad() {
        return tipo_documentoidentidad;
    }

    public void setTipo_documentoidentidad(String tipo_documentoidentidad) {
        this.tipo_documentoidentidad = tipo_documentoidentidad;
    }

    public String getNumero_documentoidentidad() {
        return numero_documentoidentidad;
    }

    public void setNumero_documentoidentidad(String numero_documentoidentidad) {
        this.numero_documentoidentidad = numero_documentoidentidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cliente() {
    }
}
