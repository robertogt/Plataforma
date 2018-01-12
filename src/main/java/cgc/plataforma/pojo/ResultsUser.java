/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.pojo;

import java.math.BigDecimal;

/**
 *
 * @author ejmorales
 */
public class ResultsUser {
    
    private BigDecimal rue;
    private String fechaActivo;
    private String nombre;
    private String puestoFuncional;

    public ResultsUser() {
    }
    
    public ResultsUser(BigDecimal rue, String fechaActivo, String nombre,
            String puestoFuncional) {
        this.rue = rue;
        this.fechaActivo = fechaActivo;
        this.nombre = nombre;
        this.puestoFuncional = puestoFuncional;
    }

    public BigDecimal getRue() {
        return rue;
    }

    public void setRue(BigDecimal rue) {
        this.rue = rue;
    }

    public String getFechaActivo() {
        return fechaActivo;
    }

    public void setFechaActivo(String fechaActivo) {
        this.fechaActivo = fechaActivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuestoFuncional() {
        return puestoFuncional;
    }

    public void setPuestoFuncional(String puestoFuncional) {
        this.puestoFuncional = puestoFuncional;
    }
    
    
}
