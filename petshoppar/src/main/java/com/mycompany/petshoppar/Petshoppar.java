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
                    
                    admin.executar();
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}


public class Petshoppar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new MenuPrincipal().executar();
    }
}