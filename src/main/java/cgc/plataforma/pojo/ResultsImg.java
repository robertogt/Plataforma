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
public class ResultsImg {
    
    private BigDecimal idImagen;
    private byte[] archivoImg;

    public ResultsImg() {
    }
    
    public ResultsImg(BigDecimal idImagen, byte[] archivoImg) {
        this.idImagen = idImagen;
        this.archivoImg = archivoImg;
    }

    public BigDecimal getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(BigDecimal idImagen) {
        this.idImagen = idImagen;
    }

    public byte[] getArchivoImg() {
        return archivoImg;
    }

    public void setArchivoImg(byte[] archivoImg) {
        this.archivoImg = archivoImg;
    }
    
    
    
}
