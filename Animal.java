import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Animal {
    private String nome_animal;
    private String nome_tutor;
    private LocalDate dt_nasc;
    private String especie;
    private String raca;

    public Animal(String nome_animal, String nome_tutor, String dt_nasc, String especie, String raca) {
        this.nome_animal = nome_animal;
        this.nome_tutor = nome_tutor;
        this.dt_nasc = LocalDate.parse(dt_nasc);
        this.especie = especie;
        this.raca = raca;
    }

    public int getIdade(){
        LocalDate agora = LocalDate.now();
        long diferencaEmAnos = ChronoUnit.YEARS.between(this.dt_nasc, agora);
        return (int)diferencaEmAnos;
    }

    public String getEspecie() {
        return especie;
    }
}

class Cachorro extends Animal {
    Cachorro(String nome_animal, String nome_tutor, String dt_nasc, String raca){
        super(nome_animal, nome_tutor,dt_nasc, "Cachorro", raca);
    }
}

class Gato extends Animal {
    Gato(String nome_animal, String nome_tutor, String dt_nasc, String raca){
        super(nome_animal, nome_tutor,dt_nasc, "Gato", raca);
    }
}
