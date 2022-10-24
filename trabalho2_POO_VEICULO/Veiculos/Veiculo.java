import trabalho2_POO_VEICULO.*;

public abstract class Veiculo {
    protected String marca;
    protected String modelo;
    protected String placa;
    protected double preco;
    protected int anoFabricacao;
    protected int anoModelo;
    protected int identificador; // indicador
    protected static int codigo = 0;
    protected SituacaoVeiculo situacaoVeiculo;

    protected TipoVeiculo tipoVeiculo;

    public Veiculo(String marca, String modelo, String placa,
            int anoFabricacao, int anoModelo, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.preco = preco;
        this.situacaoVeiculo = SituacaoVeiculo.DISPONIVEL;
        identificador = ++codigo;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + "\nMarca: " + marca + "\nModelo: " + modelo + "\nAno Fabricacao: " +
                anoFabricacao + "\nAno Modelo: " + anoModelo + "\nPreco: " + preco
                + "\nTipo de Veiculo: " + switch (getTipoVeiculo()) {
                    case CARRO -> "CARRO";
                    case ONIBUS -> "ONIBUS";
                    case CAMINHAO -> "CAMINHAO";
                }
                + "\nSituacao do Veiculo: " + switch (getSituacaoVeiculo()) {
                    case DISPONIVEL -> "DISPONIVEL";
                    case ALUGADO -> "ALUGADO";
                    case COMPRADO -> "COMPRADO";
                    case MANUTENCAO -> "MANUTENCAO";
                };
    }

    @Override
    public int hashCode() {
        return Object.hash(identificador);
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public SituacaoVeiculo getSituacaoVeiculo() {
        return situacaoVeiculo;
    }

    public String getMarca() {
        return modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public double getPreco() {
        return preco;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setSituacaoVeiculo(SituacaoVeiculo situacaoVeiculo) {
        this.situacaoVeiculo = situacaoVeiculo;
    }
}
