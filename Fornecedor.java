public class Fornecedor {
    private String nome;
    private String CNPJ;
    private String telefone;
    private String email;

    public Fornecedor(String nome, String CNPJ, String telefone, String email) {
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.telefone = telefone;
        this.email = email;

    }

    public double calcularValorCompra(double preco_Uni, int quantidade) {
        return preco_Uni * quantidade;
    }

        public void imprimirInformacoesContato() {
            System.out.println("Nome: " + nome);
            System.out.println("Telefone: " + telefone);
            System.out.println("Email: " + email);
        }
    }

