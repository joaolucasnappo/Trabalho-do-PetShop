package com.mycompany.petshoppar;
import java.util.Scanner;

public class Petshoppar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueMenu = true;  

        while (continueMenu) {
            System.out.println("----Pet-Celso----");
            System.out.println("Bem vindo ao nosso pet-shop!");
            System.out.println("Escolha uma das opcoes de servico a seguir:");
            System.out.println("1)Servicos individuais");
            System.out.println("2)Pacote de servicos");
            System.out.println("3)Cadastro de cliente e pet(s)");
            System.out.println("4)Sair");

            int opcao = sc.nextInt();  

            switch (opcao) {
                case 1 -> {
                    System.out.println("Opcoes de servico individual.");
                    System.out.println("1)Banho e Tosa");
                    System.out.println("2)Consulta");
                    System.out.println("3)Cirurgia");
                    System.out.println("4)Sair");

                    int opcao2 = sc.nextInt();

                    switch (opcao2) {
                        case 1 -> {
                            System.out.println("Gostaria de dar banho e tosa?");
                            System.out.println("1-Sim e 2-Não");
                            int opcao9 = sc.nextInt();
                            switch (opcao9){
                                case 1->{
                                    System.out.println("Obrigado!!");
                                    System.out.println("Deixe seu pet conosco na nossa recepição junto com o nota da compra. ");
                            }
                                case 2->{
                                    System.out.println("Voltando ao menu.");
                                }
                            }
                        }   
                        case 2 -> {
                            sc.nextLine();
                            System.out.println("Marcando consulta");
                            System.out.println("Nome do dono:");
                            String dono = sc.nextLine();
                            
                            System.out.println("Nome do pet");
                            String pet = sc.nextLine();
                            
                            System.out.println("Digite a data da consulta que é de sua preferencia");
                            System.out.println("*Lembrando que se não tiver consulta disponivel na data de sua preferencia");
                            System.out.println("vamos ligar perguntando sobre consultas em datas proximas*");
                            String dataConsulta = sc.nextLine();
                            System.out.println("Consulta marcada para " + pet + " de " + dono + " no dia " + dataConsulta);
                            
                        }
                        case 3 -> {
                            System.out.println("Cirurgia");
                            System.out.println("Senha gerada!");
                            System.out.println("Aguarde ser chamado e vá ate o guiche");   
                        }
                        case 4 -> System.out.println("Voltando ao menu inicial...");
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }
                }
                case 2 -> {
                    System.out.println("Pacote de serviços.");
                    System.out.println("1)Pacote para funeral");
                    System.out.println("2)Pacote Anual de servicos");
                    System.out.println("3)Pacote hospedagem");
                    System.out.println("4)Sair");

                    int opcao3 = sc.nextInt();

                    switch (opcao3) {
                        case 1 ->{ System.out.println("Pacote funerario");
                                   System.out.println("Valor do plano é de 650 reais");
                                   System.out.println("Deseja efetuar a compra?");
                                   System.out.println("1-Sim e 2-Não");
                                   int opcao10 = sc.nextInt();
                                   switch (opcao10){
                                       case 1->{
                                           System.out.println("Escolha a forma de pagamento:");
                                           System.out.println("1)Credito");
                                           System.out.println("2)Debito");
                                           System.out.println("3)Pix");
                                           int opcao11 = sc.nextInt();
                                           switch (opcao11){
                                               case 1-> System.out.println("Transferencia aceita! Imprimindo recibo!\n");
                                               case 2-> System.out.println("Transferencia aceita! Imprimindo recibo!\n");
                                               case 3-> System.out.println("Transferencia aceita! Imprimindo recibo!\n");
                                           
                                           }
                                           
                                       }
                                       case 2-> System.out.println("Voltando ao menu principal..."); 
                                   }
                        }
                        case 2 ->{
                            System.out.println("Plano anual de serviços");
                            System.out.println("Valor do plano é de 2500 reais");
                            System.out.println("Deseja efetuar a compra?");
                            System.out.println("1-Sim e 2-Não");
                            int opcao12 = sc.nextInt();
                            switch (opcao12){
                                       case 1->{
                                           System.out.println("Escolha a forma de pagamento:");
                                           System.out.println("1)Credito");
                                           System.out.println("2)Debito");
                                           System.out.println("3)Pix");
                                           int opcao13 = sc.nextInt();
                                           switch (opcao13){
                                               case 1-> System.out.println("Transferencia aceita! Imprimindo recibo!\n");
                                               case 2-> System.out.println("Transferencia aceita! Imprimindo recibo!\n");
                                               case 3-> System.out.println("Transferencia aceita! Imprimindo recibo!\n");
                                           
                                           }
                                           
                                       }
                                       case 2-> System.out.println("Voltando ao menu principal..."); 
                                   }
                        }
                        case 3 ->{ 
                            System.out.println("Pacote adestramento");
                            System.out.println("Valor de 900 por 3 meses");
                            System.out.println("Deseja efetuar a compra?");
                            System.out.println("1-Sim e 2-Não");
                             int opcao14 = sc.nextInt();
                                  switch (opcao14){
                                       case 1->{
                                           System.out.println("Escolha a forma de pagamento:");
                                           System.out.println("1)Credito");
                                           System.out.println("2)Debito");
                                           System.out.println("3)Pix");
                                           int opcao15 = sc.nextInt();
                                           switch (opcao15){
                                               case 1-> System.out.println("Transferencia aceita! Imprimindo recibo!\n");
                                               case 2-> System.out.println("Transferencia aceita! Imprimindo recibo!\n");
                                               case 3-> System.out.println("Transferencia aceita! Imprimindo recibo!\n");
                                           
                                           }
                                           
                                       }
                                       case 2-> System.out.println("Voltando ao menu principal..."); 
                                   }
                        }
                        case 4 -> System.out.println("Voltando ao menu inicial...");
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }
                }
                case 3 -> {
                    
                    sc.nextLine();  
                    System.out.println("Cadastro");
                    System.out.println("1) Nome do dono");
                    String dono = sc.nextLine();  

                    System.out.println("2) Nome do pet");
                    String pet = sc.nextLine();  

                    System.out.println("3) Número de telefone");
                    String telefone = sc.nextLine(); 

                    System.out.println("Cadastro realizado:");
                    System.out.println("Nome do dono: " + dono);
                    System.out.println("Nome do pet: " + pet);
                    System.out.println("Número de telefone: " + telefone);

                    System.out.println("Voltando ao menu inicial...");
                    
                }
                case 4 -> {
                    System.out.println("Saindo... Até logo!");
                    continueMenu = false;  
                }
                
                
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
