package bancario;

public class Cliente {
    private String nome;
    private String cpf;

    // Construtor com validação de CPF
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        setCpf(cpf); // Chama o método setCpf para validar o CPF
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.length() == 11) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido. Deve conter 11 dígitos.");
            this.cpf = "Inválido";
        }
    }
}