/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.pojo;

/**
 *
 * @author ejmorales
 */
public class ResultsLaboralRue {
    
    private Integer idRue;
    private Integer renglon;

    public ResultsLaboralRue() {
    }

    public ResultsLaboralRue(Integer idRue, Integer renglon) {
        this.idRue = idRue;
        this.renglon = renglon;
    }

    public Integer getIdRue() {
        return idRue;
    }

    public void setIdRue(Integer idRue) {
        this.idRue = idRue;
    }

    public Integer getRenglon() {
        return renglon;
    }

    public void setRenglon(Integer renglon) {
        this.renglon = renglon;
    }
    
    
   
    
}
