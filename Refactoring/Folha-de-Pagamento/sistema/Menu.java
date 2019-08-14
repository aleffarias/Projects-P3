package sistema;

public class Menu {
	
	private CalendarioSingleton calendario = CalendarioSingleton.getInstance();
	
	public void menuMain() {
		
		FolhaPagamentoFacade folhaPagamento = new FolhaPagamentoFacade();
		
		int dia = calendario.getDia();
		int diaSemana = calendario.getDiaSemana();
		int semana = calendario.getSemana();
		int mes = calendario.getMes();
		int ano = calendario.getAno();
		int ultimo = calendario.ultimoDia(mes);
		
		
		int opcao = printMenu();
		
		switch(opcao) {
		case 1:
			folhaPagamento.adicionar();
			break;
			
		case 2:
			folhaPagamento.remover();
			break;
			
		case 3:
			folhaPagamento.cartaoPonto();
			break;
			
		case 4:
			folhaPagamento.venda();
			break;
		
		case 5:
			folhaPagamento.taxaServico();			
			break;
		
		case 6:	
			folhaPagamento.editar();
			break;
		
		case 7:
			folhaPagamento.rodar(dia, diaSemana, semana, ultimo);
			calendario.avancarDia();
	
			System.out.println("\nData: " + dia + "/ " + mes + " / " + ano + " -  Folha de pagamento executada com sucesso!\n");
			break;
			
		case 8:
			
			break;
		
		case 9:
			folhaPagamento.agendaPagamento();
			break;
		
		case 10:
			folhaPagamento.novaAgenda();
			break;
			
		case 0:
			System.exit(0);
		
		default:
			System.out.println("\nErro: Opção Inválida.\n");
		}
	}
	
	public int printMenu() {
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
