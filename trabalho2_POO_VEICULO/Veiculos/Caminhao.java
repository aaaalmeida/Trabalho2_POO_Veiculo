import trabalho2_POO_VEICULO.*;

public class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String marca, String modelo, String placa,
            int anoFabricacao, int anoModelo, double preco,
            double capacidadeCarga) {
        super(marca, modelo, placa, anoFabricacao, anoModelo, preco);
        this.capacidadeCarga = capacidadeCarga;
        tipoVeiculo = TipoVeiculo.CAMINHAO;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
}
