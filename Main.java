public class Main {
    public static void main(String[] args) {
        CadastroCliente cliente1 = new CadastroCliente("João Silva", "123.456.789-00");

        Animal cachorro = new Cachorro("Rex", "João Silva", "2018-06-12", "Labrador", true, 25.5);
        Animal gato = new Gato("Mimi", "João Silva", "2019-08-10", "Persa", false, 4.2);
        Animal passaro = new Passaro("Piu-Piu", "João Silva", "2020-01-01", "Canário", true, 0.1);

        cliente1.adicionarAnimal(cachorro);
        cliente1.adicionarAnimal(gato);
        cliente1.adicionarAnimal(passaro);

        // Exibir informações do cliente e seus animais
        System.out.println(cliente1);
        System.out.println("Animais do cliente:");

        for (Animal animal : cliente1.getAnimais()) {
            animal.exibirDados();
            System.out.println();
        }
    }
}
