import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        String nome = "Clark Kent";
        String tipoConta = "Corrente";
        double saldo = 1599.99;

        System.out.println("*************************************");
        System.out.println("Nome do cliente: " + nome);
        System.out.println("Tipo de conta: " + tipoConta);
        System.out.printf("Saldo inicial: R$ %.2f%n", saldo);
        System.out.println("*************************************");

        Scanner leitura = new Scanner(System.in);
        int opcao = 0;

        String menu = "\nEscolha uma opção:\n" +
                "1. Consultar saldo\n" +
                "2. Transferir valor\n" +
                "3. Receber valor\n" +
                "4. Sair\n";

        while (opcao != 4) {
            System.out.println(menu);
            System.out.print("Digite a opção desejada: ");

            // Verifica se a entrada é um número válido
            if (leitura.hasNextInt()) {
                opcao = leitura.nextInt();

                // Lógica para lidar com as opções escolhidas
                switch (opcao) {
                    case 1:
                        // Exibe o saldo atual do cliente
                        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
                        break;
                    case 2:
                        // Realiza a transferência se houver saldo suficiente
                        System.out.print("Digite o valor para transferir: ");
                        double valorTransferencia = leitura.nextDouble();
                        if (valorTransferencia > saldo) {
                            System.out.println("Saldo insuficiente para realizar a transferência.");
                        } else {
                            saldo -= valorTransferencia;
                            System.out.printf("Transferência de R$ %.2f realizada com sucesso. Saldo atual: R$ %.2f%n", valorTransferencia, saldo);
                        }
                        break;
                    case 3:
                        // Adiciona valor ao saldo
                        System.out.print("Digite o valor a receber: ");
                        double valorRecebido = leitura.nextDouble();
                        saldo += valorRecebido;
                        System.out.printf("Recebimento de R$ %.2f realizado com sucesso. Saldo atual: R$ %.2f%n", valorRecebido, saldo);
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } else {
                // Caso o usuário não digite um número, limpa a entrada e exibe uma mensagem
                System.out.println("Entrada inválida. Por favor, digite um número.");
                leitura.next(); // Limpa a entrada inválida
            }
        }

        leitura.close(); // Fecha o scanner
        System.out.println("Obrigado por usar o programa!");
    }
}
