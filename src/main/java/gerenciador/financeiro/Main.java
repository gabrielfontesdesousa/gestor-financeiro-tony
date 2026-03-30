package gerenciador.financeiro;

import gerenciador.financeiro.db.ConexaoDB;
import gerenciador.financeiro.db.InicializadorDB;
import gerenciador.financeiro.model.Categoria;
import gerenciador.financeiro.repository.CategoriaRepository;
import gerenciador.financeiro.service.CategoriaService;
import gerenciador.financeiro.service.TransacaoService;

import java.util.Scanner;

public class Main {
    static Scanner leitor = new Scanner(System.in);
    static ConexaoDB conexaoDB = new ConexaoDB();
    static TransacaoService transacaoService = new TransacaoService(conexaoDB);
    static CategoriaService categoriaService =
            new CategoriaService(
                    new CategoriaRepository(conexaoDB.getJdbcTemplate())
            );


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
            System.out.println("3 - Buscar por id");
            System.out.println("4 - Buscar por nome");
            System.out.println("5 - Atualizar categoria");
            System.out.println("6 - Deletar categoria");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println(">>> Cadastrar categoria");
                    System.out.println("Nome da categoria:");
                    String nome = leitor.nextLine();
                    System.out.println("Descrição: ");
                    String desc = leitor.nextLine();

                    Categoria categoria = new Categoria(nome, desc);
                    categoriaService.cadastrarCategoria(categoria);
                    System.out.println("Categoria Registrada com sucesso!");
                    pausar();
                    break;
                case 2:
                    System.out.println(">>> Listar categorias");
                    categoriaService.listarCategorias().forEach(c -> {
                        System.out.println("ID: " + c.getId());
                        System.out.println("Nome: " + c.getNome());
                        System.out.println("Descrição: " + c.getDescricao());
                        System.out.println("------------------");
                    });
                    pausar();
                    break;
                case 3:
                    System.out.println(">>> Buscar categoria por id");
                    System.out.println("Informe o id que deseja buscar: ");
                    Integer id = leitor.nextInt();
                    leitor.nextLine();
                    categoria = categoriaService.buscarCategoriaPorId(id);
                    System.out.println(categoria.toString());
                    pausar();
                    break;
                case 4:
                    System.out.println(">>> Buscar categoria por nome");
                    System.out.println("Informe o nome da categoria: ");
                    String buscarNome = leitor.nextLine();
                    categoria = categoriaService.buscarCategoriaPorNome(buscarNome);
                    System.out.println(categoria.toString());
                    pausar();
                    break;
                case 5:
                    System.out.println(">>> Atualizar categoria");
                    System.out.println("Informe o ID da categoria a ser atualizada: ");
                    id = leitor.nextInt();
                    leitor.nextLine();
                    System.out.println("Novo nome:");
                    String novoNome = leitor.nextLine();
                    System.out.println("Nova descrição:");
                    String novaDescricao = leitor.nextLine();
                    categoria = categoriaService.buscarCategoriaPorId(id);
                    categoria.setNome(novoNome);
                    categoria.setDescricao(novaDescricao);
                    categoriaService.atualizarCategoria(id, categoria);
                    System.out.println(categoria.toString());
                    System.out.println("Categoria atualizada");
                    pausar();
                    break;
                case 6:
                    System.out.println(">>> Deletar categoria");
                    System.out.println("Informe o ID da categoria a ser deletada: ");
                    id = leitor.nextInt();
                    leitor.nextLine();
                    categoriaService.removerCategoria(id);
                    System.out.println("Categoria removida!");
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
                    System.out.println(">>> Cadastrar transação");
                    pausar();
                    break;
                case 2:
                    System.out.println(">>> Listar transações");
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