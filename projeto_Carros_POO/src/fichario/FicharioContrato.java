package fichario;

import contrato.*;
import modelo.Cliente;
import veiculo.SituacaoVeiculo;
import veiculo.Veiculo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FicharioContrato implements Fichario {
    private ArrayList<Contrato> listaContrato;
    private Scanner scanner;

    public FicharioContrato(ArrayList<Contrato> contratos, Scanner scanner) {
        listaContrato = contratos;
        this.scanner = scanner;
    }

    public void adiciona() {
        int idCliente, idVeiculo, tipoContrato;
        Cliente cliente = null;
        Veiculo veiculo = null;
        Contrato novoContrato = null;

        scanner.skip("\n");
        System.out.println("\nInforme o CODIGO IDENTIFICADOR do Cliente: ");
        idCliente = scanner.nextInt();
        // nao tenho ideia de como consertar isso
        cliente = FicharioCliente.buscaIDENT(idCliente);
        if (cliente == null) {
            System.out.println("Cliente nao existe, a operacao falhou");
            return;
        }

        System.out.println("Informe o CODIGO IDENTIFICADOR do Veiculo: ");
        idVeiculo = scanner.nextInt();
        // idem
        veiculo = FicharioVeiculo.buscaIDENT(idVeiculo);
        if (veiculo == null) {
            System.out.println("Veiculo nao existe, a operacao falhou");
            return;
        }

        if (veiculo.getSituacaoVeiculo() != SituacaoVeiculo.DISPONIVEL) {
            System.out.println("Veiculo nao esta disponivel no momento, a operacao falhou");
            return;
        }

        System.out.println("Informe o tipo de Contrato:");
        System.out.println("[1] VENDA  |  [2] ALUGUEL");
        tipoContrato = scanner.nextInt();

        switch (tipoContrato) {
            case 1 -> {
                int qtdParcelas;
                System.out.println("Digite a quantidade de parcelas: ");
                qtdParcelas = scanner.nextInt();
                novoContrato = new Venda(veiculo, cliente, qtdParcelas);
                veiculo.setSituacaoVeiculo(SituacaoVeiculo.COMPRADO);
            }
            case 2 -> {
                String dataDevolucao;

                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

                // TODO: testar se essa leitura ta certa
                System.out.println("Digite a data de devolucao [dd/MM/yyyy]:");
                dataDevolucao = scanner.nextLine();

                LocalDate data = LocalDate.parse(dataDevolucao, formato);

                novoContrato = new Aluguel(veiculo, cliente, data);
                veiculo.setSituacaoVeiculo(SituacaoVeiculo.ALUGADO);
            }
            default -> {
                System.out.println("Tipo nao reconhecido, a operacao falhou");
                return;
            }
        }

        System.out.println("Contrato criado");
        listaContrato.add(novoContrato);
    };

    public void remove() {
        System.out.println("Digite o CODIGO IDENTIFICADOR do contrato a ser removido:");
        int id;
        id = scanner.nextInt();

        for (Contrato contrato : listaContrato)
            if (contrato.hashCode() == id) {
                if (contrato.getTipoContrato() == TipoContrato.VENDA) {
                    System.out.println("Contrato " + contrato.hashCode() + " removido");
                    id = listaContrato.indexOf(contrato);
                    listaContrato.remove(id);
                }

                else {
                    System.out.println("Contrato é do tipo ALUGUEL, nao foi possivel remover");
                }

                return;
            }

        System.out.println("Contrato nao encontrado");
    };

    public void consulta() {
        int opcao;
        System.out.println("\nBuscar Contrato por [1] INDICE ou [2] IDENTIFICADOR? ");
        opcao = scanner.nextInt();
        Contrato contrato = null;

        if (opcao == 1) {
            System.out.println("Digite o INDICE do Contrato: ");
            int num;
            num = scanner.nextInt();
            try {
                contrato = listaContrato.get(num);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("INDICE NÃO EXISTE");
                return;
            }
        } else {
            System.out.println("Digite o código IDENTIFICADOR do Contrato: ");
            int id;
            id = scanner.nextInt();
            contrato = buscaIDENT(id);
        }

        if (contrato != null) {
            System.out.println(contrato);
            return;
        }

        System.out.println("Contrato nao encontrado");
    }

    public Contrato buscaIDENT(int id) {
        for (Contrato contrato : listaContrato)
            if (contrato.hashCode() == id)
                return contrato;

        return null;
    }

    public void relatorio() {
        System.out.println("----------------");
        for (Contrato contrato : listaContrato) {
            System.out.println(contrato);
            System.out.println("----------------");
        }
    };

}