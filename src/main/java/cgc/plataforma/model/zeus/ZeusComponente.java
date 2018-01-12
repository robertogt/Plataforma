/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.model.zeus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ejmorales
 */
@Entity
@Table(name = "ZEUS_COMPONENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZeusComponente.findAll", query = "SELECT z FROM ZeusComponente z")
    , @NamedQuery(name = "ZeusComponente.findByComponente", query = "SELECT z FROM ZeusComponente z WHERE z.componente = :componente")
    , @NamedQuery(name = "ZeusComponente.findByTipoComponente", query = "SELECT z FROM ZeusComponente z WHERE z.tipoComponente = :tipoComponente")
    , @NamedQuery(name = "ZeusComponente.findByNombreFisico", query = "SELECT z FROM ZeusComponente z WHERE z.nombreFisico = :nombreFisico")
    , @NamedQuery(name = "ZeusComponente.findByDescripcion", query = "SELECT z FROM ZeusComponente z WHERE z.descripcion = :descripcion")
    , @NamedQuery(name = "ZeusComponente.findByEstado", query = "SELECT z FROM ZeusComponente z WHERE z.estado = :estado")
    , @NamedQuery(name = "ZeusComponente.findByPath", query = "SELECT z FROM ZeusComponente z WHERE z.path = :path")
    , @NamedQuery(name = "ZeusComponente.findByUrl", query = "SELECT z FROM ZeusComponente z WHERE z.url = :url")
    , @NamedQuery(name = "ZeusComponente.findByUsuarioIngresa", query = "SELECT z FROM ZeusComponente z WHERE z.usuarioIngresa = :usuarioIngresa")
    , @NamedQuery(name = "ZeusComponente.findByFechaIngresa", query = "SELECT z FROM ZeusComponente z WHERE z.fechaIngresa = :fechaIngresa")})
public class ZeusComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPONENTE")
    private BigDecimal componente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPO_COMPONENTE")
    private String tipoComponente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "NOMBRE_FISICO")
    private String nombreFisico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 500)
    @Column(name = "PATH")
    private String path;
    @Size(max = 500)
    @Column(name = "URL")
    private String url;
    @Size(max = 50)
    @Column(name = "USUARIO_INGRESA")
    private String usuarioIngresa;
    @Column(name = "FECHA_INGRESA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresa;
    @OneToMany(mappedBy = "componente")
    private List<ZeusMenu> zeusMenuList;
    @JoinColumn(name = "PROYECTO", referencedColumnName = "PROYECTO")
    @ManyToOne
    private ZeusProyecto proyecto;

    public ZeusComponente() {
    }

    public ZeusComponente(BigDecimal componente) {
        this.componente = componente;
    }

    public ZeusComponente(BigDecimal componente, String tipoComponente, String nombreFisico, String descripcion) {
        this.componente = componente;
        this.tipoComponente = tipoComponente;
        this.nombreFisico = nombreFisico;
        this.descripcion = descripcion;
    }

    public BigDecimal getComponente() {
        return componente;
    }

    public void setComponente(BigDecimal componente) {
        this.componente = componente;
    }

    public String getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(String tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public String getNombreFisico() {
        return nombreFisico;
    }

    public void setNombreFisico(String nombreFisico) {
        this.nombreFisico = nombreFisico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuarioIngresa() {
        return usuarioIngresa;
    }

    public void setUsuarioIngresa(String usuarioIngresa) {
        this.usuarioIngresa = usuarioIngresa;
    }

    public Date getFechaIngresa() {
        return fechaIngresa;
    }

    public void setFechaIngresa(Date fechaIngresa) {
        this.fechaIngresa = fechaIngresa;
    }

    @XmlTransient
    public List<ZeusMenu> getZeusMenuList() {
        return zeusMenuList;
    }

    public void setZeusMenuList(List<ZeusMenu> zeusMenuList) {
        this.zeusMenuList = zeusMenuList;
    }

    public ZeusProyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(ZeusProyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (componente != null ? componente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZeusComponente)) {
            return false;
        }
        ZeusComponente other = (ZeusComponente) object;
        if ((this.componente == null && other.componente != null) || (this.componente != null && !this.componente.equals(other.componente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cgc.plataforma.model.zeus.ZeusComponente[ componente=" + componente + " ]";
    }
    
}
