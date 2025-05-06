package com.mycompany.petshoppar;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class MenuPrincipal {
    private final Scanner sc;
    private final ServicosIndividuais servicosIndividuais;
    private final PacoteServicos pacoteServicos;
    private final CadastroCliente cadastroCliente;
    
    public MenuPrincipal() {
        sc = new Scanner(System.in);
        servicosIndividuais = new ServicosIndividuais(sc);
        pacoteServicos = new PacoteServicos(sc);
        cadastroCliente = new CadastroCliente(sc);
    }

    public void executar() {
        boolean continueMenu = true;

        while (continueMenu) {
            System.out.println("\n---- Pet-Celso ----");
            System.out.println("1) Serviços individuais");
            System.out.println("2) Pacote de serviços");
            System.out.println("3) Cadastro de cliente");
            System.out.println("4) Sair");
            // Opção 5 não aparece no menu (acesso secreto)

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> servicosIndividuais.executar();
                case 2 -> pacoteServicos.executar();
                case 3 -> cadastroCliente.executar();
                case 4 -> {
                    System.out.println("Saindo... Até logo!");
                    continueMenu = false;
                }
                case 5 -> {  // Acesso secreto ao admin
                    Administrador admin = new Administrador(sc, cadastroCliente, servicosIndividuais);
                    servicosIndividuais.setAdmin(admin);
                    admin.executar();
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}

class Administrador {
    private final Scanner sc;
    private final CadastroCliente cadastroCliente;
    private final ServicosIndividuais servicosIndividuais;
    private List<String> servicosAgendados;
    
    public Administrador(Scanner sc, CadastroCliente cadastroCliente, ServicosIndividuais servicosIndividuais) {
        this.sc = sc;
        this.cadastroCliente = cadastroCliente;
        this.servicosIndividuais = servicosIndividuais;
        this.servicosAgendados = new ArrayList<>();
    }

    public void executar() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menu Administrador ---");
            System.out.println("1) Listar clientes");
            System.out.println("2) Buscar cliente");
            System.out.println("3) Excluir cliente");
            System.out.println("4) Listar serviços agendados");
            System.out.println("5) Cancelar serviço");
            System.out.println("0) Voltar");
            
            int opcao = sc.nextInt();
            sc.nextLine();
            
            switch (opcao) {
                case 1 -> cadastroCliente.listarClientes();
                case 2 -> {
                    System.out.println("Digite o nome do cliente:");
                    cadastroCliente.buscarCliente(sc.nextLine());
                }
                case 3 -> {
                    System.out.println("Digite o nome do cliente a excluir:");
                    cadastroCliente.excluirCliente(sc.nextLine());
                }
                case 4 -> listarServicosAgendados();
                case 5 -> {
                    System.out.println("Digite o nome do pet para cancelar serviço:");
                    cancelarServicoAgendado(sc.nextLine());
                }
                case 0 -> continuar = false;
                default -> System.out.println("Opção inválida!");
            }
        }
    }
    
    private void listarServicosAgendados() {
        if (servicosAgendados.isEmpty()) {
            System.out.println("Nenhum serviço agendado.");
        } else {
            System.out.println("\n--- Serviços Agendados ---");
            servicosAgendados.forEach(System.out::println);
        }
    }
    
    private void cancelarServicoAgendado(String nomePet) {
        if (servicosAgendados.removeIf(s -> s.contains(nomePet))) {
            System.out.println("Serviço cancelado com sucesso!");
        } else {
            System.out.println("Nenhum serviço encontrado para " + nomePet);
        }
    }
    
    public void agendarServico(String servico) {
        servicosAgendados.add(servico);
    }
}

class ServicosIndividuais {
    private final Scanner sc;
    private Administrador admin;
    
    public ServicosIndividuais(Scanner sc) {
        this.sc = sc;
    }
    
    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public void executar() {
        System.out.println("\n--- Serviços Individuais ---");
        System.out.println("1) Banho e Tosa");
        System.out.println("2) Consulta");
        System.out.println("3) Cirurgia");
        System.out.println("4) Voltar");

        switch (sc.nextInt()) {
            case 1 -> banhoETosa();
            case 2 -> consulta();
            case 3 -> cirurgia();
            case 4 -> {}
            default -> System.out.println("Opção inválida!");
        }
    }

    private void banhoETosa() {
        System.out.println("\nBanho e Tosa - R$60,00");
        System.out.println("1) Confirmar\n2) Cancelar");
        if (sc.nextInt() == 1) {
            System.out.println("Leve seu pet à recepção com a nota!");
        }
    }

    private void consulta() {
        sc.nextLine();
        System.out.println("\n--- Agendar Consulta ---");
        System.out.println("Nome do dono:");
        String dono = sc.nextLine();
        
        System.out.println("Nome do pet:");
        String pet = sc.nextLine();
        
        System.out.println("Data da consulta (DD/MM/AAAA):");
        String data = sc.nextLine();
        
        String servico = String.format("Consulta para %s (Dono: %s) - %s", pet, dono, data);
        System.out.println("Agendado: " + servico);
        
        if (admin != null) {
            admin.agendarServico(servico);
        }
    }

    private void cirurgia() {
        sc.nextLine();
        System.out.println("\n--- Agendar Cirurgia ---");
        System.out.println("Nome do dono:");
        String dono = sc.nextLine();
        
        System.out.println("Nome do pet:");
        String pet = sc.nextLine();
        
        System.out.println("Data da cirurgia (DD/MM/AAAA):");
        String data = sc.nextLine();
        
        String servico = String.format("Cirurgia para %s (Dono: %s) - %s", pet, dono, data);
        System.out.println("Agendado: " + servico);
        
        if (admin != null) {
            admin.agendarServico(servico);
        }
    }
}

class PacoteServicos {
    private final Scanner sc;

    public PacoteServicos(Scanner sc) {
        this.sc = sc;
    }

    public void executar() {
        System.out.println("\n--- Pacote de Serviços ---");
        System.out.println("1) Pacote Anual (R$2500)");
        System.out.println("2) Hospedagem (R$900/3meses)");
        System.out.println("3) Funeral (R$650)");
        System.out.println("4) Voltar");

        switch (sc.nextInt()) {
            case 1 -> pacoteAnual();
            case 2 -> pacoteHospedagem();
            case 3 -> pacoteFuneral();
            case 4 -> {}
            default -> System.out.println("Opção inválida!");
        }
    }

    private void pacoteAnual() {
        System.out.println("\nPacote Anual - R$2500");
        System.out.println("1) Comprar\n2) Cancelar");
        if (sc.nextInt() == 1) processarPagamento();
    }

    private void pacoteHospedagem() {
        System.out.println("\nHospedagem - R$900/3meses");
        System.out.println("1) Comprar\n2) Cancelar");
        if (sc.nextInt() == 1) processarPagamento();
    }

    private void pacoteFuneral() {
        System.out.println("\nFuneral - R$650");
        System.out.println("1) Comprar\n2) Cancelar");
        if (sc.nextInt() == 1) processarPagamento();
    }

    private void processarPagamento() {
        System.out.println("\nForma de pagamento:");
        System.out.println("1) Crédito\n2) Débito\n3) Pix");
        System.out.println("Pagamento processado com sucesso!");
    }
}

class CadastroCliente {
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
    public List<String> getPets() { return pets; }
    public String getTelefone() { return telefone; }
    
    public void adicionarPet(String nome) {
        pets.add(nome);
    }
}

public class Petshoppar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Configuração inicial
        CadastroCliente cadastro = new CadastroCliente(sc);
        ServicosIndividuais servicos = new ServicosIndividuais(sc);
        
        // Link para o admin (não aparece publicamente)
        servicos.setAdmin(new Administrador(sc, cadastro, servicos));
        
        // Inicia o sistema
        new MenuPrincipal().executar();
    }
}
