import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContaTerminal {
    int numero = 0;
    String agencia;
    String nomeCliente;
    Double saldo = 0.00;

    public ContaTerminal(int numero, String agencia, String nomeCliente, Double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return String.format(
                "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque",
                nomeCliente, agencia, numero, saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ContaTerminal> contas = new ArrayList<>();

        while (true) {
            System.out.println("Por favor, digite o número da agência! ");
            String agencia = scanner.next();

            System.out.println("Digite o Número da Conta ");
            int numero = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Digite seu Nome ");
            String nomeCliente = scanner.nextLine();

            System.out.println("Valor do depósito: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida. Por favor, digite um valor numérico para o depósito: ");
                scanner.next();
            }
            Double saldo = scanner.nextDouble();

            ContaTerminal conta = new ContaTerminal(numero, agencia, nomeCliente, saldo);
            contas.add(conta);

            System.out.println(conta);

            scanner.nextLine();

            System.out.println("Deseja criar outra conta? (s/n)");
            String resposta = scanner.nextLine().trim();
            System.out.println("Resposta lida: " + resposta);
            if (resposta.equals("n")) {
                break;
            }
        }

        System.out.println("Contas criadas: ");
        for (ContaTerminal conta : contas) {
            System.out.println(conta);
        }

        scanner.close();
    }
}
