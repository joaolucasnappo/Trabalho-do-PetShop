package com.mycompany.petshoppar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PetshopGUIUnificado extends JFrame {
    private final List<Cliente> clientes;
    private final List<String> servicosAgendados;
    
    public PetshopGUIUnificado() {
        clientes = new ArrayList<>();
        servicosAgendados = new ArrayList<>();
        setupMenuPrincipal();
    }
    
    private void setupMenuPrincipal() {
        setTitle("Pet-Celso - Sistema de Petshop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        showMainMenu();
    }
    
    private void showMainMenu() {
        getContentPane().removeAll();
        
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titulo = new JLabel("---- Pet-Celso ----", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo);
        
        JButton btnServicos = new JButton("Serviços Individuais");
        btnServicos.addActionListener(e -> showServicosMenu());
        panel.add(btnServicos);
        
        JButton btnPacotes = new JButton("Pacote de Serviços");
        btnPacotes.addActionListener(e -> showPacotesMenu());
        panel.add(btnPacotes);
        
        JButton btnCadastro = new JButton("Cadastro de Cliente");
        btnCadastro.addActionListener(e -> showCadastroMenu());
        panel.add(btnCadastro);
        
        JButton btnAdmin = new JButton("Administrador");
        btnAdmin.addActionListener(e -> acessoAdmin());
        panel.add(btnAdmin);
        
        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(e -> System.exit(0));
        panel.add(btnSair);
        
        add(panel);
        revalidate();
        repaint();
    }
    
    private void showServicosMenu() {
        getContentPane().removeAll();
        
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titulo = new JLabel("--- Serviços Individuais ---", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(titulo);
        
        JButton btnBanho = new JButton("Banho e Tosa - R$60,00");
        btnBanho.addActionListener(e -> mostrarConfirmacao("Banho e Tosa", "R$60,00"));
        panel.add(btnBanho);
        
        JButton btnConsulta = new JButton("Consulta");
        btnConsulta.addActionListener(e -> agendarServico("Consulta"));
        panel.add(btnConsulta);
        
        JButton btnCirurgia = new JButton("Cirurgia");
        btnCirurgia.addActionListener(e -> agendarServico("Cirurgia"));
        panel.add(btnCirurgia);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> showMainMenu());
        panel.add(btnVoltar);
        
        add(panel);
        revalidate();
        repaint();
    }
    
    private void showPacotesMenu() {
        getContentPane().removeAll();
        
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titulo = new JLabel("--- Pacote de Serviços ---", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(titulo);
        
        JButton btnAnual = new JButton("Pacote Anual - R$2500");
        btnAnual.addActionListener(e -> confirmarCompra("Pacote Anual", "R$2500"));
        panel.add(btnAnual);
        
        JButton btnHospedagem = new JButton("Hospedagem - R$900/3meses");
        btnHospedagem.addActionListener(e -> confirmarCompra("Hospedagem", "R$900/3meses"));
        panel.add(btnHospedagem);
        
        JButton btnFuneral = new JButton("Funeral - R$650");
        btnFuneral.addActionListener(e -> confirmarCompra("Funeral", "R$650"));
        panel.add(btnFuneral);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> showMainMenu());
        panel.add(btnVoltar);
        
        add(panel);
        revalidate();
        repaint();
    }
    
    private void showCadastroMenu() {
        getContentPane().removeAll();
        
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titulo = new JLabel("--- Cadastro de Cliente ---", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(titulo);
        
        JButton btnCadastrar = new JButton("Cadastrar Novo Cliente");
        btnCadastrar.addActionListener(e -> cadastrarCliente());
        panel.add(btnCadastrar);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> showMainMenu());
        panel.add(btnVoltar);
        
        add(panel);
        revalidate();
        repaint();
    }
    
    private void mostrarConfirmacao(String servico, String preco) {
        int opcao = JOptionPane.showConfirmDialog(this,
            servico + " - " + preco + "\nConfirmar serviço?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION);
        
        if (opcao == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Leve seu pet à recepção com a nota!");
        }
    }
    
    private void agendarServico(String tipo) {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        
        panel.add(new JLabel("Nome do dono:"));
        JTextField txtDono = new JTextField();
        panel.add(txtDono);
        
        panel.add(new JLabel("Nome do pet:"));
        JTextField txtPet = new JTextField();
        panel.add(txtPet);
        
        panel.add(new JLabel("Data (DD/MM/AAAA):"));
        JTextField txtData = new JTextField();
        panel.add(txtData);
        
        if (JOptionPane.showConfirmDialog(this, panel, "Agendar " + tipo, 
            JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            String servico = "Agendado: " + tipo + " para " + txtPet.getText() + 
                           " (Dono: " + txtDono.getText() + ") - " + txtData.getText();
            servicosAgendados.add(servico);
            JOptionPane.showMessageDialog(this, servico);
        }
    }
    
    private void confirmarCompra(String pacote, String preco) {
        if (JOptionPane.showConfirmDialog(this, pacote + " - " + preco + "\nConfirmar compra?",
            "Confirmação de Compra", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            
            String[] opcoes = {"Crédito", "Débito", "Pix"};
            if (JOptionPane.showInputDialog(this, "Escolha a forma de pagamento:",
                "Forma de Pagamento", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]) != null) {
                JOptionPane.showMessageDialog(this, "Pagamento processado com sucesso!");
            }
        }
    }
    
    private void cadastrarCliente() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        
        panel.add(new JLabel("Nome do dono:"));
        JTextField txtDono = new JTextField();
        panel.add(txtDono);
        
        panel.add(new JLabel("Quantidade de pets:"));
        JTextField txtQtdPets = new JTextField();
        panel.add(txtQtdPets);
        
        panel.add(new JLabel("Telefone:"));
        JTextField txtTelefone = new JTextField();
        panel.add(txtTelefone);
        
        if (JOptionPane.showConfirmDialog(this, panel, "Dados do Cliente", 
            JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                int qtdPets = Integer.parseInt(txtQtdPets.getText());
                List<String> pets = new ArrayList<>();
                
                for (int i = 0; i < qtdPets; i++) {
                    String nomePet = JOptionPane.showInputDialog(this, 
                        "Nome do pet #" + (i + 1) + ":");
                    if (nomePet != null && !nomePet.trim().isEmpty()) {
                        pets.add(nomePet);
                    }
                }
                
                Cliente cliente = new Cliente(txtDono.getText(), pets, txtTelefone.getText());
                clientes.add(cliente);
                
                JOptionPane.showMessageDialog(this, "✅ Cadastro realizado!");
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Quantidade de pets deve ser um número!");
            }
        }
    }
    
    private void acessoAdmin() {
        String senha = JOptionPane.showInputDialog(this, "Digite a senha do administrador:");
        if ("admin".equals(senha)) {
            showAdminMenu();
        } else if (senha != null) {
            JOptionPane.showMessageDialog(this, "Senha incorreta!");
        }
    }
    
    private void showAdminMenu() {
        getContentPane().removeAll();
        
        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titulo = new JLabel("--- Menu Administrador ---", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(titulo);
        
        JButton btnListar = new JButton("Listar Clientes");
        btnListar.addActionListener(e -> listarClientes());
        panel.add(btnListar);
        
        JButton btnBuscar = new JButton("Buscar Cliente");
        btnBuscar.addActionListener(e -> buscarCliente());
        panel.add(btnBuscar);
        
        JButton btnExcluir = new JButton("Excluir Cliente");
        btnExcluir.addActionListener(e -> excluirCliente());
        panel.add(btnExcluir);
        
        JButton btnServicos = new JButton("Listar Serviços Agendados");
        btnServicos.addActionListener(e -> listarServicosAgendados());
        panel.add(btnServicos);
        
        JButton btnCancelar = new JButton("Cancelar Serviço");
        btnCancelar.addActionListener(e -> cancelarServico());
        panel.add(btnCancelar);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> showMainMenu());
        panel.add(btnVoltar);
        
        add(panel);
        revalidate();
        repaint();
    }
    
    private void listarClientes() {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente cadastrado!");
        } else {
            StringBuilder sb = new StringBuilder("--- Clientes Cadastrados ---\n\n");
            for (Cliente c : clientes) {
                sb.append("Dono: ").append(c.getDono()).append("\n");
                sb.append("Pets: ").append(c.getPets()).append("\n");
                sb.append("Tel: ").append(c.getTelefone()).append("\n\n");
            }
            
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            textArea.setRows(15);
            textArea.setColumns(40);
            
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(this, scrollPane, "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void buscarCliente() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do cliente:");
        if (nome != null && !nome.trim().isEmpty()) {
            for (Cliente c : clientes) {
                if (c.getDono().toLowerCase().contains(nome.toLowerCase())) {
                    JOptionPane.showMessageDialog(this,
                        "--- Dados do Cliente ---\n" +
                        "Dono: " + c.getDono() + "\n" +
                        "Pets: " + c.getPets() + "\n" +
                        "Tel: " + c.getTelefone());
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
        }
    }
    
    private void excluirCliente() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do cliente a excluir:");
        if (nome != null && !nome.trim().isEmpty()) {
            if (clientes.removeIf(c -> c.getDono().equalsIgnoreCase(nome))) {
                JOptionPane.showMessageDialog(this, "Cliente removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
            }
        }
    }
    
    private void listarServicosAgendados() {
        if (servicosAgendados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum serviço agendado.");
        } else {
            StringBuilder sb = new StringBuilder("--- Serviços Agendados ---\n\n");
            for (String servico : servicosAgendados) {
                sb.append(servico).append("\n");
            }
            
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            textArea.setRows(10);
            textArea.setColumns(40);
            
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(this, scrollPane, "Serviços Agendados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void cancelarServico() {
        String nomePet = JOptionPane.showInputDialog(this, "Digite o nome do pet para cancelar serviço:");
        if (nomePet != null && !nomePet.trim().isEmpty()) {
            if (servicosAgendados.removeIf(s -> s.toLowerCase().contains(nomePet.toLowerCase()))) {
                JOptionPane.showMessageDialog(this, "Serviço cancelado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum serviço encontrado para " + nomePet);
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PetshopGUIUnificado().setVisible(true));
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
