import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    public static void main(String[] args){

        PessoaDao pessoas = new PessoaDao();
        scanner = new Scanner(System.in);
        int resposta = 0;

        while(resposta != 4){
            System.out.println("---- Menu ----");
            System.out.println("1 - Salvar Pessoa");
            System.out.println("2 - Listar Pessoas");
            System.out.println("3 - Deletar por email");
            System.out.println("4 - Sair");

            resposta = scanner.nextInt();
            scanner.nextLine();

            switch (resposta){
                case 1:
                    Pessoa novaPessoa = cadastrarPessoa();
                    pessoas.salvarPessoa(novaPessoa);
                    break;
                case 2:
                    System.out.println("--- Lista de Pessoas ---");

                    for (Pessoa pessoa : pessoas.getPessoas()){
                        System.out.println("Nome: " + pessoa.getNome());
                        System.out.println("E-mail: " + pessoa.getEmail());
                        System.out.println("\n");
                    }
                    break;
                case 3:
                    System.out.println("Informe o email da pessoa a ser deletada: ");
                    String email = scanner.nextLine();
                    pessoas.deletarPorEmail(email);
                    break;
                case 4:
                    System.out.println("Saindo do sistema!");
                    break;
                default:
                    System.out.println("Escolha uma opção válida!");
            }

        }

        scanner.close();
    }


    private static Pessoa cadastrarPessoa(){
        System.out.println("Informe o nome da Pessoa a ser adicionada");
        String nomePessoa = scanner.nextLine();
        System.out.println("Informe o email da Pessoa a ser adicionada");
        String emailPessoa = scanner.nextLine();
        Pessoa novaPessoa = new Pessoa(nomePessoa,emailPessoa);
        return novaPessoa;
    }

}
