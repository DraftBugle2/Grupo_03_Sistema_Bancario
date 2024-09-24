# Sistema Bancário Simples

Este repositório contém a implementação de um sistema bancário básico em Java, com funcionalidades essenciais como criação de clientes, gerenciamento de contas bancárias, e operações como saque, depósito e transferência de valores. O código foi organizado em três classes principais: `Cliente`, `ContaBancaria`, e `Principal`. Abaixo está uma descrição detalhada de cada componente e suas funcionalidades.

## Funcionalidades

1. **Criação de Clientes:**
   - O sistema permite a criação de clientes com nome e CPF.
   - O CPF é validado para garantir que contém 11 dígitos. Se o CPF for inválido, uma mensagem de erro é exibida e o CPF será armazenado como "Inválido".

2. **Gerenciamento de Contas Bancárias:**
   - Cada cliente pode possuir uma conta bancária, que inclui um número de conta, saldo inicial e limite de crédito.
   - O sistema permite criar contas com saldo e limite definidos ou com valores padrão (saldo zero e limite zero).

3. **Operações Bancárias:**
   - **Saque:** Os clientes podem sacar dinheiro de suas contas, desde que tenham saldo ou limite disponível.
   - **Depósito:** Os clientes podem depositar qualquer valor em suas contas.
   - **Transferência:** O sistema permite transferir valores entre contas, respeitando o saldo e o limite disponíveis.
   - **Exibição de Saldo:** O saldo de cada conta pode ser exibido a qualquer momento após uma operação.

## Estrutura do Código

### 1. `Cliente.java`
Esta classe representa um cliente no sistema. Ela contém:
   - **Atributos**: `nome` e `cpf`.
   - **Validação de CPF**: O CPF é validado para garantir que tenha 11 dígitos. Caso contrário, o CPF é marcado como inválido.
   - **Métodos Getters e Setters**: Para acessar e modificar o nome e o CPF de um cliente.

### 2. `ContaBancaria.java`
Esta classe representa uma conta bancária associada a um cliente. Ela contém:
   - **Atributos**: `numero` (número da conta), `saldo` (saldo da conta), `limite` (limite de crédito) e um objeto `Cliente`.
   - **Métodos principais**:
     - **`sacar(double valor)`**: Realiza um saque, desde que haja saldo suficiente ou dentro do limite de crédito.
     - **`depositar(double valor)`**: Permite depositar dinheiro na conta.
     - **`transferir(ContaBancaria contaDestino, double valor)`**: Transfere dinheiro para outra conta, desde que o valor esteja dentro do saldo e limite.
     - **`exibirSaldo()`**: Exibe o saldo atual da conta.

### 3. `Principal.java`
Esta classe contém o ponto de entrada do programa e a lógica de interação com o usuário. Ela:
   - Cria dois clientes e suas respectivas contas.
   - Permite ao usuário realizar operações como saque, depósito, transferência e exibir os saldos das contas.
   - As operações são executadas em um loop, permitindo múltiplas transações até que o usuário opte por sair.

## Como o Sistema Funciona

1. **Entrada de Dados**: O sistema usa a classe `Scanner` para permitir que o usuário insira dados como nome, CPF, número da conta, e valores para saque, depósito ou transferência.
2. **Validação**: O sistema valida o CPF no momento da criação do cliente e garante que as operações financeiras respeitam o saldo e limite da conta.
3. **Interação com o Usuário**: Após criar clientes e contas, o usuário pode realizar várias operações até escolher encerrar as operações.

---

Este sistema é uma implementação simples e pode ser facilmente expandido para incluir funcionalidades mais complexas, como persistência de dados, autenticação de clientes, e tarifas bancárias.
