package bancario;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar cliente 1
        Cliente cliente1 = criarCliente(scanner, 1);
        ContaBancaria conta1 = criarConta(scanner, cliente1);

        // Criar cliente 2
        Cliente cliente2 = criarCliente(scanner, 2);
        ContaBancaria conta2 = criarConta(scanner, cliente2);

        // Exibir saldos iniciais
        System.out.println("\nSaldo inicial:");
        conta1.exibirSaldo();
        conta2.exibirSaldo();

        // Realizar operações de saque e depósito com laços de repetição
        while (true) {
            int opcao = -1; // Valor inicial inválido
            while (opcao < 0 || opcao > 3) {
                System.out.println("\nDigite 1 para sacar, 2 para depositar, 3 para transferir, ou 0 para sair: ");
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                } else {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    scanner.next(); // Consumir a entrada inválida
                }
            }

            if (opcao == 1) {
                System.out.println("Escolha a conta (1 ou 2) para sacar: ");
                int contaEscolhida = scanner.nextInt();
                System.out.println("Digite o valor para sacar: ");
                double valorSaque = scanner.nextDouble();

                if (contaEscolhida == 1) {
                    conta1.sacar(valorSaque);
                } else if (contaEscolhida == 2) {
                    conta2.sacar(valorSaque);
                } else {
                    System.out.println("Conta inválida.");
                }

            } else if (opcao == 2) {
                System.out.println("Escolha a conta (1 ou 2) para depositar: ");
                int contaEscolhida = scanner.nextInt();
                System.out.println("Digite o valor para depositar: ");
                double valorDeposito = scanner.nextDouble();

                if (contaEscolhida == 1) {
                    conta1.depositar(valorDeposito);
                } else if (contaEscolhida == 2) {
                    conta2.depositar(valorDeposito);
                } else {
                    System.out.println("Conta inválida.");
                }

            } else if (opcao == 3) {
                System.out.println("Escolha a conta de origem (1 ou 2): ");
                int contaOrigem = scanner.nextInt();
                System.out.println("Digite o valor para transferir: ");
                double valorTransferencia = scanner.nextDouble();

                if (contaOrigem == 1) {
                    conta1.transferir(conta2, valorTransferencia);
                } else if (contaOrigem == 2) {
                    conta2.transferir(conta1, valorTransferencia);
                } else {
                    System.out.println("Conta de origem inválida.");
                }

            } else if (opcao == 0) {
                System.out.println("Operações encerradas.");
                break;
            }

            // Exibir saldo atualizado após cada operação
            conta1.exibirSaldo();
            conta2.exibirSaldo();
        }

        scanner.close();
    }

    // Função para criar cliente
    public static Cliente criarCliente(Scanner scanner, int numeroCliente) {
        String nome = "";
        while (true) { // Loop para validar nome com apenas letras
            System.out.printf("Digite o nome do cliente %d (somente letras): ", numeroCliente);
            nome = scanner.nextLine();
            if (nome.matches("[a-zA-Z\\s]+")) { // Verifica se contém apenas letras e espaços
                break;
            }
            System.out.println("Nome inválido! O nome deve conter apenas letras. Tente novamente.");
        }

        String cpf = "";
        while (true) { // Loop para validar CPF
            System.out.printf("Digite o CPF do cliente %d (11 dígitos): ", numeroCliente);
            cpf = scanner.nextLine();
            if (cpf.matches("\\d{11}")) { // Verifica se o CPF tem exatamente 11 dígitos
                break; // CPF válido, sai do loop
            }
            System.out.println("CPF inválido! Deve conter 11 dígitos numéricos. Tente novamente.");
        }

        return new Cliente(nome, cpf);
    }

    // Função para criar conta
    public static ContaBancaria criarConta(Scanner scanner, Cliente cliente) {
        System.out.printf("Digite o número da conta do cliente %s: ", cliente.getNome());
        String numeroConta = scanner.nextLine();
        return new ContaBancaria(numeroConta, 1000.0, 500.0, cliente); // Criando conta com saldo e limite padrão
    }
}
