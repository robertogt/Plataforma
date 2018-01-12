/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.model.zeus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "ZEUS_PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZeusProyecto.findAll", query = "SELECT z FROM ZeusProyecto z")
    , @NamedQuery(name = "ZeusProyecto.findByProyecto", query = "SELECT z FROM ZeusProyecto z WHERE z.proyecto = :proyecto")
    , @NamedQuery(name = "ZeusProyecto.findByNombre", query = "SELECT z FROM ZeusProyecto z WHERE z.nombre = :nombre")
    , @NamedQuery(name = "ZeusProyecto.findByDescripcion", query = "SELECT z FROM ZeusProyecto z WHERE z.descripcion = :descripcion")
    , @NamedQuery(name = "ZeusProyecto.findByResponsable", query = "SELECT z FROM ZeusProyecto z WHERE z.responsable = :responsable")
    , @NamedQuery(name = "ZeusProyecto.findByProyectoPadre", query = "SELECT z FROM ZeusProyecto z WHERE z.proyectoPadre = :proyectoPadre")
    , @NamedQuery(name = "ZeusProyecto.findByEstado", query = "SELECT z FROM ZeusProyecto z WHERE z.estado = :estado")
    , @NamedQuery(name = "ZeusProyecto.findByUsuarioIngresa", query = "SELECT z FROM ZeusProyecto z WHERE z.usuarioIngresa = :usuarioIngresa")
    , @NamedQuery(name = "ZeusProyecto.findByFechaIngresa", query = "SELECT z FROM ZeusProyecto z WHERE z.fechaIngresa = :fechaIngresa")})
public class ZeusProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROYECTO")
    private BigDecimal proyecto;
    @Size(max = 500)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 4000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "RESPONSABLE")
    private String responsable;
    @Column(name = "PROYECTO_PADRE")
    private BigInteger proyectoPadre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 50)
    @Column(name = "USUARIO_INGRESA")
    private String usuarioIngresa;
    @Column(name = "FECHA_INGRESA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresa;
    @OneToMany(mappedBy = "proyecto")
    private List<ZeusPerfil> zeusPerfilList;
    @OneToMany(mappedBy = "proyecto")
    private List<ZeusRole> zeusRoleList;
    @OneToMany(mappedBy = "proyecto")
    private List<ZeusComponente> zeusComponenteList;

    public ZeusProyecto() {
    }

    public ZeusProyecto(BigDecimal proyecto) {
        this.proyecto = proyecto;
    }

    public ZeusProyecto(BigDecimal proyecto, String estado) {
        this.proyecto = proyecto;
        this.estado = estado;
    }

    public BigDecimal getProyecto() {
        return proyecto;
    }

    public void setProyecto(BigDecimal proyecto) {
        this.proyecto = proyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public BigInteger getProyectoPadre() {
        return proyectoPadre;
    }

    public void setProyectoPadre(BigInteger proyectoPadre) {
        this.proyectoPadre = proyectoPadre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
    public List<ZeusPerfil> getZeusPerfilList() {
        return zeusPerfilList;
    }

    public void setZeusPerfilList(List<ZeusPerfil> zeusPerfilList) {
        this.zeusPerfilList = zeusPerfilList;
    }

    @XmlTransient
    public List<ZeusRole> getZeusRoleList() {
        return zeusRoleList;
    }

    public void setZeusRoleList(List<ZeusRole> zeusRoleList) {
        this.zeusRoleList = zeusRoleList;
    }

    @XmlTransient
    public List<ZeusComponente> getZeusComponenteList() {
        return zeusComponenteList;
    }

    public void setZeusComponenteList(List<ZeusComponente> zeusComponenteList) {
        this.zeusComponenteList = zeusComponenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyecto != null ? proyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZeusProyecto)) {
            return false;
        }
        ZeusProyecto other = (ZeusProyecto) object;
        if ((this.proyecto == null && other.proyecto != null) || (this.proyecto != null && !this.proyecto.equals(other.proyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cgc.plataforma.model.zeus.ZeusProyecto[ proyecto=" + proyecto + " ]";
    }
    
}
