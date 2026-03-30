package gerenciador.financeiro;
import gerenciador.financeiro.db.ConexaoDB;
import gerenciador.financeiro.db.InicializadorDB;
import gerenciador.financeiro.enums.TipoTransacao;
import gerenciador.financeiro.model.Categoria;
import gerenciador.financeiro.model.Transacao;
import gerenciador.financeiro.repository.LogTransacaoRepository;
import gerenciador.financeiro.repository.TransacaoRepository;
import gerenciador.financeiro.service.LogTransacaoService;
import gerenciador.financeiro.service.TransacaoService;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    static Scanner leitor = new Scanner(System.in);
    static ConexaoDB conexaoDB = new ConexaoDB();
    static JdbcTemplate jdbc;
    static TransacaoService transacaoService = new TransacaoService( new TransacaoRepository(conexaoDB.getJdbcTemplate()));
    static LogTransacaoService logTransacaoService = new LogTransacaoService(new LogTransacaoRepository(jdbc));

    public static void main(String[] args) {
        InicializadorDB.inicializar(conexaoDB);
        menuPrincipal();
    }

    public static void menuPrincipal() {
        boolean executando = true;

        while (executando) {
            limparConsole();
            System.out.println("=================================");
            System.out.println("     GERENCIADOR FINANCEIRO");
            System.out.println("=================================");
            System.out.println("1 - Categorias");
            System.out.println("2 - Transações");
            System.out.println("3 - Metas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    telaCategorias();
                    break;
                case 2:
                    telaTransacoes();
                    break;
                case 3:
                    telaMetas();
                    break;
                case 0:
                    executando = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    pausar();
            }
        }
    }

    public static void telaCategorias() {
        boolean voltar = false;

        while (!voltar) {
            limparConsole();
            System.out.println("=================================");
            System.out.println("         MENU CATEGORIAS");
            System.out.println("=================================");
            System.out.println("1 - Cadastrar categoria");
            System.out.println("2 - Listar categorias");
            System.out.println("3 - Buscar por nome");
            System.out.println("4 - Atualizar categoria");
            System.out.println("5 - Deletar categoria");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println(">>> Cadastrar categoria");
                    pausar();
                    break;
                case 2:
                    System.out.println(">>> Listar categorias");
                    pausar();
                    break;
                case 3:
                    System.out.println(">>> Buscar categoria por nome");
                    pausar();
                    break;
                case 4:
                    System.out.println(">>> Atualizar categoria");
                    pausar();
                    break;
                case 5:
                    System.out.println(">>> Deletar categoria");
                    pausar();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    pausar();
            }
        }
    }

    public static void telaTransacoes() {
        boolean voltar = false;

        while (!voltar) {
            limparConsole();
            System.out.println("=================================");
            System.out.println("         MENU TRANSAÇÕES");
            System.out.println("=================================");
            System.out.println("1 - Cadastrar transação");
            System.out.println("2 - Listar transações");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Listar por tipo");
            System.out.println("5 - Deletar transação");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    Double valor = 0.0;
                    String descricao = "";
                    TipoTransacao tipo = null;
                    Integer categoriaId = 0;
                    String nomeCategoria = "";
                    String descricaoCategoria = "";
                    System.out.println(">>> Cadastrar transação");
                    System.out.println("Insira o valor da transação: ");
                    valor = leitor.nextDouble();
                    leitor.nextLine();
                    LocalDateTime dataHora = LocalDateTime.now();
                    System.out.println("Insira a descrição da transação: ");
                    descricao = leitor.nextLine();
                    System.out.println("Insira o tipo da transação: \n" +
                            "1 - Receita \n" +
                            "2 - Despesa \n");
                    switch (leitor.nextInt()){
                        case 1:
                            tipo = TipoTransacao.DESPESA;
                        case 2:
                            tipo = TipoTransacao.RECEITA;
                    }
                    System.out.println("Insira a categoria da transação: ");
                    transacaoService.cadastrarTransacao(new Transacao(valor, dataHora, descricao, new Categoria(nomeCategoria, descricaoCategoria), tipo));
                    pausar();
                    break;
                case 2:
                    System.out.println(">>> Listar transações");
                    System.out.println(transacaoService.listarTransacoes());
                    pausar();
                    break;
                case 3:
                    System.out.println(">>> Buscar transação por ID");
                    pausar();
                    break;
                case 4:
                    System.out.println(">>> Listar transações por tipo");
                    pausar();
                    break;
                case 5:
                    System.out.println(">>> Deletar transação");
                    pausar();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    pausar();
            }
        }
    }

    public static void telaMetas() {
        boolean voltar = false;

        while (!voltar) {
            limparConsole();
            System.out.println("=================================");
            System.out.println("           MENU METAS");
            System.out.println("=================================");
            System.out.println("1 - Cadastrar meta");
            System.out.println("2 - Listar metas");
            System.out.println("3 - Atualizar progresso");
            System.out.println("4 - Deletar meta");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println(">>> Cadastrar meta");
                    pausar();
                    break;
                case 2:
                    System.out.println(">>> Listar metas");
                    pausar();
                    break;
                case 3:
                    System.out.println(">>> Atualizar progresso da meta");
                    pausar();
                    break;
                case 4:
                    System.out.println(">>> Deletar meta");
                    pausar();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    pausar();
            }
        }
    }

    public static void pausar() {
        System.out.println("\nPressione ENTER para continuar...");
        leitor.nextLine();
    }

    public static void limparConsole() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}