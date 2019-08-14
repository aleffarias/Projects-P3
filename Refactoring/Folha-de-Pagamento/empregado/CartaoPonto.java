package empregado;

import sistema.BancoDadosSingleton;
import sistema.TratamentoExc;

public class CartaoPonto {
	
	private BancoDadosSingleton bancoDados = BancoDadosSingleton.getInstance();
	private Horista horista;
	
	public boolean verificaHorista() {
		int index = bancoDados.searchEmpregado();
		if (index == -1) return false;
		
		if (bancoDados.getListaEmpregados().get(index) instanceof Horista) {
			horista = (Horista) bancoDados.getListaEmpregados().get(index);
			
			return true;
		}
		
		else return false;
	}
	
	
	public void lancarCartao() {
		
		if (verificaHorista() == true) {
		
			System.out.println("\nHorário Entrada:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
			int cartaoPontoE = TratamentoExc.lerInt();
			
			System.out.println("\nHorário Saída:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
			int cartaoPontoS = TratamentoExc.lerInt();
			
			// Calcula o salário
			double salarioHorista = horista.getSalarioHorista() + (calculaSalario(horista.getSalarioHora(), cartaoPontoE, cartaoPontoS));
			
			horista.setSalarioHorista(salarioHorista);
			
			System.out.println("\nCartão de Ponto registrado com sucesso!\n");
			
		} else {System.out.println("\nErro: Empregado não é Horista.\n");} 
	}
	
	
	public double calculaSalario(double salarioHora, int entrada, int saida) {
		double salario;
		
		int horaTrabalhada = saida - entrada;
		float minutos = horaTrabalhada % 100;
		
		if (horaTrabalhada <= 800) {
		
			if (minutos < 10) {
				minutos = minutos / 10;
			} else {
				minutos = minutos / 100;
			}
			
			salario = ((horaTrabalhada / 100) * salarioHora) + (minutos * salarioHora);
		} else {
			int horaExtra = horaTrabalhada - 800;
			
			if (minutos < 10) {
				minutos = minutos / 10;
			} else {
				minutos = minutos / 100;
			}
			
			salario = (8 * salarioHora + ((horaExtra / 100) * (salarioHora * 1.5)) + (minutos * (horaExtra * 1.5)));
			
		}
		
		return salario;
	}
}
