package gerenciador.financeiro;
import gerenciador.financeiro.enums.StatusTransacao;
import gerenciador.financeiro.enums.TipoTransacao;
import gerenciador.financeiro.model.Categoria;
import gerenciador.financeiro.model.LogTransacao;
import gerenciador.financeiro.model.Meta;
import gerenciador.financeiro.model.Transacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Categoria categoria = new Categoria("Salario", "Salário Empresa");
        Categoria categoria1 = new Categoria("Lazer", "Parque");
        System.out.println(categoria1.toString() + "\n" + categoria.toString());
        List<LogTransacao> logTransacoes = new ArrayList<LogTransacao>();
        Transacao t1 = null;

        try{
            t1 = new Transacao(1000.00, LocalDateTime.now(), "Compra Parque", categoria1, TipoTransacao.DESPESA);
            logTransacoes.add(new LogTransacao( LocalDateTime.now(), "Sucesso na operação", StatusTransacao.OPERACAO_CONCLUIDA));
        } catch (Exception e){
            logTransacoes.add(new LogTransacao( LocalDateTime.now(), e.getMessage(), StatusTransacao.FALHA));
        }

        System.out.println(t1.toString());
        for (int i = 0; i < logTransacoes.size(); i++) {
            System.out.println(logTransacoes.get(i).toString());
        }
        Meta m1 = new Meta(3000.00, 2000.00, LocalDate.of(2027,01,01));
        System.out.println(m1.toString());
        String mensagem = "[";
        Double porcentagemAtingida = m1.porcentagemAtingido() / 10;
        for (int i = 0; i < porcentagemAtingida; i++) {
            mensagem += "######";
        }
        for (int i = 0; i < 10 - porcentagemAtingida; i++){
            mensagem += "......";

        }
        mensagem += "]";
        System.out.println(mensagem);
    }
}
