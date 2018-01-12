/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.model.zeus;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ejmorales
 */
@Embeddable
public class ZeusPerfilRolePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERFIL")
    private BigInteger perfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE")
    private BigInteger role;

    public ZeusPerfilRolePK() {
    }

    public ZeusPerfilRolePK(BigInteger perfil, BigInteger role) {
        this.perfil = perfil;
        this.role = role;
    }

    public BigInteger getPerfil() {
        return perfil;
    }

    public void setPerfil(BigInteger perfil) {
        this.perfil = perfil;
    }

    public BigInteger getRole() {
        return role;
    }

    public void setRole(BigInteger role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfil != null ? perfil.hashCode() : 0);
        hash += (role != null ? role.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZeusPerfilRolePK)) {
            return false;
        }
        ZeusPerfilRolePK other = (ZeusPerfilRolePK) object;
        if ((this.perfil == null && other.perfil != null) || (this.perfil != null && !this.perfil.equals(other.perfil))) {
            return false;
        }
        if ((this.role == null && other.role != null) || (this.role != null && !this.role.equals(other.role))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cgc.plataforma.model.zeus.ZeusPerfilRolePK[ perfil=" + perfil + ", role=" + role + " ]";
    }
    
}
