class ServicoPetShop {
    private Animal animal;
    private String tipoServico;
    private double preco;

    public ServicoPetShop (Animal animal, String tipoServico, double preco) {
        this.animal = animal;
        this.tipoServico = tipoServico;
        this.preco = preco;
    }

    public void realizarServico() {
        System.out.println("Serviço de " + tipoServico + " foi realizado para " + animal.getEspecie() + " com idade de " + animal.getIdade() + " anos");
        System.out.println("Preço: R$" + preco);
    }


    public Animal getAnimal() {
        return animal;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public double getPreco() {
        return preco;
    }
}
