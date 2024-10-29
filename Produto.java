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

        public int setEntradaEstoque(int quantidade){
            this.estoque += quantidade;
            return this.estoque;
        }

        public int setSaidaEstoque(int quantidade){
            this.estoque -= quantidade;
            return this.estoque;
        }

        public double atualizarValor(double preco_venda){
            this.preco_venda = preco_venda;
            return this.preco_venda;
        }
        public double calcularLucro() {
            return this.preco_venda - this.preco_custo;
        }
        public boolean verificarEstoqueBaixo(int limite) {
            return this.estoque < limite;
        }
        public String exibirInformacoes() {
            return "Código: " + codigo + "\nNome: " + nome + "\nPreço de Custo: " + preco_custo +
                    "\nPreço de Venda: " + preco_venda + "\nEstoque: " + estoque +
                    "\nDescrição: " + descricao;
        }

    }


