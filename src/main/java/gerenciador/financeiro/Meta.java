package gerenciador.financeiro;

import java.time.LocalDate;

public class Meta {
    private Double valorFinal;
    private Double valorAtual;
    private LocalDate dtFinal;

    public Meta(Double valorFinal, Double valorAtual, LocalDate dtFinal) {
        this.valorFinal = valorFinal;
        this.valorAtual = valorAtual;
        this.dtFinal = dtFinal;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "valorFinal=" + valorFinal +
                ", valorAtual=" + valorAtual +
                ", dtFinal=" + dtFinal +
                '}';
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public LocalDate getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(LocalDate dtFinal) {
        this.dtFinal = dtFinal;
    }
    public Double porcentagemAtingido(){
        return getValorAtual() / getValorFinal() * 100;
    }
}
