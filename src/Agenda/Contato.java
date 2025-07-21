package Agenda;

// Classe que representa um contato com nome, telefone e email
public class Contato {

    // Atributos privados, encapsulados
    private String nome;
    private String telefone;
    private String email;

    // Métodos "getters" - usados para obter os valores dos atributos

    // Retorna o nome do contato
    public String getNome() {
        return nome;
    }

    // Retorna o telefone do contato
    public String getTelefone() {
        return telefone;
    }

    // Retorna o email do contato
    public String getEmail() {
        return email;
    }

    // Métodos "setters" - usados para definir/alterar os valores dos atributos

    // Define o nome do contato
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Define o telefone do contato
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Define o email do contato
    public void setEmail(String email) {
        this.email = email;
    }
}
