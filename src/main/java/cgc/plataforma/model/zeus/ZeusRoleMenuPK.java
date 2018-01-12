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
public class ZeusRoleMenuPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "MENU")
    private BigInteger menu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE")
    private BigInteger role;

    public ZeusRoleMenuPK() {
    }

    public ZeusRoleMenuPK(BigInteger menu, BigInteger role) {
        this.menu = menu;
        this.role = role;
    }

    public BigInteger getMenu() {
        return menu;
    }

    public void setMenu(BigInteger menu) {
        this.menu = menu;
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
        hash += (menu != null ? menu.hashCode() : 0);
        hash += (role != null ? role.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZeusRoleMenuPK)) {
            return false;
        }
        ZeusRoleMenuPK other = (ZeusRoleMenuPK) object;
        if ((this.menu == null && other.menu != null) || (this.menu != null && !this.menu.equals(other.menu))) {
            return false;
        }
        if ((this.role == null && other.role != null) || (this.role != null && !this.role.equals(other.role))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cgc.plataforma.model.zeus.ZeusRoleMenuPK[ menu=" + menu + ", role=" + role + " ]";
    }
    
}
