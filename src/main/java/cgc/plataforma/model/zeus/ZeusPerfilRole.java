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
@Table(name = "ZEUS_PERFIL_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZeusPerfilRole.findAll", query = "SELECT z FROM ZeusPerfilRole z")
    , @NamedQuery(name = "ZeusPerfilRole.findByPerfil", query = "SELECT z FROM ZeusPerfilRole z WHERE z.zeusPerfilRolePK.perfil = :perfil")
    , @NamedQuery(name = "ZeusPerfilRole.findByRole", query = "SELECT z FROM ZeusPerfilRole z WHERE z.zeusPerfilRolePK.role = :role")
    , @NamedQuery(name = "ZeusPerfilRole.findByDescripcion", query = "SELECT z FROM ZeusPerfilRole z WHERE z.descripcion = :descripcion")
    , @NamedQuery(name = "ZeusPerfilRole.findByEstado", query = "SELECT z FROM ZeusPerfilRole z WHERE z.estado = :estado")
    , @NamedQuery(name = "ZeusPerfilRole.findByUsuarioIngresa", query = "SELECT z FROM ZeusPerfilRole z WHERE z.usuarioIngresa = :usuarioIngresa")
    , @NamedQuery(name = "ZeusPerfilRole.findByFechaIngresa", query = "SELECT z FROM ZeusPerfilRole z WHERE z.fechaIngresa = :fechaIngresa")})
public class ZeusPerfilRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ZeusPerfilRolePK zeusPerfilRolePK;
    @Size(max = 4000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 50)
    @Column(name = "USUARIO_INGRESA")
    private String usuarioIngresa;
    @Column(name = "FECHA_INGRESA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresa;
    @JoinColumn(name = "PERFIL", referencedColumnName = "PERFIL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ZeusPerfil zeusPerfil;
    @JoinColumn(name = "ROLE", referencedColumnName = "ROLE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ZeusRole zeusRole;

    public ZeusPerfilRole() {
    }

    public ZeusPerfilRole(ZeusPerfilRolePK zeusPerfilRolePK) {
        this.zeusPerfilRolePK = zeusPerfilRolePK;
    }

    public ZeusPerfilRole(BigInteger perfil, BigInteger role) {
        this.zeusPerfilRolePK = new ZeusPerfilRolePK(perfil, role);
    }

    public ZeusPerfilRolePK getZeusPerfilRolePK() {
        return zeusPerfilRolePK;
    }

    public void setZeusPerfilRolePK(ZeusPerfilRolePK zeusPerfilRolePK) {
        this.zeusPerfilRolePK = zeusPerfilRolePK;
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

    public ZeusPerfil getZeusPerfil() {
        return zeusPerfil;
    }

    public void setZeusPerfil(ZeusPerfil zeusPerfil) {
        this.zeusPerfil = zeusPerfil;
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
        hash += (zeusPerfilRolePK != null ? zeusPerfilRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZeusPerfilRole)) {
            return false;
        }
        ZeusPerfilRole other = (ZeusPerfilRole) object;
        if ((this.zeusPerfilRolePK == null && other.zeusPerfilRolePK != null) || (this.zeusPerfilRolePK != null && !this.zeusPerfilRolePK.equals(other.zeusPerfilRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cgc.plataforma.model.zeus.ZeusPerfilRole[ zeusPerfilRolePK=" + zeusPerfilRolePK + " ]";
    }
    
}
