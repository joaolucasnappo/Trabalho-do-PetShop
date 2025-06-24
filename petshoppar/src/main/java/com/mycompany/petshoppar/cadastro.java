
package com.mycompany.petshoppar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nappada
 */class CadastroCliente {
    private final Scanner sc;
    private final List<Cliente> clientes;
    
    public CadastroCliente(Scanner sc) {
        this.sc = sc;
        this.clientes = new ArrayList<>();
    }

    public void executar() {
        sc.nextLine();  
        System.out.println("\n--- Cadastro de Cliente ---");
        
        System.out.println("Nome do dono:");
        String dono = sc.nextLine();

        System.out.println("Quantidade de pets:");
        int qtdPets = sc.nextInt();
        sc.nextLine();
        
        List<String> pets = new ArrayList<>();
        for (int i = 0; i < qtdPets; i++) {
            System.out.println("Nome do pet #" + (i+1) + ":");
            pets.add(sc.nextLine());
        }

        System.out.println("Telefone:");
        String telefone = sc.nextLine();

        clientes.add(new Cliente(dono, pets, telefone));
        System.out.println("\n✅ Cadastro realizado!");

        System.out.println("Adicionar mais pets? (1-Sim/2-Não)");
        if (sc.nextInt() == 1) {
            sc.nextLine();
            adicionarMaisPets(dono);
        }
    }
    
    private void adicionarMaisPets(String nomeDono) {
        System.out.println("\nQuantos pets deseja adicionar?");
        int qtd = sc.nextInt();
        sc.nextLine();
        
        for (Cliente c : clientes) {
            if (c.getDono().equalsIgnoreCase(nomeDono)) {
                for (int i = 0; i < qtd; i++) {
                    System.out.println("Nome do pet #" + (i+1) + ":");
                    c.adicionarPet(sc.nextLine());
                }
                System.out.println("🐾 Pets adicionados! Lista atual:");
                System.out.println(c.getPets());
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }
    
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
        } else {
            System.out.println("\n--- Clientes Cadastrados ---");
            clientes.forEach(c -> {
                System.out.println("Dono: " + c.getDono());
                System.out.println("Pets: " + c.getPets());
                System.out.println("Tel: " + c.getTelefone() + "\n");
            });
        }
    }
    
    public void buscarCliente(String nome) {
        boolean encontrado = false;
        for (Cliente c : clientes) {
            if (c.getDono().equalsIgnoreCase(nome)) {
                System.out.println("\n--- Dados do Cliente ---");
                System.out.println("Dono: " + c.getDono());
                System.out.println("Pets: " + c.getPets());
                System.out.println("Tel: " + c.getTelefone());
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("Cliente não encontrado!");
    }
    
    public void excluirCliente(String nome) {
        if (clientes.removeIf(c -> c.getDono().equalsIgnoreCase(nome))) {
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
}
class Cliente {
    private final String dono;
    private final List<String> pets;
    private final String telefone;
    
    public Cliente(String dono, List<String> pets, String telefone) {
        this.dono = dono;
        this.pets = pets;
        this.telefone = telefone;
    }
    
    public String getDono() { return dono; }
    public List<String> getPets() { return pets; }    public String getTelefone() { return telefone; }
    
    public void adicionarPet(String nome) {
        pets.add(nome);
    }
}
public class cadastro {
    
}
