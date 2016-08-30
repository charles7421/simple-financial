/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ux.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author charles
 */
@Entity
@Table(name = "sub_categorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubCategorias.findAll", query = "SELECT s FROM SubCategorias s"),
    @NamedQuery(name = "SubCategorias.findByIdSubCategoria", query = "SELECT s FROM SubCategorias s WHERE s.idSubCategoria = :idSubCategoria"),
    @NamedQuery(name = "SubCategorias.findByDescricao", query = "SELECT s FROM SubCategorias s WHERE s.descricao = :descricao")})
public class SubCategorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sub_categoria")
    private Integer idSubCategoria;
    @Size(max = 250)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idSubCategoria")
    private List<LancamentosFinanceiros> lancamentosFinanceirosList;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categorias idCategoria;

    public SubCategorias() {
    }

    public SubCategorias(Integer idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }

    public Integer getIdSubCategoria() {
        return idSubCategoria;
    }

    public void setIdSubCategoria(Integer idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<LancamentosFinanceiros> getLancamentosFinanceirosList() {
        return lancamentosFinanceirosList;
    }

    public void setLancamentosFinanceirosList(List<LancamentosFinanceiros> lancamentosFinanceirosList) {
        this.lancamentosFinanceirosList = lancamentosFinanceirosList;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubCategoria != null ? idSubCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubCategorias)) {
            return false;
        }
        SubCategorias other = (SubCategorias) object;
        if ((this.idSubCategoria == null && other.idSubCategoria != null) || (this.idSubCategoria != null && !this.idSubCategoria.equals(other.idSubCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ux.model.SubCategorias[ idSubCategoria=" + idSubCategoria + " ]";
    }
    
}
