import java.util.ArrayList;
import java.util.List;

public class CadastroCliente {
    private String nome_tutor;
    private String cpf;
    private List<Animal> animais;


    public CadastroCliente(String nome_tutor, String cpf) {
        this.nome_tutor = nome_tutor;
        this.cpf = cpf;
        this.animais = new ArrayList<>();
    }

    public void adicionarAnimal(Animal animal) {
        if (animal != null) {
            animais.add(animal);
        }
    }

    public List<Animal> getAnimais() {
        return animais;

    }

    public String getCpf() {
        return cpf;
    }

    public String toString() {
        return "Cliente" + nome_tutor + ", CPF" + cpf + ", Quantidade de Animais: " + animais.size();
    }
}
