package empresa;

import java.util.ArrayList;

import empregado.Empregado;
import sistema.BancoDadosSingleton;

public class RodarFolha {
	
	private BancoDadosSingleton bancoDados = BancoDadosSingleton.getInstance();
	private ArrayList<Empregado> listaEmpregados = bancoDados.getListaEmpregados();
	
	public void rodarFolha_(int dia, int diaSemana, int semana, int ultimo) {
		System.out.println("\n**  	RODAR A FOLHA DE PAGAMENTO  	**\n");
		System.out.println("Verificando Empregados...\n");
			
		for (int i=0; i < listaEmpregados.size(); i++) {
	
			if ((listaEmpregados.get(i).getTipoAgenda() == "1 - Semanal") && (listaEmpregados.get(i).getDiaFrequencia() == diaSemana)) {		
				
				listaEmpregados.get(i).pagarEmpregado(listaEmpregados, i);
				
			} else if ((listaEmpregados.get(i).getTipoAgenda() == "2 - Semanal") && (listaEmpregados.get(i).getDiaFrequencia() == diaSemana)
					&& (semana == 2 || semana == 4)) {
				
				listaEmpregados.get(i).pagarEmpregado(listaEmpregados, i);
				
			} else if ((listaEmpregados.get(i).getTipoAgenda() == "3 - Semanal") && (listaEmpregados.get(i).getDiaFrequencia() == diaSemana) 
					&& (semana == 3)) {
				
				listaEmpregados.get(i).pagarEmpregado(listaEmpregados, i);
				
			} else if (listaEmpregados.get(i).getTipoAgenda() == "Mensal") {
				
				if (listaEmpregados.get(i).getDiaFrequencia() == 28 || listaEmpregados.get(i).getDiaFrequencia() == 30 
					|| listaEmpregados.get(i).getDiaFrequencia() == 31) { // Verifica se o dia na agenda não foi alterado
				
					listaEmpregados.get(i).setDiaFrequencia(ultimo);
				}
				
				if (listaEmpregados.get(i).getDiaFrequencia() == dia) {
					listaEmpregados.get(i).pagarEmpregado(listaEmpregados, i);	
					
				}
			}
		}
		
	}
}
