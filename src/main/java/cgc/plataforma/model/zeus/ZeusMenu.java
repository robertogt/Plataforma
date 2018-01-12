/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgc.plataforma.model.zeus;

import cgc.plataforma.pojo.ResultsMenu;
import cgc.plataforma.pojo.ResultsMenuIcono;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
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
@Table(name = "ZEUS_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZeusMenu.findAll", query = "SELECT z FROM ZeusMenu z")
    , @NamedQuery(name = "ZeusMenu.findByMenu", query = "SELECT z FROM ZeusMenu z WHERE z.menu = :menu")
    , @NamedQuery(name = "ZeusMenu.findByEtiqueta", query = "SELECT z FROM ZeusMenu z WHERE z.etiqueta = :etiqueta")
    , @NamedQuery(name = "ZeusMenu.findByEstado", query = "SELECT z FROM ZeusMenu z WHERE z.estado = :estado")
    , @NamedQuery(name = "ZeusMenu.findByOrden", query = "SELECT z FROM ZeusMenu z WHERE z.orden = :orden")
    , @NamedQuery(name = "ZeusMenu.findByMenuPadre", query = "SELECT z FROM ZeusMenu z WHERE z.menuPadre = :menuPadre")
    , @NamedQuery(name = "ZeusMenu.findByMensaje", query = "SELECT z FROM ZeusMenu z WHERE z.mensaje = :mensaje")
    , @NamedQuery(name = "ZeusMenu.findByUsuarioIngresa", query = "SELECT z FROM ZeusMenu z WHERE z.usuarioIngresa = :usuarioIngresa")
    , @NamedQuery(name = "ZeusMenu.findByFechaIngresa", query = "SELECT z FROM ZeusMenu z WHERE z.fechaIngresa = :fechaIngresa")
    , @NamedQuery(name = "ZeusMenu.findByUsuario", query = "SELECT distinct z FROM ZeusMenu z INNER JOIN z.zeusRoleMenuList rm " +
                                                            "INNER JOIN rm.zeusRole r " +
                                                            "INNER JOIN r.zeusPerfilRoleList pr " +
                                                            "INNER JOIN  pr.zeusPerfil p " +
                                                            "INNER JOIN  p.zeusPerfilUsuarioList pu " +
                                                            "WHERE pu.loginAd = UPPER(:usuario) " +
                                                            "and z.menuPadre=0 "+
                                                            "and z.tipo = :tipo "+
                                                            "and z.estado = 'A' "+
                                                            "and pu.estado = 'A' ")
    , @NamedQuery(name = "ZeusMenu.findByMenuPadreUser", query = "SELECT distinct z FROM ZeusMenu z INNER JOIN z.zeusRoleMenuList rm " +
                                                            "INNER JOIN rm.zeusRole r " +
                                                            "INNER JOIN r.zeusPerfilRoleList pr " +
                                                            "INNER JOIN  pr.zeusPerfil p " +
                                                            "INNER JOIN  p.zeusPerfilUsuarioList pu " +
                                                            "WHERE pu.loginAd = UPPER(:usuario) " +
                                                            "AND z.menuPadre = :menuPadre ")
})
@NamedNativeQueries({
    @NamedNativeQuery(name = "ZeusMenu.NativeQueryMenu",
                      query = "SELECT DISTINCT M.MENU menu,M.MENU_PADRE menuPadre,M.ETIQUETA etiqueta,NVL(C.PATH,C.URL) path,C.NOMBRE_FISICO nombreFisico, LEVEL nivel, M.ORDEN, " +
                                "CONNECT_BY_ISLEAF HOJA " +
                                "FROM ZEUS_MENU M " +
                                "INNER JOIN ZEUS_COMPONENTE C ON M.COMPONENTE = C.COMPONENTE " +
                                "INNER JOIN ZEUS_ROLE_MENU RM ON M.MENU = RM.MENU " +
                                "INNER JOIN ZEUS_ROLE R ON RM.ROLE = R.ROLE " +
                                "INNER JOIN ZEUS_PERFIL_ROLE PR ON R.ROLE = PR.ROLE " +
                                "INNER JOIN ZEUS_PERFIL P ON PR.PERFIL = P.PERFIL " +
                                "INNER JOIN ZEUS_PERFIL_USUARIO U ON P.PERFIL = U.PERFIL " +
                                "WHERE U.LOGIN_AD = UPPER(?) " +
                                "AND LEVEL = 1 " +
                                "AND M.ESTADO = 'A' "+
                                "CONNECT BY PRIOR M.MENU = M.MENU_PADRE " +
                                "START WITH M.MENU_PADRE = ? " +
                                "ORDER BY ORDEN,LEVEL",
                      resultSetMapping = "ResultsMenu"
    ),
    @NamedNativeQuery(name = "ZeusMenu.NativeQueryIcono",
                      query = "SELECT M.ICONO icono " +                               
                                "FROM ZEUS_MENU M " +                                
                                "WHERE M.MENU = ? ",                                 
                      resultSetMapping = "ResultsMenuIcono"
    )
})
@SqlResultSetMappings({
    @SqlResultSetMapping(name="ResultsMenu",
                         classes = {@ConstructorResult(targetClass = ResultsMenu.class,
                                 columns = {@ColumnResult(name = "menu", type = BigDecimal.class),
                                            @ColumnResult(name = "menuPadre", type = BigDecimal.class),
                                            @ColumnResult(name = "etiqueta", type = String.class),
                                            @ColumnResult(name = "path", type = String.class),
                                            @ColumnResult(name = "nombreFisico", type = String.class),
                                            @ColumnResult(name = "nivel", type = BigDecimal.class),
                                            @ColumnResult(name = "orden", type = BigDecimal.class),
                                            @ColumnResult(name = "hoja", type = BigDecimal.class) })
                         }),
    @SqlResultSetMapping(name="ResultsMenuIcono",
                         classes = {@ConstructorResult(targetClass = ResultsMenuIcono.class,
                                 columns = {@ColumnResult(name = "icono") })
                         })
})
public class ZeusMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MENU")
    private BigDecimal menu;
    @Size(max = 30)
    @Column(name = "ETIQUETA")
    private String etiqueta;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "ORDEN")
    private BigInteger orden;
    @Column(name = "MENU_PADRE")
    private BigInteger menuPadre;
    @Size(max = 500)
    @Column(name = "MENSAJE")
    private String mensaje;
    @Size(max = 50)
    @Column(name = "USUARIO_INGRESA")
    private String usuarioIngresa;
    @Column(name = "FECHA_INGRESA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresa;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ICONO")
    private byte[] icono;
    @Size(max = 1)
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "PLATAFORMA_WEB")
    private String plataformaWeb;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<ZeusBitacora> zeusBitacoraList;
    @JoinColumn(name = "COMPONENTE", referencedColumnName = "COMPONENTE")
    @ManyToOne
    private ZeusComponente componente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zeusMenu")
    private List<ZeusRoleMenu> zeusRoleMenuList;

    public ZeusMenu() {
    }

    public ZeusMenu(BigDecimal menu) {
        this.menu = menu;
    }

    public String getPlataformaWeb() {
        return plataformaWeb;
    }

    public void setPlataformaWeb(String plataformaWeb) {
        this.plataformaWeb = plataformaWeb;
    }
    
    public BigDecimal getMenu() {
        return menu;
    }

    public void setMenu(BigDecimal menu) {
        this.menu = menu;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getOrden() {
        return orden;
    }

    public void setOrden(BigInteger orden) {
        this.orden = orden;
    }

    public BigInteger getMenuPadre() {
        return menuPadre;
    }

    public void setMenuPadre(BigInteger menuPadre) {
        this.menuPadre = menuPadre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
    
    public byte[] getIcono() {
        return icono;
    }

    public void setIcono(byte[] icono) {
        this.icono = icono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

    @XmlTransient
    public List<ZeusBitacora> getZeusBitacoraList() {
        return zeusBitacoraList;
    }

    public void setZeusBitacoraList(List<ZeusBitacora> zeusBitacoraList) {
        this.zeusBitacoraList = zeusBitacoraList;
    }

    public ZeusComponente getComponente() {
        return componente;
    }

    public void setComponente(ZeusComponente componente) {
        this.componente = componente;
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
        hash += (menu != null ? menu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZeusMenu)) {
            return false;
        }
        ZeusMenu other = (ZeusMenu) object;
        if ((this.menu == null && other.menu != null) || (this.menu != null && !this.menu.equals(other.menu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cgc.plataforma.model.zeus.ZeusMenu[ menu=" + menu + " ]";
    }
    
}
