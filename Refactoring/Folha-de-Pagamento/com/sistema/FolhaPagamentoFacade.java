package com.sistema;

import com.empresa.AddEmpregado;

public class FolhaPagamentoFacade {
	private BancoDados bancoDados;
	private AddEmpregado addEmpregado;
	
	public FolhaPagamentoFacade() {
		this.bancoDados = new BancoDados();
		this.addEmpregado = new AddEmpregado();
	}
	
	public void adicionar() {
		addEmpregado.add(bancoDados);
	}
	
	public void remover() {
		bancoDados.removeEmpregado();
	}
	
	public void cartaoPonto() {
		
	}
	
	public void resultadoVenda() {
			
		}
}
