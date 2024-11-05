public class Funcionario {
    private String nome;
    private String cpf;
    private String admissao;
    private String cargo;
    private int idade;
    private double salario;

    public Funcionario(String nome, String cpf, String admissao, String cargo, int idade, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.admissao = admissao;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;

    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Data da admissão: " + admissao);
        System.out.println("Cargo: " + cargo);
        System.out.println("Idade: " + idade);
        System.out.println("Salário: " + salario);
    }

}
