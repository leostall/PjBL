public abstract class Produto {
    private int codigo;
    private String nome;
    private double preco_custo;
    private double preco_venda;
    private int estoque;
    private String descricao;

    Produto(int codigo, String nome, double preco_custo, double preco_venda, int estoque, String descricao){
        this.codigo = codigo;
        this.nome = nome;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.estoque = estoque;
        this.descricao = descricao;
    }

    public int atualizarEstoque(int quantidade){
        this.estoque += quantidade;
        return this.estoque;
    }
}
