package com.empresa;

import java.util.ArrayList;

import com.empregado.Empregado;
import com.sistema.TratamentoExc;

public class Agenda {

	public int searchEmpregado(ArrayList<Empregado> listaEmpregados, int nEmpregado){
		int i;
		
		if (listaEmpregados.isEmpty()) {
			System.out.println("\nErro: Não há empregados cadastrados.\n");
			return -1;
		}
		
		for (i=0; i < listaEmpregados.size(); i++) {
			if (listaEmpregados.get(i).getNumeroEmpregado() == nEmpregado) {
				break;
			}
		}
		
		return i;
	}
	
	
	public void consultaAgenda(ArrayList<Empregado> listaEmpregados) {
		if (listaEmpregados.isEmpty()) {
			System.out.println("\nErro: Não há empregados cadastrados.\n");
			return;
		}
		
		for (int i=0; i < listaEmpregados.size(); i++) {
			System.out.println(listaEmpregados.get(i).toString() + "\n\n");
		}
	}
	
	public void novaAgenda(ArrayList<Empregado> listaEmpregados, int index) {
		String agenda = null;
	
		System.out.println("\nEscolha uma opção:\n(1) - Mensal\n(2) - Semanal");
		int opcao = TratamentoExc.lerInt();
		
		if (opcao == 1) {
			System.out.println("\nEscolha o dia ou digite -1 para o último dia do mês");
			int opcao2 = TratamentoExc.lerInt();
			
			listaEmpregados.get(index).setTipoAgenda("Mensal");
			
			if (opcao2 == -1) {
				listaEmpregados.get(index).setDiaFrequencia(30);
			} else {
				
				listaEmpregados.get(index).setDiaFrequencia(opcao2);
			}
			
		} else if (opcao == 2) {
			System.out.println("\nEscolha a frequencia:\n1 - Toda semana\n2 - A cada duas semanas\n3 - A cada três semanas\n");
			int opcao2 = TratamentoExc.lerInt();
			
			if (opcao2 == 1) agenda = "1 - Semanal";
			else if (opcao2 == 2) agenda = "2 - Semanal";
			else if (opcao2 == 3) agenda = "3 - Semanal";
			
			listaEmpregados.get(index).setTipoAgenda(agenda);
			
			System.out.println("\nEscolha o dia da semana:\n1 - Segunda\n2 - Terça\n3 - Quarta\n4 - Quinta\n5 - Sexta");
			int opcao3 = TratamentoExc.lerInt();
			
			listaEmpregados.get(index).setDiaFrequencia(opcao3);
			
		}
		
		System.out.println("\nNova agenda de pagamento criada com sucesso!\n");
		
	}
	
	
}
