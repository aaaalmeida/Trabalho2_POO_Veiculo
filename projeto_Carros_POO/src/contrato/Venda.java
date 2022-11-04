package contrato;

import modelo.Cliente;
import veiculo.Veiculo;

public class Venda extends Contrato {
    private double valorParcela;
    private QtdParcela qtdParcelas;

    public Venda(Veiculo veiculo, Cliente cliente, int qtdParc) {
        super(veiculo, cliente);
        tipoContrato = TipoContrato.VENDA;
        this.preco = (veiculo.getPreco() + veiculo.getPreco() * 0.30); // custo do veiculo mais 30%
        // TODO: descobrir como receber um inteiro como valor do enum
//        this.qtdParcelas = qtdParc;
//         valorParcela = this.preco / qtdParcelas;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public QtdParcela getQtdParcelas() {
        return qtdParcelas;
    }
}