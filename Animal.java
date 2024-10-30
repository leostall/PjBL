import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Animal {
    private String nome_animal;
    private String nome_tutor;
    private LocalDate dt_nasc;
    private String especie;
    private String raca;
    private boolean castrado;
    private double peso;

    public Animal(String nome_animal, String nome_tutor, String dt_nasc, String especie, String raca, boolean castrado, double peso) {
        this.nome_animal = nome_animal;
        this.nome_tutor = nome_tutor;
        this.dt_nasc = LocalDate.parse(dt_nasc);
        this.especie = especie;
        this.raca = raca;
        this.castrado = castrado;
        this.peso = peso;
    }

    // MÉTODOS GET ----------------------------------------------------------

    public String getNome(){return this.nome_animal;}
    public String getRaca(){return this.raca;}
    public boolean getCastrado(){return this.castrado;}
    public double getPeso(){return this.peso;}

    public int getIdade() {
        LocalDate agora = LocalDate.now();
        long diferencaEmAnos = ChronoUnit.YEARS.between(this.dt_nasc, agora);
        return (int) diferencaEmAnos;
    }

    // MÉTODOS SET ----------------------------------------------------------

    public void setCastrado(boolean castrado) {this.castrado = castrado;}
    public void setPeso(double peso) {this.peso = peso;}

    
    public void exibirDados() {
        System.out.println("Nome do Animal: " + nome_animal);
        System.out.println("Nome do Tutor: " + nome_tutor);
        System.out.println("Data de Nascimento: " + dt_nasc);
        System.out.println("Idade: " + getIdade() + " anos");
        System.out.println("Espécie: " + especie);
        System.out.println("Raça: " + raca);
        System.out.println("Castrado: " + (castrado ? "Sim" : "Não"));
        System.out.println("Som Emitido: " + emitirSom());
    }

    public abstract String emitirSom();
}

class Cachorro extends Animal {
    Cachorro(String nome_animal, String nome_tutor, String dt_nasc, String raca, boolean castrado, double peso) {
        super(nome_animal, nome_tutor, dt_nasc, "Cachorro", raca, castrado, peso);
    }

    @Override
    public String emitirSom() {
        return "Latido";
    }
}

class Gato extends Animal {
    Gato(String nome_animal, String nome_tutor, String dt_nasc, String raca, boolean castrado, double peso) {
        super(nome_animal, nome_tutor, dt_nasc, "Gato", raca, castrado, peso);
    }

    @Override
    public String emitirSom() {
        return "Miau";
    }
}

class Passaro extends Animal {
    Passaro(String nome_animal, String nome_tutor, String dt_nasc, String raca, boolean castrado, double peso) {
        super(nome_animal, nome_tutor, dt_nasc, "Pássaro", raca, castrado, peso);
    }

    @Override
    public String emitirSom() {
        return "Piu";
    }
}
