# Folha de Pagamento
Projeto java sem orientação a objeto (primeiro projeto).

>"O objetivo do projeto é construir um sistema de folha de pagamento. O sistema consiste de um
banco de dados de empregados de uma empresa além dos seus dados associados tais como cartões
de ponto. O sistema deve pagar cada empregado. Empregados devem receber o salário correto, no
momento correto, usando o método que eles preferem. Além do mais, várias taxas e impostos são
deduzidos do seu salário."
## Configurações
* **Versão do java:** 1.8.0_201
* **IDE utilizada:** Eclipse 2018-12 (4.10.0)
* **SO:** Ubuntu 18.04.1 Lts 

## Funcionalidades
* A data incial é 01/01/2019

**1. Adicionar Empregado**
* Cadastra um novo empregado com seus respectivos dados e atribui em cada índice da coluna da matriz (empregado[numeroFuncionario][indice]).

**2. Remover Empregado** 
* Antes de remover, mostra todos os empreados cadastrados (todosEmpregos(0)).
* Após escolher o funcionário, atribui null para todos os índices da coluna da matriz empregado[ ][ ].

**3. Lançar Cartão de Ponto**
* Verifica se o funcionário é horista.
* Tem como entrada a hora de entrada e saída do empregado horista. O salário do empregado horista é calculado pelo método salarioHorista(double salarioHora, int entrada, int saida) e atribuido ao índice referente ao salário líquido do empregado.

**4. Lançar Resultado de Venda**
* Verifica se o funcionário é comissionado.
* Tem como entrada a data da venda e o valor da venda. É adicionado ao salário líquido do empregado comisionado o valor da comissão da venda de acordo com sua taxa da comissão.

**5. Lançar Taxa de Serviço**
* Verifica se o funcionário é do sindicato.
* Tem como entrada o serviço e o valor da taxa desse serviço. O valor é duduzido e o resultado atribuido ao salário líquido.

**6. Alterar Detalhes do Empregado**
* Escolhe o funcionário e edita seus dados.

**7. Rodar Folha de Pagamento**
* Verifica se algum empregado será pago (de acordo com a agenda de pagamento) na data atual. Caso haja pagamento, é chamado o método contracheque(numeroFuncionario) e mostrará os dados e o salário líquido. Logo após, o salaŕio líquido é zerado.
* **Após rodar a folha de pagamento, a data avança um dia.**

**8. Undu/Redu**
* Não implementada.

**9. Agenda de Pagamento**
* Chama o método todosEmpregados() e como parâmetro passa o tipo da agenda do empregado (1 - semanal, 2 - bi-semanal, 3 - mensal, 4 - nova agenda semanal, 5 - nova agenda mensal) onde é exibido todos os empregados separados por agenda de pagamento.

**10. Criar Agenda de Pagamento**
* Semanal: escolhe a frequência de pagamento (toda semana, a cada 2 semanas, ...) e o dia da semana.
* Mensal: escohe o dia do mês para receber.
