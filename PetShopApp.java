import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

// Classe centralizada para armazenar dados de cadastro
class DadosCadastro {
    static ArrayList<CadastroCliente> clientes = new ArrayList<>();
    static ArrayList<Produto> produtos = new ArrayList<>();
    static ArrayList<String> vendas = new ArrayList<>();
    static ArrayList<String> agendamentos = new ArrayList<>();
}

public class PetShopApp extends JFrame {

    public PetShopApp() {
        // Estilização
        UIManager.put("Button.background", new Color(128, 0, 128)); // Roxo para os botões
        UIManager.put("Button.foreground", Color.WHITE); // Texto branco
        UIManager.put("Panel.background", new Color(245, 245, 255)); // Fundo claro para os painéis

        setTitle("Sistema PetShop");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu principal
        JPanel mainMenu = new JPanel();
        mainMenu.setLayout(new GridLayout(6, 1));

        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        JButton btnCadastrarAnimal = new JButton("Cadastrar Animal");
        JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
        JButton btnVendaProduto = new JButton("Venda de Produto");
        JButton btnAgendarServico = new JButton("Agendar Serviço");
        JButton btnRelatorios = new JButton("Gerar Relatórios");

        mainMenu.add(btnCadastrarCliente);
        mainMenu.add(btnCadastrarAnimal);
        mainMenu.add(btnCadastrarProduto);
        mainMenu.add(btnVendaProduto);
        mainMenu.add(btnAgendarServico);
        mainMenu.add(btnRelatorios);

        add(mainMenu, BorderLayout.CENTER);

        // Ações dos botões
        btnCadastrarCliente.addActionListener(e -> abrirTelaCadastroCliente());
        btnCadastrarAnimal.addActionListener(e -> abrirTelaCadastroAnimal());
        btnCadastrarProduto.addActionListener(e -> abrirTelaCadastroProduto());
        btnVendaProduto.addActionListener(e -> abrirTelaVendaProduto());
        btnAgendarServico.addActionListener(e -> abrirTelaAgendamento());
        btnRelatorios.addActionListener(e -> abrirTelaRelatorios());

        setVisible(true);
    }

