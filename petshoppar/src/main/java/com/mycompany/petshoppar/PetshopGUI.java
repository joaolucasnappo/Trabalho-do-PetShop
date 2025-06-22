package com.mycompany.petshoppar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PetshopGUI extends JFrame {
    private ServicosIndividuaisGUI servicosIndividuais;
    private PacoteServicosGUI pacoteServicos;
    private CadastroClienteGUI cadastroCliente;
    private AdministradorGUI administrador;
    
    public PetshopGUI() {
        servicosIndividuais = new ServicosIndividuaisGUI();
        pacoteServicos = new PacoteServicosGUI();
        cadastroCliente = new CadastroClienteGUI();
        administrador = new AdministradorGUI(cadastroCliente);
        
        setupMenuPrincipal();
    }
    
    private void setupMenuPrincipal() {
        setTitle("Pet-Celso - Sistema de Petshop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titulo = new JLabel("---- Pet-Celso ----", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo);
        
        JButton btnServicos = new JButton("Serviços Individuais");
        btnServicos.addActionListener(e -> servicosIndividuais.setVisible(true));
        panel.add(btnServicos);
        
        JButton btnPacotes = new JButton("Pacote de Serviços");
        btnPacotes.addActionListener(e -> pacoteServicos.setVisible(true));
        panel.add(btnPacotes);
        
        JButton btnCadastro = new JButton("Cadastro de Cliente");
        btnCadastro.addActionListener(e -> cadastroCliente.setVisible(true));
        panel.add(btnCadastro);
        
        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(e -> System.exit(0));
        panel.add(btnSair);
        
        // Botão secreto de administrador (invisível até clique duplo no título)
        titulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    administrador.setVisible(true);
                }
            }
        });
        
        add(panel);
    }
    
    public static void main(String[] args) {        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PetshopGUI().setVisible(true);
            }
        });
    }
}

class ServicosIndividuaisGUI extends JFrame {
    public ServicosIndividuaisGUI() {
        setupWindow();
    }
    
    private void setupWindow() {
        setTitle("Serviços Individuais");
        setSize(350, 250);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titulo = new JLabel("--- Serviços Individuais ---", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(titulo);
        
        JButton btnBanho = new JButton("Banho e Tosa - R$60,00");
        btnBanho.addActionListener(e -> mostrarConfirmacao("Banho e Tosa", "R$60,00"));
        panel.add(btnBanho);
        
        JButton btnConsulta = new JButton("Consulta");
        btnConsulta.addActionListener(e -> agendarConsulta());
        panel.add(btnConsulta);
        
        JButton btnCirurgia = new JButton("Cirurgia");
        btnCirurgia.addActionListener(e -> agendarCirurgia());
        panel.add(btnCirurgia);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> setVisible(false));
        panel.add(btnVoltar);
        
        add(panel);
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
      private void agendarConsulta() {
        agendar("Consulta");
    }
    
    private void agendarCirurgia() {
        agendar("Cirurgia");
    }
    
    private void agendar(String tipo) {
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
            JOptionPane.showMessageDialog(this, "Agendado: " + tipo + " para " + 
                txtPet.getText() + " (Dono: " + txtDono.getText() + ") - " + txtData.getText());
        }
    }
}

class PacoteServicosGUI extends JFrame {
    public PacoteServicosGUI() {
        setupWindow();
    }
    
    private void setupWindow() {
        setTitle("Pacote de Serviços");
        setSize(350, 250);
        setLocationRelativeTo(null);
        
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
        btnVoltar.addActionListener(e -> setVisible(false));
        panel.add(btnVoltar);
        
        add(panel);
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
}

class CadastroClienteGUI extends JFrame {
    private List<Cliente> clientes;
    
    public CadastroClienteGUI() {
        clientes = new ArrayList<>();
        setupWindow();
    }
    
