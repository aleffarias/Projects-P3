package sistema;

import empresa.AddEmpregado;

public class FolhaPagamentoFacade {
	private BancoDadosSingleton bancoDados;
	private AddEmpregado addEmpregado;
	
	public FolhaPagamentoFacade() {
		this.bancoDados = BancoDadosSingleton.getInstance();
		this.addEmpregado = new AddEmpregado();
	}
	
	public void adicionar() {
		addEmpregado.add();
	}
	
	public void remover() {
		bancoDados.removeEmpregado();
	}
	
	public void cartaoPonto() {
		
	}
	
	public void resultadoVenda() {
			
		}
}
