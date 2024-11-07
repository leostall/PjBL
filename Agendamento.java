import java.time.LocalDate;

public class Agendamento {
    private LocalDate dataHora;
    private String tipoServico;
    private String cliente;


    public Agendamento(LocalDate date, String tipoServico, String cliente) {
        this.dataHora = date;
        this.tipoServico = tipoServico;
        this.cliente = cliente;
    }

    public boolean verificarDisponibilidade(LocalDate novaDataHora) {
        return !dataHora.equals(novaDataHora);
    }

    public void imprimirInformacoesContato() {
        System.out.println("Data: " + dataHora);
        System.out.println("Serviço: " + tipoServico);
        System.out.println("Nome do cliente: " + cliente);
    }
}

