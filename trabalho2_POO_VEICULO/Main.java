import trabalho2_POO_VEICULO.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Veiculo> lVeiculo = new ArrayList<Veiculo>();
        FicharioVeiculo ficharioVeiculo = new FicharioVeiculo(lVeiculo);
        ArrayList<Cliente> lClientes = new ArrayList<Cliente>();
        FicharioCliente ficharioCliente = new FicharioCliente(lClientes);
    
        int opcaoInterna, opcaoExterna;

        do {
            System.out.println("\nMENU DE FICHARIOS");
            System.out.println("1 - VEICULOS");
            System.out.println("2 - CLIENTES");
            System.out.println("3 - CONTRATO");
            System.out.println("Digite a opção desejada: ");
            opcaoExterna = scanner.nextInt();

            switch (opcaoExterna) {
                case 1:
                    break;
                
                case 2:
                    break;
                
                case 3:
                    break;
            }
        
        } while(opcaoExterna != 0);
    }
}
