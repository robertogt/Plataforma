/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author ejmorales
 */
public class ResultsMenu implements Serializable{
    
    private BigDecimal menu;
    private BigDecimal menuPadre;
    private String etiqueta;
    private String path;
    private String nombreFisico;
    private BigDecimal nivel;
    private BigDecimal orden;
    private BigDecimal hoja;

    public ResultsMenu() {
    }
        
    public ResultsMenu(BigDecimal menu, BigDecimal menuPadre,
            String etiqueta, String path, String nombreFisico,
            BigDecimal nivel, BigDecimal orden, BigDecimal hoja) {
        this.menu = menu;
        this.menuPadre = menuPadre;
        this.etiqueta = etiqueta;
        this.path = path;
        this.nombreFisico = nombreFisico;
        this.nivel = nivel;
        this.orden = orden;
        this.hoja = hoja;
    }

    public BigDecimal getOrden() {
        return orden;
    }

    public void setOrden(BigDecimal orden) {
        this.orden = orden;
    }
  
    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNombreFisico() {
        return nombreFisico;
    }

    public void setNombreFisico(String nombreFisico) {
        this.nombreFisico = nombreFisico;
    }

    public BigDecimal getMenu() {
        return menu;
    }

    public void setMenu(BigDecimal menu) {
        this.menu = menu;
    }

    public BigDecimal getMenuPadre() {
        return menuPadre;
    }

    public void setMenuPadre(BigDecimal menuPadre) {
        this.menuPadre = menuPadre;
    }

    public BigDecimal getNivel() {
        return nivel;
    }

    public void setNivel(BigDecimal nivel) {
        this.nivel = nivel;
    }

    public BigDecimal getHoja() {
        return hoja;
    }

    public void setHoja(BigDecimal hoja) {
        this.hoja = hoja;
    }

    
    
    
}
