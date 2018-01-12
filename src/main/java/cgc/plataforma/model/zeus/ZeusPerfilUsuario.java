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
@Table(name = "ZEUS_PERFIL_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZeusPerfilUsuario.findAll", query = "SELECT z FROM ZeusPerfilUsuario z")
    , @NamedQuery(name = "ZeusPerfilUsuario.findByUsuario", query = "SELECT z FROM ZeusPerfilUsuario z WHERE z.zeusPerfilUsuarioPK.usuario = :usuario")
    , @NamedQuery(name = "ZeusPerfilUsuario.findByPerfil", query = "SELECT z FROM ZeusPerfilUsuario z WHERE z.zeusPerfilUsuarioPK.perfil = :perfil")
    , @NamedQuery(name = "ZeusPerfilUsuario.findByEstado", query = "SELECT z FROM ZeusPerfilUsuario z WHERE z.estado = :estado")
    , @NamedQuery(name = "ZeusPerfilUsuario.findByUsuarioIngresa", query = "SELECT z FROM ZeusPerfilUsuario z WHERE z.usuarioIngresa = :usuarioIngresa")
    , @NamedQuery(name = "ZeusPerfilUsuario.findByFechaIngresa", query = "SELECT z FROM ZeusPerfilUsuario z WHERE z.fechaIngresa = :fechaIngresa")
    , @NamedQuery(name = "ZeusPerfilUsuario.findByObservacion", query = "SELECT z FROM ZeusPerfilUsuario z WHERE z.observacion = :observacion")
    , @NamedQuery(name = "ZeusPerfilUsuario.findByUsuarioActualizacion", query = "SELECT z FROM ZeusPerfilUsuario z WHERE z.usuarioActualizacion = :usuarioActualizacion")
    , @NamedQuery(name = "ZeusPerfilUsuario.findByFechaActualizacion", query = "SELECT z FROM ZeusPerfilUsuario z WHERE z.fechaActualizacion = :fechaActualizacion")})
public class ZeusPerfilUsuario implements Serializable {

    @Column(name = "ID_RUE")
    private Long idRue;
    @Size(max = 50)
    @Column(name = "LOGIN_AD")
    private String loginAd;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ZeusPerfilUsuarioPK zeusPerfilUsuarioPK;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 50)
    @Column(name = "USUARIO_INGRESA")
    private String usuarioIngresa;
    @Column(name = "FECHA_INGRESA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresa;
    @Size(max = 500)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Size(max = 20)
    @Column(name = "USUARIO_ACTUALIZACION")
    private String usuarioActualizacion;
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @JoinColumn(name = "PERFIL", referencedColumnName = "PERFIL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ZeusPerfil zeusPerfil;

    public ZeusPerfilUsuario() {
    }

    public ZeusPerfilUsuario(ZeusPerfilUsuarioPK zeusPerfilUsuarioPK) {
        this.zeusPerfilUsuarioPK = zeusPerfilUsuarioPK;
    }

    public ZeusPerfilUsuario(String usuario, BigInteger perfil) {
        this.zeusPerfilUsuarioPK = new ZeusPerfilUsuarioPK(usuario, perfil);
    }

    public ZeusPerfilUsuarioPK getZeusPerfilUsuarioPK() {
        return zeusPerfilUsuarioPK;
    }

    public void setZeusPerfilUsuarioPK(ZeusPerfilUsuarioPK zeusPerfilUsuarioPK) {
        this.zeusPerfilUsuarioPK = zeusPerfilUsuarioPK;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public ZeusPerfil getZeusPerfil() {
        return zeusPerfil;
    }

    public void setZeusPerfil(ZeusPerfil zeusPerfil) {
        this.zeusPerfil = zeusPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zeusPerfilUsuarioPK != null ? zeusPerfilUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZeusPerfilUsuario)) {
            return false;
        }
        ZeusPerfilUsuario other = (ZeusPerfilUsuario) object;
        if ((this.zeusPerfilUsuarioPK == null && other.zeusPerfilUsuarioPK != null) || (this.zeusPerfilUsuarioPK != null && !this.zeusPerfilUsuarioPK.equals(other.zeusPerfilUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cgc.plataforma.model.zeus.ZeusPerfilUsuario[ zeusPerfilUsuarioPK=" + zeusPerfilUsuarioPK + " ]";
    }

    public Long getIdRue() {
        return idRue;
    }

    public void setIdRue(Long idRue) {
        this.idRue = idRue;
    }

    public String getLoginAd() {
        return loginAd;
    }

    public void setLoginAd(String loginAd) {
        this.loginAd = loginAd;
    }
    
}
