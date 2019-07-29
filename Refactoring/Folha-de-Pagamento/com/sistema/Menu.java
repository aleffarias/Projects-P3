package com.sistema;

public class Menu {
	
	static Calendario calendario = new Calendario(1, 1, 2019);
	
	public static int printMenu() {
		System.out.println("=============================== FOLHA DE PAGAMENTO =====================================");
		
		System.out.println(calendario.toString());
		
		System.out.println("\nEscolha uma opção:");
		System.out.println("(1) - Adicionar Empregado");
		System.out.println("(2) - Remover Empregado");
		System.out.println("(3) - Lançar um Cartão de Ponto");
		System.out.println("(4) - Lançar um Resultado Venda");
		System.out.println("(5) - Lançar uma Taxa de Serviço");
		System.out.println("(6) - Alterar Detalhes de um Empregado");
		System.out.println("(7) - Rodar a Folha de Pagamento para Hoje (após rodar, avança 1 dia)");
		System.out.println("(8) - Undo/redo");
		System.out.println("(9) - Agenda de Pagamento");
		System.out.println("(10) - Criação de Novas Agendas de Pagamento");
		System.out.println("(0) - Sair");
		System.out.println("=======================================================================================");
		
		return TratamentoExc.lerInt();
		
	}

}
