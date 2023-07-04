import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nome = "Felícia Barros";
        String tipoDeConta = "corrente";
        double saldoAtual = 3500;
        String mensagemInicial = String.format("""
                ****************************************
                Dados iniciais do cliente:
                
                Nome: %s
                Tipo de conta: %s
                Saldo atual: R$ %.2f
                ****************************************
                """, nome,tipoDeConta, saldoAtual);
        System.out.println(mensagemInicial);
        Scanner leitor = new Scanner(System.in);
        int opcoes = 0;

        while (opcoes != 4) {
            double valorTransferencia;

            System.out.println("""
                    Operações:
                    
                    1- Consultar saldos
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                    
                    Digite a opção desejada:
                    """);

            opcoes = leitor.nextInt();
            if (opcoes == 1) {
                System.out.println("> Seu saldo atual é de: R$ " + saldoAtual);
            } else if (opcoes == 2) {
                System.out.println("Qual valor você deseja adicionar?");
                valorTransferencia = leitor.nextDouble();
                if (valorTransferencia > 0) {
                    saldoAtual += valorTransferencia;
                    System.out.println("> Seu saldo atual é de R$ " + saldoAtual);
                } else {
                    System.out.println("> Você tentou enviar um valor inválido!");
                }
            } else if (opcoes == 3) {
                System.out.println("Qual valor você deseja sacar?");
                valorTransferencia = leitor.nextDouble();
                if (valorTransferencia > saldoAtual) {
                    System.out.println("> Você não tem saldo suficiente para essa transação!");
                } else {
                    saldoAtual -= valorTransferencia;
                    System.out.println("> Seu saldo atual é de R$ " + saldoAtual);
                }
            } else if (opcoes == 4) {
                System.out.println("Processo finalizado com sucesso!");
                break;
            } else {
                System.out.println("> Opção inválida!");
            }
        }
    }
}