    private void abrirTelaCadastroCliente() {
        JFrame frame = new JFrame("Cadastrar Cliente");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2));

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblCpf = new JLabel("CPF:");
        JTextField txtCpf = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        frame.add(lblNome);
        frame.add(txtNome);
        frame.add(lblCpf);
        frame.add(txtCpf);
        frame.add(new JLabel("")); // Preencher célula em branco
        frame.add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String cpf = txtCpf.getText().trim();

            if (nome.isEmpty() || cpf.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Nome e CPF são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                DadosCadastro.clientes.add(new CadastroCliente(nome, cpf));
                JOptionPane.showMessageDialog(frame, "Cliente cadastrado com sucesso!");
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    private void abrirTelaCadastroAnimal() {
        JFrame frame = new JFrame("Cadastrar Animal");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(7, 2));

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblEspecie = new JLabel("Espécie:");
        String[] especies = {"Cachorro", "Gato", "Pássaro"};
        JComboBox<String> cmbEspecie = new JComboBox<>(especies);
        JLabel lblRaca = new JLabel("Raça:");
        JTextField txtRaca = new JTextField();
        JLabel lblCliente = new JLabel("Cliente:");
        JComboBox<String> cmbClientes = new JComboBox<>(DadosCadastro.clientes.stream().map(CadastroCliente::getNome).toArray(String[]::new));
        JButton btnSalvar = new JButton("Salvar");

        frame.add(lblNome);
        frame.add(txtNome);
        frame.add(lblEspecie);
        frame.add(cmbEspecie);
        frame.add(lblRaca);
        frame.add(txtRaca);
        frame.add(lblCliente);
        frame.add(cmbClientes);
        frame.add(new JLabel("")); // Preencher célula em branco
        frame.add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String especie = (String) cmbEspecie.getSelectedItem();
            String raca = txtRaca.getText().trim();
            String nomeCliente = (String) cmbClientes.getSelectedItem();

            if (nome.isEmpty() || especie.isEmpty() || raca.isEmpty() || nomeCliente == null) {
                JOptionPane.showMessageDialog(frame, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                Animal animal;
                switch (especie) {
                    case "Cachorro":
                        animal = new Cachorro(nome, nomeCliente, "2020-01-01", raca, true, 10.0);
                        break;
                    case "Gato":
                        animal = new Gato(nome, nomeCliente, "2020-01-01", raca, true, 10.0);
                        break;
                    case "Pássaro":
                        animal = new Passaro(nome, nomeCliente, "2020-01-01", raca, true, 0.5);
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Espécie inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                }

                DadosCadastro.clientes.stream()
                        .filter(cliente -> cliente.getNome().equalsIgnoreCase(nomeCliente))
                        .findFirst()
                        .ifPresent(cliente -> cliente.adicionarAnimal(animal));

                JOptionPane.showMessageDialog(frame, "Animal cadastrado com sucesso!");
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    private void abrirTelaCadastroProduto() {
        JFrame frame = new JFrame("Cadastrar Produto");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(7, 2));

        JLabel lblCodigo = new JLabel("Código:");
        JTextField txtCodigo = new JTextField();
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblPrecoCusto = new JLabel("Preço de Custo:");
        JTextField txtPrecoCusto = new JTextField();
        JLabel lblPrecoVenda = new JLabel("Preço de Venda:");
        JTextField txtPrecoVenda = new JTextField();
        JLabel lblEstoque = new JLabel("Estoque:");
        JTextField txtEstoque = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        frame.add(lblCodigo);
        frame.add(txtCodigo);
        frame.add(lblNome);
        frame.add(txtNome);
        frame.add(lblPrecoCusto);
        frame.add(txtPrecoCusto);
        frame.add(lblPrecoVenda);
        frame.add(txtPrecoVenda);
        frame.add(lblEstoque);
        frame.add(txtEstoque);
        frame.add(new JLabel("")); // Preencher célula em branco
        frame.add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText().trim());
                String nome = txtNome.getText().trim();
                double precoCusto = Double.parseDouble(txtPrecoCusto.getText().trim());
                double precoVenda = Double.parseDouble(txtPrecoVenda.getText().trim());
                int estoque = Integer.parseInt(txtEstoque.getText().trim());
                String descricao = txtNome.getText().trim();

                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Nome do produto é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    Produto produto = new ProdutoVenda(codigo, nome, precoCusto, precoVenda, estoque, descricao);
                    DadosCadastro.produtos.add(produto);
                    JOptionPane.showMessageDialog(frame, "Produto cadastrado com sucesso!");
                    frame.dispose();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Preencha os campos com valores válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    // Tela para registrar uma venda de produto
    private void abrirTelaVendaProduto() {
        JFrame frame = new JFrame("Venda de Produto");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        JLabel lblProduto = new JLabel("Produto:");
        JComboBox<String> cmbProduto = new JComboBox<>(DadosCadastro.produtos.stream()
                .map(Produto::getNome)  // Assumindo que Produto tem o método getNome()
                .toArray(String[]::new));
        JLabel lblQuantidade = new JLabel("Quantidade:");
        JTextField txtQuantidade = new JTextField();
        JButton btnVender = new JButton("Vender");

        frame.add(lblProduto);
        frame.add(cmbProduto);
        frame.add(lblQuantidade);
        frame.add(txtQuantidade);
        frame.add(new JLabel("")); // Preencher célula em branco
        frame.add(btnVender);

        btnVender.addActionListener(e -> {
            String produtoNome = (String) cmbProduto.getSelectedItem();
            int quantidade;
            try {
                quantidade = Integer.parseInt(txtQuantidade.getText().trim());
                if (quantidade <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Quantidade inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Produto produto = DadosCadastro.produtos.stream()
                    .filter(p -> p.getNome().equals(produtoNome))
                    .findFirst().orElse(null);

            if (produto != null && produto.getEstoque() >= quantidade) {
                // Registrar venda
                produto.setEntradaEstoque(produto.getEstoque() - quantidade);
                DadosCadastro.vendas.add("Venda: " + produtoNome + " - Quantidade: " + quantidade);
                JOptionPane.showMessageDialog(frame, "Venda realizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(frame, "Estoque insuficiente para a venda!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    // Tela para agendamento de serviços
    private void abrirTelaAgendamento() {
        JFrame frame = new JFrame("Agendar Serviço");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        JLabel lblAnimal = new JLabel("Animal:");
        JComboBox<String> cmbAnimal = new JComboBox<>(DadosCadastro.clientes.stream()
                .flatMap(cliente -> cliente.getAnimal().stream())  // Assumindo que cada cliente tem uma lista de animais
                .map(Animal::getNome)  // Método que retorna o nome do animal
                .toArray(String[]::new));
        JLabel lblServico = new JLabel("Serviço:");
        JComboBox<String> cmbServico = new JComboBox<>(new String[]{"Banho", "Tosa", "Banho e Tosa"});
        JLabel lblData = new JLabel("Data (AAAA-MM-DD):");
        JTextField txtData = new JTextField();
        JButton btnAgendar = new JButton("Agendar");

        frame.add(lblAnimal);
        frame.add(cmbAnimal);
        frame.add(lblServico);
        frame.add(cmbServico);
        frame.add(lblData);
        frame.add(txtData);
        frame.add(new JLabel("")); // Preencher célula em branco
        frame.add(btnAgendar);

        btnAgendar.addActionListener(e -> {
            String nomeAnimal = (String) cmbAnimal.getSelectedItem();
            String servico = (String) cmbServico.getSelectedItem();
            String data = txtData.getText().trim();

            if (nomeAnimal == null || servico == null || data.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                LocalDate.parse(data);  // Verifica se a data está no formato correto (AAAA-MM-DD)
                DadosCadastro.agendamentos.add("Agendamento: " + nomeAnimal + " - Serviço: " + servico + " - Data: " + data);
                JOptionPane.showMessageDialog(frame, "Serviço agendado com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Data inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    // Tela para gerar relatórios de vendas e agendamentos
    private void abrirTelaRelatorios() {
        JFrame frame = new JFrame("Relatórios");
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        JTextArea txtRelatorios = new JTextArea();
        txtRelatorios.setEditable(false);

        JButton btnGerarVendas = new JButton("Gerar Relatório de Vendas");
        JButton btnGerarAgendamentos = new JButton("Gerar Relatório de Agendamentos");

        JPanel panel = new JPanel();
        panel.add(btnGerarVendas);
        panel.add(btnGerarAgendamentos);

        btnGerarVendas.addActionListener(e -> {
            StringBuilder vendasReport = new StringBuilder("Relatório de Vendas:\n");
            for (String venda : DadosCadastro.vendas) {
                vendasReport.append(venda).append("\n");
            }
            txtRelatorios.setText(vendasReport.toString());
        });

        btnGerarAgendamentos.addActionListener(e -> {
            StringBuilder agendamentosReport = new StringBuilder("Relatório de Agendamentos:\n");
            for (String agendamento : DadosCadastro.agendamentos) {
                agendamentosReport.append(agendamento).append("\n");
            }
            txtRelatorios.setText(agendamentosReport.toString());
        });

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(txtRelatorios), BorderLayout.CENTER);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(PetShopApp::new);
    }
}
