/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ux.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tipos_documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDocumentos.findAll", query = "SELECT t FROM TiposDocumentos t"),
    @NamedQuery(name = "TiposDocumentos.findByIdTipoDocumento", query = "SELECT t FROM TiposDocumentos t WHERE t.idTipoDocumento = :idTipoDocumento"),
    @NamedQuery(name = "TiposDocumentos.findByDescricao", query = "SELECT t FROM TiposDocumentos t WHERE t.descricao = :descricao")})
public class TiposDocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;
    @Size(max = 250)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDocumento")
    private List<LancamentosFinanceiros> lancamentosFinanceirosList;

    public TiposDocumentos() {
    }

    public TiposDocumentos(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDocumento != null ? idTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDocumentos)) {
            return false;
        }
        TiposDocumentos other = (TiposDocumentos) object;
        if ((this.idTipoDocumento == null && other.idTipoDocumento != null) || (this.idTipoDocumento != null && !this.idTipoDocumento.equals(other.idTipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ux.model.TiposDocumentos[ idTipoDocumento=" + idTipoDocumento + " ]";
    }
    
}