    private void setupWindow() {
        setTitle("Cadastro de Cliente");
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titulo = new JLabel("--- Cadastro de Cliente ---", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(titulo);
        
        JButton btnCadastrar = new JButton("Cadastrar Novo Cliente");
        btnCadastrar.addActionListener(e -> cadastrarCliente());
        panel.add(btnCadastrar);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> setVisible(false));
        panel.add(btnVoltar);
        
        add(panel);
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
        
        int opcao = JOptionPane.showConfirmDialog(this, panel, 
            "Dados do Cliente", JOptionPane.OK_CANCEL_OPTION);
        
        if (opcao == JOptionPane.OK_OPTION) {
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
                
                int maisPets = JOptionPane.showConfirmDialog(this,
                    "Adicionar mais pets?", "Mais Pets", JOptionPane.YES_NO_OPTION);
                if (maisPets == JOptionPane.YES_OPTION) {
                    adicionarMaisPets(txtDono.getText());
                }
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Quantidade de pets deve ser um número!");
            }
        }
    }
    
    private void adicionarMaisPets(String nomeDono) {
        String qtdStr = JOptionPane.showInputDialog(this, "Quantos pets deseja adicionar?");
        if (qtdStr != null) {
            try {
                int qtd = Integer.parseInt(qtdStr);
                
                for (Cliente c : clientes) {
                    if (c.getDono().equalsIgnoreCase(nomeDono)) {
                        for (int i = 0; i < qtd; i++) {
                            String nomePet = JOptionPane.showInputDialog(this, 
                                "Nome do pet #" + (i + 1) + ":");
                            if (nomePet != null && !nomePet.trim().isEmpty()) {
                                c.adicionarPet(nomePet);
                            }
                        }
                        JOptionPane.showMessageDialog(this, 
                            "🐾 Pets adicionados!\nLista atual: " + c.getPets());
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Quantidade deve ser um número!");
            }
        }
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public void buscarCliente(String nome) {
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
    
    public void excluirCliente(String nome) {
        if (clientes.removeIf(c -> c.getDono().equalsIgnoreCase(nome))) {
            JOptionPane.showMessageDialog(this, "Cliente removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
        }
    }
    
    public void listarClientes() {
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
}

class AdministradorGUI extends JFrame {
    private CadastroClienteGUI cadastroCliente;
    private List<String> servicosAgendados;
    
    public AdministradorGUI(CadastroClienteGUI cadastroCliente) {
        this.cadastroCliente = cadastroCliente;
        this.servicosAgendados = new ArrayList<>();
        setupWindow();
    }
    
    private void setupWindow() {
        setTitle("Menu Administrador");
        setSize(350, 350);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titulo = new JLabel("--- Menu Administrador ---", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(titulo);
        
        JButton btnListar = new JButton("Listar Clientes");
        btnListar.addActionListener(e -> cadastroCliente.listarClientes());
        panel.add(btnListar);
        
        JButton btnBuscar = new JButton("Buscar Cliente");
        btnBuscar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog(this, "Digite o nome do cliente:");
            if (nome != null && !nome.trim().isEmpty()) {
                cadastroCliente.buscarCliente(nome);
            }
        });
        panel.add(btnBuscar);
        
        JButton btnExcluir = new JButton("Excluir Cliente");
        btnExcluir.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog(this, "Digite o nome do cliente a excluir:");
            if (nome != null && !nome.trim().isEmpty()) {
                cadastroCliente.excluirCliente(nome);
            }
        });
        panel.add(btnExcluir);
        
        JButton btnServicos = new JButton("Listar Serviços Agendados");
        btnServicos.addActionListener(e -> listarServicosAgendados());
        panel.add(btnServicos);
        
        JButton btnCancelar = new JButton("Cancelar Serviço");
        btnCancelar.addActionListener(e -> {
            String nomePet = JOptionPane.showInputDialog(this, "Digite o nome do pet para cancelar serviço:");
            if (nomePet != null && !nomePet.trim().isEmpty()) {
                cancelarServicoAgendado(nomePet);
            }
        });
        panel.add(btnCancelar);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> setVisible(false));
        panel.add(btnVoltar);
        
        add(panel);
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
    
    private void cancelarServicoAgendado(String nomePet) {
        if (servicosAgendados.removeIf(s -> s.toLowerCase().contains(nomePet.toLowerCase()))) {
            JOptionPane.showMessageDialog(this, "Serviço cancelado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum serviço encontrado para " + nomePet);
        }
    }
    
    public void agendarServico(String servico) {
        servicosAgendados.add(servico);
    }
}
