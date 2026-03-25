package gerenciador.financeiro;
import java.util.Scanner;

public class Main {

    static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
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
                    // chamar service aqui
                    pausar();
                    break;
                case 2:
                    System.out.println(">>> Listar categorias");
                    // chamar service aqui
                    pausar();
                    break;
                case 3:
                    System.out.println(">>> Buscar categoria por nome");
                    // chamar service aqui
                    pausar();
                    break;
                case 4:
                    System.out.println(">>> Atualizar categoria");
                    // chamar service aqui
                    pausar();
                    break;
                case 5:
                    System.out.println(">>> Deletar categoria");
                    // chamar service aqui
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