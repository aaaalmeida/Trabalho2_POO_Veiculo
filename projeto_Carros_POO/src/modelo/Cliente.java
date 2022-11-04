package modelo;
import java.util.Objects;

public class Cliente {
    private String nome;
    private String telefone;
    private String CPF;
    private int identificador; // identificador
    private static int codigo = 0;

    public Cliente(String nome, String telefone, String CPF) {
        this.nome = nome;
        this.telefone = telefone;
        this.CPF = CPF;
        identificador = ++codigo;
    }

    @Override
    public String toString() {
        return "CODIGO IDENTIFICADOR: " + identificador + "\nNome: " + nome +
                "\nTelefone: " + telefone + "\nCPF: " + CPF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return identificador == cliente.identificador;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCPF() {
        return CPF;
    }
}
