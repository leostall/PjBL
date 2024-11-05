import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class CadastroCliente {
    private String nome_cliente;
    private String cpf;
    private ArrayList<Animal> animais;


    public CadastroCliente(String nome_cliente, String cpf) {
        this.nome_cliente = nome_cliente;
        this.cpf = cpf;
        this.animais = new ArrayList<>();
    }

    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    public String getNome() {
        return nome_cliente;
    }


    public ArrayList<Animal> getAnimal() {
        return animais;

    }

    public String getCpf() {
        return cpf;
    }

    public String toString() {
        return "Cliente" + nome_cliente + ", CPF" + cpf + ", Quantidade de Animais: " + animais.size();
    }

    public Animal buscarAnimalPorNome(String nome) throws AnimalNaoEncontradoException {
        for (Animal animal : animais) {
            if (animal.getNome().equalsIgnoreCase(nome)) {
                return animal;
            }
        }
        throw new AnimalNaoEncontradoException("Animal com o nome " + nome + " não foi encontrado.");
    }
}
