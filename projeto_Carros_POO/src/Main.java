import contrato.Contrato;
import fichario.FicharioCliente;
import fichario.FicharioContrato;
import fichario.FicharioVeiculo;
import modelo.Cliente;
import veiculo.Veiculo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        FicharioVeiculo ficharioVeiculo = new FicharioVeiculo(listaVeiculos, scanner);

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        FicharioCliente ficharioCliente = new FicharioCliente(listaClientes, scanner);

        ArrayList<Contrato> listaContratos = new ArrayList<Contrato>();
        FicharioContrato FicharioContrato = new FicharioContrato(listaContratos, scanner);

        int opcaoInterna, opcaoExterna;

        do {
            System.out.println("\n----------------");
            System.out.println("____ MENU DE FICHARIOS ____");
            System.out.println("0 - TERMINAR PROGRAMA");
            System.out.println("1 - VEICULO");
            System.out.println("2 - CLIENTE");
            System.out.println("3 - CONTRATO");
            opcaoExterna = scanner.nextInt();

            switch (opcaoExterna) {
                case 0:
                    System.out.println("\n----------------");
                    break;

                case 1:
                    do {
                        System.out.println("\n------------------------");
                        System.out.println("____ MENU DE VEICULOS ____");
                        System.out.println("0 - VOLTAR PARA MENU DE FICHARIOS");
                        System.out.println("1 - ADICIONAR VEICULO");
                        System.out.println("2 - REMOVER VEICULO");
                        System.out.println("3 - CONSULTAR VEICULO");
                        System.out.println("4 - RELATORIO");
                        opcaoInterna = scanner.nextShort();
                        switch (opcaoInterna) {
                            case 0 -> System.out.println("\n------------------------");
                            case 1 -> ficharioVeiculo.adiciona();
                            case 2 -> ficharioVeiculo.remove();
                            case 3 -> ficharioVeiculo.consulta();
                            case 4 -> ficharioVeiculo.relatorio();
                            default -> System.out.println("OPCAO INCORRETA");
                        }
                    } while (opcaoInterna != 0); // menu veiculo
                    break;

                case 2:
                    do {
                        System.out.println("\n------------------------");
                        System.out.println("____ MENU DE CLIENTES ____");
                        System.out.println("0 - VOLTAR PARA MENU DE FICHARIOS");
                        System.out.println("1 - ADICIONA CLIENTE");
                        System.out.println("2 - REMOVE CLIENTE");
                        System.out.println("3 - CONSULTA CLIENTE");
                        System.out.println("4 - RELATORIO");
                        opcaoInterna = scanner.nextInt();
                        switch (opcaoInterna) {
                            case 0 -> System.out.println("\n------------------------");
                            case 1 -> ficharioCliente.adiciona();
                            case 2 -> ficharioCliente.remove();
                            case 3 -> ficharioCliente.consulta();
                            case 4 -> ficharioCliente.relatorio();
                            default -> System.out.println("OPCAO INCORRETA");
                        }
                    } while (opcaoInterna != 0); // menu cliente
                    break;

                case 3:
                    do {
                        System.out.println("\n------------------------");
                        System.out.println("____ MENU DE CONTRATOS ____");
                        System.out.println("0 - VOLTAR PARA MENU DE FICHARIOS");
                        System.out.println("1 - CRIAR CONTRATO");
                        System.out.println("2 - REMOVER CONTRATO");
                        System.out.println("3 - CONSULTAR CONTRATO");
                        System.out.println("4 - RELATORIO");
                        opcaoInterna = scanner.nextShort();
                        switch (opcaoInterna) {
                            case 0 -> System.out.println("\n------------------------");
                            case 1 -> FicharioContrato.adiciona();
                            case 2 -> FicharioContrato.remove();
                            case 3 -> FicharioContrato.consulta();
                            case 4 -> FicharioContrato.relatorio();
                            default -> System.out.println("OPCAO INCORRETA");
                        }
                    } while (opcaoInterna != 0); // menu contrato

                    break;
                default:
                    System.out.println("OPCAO INCORRETA");
                    break;
            }

        } while (opcaoExterna != 0); // menu ficharios

        System.out.println("FIM DO PROGRAMA :)");
    }
}
