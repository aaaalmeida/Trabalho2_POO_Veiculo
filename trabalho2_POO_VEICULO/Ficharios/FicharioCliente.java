import trabalho2_POO_VEICULO.*;

import java.util.ArrayList;
import java.util.Scanner;

public class FicharioCliente implements Fichario {
    private ArrayList<Cliente> listaClientes;
    private Scanner scanner;

    public FicharioCliente(ArrayList<Cliente> clientes, Scanner scanner) {
        listaClientes = clientes;
        this.scanner = scanner;
    }

    public void adiciona() {
        String _nome, _telefone, _CPF;

        System.out.println("\nDigite o nome do cliente: ");
        _nome = scanner.nextLine();
        System.out.println("Digite o telefone do cliente: ");
        _telefone = scanner.nextLine();
        System.out.println("Digite o CPF do cliente: ");
        _CPF = scanner.nextLine();

        Cliente novoCLiente = new Cliente(_nome, _telefone, _CPF);
        System.out.println("Cliente " + novoCLiente.getNome() + " adicionado com o codigo " + novoCLiente.hashCode());
        listaClientes.add(novoCLiente);
    }

    public void remove() {
        System.out.println("\nDigite o CODIGO IDENTIFICADOR do cliente a ser removido: ");
        int id;
        id = scanner.nextInt();

        for (Cliente cliente : listaClientes) {
            if (id == cliente.hashCode()) {
                id = listaClientes.indexOf(cliente);
                System.out.println("Cliente " + cliente.hashCode() + " foi removido");
                listaClientes.remove(id);
                return;
            }
        }

        System.out.println("Cliente " + id + " nao encontrado");
    }

    public void consulta() {
        int resp;
        System.out.println("\nBuscar cliente por [1]INDICE, [2] CPF ou [3]IDENTIFICADOR? ");
        resp = scanner.nextInt();
        Cliente cliente = null;

        switch (resp) {
            case 1:
                System.out.println("Digite o INDICE do Cliente: ");
                int num;
                num = scanner.nextInt();
                try {
                    cliente = listaClientes.get(num);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("INDICE NÃO EXISTE");
                }
                break;
            case 2:
                cliente = buscaCPF();
                break;
            default:
                cliente = buscaIDENT();
                break;
        }

        if (cliente != null) {
            System.out.println(cliente);
            return;
        }

        System.out.println("Cliente nao encontrado");
    }

    public Cliente buscaCPF() {
        System.out.println("Digite o CPF do Cliente: ");
        String cpf;
        cpf = scanner.nextLine();

        for (Cliente cliente : listaClientes)
            if (cliente.getCPF() == cpf)
                return cliente;

        return null;
    }

    public Cliente buscaIDENT() {
        System.out.println("Digite o código IDENTIFICADOR do Cliente: ");
        long id;
        id = scanner.nextLong();

        for (Cliente cliente : listaClientes)
            if (cliente.hashCode() == id)
                return cliente;

        return null;
    }

    public void relatorio() {

        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
            System.out.println("----------------");
        }
    }
}
