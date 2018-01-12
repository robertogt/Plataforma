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
import javax.persistence.CascadeType;
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
@Table(name = "ZEUS_PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZeusPerfil.findAll", query = "SELECT z FROM ZeusPerfil z")
    , @NamedQuery(name = "ZeusPerfil.findByPerfil", query = "SELECT z FROM ZeusPerfil z WHERE z.perfil = :perfil")
    , @NamedQuery(name = "ZeusPerfil.findByNombre", query = "SELECT z FROM ZeusPerfil z WHERE z.nombre = :nombre")
    , @NamedQuery(name = "ZeusPerfil.findByEstado", query = "SELECT z FROM ZeusPerfil z WHERE z.estado = :estado")
    , @NamedQuery(name = "ZeusPerfil.findByUsuarioIngresa", query = "SELECT z FROM ZeusPerfil z WHERE z.usuarioIngresa = :usuarioIngresa")
    , @NamedQuery(name = "ZeusPerfil.findByFechaIngresa", query = "SELECT z FROM ZeusPerfil z WHERE z.fechaIngresa = :fechaIngresa")})
public class ZeusPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERFIL")
    private BigDecimal perfil;
    @Size(max = 500)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 50)
    @Column(name = "USUARIO_INGRESA")
    private String usuarioIngresa;
    @Column(name = "FECHA_INGRESA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresa;
    @JoinColumn(name = "PROYECTO", referencedColumnName = "PROYECTO")
    @ManyToOne
    private ZeusProyecto proyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zeusPerfil")
    private List<ZeusPerfilRole> zeusPerfilRoleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zeusPerfil")
    private List<ZeusPerfilUsuario> zeusPerfilUsuarioList;

    public ZeusPerfil() {
    }

    public ZeusPerfil(BigDecimal perfil) {
        this.perfil = perfil;
    }

    public BigDecimal getPerfil() {
        return perfil;
    }

    public void setPerfil(BigDecimal perfil) {
        this.perfil = perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public ZeusProyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(ZeusProyecto proyecto) {
        this.proyecto = proyecto;
    }

    @XmlTransient
    public List<ZeusPerfilRole> getZeusPerfilRoleList() {
        return zeusPerfilRoleList;
    }

    public void setZeusPerfilRoleList(List<ZeusPerfilRole> zeusPerfilRoleList) {
        this.zeusPerfilRoleList = zeusPerfilRoleList;
    }

    @XmlTransient
    public List<ZeusPerfilUsuario> getZeusPerfilUsuarioList() {
        return zeusPerfilUsuarioList;
    }

    public void setZeusPerfilUsuarioList(List<ZeusPerfilUsuario> zeusPerfilUsuarioList) {
        this.zeusPerfilUsuarioList = zeusPerfilUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfil != null ? perfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZeusPerfil)) {
            return false;
        }
        ZeusPerfil other = (ZeusPerfil) object;
        if ((this.perfil == null && other.perfil != null) || (this.perfil != null && !this.perfil.equals(other.perfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cgc.plataforma.model.zeus.ZeusPerfil[ perfil=" + perfil + " ]";
    }
    
}
