/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.pojo;

import java.io.Serializable;

/**
 *
 * @author ejmorales
 */
public class InfoUsuario implements Serializable{
    
    private String usuario;
    private String nombreEmpleado;
    private String imgUrl;
    private String puestoEmpleado;
    private String fechaAlta;
    private String status;
    private String statusIcon;

    public InfoUsuario() {
    }
  
    public InfoUsuario(String usuario, String nombreEmpleado,String imgUrl,
            String puestoEmpleado,String fechaAlta) {
        this.usuario = usuario;
        this.nombreEmpleado = nombreEmpleado;
        
        if(imgUrl != null){
            this.imgUrl = "data:image/jpg;base64," + imgUrl;
        }else{
            this.imgUrl = "assets/img/icon-user-default.png";
        }
        
        this.puestoEmpleado = puestoEmpleado;
        this.fechaAlta = fechaAlta;
        this.status = "Online";
        this.statusIcon = "fa fa-circle text-success";
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getPuestoEmpleado() {
        return puestoEmpleado;
    }

    public void setPuestoEmpleado(String puestoEmpleado) {
        this.puestoEmpleado = puestoEmpleado;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusIcon() {
        return statusIcon;
    }

    public void setStatusIcon(String statusIcon) {
        this.statusIcon = statusIcon;
    }
    
    
            
    
}
