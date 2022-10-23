import java.time.LocalDate;
import java.time.Period;
// import trabalho2_POO_VEICULO.*;

public class Aluguel extends Contrato {
    private LocalDate dataDevolucao;
    private Period tempoAlugado;

    public Aluguel(Veiculo veiculo, Cliente cliente, LocalDate dataDevolucao) {
        super(veiculo, cliente);
        this.dataDevolucao = dataDevolucao;
        tempoAlugado = Period.between(dataDevolucao, dataSaida);
        this.preco = veiculo.getPreco() * 0.08; // mensalidade de 8% do custo do veiculo
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public Period getTempoAlugado() {
        return tempoAlugado;
    }

}
