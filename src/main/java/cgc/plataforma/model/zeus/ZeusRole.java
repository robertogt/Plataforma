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
@Table(name = "ZEUS_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZeusRole.findAll", query = "SELECT z FROM ZeusRole z")
    , @NamedQuery(name = "ZeusRole.findByRole", query = "SELECT z FROM ZeusRole z WHERE z.role = :role")
    , @NamedQuery(name = "ZeusRole.findByNombre", query = "SELECT z FROM ZeusRole z WHERE z.nombre = :nombre")
    , @NamedQuery(name = "ZeusRole.findByEstado", query = "SELECT z FROM ZeusRole z WHERE z.estado = :estado")
    , @NamedQuery(name = "ZeusRole.findByUsuarioIngresa", query = "SELECT z FROM ZeusRole z WHERE z.usuarioIngresa = :usuarioIngresa")
    , @NamedQuery(name = "ZeusRole.findByFechaIngresa", query = "SELECT z FROM ZeusRole z WHERE z.fechaIngresa = :fechaIngresa")})
public class ZeusRole implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE")
    private BigDecimal role;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zeusRole")
    private List<ZeusPerfilRole> zeusPerfilRoleList;
    @JoinColumn(name = "PROYECTO", referencedColumnName = "PROYECTO")
    @ManyToOne
    private ZeusProyecto proyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zeusRole")
    private List<ZeusRoleMenu> zeusRoleMenuList;

    public ZeusRole() {
    }

    public ZeusRole(BigDecimal role) {
        this.role = role;
    }

    public BigDecimal getRole() {
        return role;
    }

    public void setRole(BigDecimal role) {
        this.role = role;
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

    @XmlTransient
    public List<ZeusPerfilRole> getZeusPerfilRoleList() {
        return zeusPerfilRoleList;
    }

    public void setZeusPerfilRoleList(List<ZeusPerfilRole> zeusPerfilRoleList) {
        this.zeusPerfilRoleList = zeusPerfilRoleList;
    }

    public ZeusProyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(ZeusProyecto proyecto) {
        this.proyecto = proyecto;
    }

    @XmlTransient
    public List<ZeusRoleMenu> getZeusRoleMenuList() {
        return zeusRoleMenuList;
    }

    public void setZeusRoleMenuList(List<ZeusRoleMenu> zeusRoleMenuList) {
        this.zeusRoleMenuList = zeusRoleMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (role != null ? role.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZeusRole)) {
            return false;
        }
        ZeusRole other = (ZeusRole) object;
        if ((this.role == null && other.role != null) || (this.role != null && !this.role.equals(other.role))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cgc.plataforma.model.zeus.ZeusRole[ role=" + role + " ]";
    }
    
}
