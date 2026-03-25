package gerenciador.financeiro.model;

import gerenciador.financeiro.enums.StatusTransacao;
import gerenciador.financeiro.enums.TipoTransacao;

import java.time.LocalDateTime;

public class Transacao {
    private Double Valor;
    private LocalDateTime dtHora;
    private StatusTransacao status;
    private String descricao;
    private Categoria categoria;
    private TipoTransacao tipoTransacao;

    @Override
    public String toString() {
        return "Transacao{" +
                "Valor=" + Valor +
                ", dtHora=" + dtHora +
                ", status=" + status +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", tipoTransacao=" + tipoTransacao +
                '}';
    }

    public Transacao(Double valor, LocalDateTime dtHora, String descricao, Categoria categoria, TipoTransacao tipoTransacao) {
        Valor = valor;
        this.dtHora = dtHora;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tipoTransacao = tipoTransacao;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }

    public LocalDateTime getDtHora() {
        return dtHora;
    }

    public void setDtHora(LocalDateTime dtHora) {
        this.dtHora = dtHora;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public void setStatus(StatusTransacao status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}
