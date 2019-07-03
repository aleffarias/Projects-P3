package com.folhapagamento;

public class Main {

	static Calendario calendario = new Calendario();

	public static void main(String[] args) {
				
		Funcionalidades funcionalidades = new Funcionalidades();
		
		while (true) {
			
			int dia = calendario.getDia();
			int diaSemana = calendario.getDiaSemana();
			int semana = calendario.getSemana();
			int mes = calendario.getMes();
			int ano = calendario.getAno();
			int ultimo = calendario.ultimoDia(mes);
			
			menu();
			
			int opcao = TratamentoExc.lerInt();
			
			switch(opcao) {
			case 1:
				funcionalidades.addEmpregado();
				break;
				
			case 2:
				funcionalidades.removerEmpregado();
				break;
				
			case 3:
				funcionalidades.lancarCartaoPonto();
				break;
				
			case 4:
				funcionalidades.lancarResultadoVenda();
				break;
			
			case 5:
				funcionalidades.lancarTaxaServico();
				break;
			
			case 6:	
				funcionalidades.alterarDetalhe();
				break;
			
			case 7:
				funcionalidades.rodarFolha(dia, diaSemana, semana, ultimo);
				calendario.avancarDia();
				
				System.out.println("\nData: " + dia + "/ " + mes + " / " + ano + " -  Folha de pagamento executada com sucesso!\n");
				break;
				
			case 8:
				
				break;
			
			case 9:
				funcionalidades.agendaPagamento();
				break;
			
			case 10:
				funcionalidades.novaAgenda();
				break;
				
			case 0:
				System.exit(0);
			
			default:
				System.out.println("\nErro: Opção Inválida.\n");
			}
			
		}
	}
	
	public static void menu() {
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
	}
	
}
