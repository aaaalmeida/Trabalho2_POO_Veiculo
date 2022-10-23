import trabalho2_POO_VEICULO.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FicharioContrato implements Fichario {
    private ArrayList<Contrato> listaContrato;
    private Scanner scanner; 

    public FicharioContrato(ArrayList<Contrato> contratos, Scanner scanner) {
        listaContrato = contratos;
        this.scanner = scanner;
    }

    public void adiciona(){
        int idCliente, idVeiculo, tipoContrato;

        Cliente cliente;
        Veiculo veiculo;
        System.out.println("\nInforme o CODIGO IDENTIFICADOR do Cliente: ");
        idCliente = scanner.nextInt();
        //TODO: verificar se id do cliente existe

        System.out.println("Informe o CODIGO IDENTIFICADOR do Veiculo: ");
        idVeiculo = scanner.nextInt();
        //TODO: verificar se id do veiculo existe
        
        System.out.println("Informe o tipo de Contrato:");
        System.out.println("[1] VENDA  |  [2] ALUGUEL");
        tipoContrato = scanner.nextInt();

        switch (tipoContrato){
            case 1:
                int qtdParcelas;
                System.out.println("Digite a quantidade de parcelas: ");
                qtdParcelas = scanner.nextInt();
                Venda novoContrato = new Venda(veiculo, cliente, qtdParcelas);
                break;

            case 2:
                LocalDate dataDevolucao;
                System.out.println("Digite a data de devolucao [dd/MM/yyyy]:");
                dataDevolucao = scanner.nextLine();
                //TODO: testar se essa leitura ta certa
                // Venda novoContrato = new Aluguel(veiculo, cliente, dataDevolucao);

            default:
            System.out.println("Tipo nao reconhecido, a operacao falhou");
            return;
        }

        System.out.println("Contrato criado");
        listaContrato.add(novoContrato);
    };

    public void remove(){};

    public void consulta(){};

    public void relatorio(){};

}
