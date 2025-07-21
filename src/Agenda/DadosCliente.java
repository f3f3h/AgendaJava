package Agenda;

import java.util.Scanner;

public class DadosCliente { // Declaração da classe principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome;
        do {
            System.out.print("Digite seu nome: "); // Solicita o nome do usuário
            nome = scanner.nextLine().trim(); // Lê a entrada, removendo espaços extras no início e fim

            if (nome.isEmpty()) { // Verifica se o nome está vazio
                System.out.println("Nome não pode ser vazio. Tente novamente."); // Mensagem de erro
            }
        } while (nome.isEmpty()); // Repete enquanto o nome estiver vazio

        // Manipulação do nome: capitaliza a primeira letra de cada palavra
        nome = capitalizarNome(nome);

        String telefone;
        do {
            System.out.print("Digite seu telefone (somente números): "); // Solicita o telefone
            telefone = scanner.nextLine().trim(); // Lê e remove espaços

            // Verifica se o telefone contém apenas números e tem 10 ou 11 dígitos
            if (!telefone.matches("\\d{10,11}")) {
                System.out.println("Telefone inválido! Deve conter apenas números e ter entre 10 e 11 dígitos.");
            }
        } while (!telefone.matches("\\d{10,11}")); // Repete até o telefone ser válido

        // Formata o telefone com máscara adequada (ex: (11) 91234-5678)
        telefone = formatarTelefone(telefone);

        String email;
        do {
            System.out.print("Digite seu email: "); // Solicita o email
            email = scanner.nextLine().trim().toLowerCase(); // Remove espaços e converte para minúsculo

            // Verifica se o email está em formato válido com regex
            if (!email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$")) {
                System.out.println("Email inválido! Tente novamente.");
            }
        } while (!email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$")); // Repete até o email ser válido

        // Cria um objeto Contato e define os atributos usando os métodos setters
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setTelefone(telefone);
        contato.setEmail(email);

        // Exibe os dados do contato usando os métodos getters
        System.out.println("\nContato cadastrado com sucesso:");
        System.out.println("Nome: " + contato.getNome());
        System.out.println("Telefone: " + contato.getTelefone());
        System.out.println("Email: " + contato.getEmail());

        scanner.close(); // Fecha o Scanner para liberar o recurso
    }

    // Método que capitaliza a primeira letra de cada palavra no nome
    public static String capitalizarNome(String nome) {
        String[] partes = nome.split(" "); // Divide o nome em partes (palavras)
        StringBuilder nomeFormatado = new StringBuilder(); // Objeto para construir o nome formatado

        for (String parte : partes) {
            if (!parte.isEmpty()) {
                // Adiciona a primeira letra em maiúscula e o restante em minúscula
                nomeFormatado.append(parte.substring(0, 1).toUpperCase())
                        .append(parte.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return nomeFormatado.toString().trim(); // Retorna o nome formatado, removendo espaços finais
    }

    // Método que formata o número de telefone conforme o padrão brasileiro
    public static String formatarTelefone(String telefone) {
        if (telefone.length() == 11) { // Celular com DDD
            return "(" + telefone.substring(0, 2) + ") " +
                    telefone.substring(2, 7) + "-" +
                    telefone.substring(7);
        } else if (telefone.length() == 10) { // Telefone fixo com DDD
            return "(" + telefone.substring(0, 2) + ") " +
                    telefone.substring(2, 6) + "-" +
                    telefone.substring(6);
        } else {
            return telefone; // Caso inesperado, retorna como está
        }
    }
}
