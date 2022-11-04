package contrato;
import modelo.Cliente;
import veiculo.Veiculo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Contrato {
    protected Veiculo veiculo;
    protected Cliente cliente;
    protected double preco;
    protected LocalDate dataSaida;
    protected int identificador; // identificador
    protected static int codigo = 0;
    protected TipoContrato tipoContrato;

    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

    public Contrato(Veiculo veiculo, Cliente cliente) {
        dataSaida = LocalDate.now();
        this.identificador = ++codigo;
        this.veiculo = veiculo;
        this.cliente = cliente;
        // preco varia conforme o tipo de contrato
    }


    @Override
    public String toString() {
        return "Codigo do Contrato: " + identificador + "\nNome do Cliente: " + cliente.getNome()
                + "\nCodigo do Cliente: " + cliente.hashCode() + "\nCodigo do Veiculo: " + veiculo.hashCode()
                + "\nPlaca do Veiculo: " + veiculo.getPlaca() + "\nModelo do Veiculo: " + veiculo.getModelo()
                + "\nMarca do Veiculo: " + veiculo.getMarca() + "\nPreco do Contrato: R$ " + preco
                + "\nData de saida do Veiculo: " + dataSaida.format(formatter)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return identificador == contrato.identificador;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }
}
