/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ejmorales
 */
public class JsonMenu implements Serializable{
    
    private Integer menu;
    private String etiqueta;
    private String path;
    private String nombreFisico;
    private Integer hoja;
    private String leftIcon;
    private String leftActiveIcon;
    private String rightIcon;
    private String rightActiveIcon;
    private String type;
    private boolean isActive;
    private String imgIcon;
    private ArrayList<JsonMenu> data; 

    public JsonMenu() {
    }
    
    public JsonMenu(Integer menu, String etiqueta, String path,
            String nombreFisico, Integer hoja, String leftIcon, String leftActiveIcon,
            String rightIcon,String rightActiveIcon, String type,
            boolean isActive,String imgIcon, ArrayList<JsonMenu> data) {
        this.menu = menu;
        this.etiqueta = etiqueta;
        this.path = path;
        this.nombreFisico = nombreFisico;
        this.hoja = hoja;
        this.leftIcon = leftIcon;
        this.leftActiveIcon = leftActiveIcon;
        this.rightIcon = rightIcon;
        this.rightActiveIcon = rightActiveIcon;
        this.type = type;
        this.isActive = isActive;
        if(imgIcon != null){
            this.imgIcon = "data:image/jpg;base64," + imgIcon;
        }else if (imgIcon == null) {
            this.imgIcon = "assets/img/77.png";
        }else{
            this.imgIcon = null;
        }        
        this.data = data;
    }

    public Integer getMenu() {
        return menu;
    }

    public void setMenu(Integer menu) {
        this.menu = menu;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public ArrayList<JsonMenu> getData() {
        return data;
    }

    public void setData(ArrayList<JsonMenu> data) {
        this.data = data;
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

    public Integer getHoja() {
        return hoja;
    }

    public void setHoja(Integer hoja) {
        this.hoja = hoja;
    }

    public String getLeftIcon() {
        return leftIcon;
    }

    public void setLeftIcon(String leftIcon) {
        this.leftIcon = leftIcon;
    }

    public String getRightIcon() {
        return rightIcon;
    }

    public void setRightIcon(String rightIcon) {
        this.rightIcon = rightIcon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLeftActiveIcon() {
        return leftActiveIcon;
    }

    public void setLeftActiveIcon(String leftActiveIcon) {
        this.leftActiveIcon = leftActiveIcon;
    }

    public String getRightActiveIcon() {
        return rightActiveIcon;
    }

    public void setRightActiveIcon(String rightActiveIcon) {
        this.rightActiveIcon = rightActiveIcon;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getImgIcon() {
        return imgIcon;
    }

    public void setImgIcon(String imgIcon) {
        this.imgIcon = imgIcon;
    }
    
    
    
}
