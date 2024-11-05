// Classe abstrata Produto
public abstract class Produto {
    private int codigo;
    private String nome;
    private double precoCusto;
    private double precoVenda;
    private int estoque;
    private String descricao;

    // Construtor da classe Produto
    public Produto(int codigo, String nome, double precoCusto, double precoVenda, int estoque, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
        this.descricao = descricao;
    }

    // Métodos de manipulação de estoque
    public int setEntradaEstoque(int quantidade) {
        this.estoque += quantidade;
        return this.estoque;
    }

    public int setSaidaEstoque(int quantidade) {
        if (quantidade <= this.estoque) {
            this.estoque -= quantidade;
        } else {
            System.out.println("Quantidade de saída excede o estoque atual!");
        }
        return this.estoque;
    }

    // Atualiza o valor de venda
    public double atualizarValor(double precoVenda) {
        this.precoVenda = precoVenda;
        return this.precoVenda;
    }

    // Calcula o lucro
    public double calcularLucro() {
        return this.precoVenda - this.precoCusto;
    }

    // Verifica se o estoque está abaixo do limite
    public boolean verificarEstoqueBaixo(int limite) {
        return this.estoque < limite;
    }

    // Exibe as informações do produto
    public String exibirInformacoes() {
        return "Código: " + codigo + "\nNome: " + nome + "\nPreço de Custo: " + precoCusto +
                "\nPreço de Venda: " + precoVenda + "\nEstoque: " + estoque +
                "\nDescrição: " + descricao;
    }
}

// Classe concreta ProdutoConcreto que herda de Produto
 class ProdutoConcreto extends Produto {
    public ProdutoConcreto(int codigo, String nome, double precoCusto, double precoVenda, int estoque, String descricao) {
        super(codigo, nome, precoCusto, precoVenda, estoque, descricao);
    }
}

