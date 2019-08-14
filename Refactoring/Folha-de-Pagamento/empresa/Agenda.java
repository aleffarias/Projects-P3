package empresa;

import java.util.ArrayList;

import empregado.Empregado;
import sistema.BancoDadosSingleton;
import sistema.TratamentoExc;

public class Agenda {
	
	private BancoDadosSingleton bancoDados = BancoDadosSingleton.getInstance();
	private ArrayList<Empregado> listaEmpregados = bancoDados.getListaEmpregados();
	
	public void consultaAgenda() {
		if (listaEmpregados.isEmpty()) {
			System.out.println("\nErro: Não há empregados cadastrados.\n");
			return;
		}
		
		for (int i=0; i < listaEmpregados.size(); i++) {
			System.out.println(listaEmpregados.get(i).toString() + "\n\n");
		}
	}
	
	public void novaAgenda() {
		
		int index = bancoDados.searchEmpregado();
		
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
