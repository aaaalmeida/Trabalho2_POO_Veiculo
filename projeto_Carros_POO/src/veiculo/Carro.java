package veiculo;
public class Carro extends Veiculo {
    private int qtdPortas;

    public Carro(String marca, String modelo, String placa,
                 int anoFabricacao, int anoModelo, double preco, int qtdPortas) {
        super(marca, modelo, placa, anoFabricacao, anoModelo, preco);
        this.qtdPortas = qtdPortas;
        tipoVeiculo = TipoVeiculo.CARRO;
    }

    public int getQtdPortas() {
        return qtdPortas;
    }

    public void setQtdPortas(int qtdPortas) {
        this.qtdPortas = qtdPortas;
    }

}
