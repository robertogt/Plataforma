/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.model.zeus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ejmorales
 */
@Entity
@Table(name = "ZEUS_BITACORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZeusBitacora.findAll", query = "SELECT z FROM ZeusBitacora z")
    , @NamedQuery(name = "ZeusBitacora.findByUsuario", query = "SELECT z FROM ZeusBitacora z WHERE z.usuario = :usuario")
    , @NamedQuery(name = "ZeusBitacora.findByFecha", query = "SELECT z FROM ZeusBitacora z WHERE z.fecha = :fecha")
    , @NamedQuery(name = "ZeusBitacora.findByMaquina", query = "SELECT z FROM ZeusBitacora z WHERE z.maquina = :maquina")
    , @NamedQuery(name = "ZeusBitacora.findByCorrelativoBitacora", query = "SELECT z FROM ZeusBitacora z WHERE z.correlativoBitacora = :correlativoBitacora")})
public class ZeusBitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 400)
    @Column(name = "MAQUINA")
    private String maquina;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "bSequence", sequenceName = "ZEUS_BITACORA_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "bSequence",strategy = GenerationType.SEQUENCE)
    @Column(name = "CORRELATIVO_BITACORA")
    private BigDecimal correlativoBitacora;
    @JoinColumn(name = "MENU", referencedColumnName = "MENU")
    @ManyToOne(optional = false)
    private ZeusMenu menu;
    @Size(max = 1)
    @Column(name = "PLATAFORMA_WEB")
    private String plataformaWeb;

    public ZeusBitacora() {
    }

    public ZeusBitacora(BigDecimal correlativoBitacora) {
        this.correlativoBitacora = correlativoBitacora;
    }

    public ZeusBitacora(BigDecimal correlativoBitacora, String usuario,String plataformaWeb) {
        this.correlativoBitacora = correlativoBitacora;
        this.usuario = usuario;
        this.plataformaWeb = plataformaWeb;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public BigDecimal getCorrelativoBitacora() {
        return correlativoBitacora;
    }

    public void setCorrelativoBitacora(BigDecimal correlativoBitacora) {
        this.correlativoBitacora = correlativoBitacora;
    }

    public ZeusMenu getMenu() {
        return menu;
    }

    public void setMenu(ZeusMenu menu) {
        this.menu = menu;
    }

    public String getPlataformaWeb() {
        return plataformaWeb;
    }

    public void setPlataformaWeb(String plataformaWeb) {
        this.plataformaWeb = plataformaWeb;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correlativoBitacora != null ? correlativoBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZeusBitacora)) {
            return false;
        }
        ZeusBitacora other = (ZeusBitacora) object;
        if ((this.correlativoBitacora == null && other.correlativoBitacora != null) || (this.correlativoBitacora != null && !this.correlativoBitacora.equals(other.correlativoBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cgc.plataforma.model.zeus.ZeusBitacora[ correlativoBitacora=" + correlativoBitacora + " ]";
    }
    
}
