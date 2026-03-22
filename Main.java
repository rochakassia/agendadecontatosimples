import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== AGENDA DE CONTATOS =====");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Buscar");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Contato c = new Contato(nome, telefone, email);
                    Agenda.adicionarContato(c);

                    System.out.println("Contato adicionado!");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE CONTATOS ---");
                    Agenda.listarContatos();
                    break;

                case 3:
                    System.out.print("Nome para remover: ");
                    String nomeRemover = sc.nextLine();

                    Agenda.removerContato(nomeRemover);
                    System.out.println("Contato removido (se existia).");
                    break;

                case 4:
                    System.out.print("Nome do contato que deseja atualizar: ");
                    String nomeBusca = sc.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();

                    System.out.print("Novo telefone: ");
                    String novoTelefone = sc.nextLine();

                    System.out.print("Novo email: ");
                    String novoEmail = sc.nextLine();

                    Contato novoContato = new Contato(novoNome, novoTelefone, novoEmail);
                    Agenda.atualizarContato(nomeBusca, novoContato);

                    System.out.println("Contato atualizado!");
                    break;

                case 5:
                    System.out.print("Nome para buscar: ");
                    String nomeBusca2 = sc.nextLine();

                    Agenda.buscarContato(nomeBusca2);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}