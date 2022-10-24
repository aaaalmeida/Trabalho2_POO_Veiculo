import trabalho2_POO_VEICULO.*;

import java.util.ArrayList;
import java.util.Scanner;

public class FicharioVeiculo implements Fichario {
    private ArrayList<Veiculo> listaVeiculos;
    private Scanner scanner;

    public FicharioVeiculo(ArrayList<Veiculo> veiculos, Scanner scanner) {
        listaVeiculos = veiculos;
        this.scanner = scanner;
    }

    public void adiciona() {
        String marca, modelo, placa;
        int anoFab, anoMod;
        double preco;
        Veiculo novoVeiculo = null;
        
        // scanner.skip("\n");
        System.out.println("\nDigite a placa do veiculo: ");
        placa = scanner.nextLine();
        System.out.println("Digite a marca do veiculo: ");
        marca = scanner.nextLine();
        System.out.println("Digite o modelo do veiculo: ");
        modelo = scanner.nextLine();
        System.out.println("Digite o ano de fabricacao do veiculo: ");
        anoFab = scanner.nextInt();
        System.out.println("Digite o ano do modelo do veiculo: ");
        anoMod = scanner.nextInt();
        System.out.println("Digite o preco do veiculo: ");
        preco = scanner.nextDouble();

        System.out.println("Digite o tipo de veiculo: ");
        System.out.println("[1] CARRO  |  [2] ONIBUS  |  [3] CAMINHAO");
        int tipo;
        tipo = scanner.nextInt();

        switch (tipo) {
            case 1:
                int qtdPortas;

                System.out.println("Digite a quantidade de portas do Carro: ");
                qtdPortas = scanner.nextInt();
                novoVeiculo = new Carro(marca, modelo, placa, anoFab, anoMod, preco, qtdPortas);
                break;

            case 2:
                int qtdEixo, qtdPas;

                System.out.println("Digite a quantidade de eixos do Onibus: ");
                qtdEixo = scanner.nextInt();
                System.out.println("Digite a quantidade de passageiros do Onibus: ");
                qtdPas = scanner.nextInt();
                novoVeiculo = new Onibus(marca, modelo, placa, anoFab, anoMod, preco, qtdPas, qtdEixo);
                break;

            case 3:
                double capacidade;

                System.out.println("Digite a capacidade de carga do Caminhao: ");
                capacidade = scanner.nextDouble();
                novoVeiculo = new Caminhao(marca, modelo, placa, anoFab, anoMod, preco, capacidade);
                break;

            default:
                System.out.println("Opcao invalida, Veiculo nao cadastrado");
                return;
        }

        System.out.println("Veiculo adicionado com sucesso");
        listaVeiculos.add(novoVeiculo);
    }

    public void remove() {
        System.out.println("\nDigite o CODIGO IDENTIFICADOR do veiculo a ser removido:");
        int id;
        id = scanner.nextInt();

        for (Veiculo veiculo : listaVeiculos)
            if (id == veiculo.hashCode()) {
                id = listaVeiculos.indexOf(veiculo);

                switch (veiculo.getSituacaoVeiculo()) {
                    case DISPONIVEL:
                    case MANUTENCAO:
                        System.out.println("Veiculo " + veiculo.hashCode() + " foi removido");
                        listaVeiculos.remove(id);
                        return;

                    case ALUGADO:
                    case COMPRADO:
                        System.out.println("Veiculo foi comprado/alugado, nao foi possivel remove-lo");
                        return;
                }

            }

        System.out.println("Veiculo nao encontrado");
    };

    public void consulta() {
        int resp;
        System.out.println("\nBuscar Veiculo por [1]INDICE, [2] PLACA ou [3]IDENTIFICADOR? ");
        resp = scanner.nextInt();
        Veiculo veiculo = null;

        switch (resp) {
            case 1:
                System.out.println("Digite o INDICE do Veiculo: ");
                int num;
                num = scanner.nextInt();
                try {
                    veiculo = listaVeiculos.get(num);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("INDICE NÃO EXISTE");
                }
                break;

            case 2:
                System.out.println("Digite a placa do Veiculo: ");
                String placa;
                placa = scanner.nextLine();
                veiculo = buscaPlaca(placa);
                break;

            default:
                System.out.println("Digite o código IDENTIFICADOR do Veiculo: ");
                int id;
                id = scanner.nextInt();
                veiculo = buscaIDENT(id);
                break;
        }

        if (veiculo != null) {
            System.out.println(veiculo);
            return;
        }

        System.out.println("Veiculo nao encontrado");
    };

    public Veiculo buscaPlaca(String placa) {
        for (Veiculo veiculo : listaVeiculos)
            if (placa == veiculo.getPlaca())
                return veiculo;

        return null;
    }

    public Veiculo buscaIDENT(int id) {
        for (Veiculo veiculo : listaVeiculos)
            if (id == veiculo.hashCode())
                return veiculo;

        return null;
    }

    public void relatorio() {
        System.out.println("----------------");
        for (Veiculo veiculo : listaVeiculos) {
            System.out.println(veiculo);
            System.out.println("----------------");
        }
    }
}
