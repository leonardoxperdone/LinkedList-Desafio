
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<Ninja> listaNinja = new LinkedList<>();
        int opc = 0;

        do {
            System.out.println("\n=== CADASTRO NINJA ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Remover");
            System.out.println("3 - Visualizar todos");
            System.out.println("4 - Buscar por nome");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");

            try {
                opc = sc.nextInt();
                sc.nextLine(); // consome o enter
            } catch (InputMismatchException e) {
                System.out.println("⚠️ ERRO: digite um número válido.");
                sc.nextLine(); // limpa entrada inválida
                continue;
            }

            switch (opc) {
                case 1:
                    System.out.println("\n--- Novo Ninja ---");
                    System.out.print("Nome: ");
                    String name = sc.nextLine();

                    int age = 0;
                    try {
                        System.out.print("Idade: ");
                        age = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("⚠️ Idade inválida.");
                        sc.nextLine();
                        continue;
                    }

                    System.out.print("Vila: ");
                    String village = sc.nextLine();

                    listaNinja.add(new Ninja(name, age, village));
                    System.out.println("✅ Cadastro finalizado com sucesso.");
                    break;

                case 2:
                    if (listaNinja.isEmpty()) {
                        System.out.println("⚠️ Lista vazia, nada a remover.");
                    } else {
                        listaNinja.poll(); // remove o primeiro
                        System.out.println("✅ Ninja removido.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Lista de Ninjas ---");
                    if (listaNinja.isEmpty()) {
                        System.out.println("📭 A lista está vazia.");
                    } else {
                        for (Ninja t : listaNinja) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome para buscar: ");
                    String nomeBusca = sc.nextLine();
                    boolean encontrado = false;

                    for (Ninja n : listaNinja) {
                        if (n.getNome().equalsIgnoreCase(nomeBusca)) {
                            System.out.println("✅ Ninja encontrado: " + n);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("❌ Ninja não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("🏁 Encerrando o programa...");
                    break;

                default:
                    System.out.println("❌ Opção inválida.");
                    break;
            }

        } while (opc != 5);

        sc.close();
    }
}
