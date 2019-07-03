package com.folhapagamento;

import java.util.ArrayList;

import com.empregado.Assalariado;
import com.empregado.Comissionado;
import com.empregado.Empregado;
import com.empregado.Horista;

public class EditarDetalhes {
	
	public static void alterarTipo(ArrayList<Empregado> listaEmpregados, int i) {
		Empregado novoEmpregado = null;
		
		System.out.println("\nEscolha o tipo do empregado:\n(1) - Horista\n(2) - Assalariado\n(3) - Comissionado");
		  int tipo = TratamentoExc.lerInt();
		  
		  if (tipo == 1) {
			  novoEmpregado = new Horista(listaEmpregados.get(i).getNumeroEmpregado(), listaEmpregados.get(i).getNome(), 
					  listaEmpregados.get(i).getEndereco(), listaEmpregados.get(i).getMetodoPagamento(), listaEmpregados.get(i).getIsSindicato(), 
					  tipo, listaEmpregados.get(i).getTipoAgenda(), listaEmpregados.get(i).getDiaFrequencia());
			 			  
			  novoEmpregado.salario();
			  
			  if (listaEmpregados.get(i).getIsSindicato() == 1) {
				  novoEmpregado.getSindicato().setNumeroSindicato(listaEmpregados.get(i).getSindicato().getNumeroSindicato());
				  novoEmpregado.getSindicato().setTaxaSindical(listaEmpregados.get(i).getSindicato().getTaxaSindicall());
			  }
			  
		  } else if (tipo == 2) {
			  novoEmpregado = new Assalariado(listaEmpregados.get(i).getNumeroEmpregado(), listaEmpregados.get(i).getNome(), 
					  listaEmpregados.get(i).getEndereco(), listaEmpregados.get(i).getMetodoPagamento(), listaEmpregados.get(i).getIsSindicato(), 
					  tipo, listaEmpregados.get(i).getTipoAgenda(), listaEmpregados.get(i).getDiaFrequencia());
			  
			  novoEmpregado.salario();
			  
			  if (listaEmpregados.get(i).getIsSindicato() == 1) {
				  novoEmpregado.getSindicato().setNumeroSindicato(listaEmpregados.get(i).getSindicato().getNumeroSindicato());
				  novoEmpregado.getSindicato().setTaxaSindical(listaEmpregados.get(i).getSindicato().getTaxaSindicall());
			  }
			  
			  
		  } else if (tipo == 3) {
			  novoEmpregado = new Comissionado(listaEmpregados.get(i).getNumeroEmpregado(), listaEmpregados.get(i).getNome(), 
					  listaEmpregados.get(i).getEndereco(), listaEmpregados.get(i).getMetodoPagamento(), listaEmpregados.get(i).getIsSindicato(), 
					  tipo, listaEmpregados.get(i).getTipoAgenda(), listaEmpregados.get(i).getDiaFrequencia());
			  
			  novoEmpregado.salario();
			  
			  if (listaEmpregados.get(i).getIsSindicato() == 1) {
				  novoEmpregado.getSindicato().setNumeroSindicato(listaEmpregados.get(i).getSindicato().getNumeroSindicato());
				  novoEmpregado.getSindicato().setTaxaSindical(listaEmpregados.get(i).getSindicato().getTaxaSindicall());
			  }
		  }
		  
		  listaEmpregados.add(novoEmpregado);
		  listaEmpregados.remove(i);
		  
		  System.out.println("\nTipo do empregado alterado com sucesso!\n");
	}
}
