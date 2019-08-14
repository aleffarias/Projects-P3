# Folha de Pagamento Refatorado

## Padrões
1. Facade Finalizado...
> Oferecer uma interface única para um conjunto de interfaces de um subsistema. Facade define uma interface de nível mais elevado que torna o subsistema mais fácil de usar.
  - Classe: **FolhaPagamentoFacade**

2. Singleton
> Garantir que uma classe só tenha uma única instância, e prover um ponto de acesso global a ela.
  - Classes: **BancoDadosSingleton**, **CalendarioSingleton**

3. Template Method
> Definir o esqueleto de um algoritmo dentro de uma operação, deixando alguns passos a serem preenchidos
pelas subclasses. Template Method permite que suas subclasses redefinam certos passos de um algoritmo sem
mudar sua estrutura.
  - Classes: **Empregado** -> **Assalariado**, **Comissionado**, **Horista**
  
Projeto OO original sem refatoração: https://github.com/aleffarias/Projects-P3/tree/master/ProjetoOO 

## Configurações
* **Versão do java:** 11.0.4
* **IDE utilizada:** Eclipse 2019-06 (4.12.0)
* **SO:** Deepin 15.10.2
