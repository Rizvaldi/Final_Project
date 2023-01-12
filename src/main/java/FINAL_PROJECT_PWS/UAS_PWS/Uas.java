/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FINAL_PROJECT_PWS.UAS_PWS;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MSI 65 SERIES
 */
@Entity
@Table(name = "uas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uas.findAll", query = "SELECT u FROM Uas u"),
    @NamedQuery(name = "Uas.findById", query = "SELECT u FROM Uas u WHERE u.id = :id"),
    @NamedQuery(name = "Uas.findByNama", query = "SELECT u FROM Uas u WHERE u.nama = :nama"),
    @NamedQuery(name = "Uas.findByNik", query = "SELECT u FROM Uas u WHERE u.nik = :nik"),
    @NamedQuery(name = "Uas.findByAlamat", query = "SELECT u FROM Uas u WHERE u.alamat = :alamat"),
    @NamedQuery(name = "Uas.findByFoto", query = "SELECT u FROM Uas u WHERE u.foto = :foto")})
public class Uas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)   
    private Integer id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "NIK")
    private Integer nik;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "foto")
    private String foto;

    public Uas() {
    }

    public Uas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uas)) {
            return false;
        }
        Uas other = (Uas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FINAL_PROJECT_PWS.UAS_PWS.Uas[ id=" + id + " ]";
    }
    
}
