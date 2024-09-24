package bancario;

public class ContaBancaria {
    private String numero;
    private double saldo;
    private double limite;
    private Cliente cliente;

    // Construtor com todos os parâmetros
    public ContaBancaria(String numero, double saldo, double limite, Cliente cliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        this.cliente = cliente;
    }

    // Sobrecarga do construtor para criar uma conta com saldo inicial 0 e limite 0
    public ContaBancaria(String numero, Cliente cliente) {
        this(numero, 0.0, 0.0, cliente);
    }

    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    // Método para sacar dinheiro
    public void sacar(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para o saque.");
        }
    }

    // Método para depositar dinheiro
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
    }

    // Método para transferir dinheiro entre contas
    public void transferir(ContaBancaria contaDestino, double valor) {
        if (valor <= saldo + limite) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada para a conta " + contaDestino.getNumero());
        } else {
            System.out.println("Saldo insuficiente para a transferência.");
        }
    }

    // Método para exibir o saldo atual
    public void exibirSaldo() {
        System.out.println("Saldo atual da conta " + numero + ": R$ " + saldo);
    }
}