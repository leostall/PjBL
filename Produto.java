public abstract class Produto {
    private int codigo;
    private String nome;
    private double precoCusto;
    private double precoVenda;
    private int estoque;
    private String descricao;

    public Produto(int codigo, String nome, double precoCusto, double precoVenda, int estoque, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
        this.descricao = descricao;
    }
    // MÉTODOS GET ----------------------------------------------------------
    
    public double getLucro() {return this.precoVenda - this.precoCusto;}
    public int getEstoque() {return this.estoque;}
    public double getPrecoVenda() {return this.precoVenda;}
    public double getPrecoCusto() {return this.precoCusto;}
    public int getCodigo() {return this.codigo;}


    // MÉTODOS SET ----------------------------------------------------------

    public double setValor(double preco_venda){
        if(preco_venda >= 0){ // Vrifica se o valor é maior ou igual a 0, pois não pdoemos ter um preoduto com valor negativo
            this.precoVenda = preco_venda;
            return this.precoVenda;
        } else{
            return -1;
        }
    }

    public int setSaidaEstoque(int quantidade) {
        if (quantidade <= this.estoque) {
            this.estoque -= quantidade;
        } else {
            System.out.println("Quantidade de saída excede o estoque atual!");
        }
        return this.estoque;
    }

    public int setEntradaEstoque(int quantidade) {
        this.estoque += quantidade;
        return this.estoque;
    }

    public void exibirInformacoes() {
        System.out.println("Código: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço de Custo: " + this.precoCusto);
        System.out.println("Preço de Venda: " + this.precoVenda);
        System.out.println("Estoque: " + this.estoque);
        System.out.println("Descrição: " + this.descricao);
    }
}

class ProdutoInterno extends Produto {
    public ProdutoInterno(int codigo, String nome, double preco_custo, int estoque, String descricao) {
        super(codigo, nome, preco_custo, -1, estoque, descricao);
    }
}

class ProdutoVenda extends Produto {
    public ProdutoVenda(int codigo, String nome, double preco_custo, double preco_venda, int estoque, String descricao) {
        super(codigo, nome, preco_custo, preco_venda, estoque, descricao);
    }

    public double calcularLucro() {
        return getPrecoVenda() - getPrecoCusto();
    }
}

