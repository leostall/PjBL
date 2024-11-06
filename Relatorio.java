import java.util.ArrayList;

public class Relatorio {
    public static void gerarRelatorioClientes(ArrayList<CadastroCliente> clientes) {
        System.out.println("Relatório de Clientes: ");
        for (CadastroCliente cliente : clientes) {
            System.out.println(cliente);
        }
    }


    public static void gerarRelatorioProdutos(ArrayList<Produto> produtos) {
        System.out.println("Relatório de Produtos: ");
        for (Produto produto : produtos) {
            System.out.println(produto.exibirInformacoes());
        }
    }
}


