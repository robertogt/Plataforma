/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.model.zeus;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ejmorales
 */
@Entity
@Table(name = "ZEUS_ROLE_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZeusRoleMenu.findAll", query = "SELECT z FROM ZeusRoleMenu z")
    , @NamedQuery(name = "ZeusRoleMenu.findByMenu", query = "SELECT z FROM ZeusRoleMenu z WHERE z.zeusRoleMenuPK.menu = :menu")
    , @NamedQuery(name = "ZeusRoleMenu.findByRole", query = "SELECT z FROM ZeusRoleMenu z WHERE z.zeusRoleMenuPK.role = :role")
    , @NamedQuery(name = "ZeusRoleMenu.findByEstado", query = "SELECT z FROM ZeusRoleMenu z WHERE z.estado = :estado")
    , @NamedQuery(name = "ZeusRoleMenu.findByUsuarioIngresa", query = "SELECT z FROM ZeusRoleMenu z WHERE z.usuarioIngresa = :usuarioIngresa")
    , @NamedQuery(name = "ZeusRoleMenu.findByFechaIngresa", query = "SELECT z FROM ZeusRoleMenu z WHERE z.fechaIngresa = :fechaIngresa")})
public class ZeusRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ZeusRoleMenuPK zeusRoleMenuPK;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 50)
    @Column(name = "USUARIO_INGRESA")
    private String usuarioIngresa;
    @Column(name = "FECHA_INGRESA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresa;
    @JoinColumn(name = "MENU", referencedColumnName = "MENU", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ZeusMenu zeusMenu;
    @JoinColumn(name = "ROLE", referencedColumnName = "ROLE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ZeusRole zeusRole;

    public ZeusRoleMenu() {
    }

    public ZeusRoleMenu(ZeusRoleMenuPK zeusRoleMenuPK) {
        this.zeusRoleMenuPK = zeusRoleMenuPK;
    }

    public ZeusRoleMenu(BigInteger menu, BigInteger role) {
        this.zeusRoleMenuPK = new ZeusRoleMenuPK(menu, role);
    }

    public ZeusRoleMenuPK getZeusRoleMenuPK() {
        return zeusRoleMenuPK;
    }

    public void setZeusRoleMenuPK(ZeusRoleMenuPK zeusRoleMenuPK) {
        this.zeusRoleMenuPK = zeusRoleMenuPK;
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

    public ZeusMenu getZeusMenu() {
        return zeusMenu;
    }

    public void setZeusMenu(ZeusMenu zeusMenu) {
        this.zeusMenu = zeusMenu;
    }

    public ZeusRole getZeusRole() {
        return zeusRole;
    }

    public void setZeusRole(ZeusRole zeusRole) {
        this.zeusRole = zeusRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zeusRoleMenuPK != null ? zeusRoleMenuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZeusRoleMenu)) {
            return false;
        }
        ZeusRoleMenu other = (ZeusRoleMenu) object;
        if ((this.zeusRoleMenuPK == null && other.zeusRoleMenuPK != null) || (this.zeusRoleMenuPK != null && !this.zeusRoleMenuPK.equals(other.zeusRoleMenuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cgc.plataforma.model.zeus.ZeusRoleMenu[ zeusRoleMenuPK=" + zeusRoleMenuPK + " ]";
    }
    
}
