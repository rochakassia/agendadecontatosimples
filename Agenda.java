import java.io.*;
import java.util.ArrayList;

public class Agenda {

    public static void adicionarContato(Contato c) {
        try (FileWriter fw = new FileWriter("contatos.txt", true)) {
            fw.write(c.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listarContatos() {
        try (BufferedReader br = new BufferedReader(new FileReader("contatos.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                System.out.println("Nome: " + dados[0] +
                        " | Telefone: " + dados[1] +
                        " | Email: " + dados[2]);
            }
        } catch (IOException e) {
            System.out.println("Nenhum contato encontrado.");
        }
    }

    public static void removerContato(String nomeBusca) {
        ArrayList<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("contatos.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (!dados[0].equalsIgnoreCase(nomeBusca)) {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contatos.txt"))) {
            for (String l : linhas) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarContato(String nomeBusca, Contato novoContato) {
        ArrayList<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("contatos.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (dados[0].equalsIgnoreCase(nomeBusca)) {
                    linhas.add(novoContato.toString());
                } else {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contatos.txt"))) {
            for (String l : linhas) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buscarContato(String nomeBusca) {
        try (BufferedReader br = new BufferedReader(new FileReader("contatos.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (dados[0].equalsIgnoreCase(nomeBusca)) {
                    System.out.println("Encontrado: " +
                            dados[0] + " | " +
                            dados[1] + " | " +
                            dados[2]);
                    return;
                }
            }

            System.out.println("Contato não encontrado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}