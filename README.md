# Manual de Uso - Sistema Pet-Celso

## Como Executar o Sistema

### Requisitos
- Java 8 ou superior instalado

### Execução
```bash
cd petshoppar\src\main\java\com\mycompany\petshoppar
javac PetshopGUIUnificado.java
java PetshopGUIUnificado
```

## Funcionalidades

### Menu Principal
- Serviços Individuais
- Pacote de Serviços 
- Cadastro de Cliente
- Administrador
- Sair

### Serviços Individuais

**Banho e Tosa** - R$60,00
1. Clique em "Banho e Tosa"
2. Confirme o serviço
3. Leve o pet à recepção

**Consulta e Cirurgia**
1. Selecione o serviço
2. Preencha: nome do dono, nome do pet, data
3. Confirme o agendamento

### Pacotes de Serviços
- Pacote Anual: R$2500
- Hospedagem: R$900/3meses  
- Funeral: R$650

Para contratar: selecione o pacote, confirme e escolha forma de pagamento (Crédito, Débito ou Pix).

### Cadastro de Cliente
1. Clique em "Cadastro de Cliente"
2. Preencha nome, telefone e quantidade de pets
3. Digite o nome de cada pet
4. Confirme o cadastro

### Modo Administrador
Senha: admin

Funcionalidades:
- Listar clientes
- Buscar cliente por nome
- Excluir cliente
- Listar serviços agendados
- Cancelar serviços

## Observações

- Dados são temporários e perdidos ao fechar o sistema
- Use formato DD/MM/AAAA para datas
- Digite apenas números para quantidade de pets
- Botão "Voltar" retorna ao menu anterior



