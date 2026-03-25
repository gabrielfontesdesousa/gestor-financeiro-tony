package gerenciador.financeiro.repository;

import gerenciador.financeiro.db.ConexaoDB;
import gerenciador.financeiro.enums.StatusTransacao;
import gerenciador.financeiro.model.LogTransacao;
import gerenciador.financeiro.model.Transacao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;

public class TransacaoRepository {
    private final JdbcTemplate jdbcTemplate;

    public TransacaoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void Salvar(Transacao transacao) {
        try {
            String sql = "INSERT INTO transacao VALUES (?, ?, ?, ?, ?);";
            jdbcTemplate.execute(sql);
            new LogTransacao(LocalDateTime.now(), "INSERT SUCCESS", StatusTransacao.OPERACAO_CONCLUIDA);
        } catch (Exception e) {
            new LogTransacao(LocalDateTime.now(), e.getMessage(), StatusTransacao.FALHA);
        }
    }

    public List<Transacao> listarTodas(Transacao transacao) {
        try {
            String sql = "SELECT * FROM transacao;";
            new LogTransacao(LocalDateTime.now(), "LIST SUCCESS", StatusTransacao.OPERACAO_CONCLUIDA);
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Transacao.class));
        } catch (Exception e) {
            new LogTransacao(LocalDateTime.now(), e.getMessage(), StatusTransacao.FALHA);
            return null;
        }
    }

    public Transacao buscarPorId(Transacao transacao) {
        try {
            String sql = "SELECT * FROM transacao WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Transacao.class), transacao.getId());
        } catch (Exception e) {
            new LogTransacao(LocalDateTime.now(), e.getMessage(), StatusTransacao.FALHA);
            return null;
        }
    }

    public List<Transacao> ListarPorTipo() {
        try {
            String sql = "SELECT * FROM transacao GROUP BY tipo;";
            new LogTransacao(LocalDateTime.now(), "LIST SUCCESS", StatusTransacao.OPERACAO_CONCLUIDA);
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Transacao.class));
        } catch (Exception e) {
            new LogTransacao(LocalDateTime.now(), e.getMessage(), StatusTransacao.FALHA);
            return null;
        }
    }

    public List<Transacao> ListarPorCategoria() {
        try {
            String sql = "SELECT * FROM transacao GROUP BY categoria_id;";
            new LogTransacao(LocalDateTime.now(), "LIST SUCCESS", StatusTransacao.OPERACAO_CONCLUIDA);
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Transacao.class));
        } catch (Exception e) {
            new LogTransacao(LocalDateTime.now(), e.getMessage(), StatusTransacao.FALHA);
            return null;
        }
    }

    public void atualizar(Transacao transacao) {
        try {
            String sql = "UPDATE transacao SET valor = ?, data_hora = ?, descricao = ?, tipo = ?, categoria_id = ?";
            jdbcTemplate.update(sql);
            new LogTransacao(LocalDateTime.now(), "EDIT SUCCESS", StatusTransacao.OPERACAO_CONCLUIDA);
            return;
        } catch (Exception e) {
            new LogTransacao(LocalDateTime.now(), e.getMessage(), StatusTransacao.FALHA);
            return;
        }
    }

    public void deletar(Transacao transacao) {
        try {
            String sql = "DELETE FROM meta WHERE id = ?";
            jdbcTemplate.update(sql, transacao.getId());
            new LogTransacao(LocalDateTime.now(), "DELETE SUCCESS", StatusTransacao.OPERACAO_CONCLUIDA);
        } catch (Exception e) {
            new LogTransacao(LocalDateTime.now(), e.getMessage(), StatusTransacao.OPERACAO_CONCLUIDA);
            return;
        }
    }
}
