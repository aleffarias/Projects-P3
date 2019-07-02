package com.folhapagamento;

import java.util.ArrayList;
import java.util.Scanner;

import com.empregado.Assalariado;
import com.empregado.Comissionado;
import com.empregado.Empregado;
import com.empregado.Horista;

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
		Scanner input = new Scanner(System.in);
		Empregado empregado = null;
		
		int tipo = listaEmpregados.get(index).getTipo();
		
	
		System.out.println("\nEscolha uma opção:\n(1) - Mensal\n(2) - Semanal");
		int opcao1 = input.nextInt();
		input.nextLine();
		
		if (opcao1 == 1) {
			
		}
		
	}
}
