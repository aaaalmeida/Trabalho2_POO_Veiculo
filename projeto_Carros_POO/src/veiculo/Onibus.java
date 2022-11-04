package veiculo;
public class Onibus extends Veiculo {
    private int qtdPassageiro;
    private int qtdEixo;

    public Onibus(String marca, String modelo, String placa,
                  int anoFabricacao, int anoModelo, double preco, int qtdPassageiro, int qtdEixo) {
        super(marca, modelo, placa, anoFabricacao, anoModelo, preco);

        this.qtdPassageiro = qtdPassageiro;
        this.qtdEixo = qtdEixo;
        tipoVeiculo = TipoVeiculo.ONIBUS;
    }

    public void setQtdPassageiro(int qtdPassageiro) {
        this.qtdPassageiro = qtdPassageiro;
    }

    public void setQtdEixo(int qtdEixo) {
        this.qtdEixo = qtdEixo;
    }

    public int getQtdPassageiro() {
        return qtdPassageiro;
    }

    public int getQtdEixo() {
        return qtdEixo;
    }

}