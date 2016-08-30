package br.com.ux.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author charles
 */
@Entity
@Table(name = "cartoes_credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartoesCredito.findAll", query = "SELECT c FROM CartoesCredito c"),
    @NamedQuery(name = "CartoesCredito.findByIdCartaoCredito", query = "SELECT c FROM CartoesCredito c WHERE c.idCartaoCredito = :idCartaoCredito"),
    @NamedQuery(name = "CartoesCredito.findByDescricao", query = "SELECT c FROM CartoesCredito c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "CartoesCredito.findByDtVencimentoFatura", query = "SELECT c FROM CartoesCredito c WHERE c.dtVencimentoFatura = :dtVencimentoFatura"),
    @NamedQuery(name = "CartoesCredito.findByDtFechamentoFatura", query = "SELECT c FROM CartoesCredito c WHERE c.dtFechamentoFatura = :dtFechamentoFatura"),
    @NamedQuery(name = "CartoesCredito.findByLimite", query = "SELECT c FROM CartoesCredito c WHERE c.limite = :limite"),
    @NamedQuery(name = "CartoesCredito.findBySaldoRestante", query = "SELECT c FROM CartoesCredito c WHERE c.saldoRestante = :saldoRestante")})
public class CartoesCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cartao_credito")
    private Integer idCartaoCredito;
    @Size(max = 250)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "dt_vencimento_fatura")
    @Temporal(TemporalType.DATE)
    private Date dtVencimentoFatura;
    @Column(name = "dt_fechamento_fatura")
    @Temporal(TemporalType.DATE)
    private Date dtFechamentoFatura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limite")
    private BigDecimal limite;
    @Column(name = "saldo_restante")
    private BigDecimal saldoRestante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCartaoCredito")
    private List<LancamentosFinanceiros> lancamentosFinanceirosList;

    public CartoesCredito() {
    }

    public CartoesCredito(Integer idCartaoCredito) {
        this.idCartaoCredito = idCartaoCredito;
    }

    public Integer getIdCartaoCredito() {
        return idCartaoCredito;
    }

    public void setIdCartaoCredito(Integer idCartaoCredito) {
        this.idCartaoCredito = idCartaoCredito;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtVencimentoFatura() {
        return dtVencimentoFatura;
    }

    public void setDtVencimentoFatura(Date dtVencimentoFatura) {
        this.dtVencimentoFatura = dtVencimentoFatura;
    }

    public Date getDtFechamentoFatura() {
        return dtFechamentoFatura;
    }

    public void setDtFechamentoFatura(Date dtFechamentoFatura) {
        this.dtFechamentoFatura = dtFechamentoFatura;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public BigDecimal getSaldoRestante() {
        return saldoRestante;
    }

    public void setSaldoRestante(BigDecimal saldoRestante) {
        this.saldoRestante = saldoRestante;
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
        hash += (idCartaoCredito != null ? idCartaoCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartoesCredito)) {
            return false;
        }
        CartoesCredito other = (CartoesCredito) object;
        if ((this.idCartaoCredito == null && other.idCartaoCredito != null) || (this.idCartaoCredito != null && !this.idCartaoCredito.equals(other.idCartaoCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ux.model.CartoesCredito[ idCartaoCredito=" + idCartaoCredito + " ]";
    }
    
}
