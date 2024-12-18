import java.util.InputMismatchException;
import java.util.Scanner;

public class AplicacaoBancaria {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.print("Informe o número da conta: ");
            int numeroConta = entrada.nextInt();
            entrada.nextLine();
            System.out.print("Informe o nome do titular: ");
            String nomeTitular = entrada.nextLine();
            System.out.print("Informe o saldo inicial: ");
            double saldoInicial = entrada.nextDouble();
            System.out.print("Informe o limite de saque: ");
            double limiteDeSaque = entrada.nextDouble();

            BancoConta conta = new BancoConta(numeroConta, nomeTitular, saldoInicial, limiteDeSaque);

            System.out.println("\nConta criada com sucesso!");

            while (true) {
                System.out.println("\nEscolha uma operação:");
                System.out.println("1 - Realizar saque");
                System.out.println("2 - Fazer depósito");
                System.out.println("3 - Finalizar");
                System.out.print("Opção escolhida: ");
                int escolha = entrada.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.print("Digite o valor a sacar: ");
                        double valorSaque = entrada.nextDouble();
                        conta.realizarSaque(valorSaque);
                        break;
                    case 2:
                        System.out.print("Digite o valor a depositar: ");
                        double valorDeposito = entrada.nextDouble();
                        conta.adicionarDeposito(valorDeposito);
                        break;
                    case 3:
                        System.out.println("Encerrando o programa...");
                        entrada.close();
                        System.exit(0);
                    default:
                        System.out.println("Escolha inválida. Tente novamente.");
                }
            }
        } catch (InputMismatchException excecaoDeEntrada) {
            System.out.println("Erro: Tipo de dado inserido é inválido. Por favor, corrija sua entrada.");
        } catch (ErroDeConta excecaoDeConta) {
            System.out.println("Problema ao realizar operação: " + excecaoDeConta.getMessage());
        } catch (ErroDeValor excecaoDeValor) {
            System.out.println("Problema com o valor inserido: " + excecaoDeValor.getMessage());
        } catch (Exception excecaoGeral) {
            System.out.println("Ocorreu um erro inesperado: " + excecaoGeral.getMessage());
        } finally {
            entrada.close();
            System.out.println("\nSistema finalizado.");
        }
    }
}
