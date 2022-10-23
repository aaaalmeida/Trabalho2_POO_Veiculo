import java.time.LocalDate;
import java.util.Objects;
import trabalho2_POO_VEICULO.*;

public abstract class Contrato {
    protected Veiculo veiculo;
    protected Cliente cliente;
    protected double preco;
    protected LocalDate dataSaida;
    protected int identificador; // identificador
    protected static int codigo = 0;
    protected TipoContrato tipoContrato;

    public Contrato(Veiculo veiculo, Cliente cliente) {
        dataSaida = LocalDate.now();
        this.identificador = ++codigo;
        this.veiculo = veiculo;
        this.cliente = cliente;
        // preco varia conforme o tipo de contrato
    }

    @Override
    public int hashCode() {
        return Object.hash(identificador);
    }

    @Override
    public String toString() {
        return "Codigo do Contrato: " + identificador + "\nNome do Cliente: " + cliente.getNome()
                + "\nCodigo do Cliente: " + cliente.hashCode() + "\nCodigo do Veiculo: " + veiculo.hashCode()
                + "\nPlaca do Veiculo: " + veiculo.getPlaca() + "\nModelo do Veiculo: " + veiculo.getModelo()
                + "\nMarca do Veiculo: " + veiculo.getMarca() + "\nPreco do Contrato: R$ " + preco
                + "\nData de saida do Veiculo: " + dataSaida
                + "\nTipo de Veiculo: " + switch (veiculo.getTipoVeiculo()) {
                    case CARRO -> "CARRO";
                    case ONIBUS -> "ONIBUS";
                    case CAMINHAO -> "CAMINHAO";
                }
                + "\nTipo de Contrato: " + switch (tipoContrato) {
                    case VENDA -> "VENDA";
                    case ALUGUEL -> "ALUGUEL";
                };
    }

}
