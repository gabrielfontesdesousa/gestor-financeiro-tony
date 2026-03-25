package gerenciador.financeiro.db;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.stream.Collectors;

public class InicializadorDB {

    public static void inicializar() {
        try (
                Connection conexao = db.ConexaoDB.getConexao();
                Statement statement = conexao.createStatement()
        ) {
            InputStream inputStream = InicializadorDB.class.getResourceAsStream("/gerenciador/financeiro/db/schema.sql");

            if (inputStream == null) {
                throw new RuntimeException("Arquivo schema.sql não encontrado!");
            }

            String sql = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.joining("\n"));

            String[] comandos = sql.split(";");
            for (String comando : comandos) {
                if (!comando.trim().isEmpty()) {
                    statement.execute(comando);
                }
            }

            System.out.println("Banco de dados inicializado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inicializar o banco: " + e.getMessage());
            e.printStackTrace();
        }
    }
}