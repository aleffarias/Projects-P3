package sistema;

import empregado.CartaoPonto;
import empregado.ResultadoVenda;
import empresa.AddEmpregado;
import empresa.Agenda;
import empresa.RodarFolha;

public class FolhaPagamentoFacade {
	private BancoDadosSingleton bancoDados;
	private AddEmpregado addEmpregado;
	private CartaoPonto cartaoPonto;
	private ResultadoVenda resultadoVenda;
	private RodarFolha rodarFolha;
	private Agenda agenda;
	
	public FolhaPagamentoFacade() {
		this.bancoDados = BancoDadosSingleton.getInstance();
		this.addEmpregado = new AddEmpregado();
		this.cartaoPonto = new CartaoPonto();
		this.resultadoVenda = new ResultadoVenda();
		this.rodarFolha = new RodarFolha();
		this.agenda = new Agenda();
	}
	
	public void adicionar() {
		addEmpregado.add();
	}
	
	public void remover() {
		bancoDados.removeEmpregado();
	}
	
	public void cartaoPonto() {
		cartaoPonto.lancarCartao();
	}
	
	public void venda() {
		resultadoVenda.lancarResultadoVenda();	
	}
	
	public void taxaServico() {
		int index = bancoDados.searchEmpregado();
		if (index == -1) return;
		
		if (bancoDados.getListaEmpregados().get(index).getIsSindicato() == 1) { 
			bancoDados.getListaEmpregados().get(index).getSindicato().taxaServico();
		} else {System.out.println("\nErro: Empregado não pertence ao sindicato.\n");}
	}
	
	public void editar() {
		int index = bancoDados.searchEmpregado();
		if (index == -1) return;
		
		bancoDados.getListaEmpregados().get(index).alterarDetalhes();
	}
	
	public void rodar(int dia, int diaSemana, int semana, int ultimo) {
		rodarFolha.rodarFolha_(dia, diaSemana, semana, ultimo);
	}
	
	public void agendaPagamento() {
		agenda.consultaAgenda();
	}
	
	public void novaAgenda() {
		agenda.novaAgenda();
	}
	
}
