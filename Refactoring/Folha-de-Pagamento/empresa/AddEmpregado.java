package empresa;

import java.util.Scanner;

import empregado.Assalariado;
import empregado.Comissionado;
import empregado.Horista;
import sistema.BancoDadosSingleton;
import sistema.TratamentoExc;

public class AddEmpregado {
	
	private BancoDadosSingleton bancoDados;
	private Horista horista;
	private Assalariado assalariado;
	private Comissionado comissionado;
	
	static private int numeroSindicato = 1;
	static private int numEmpregado = 1;
	
	Scanner input = new Scanner(System.in);

	public void add() {
		
		bancoDados = BancoDadosSingleton.getInstance();
		double taxaSindical = 0.0;
		
		System.out.println("\n**  ADICIONAR EMPREGADO  **\n");
		  
		System.out.println("Digite o nome do empregado:");
		String nome = input.nextLine();
	  
		System.out.println("\nDigite o endereço do empregado:");
		String endereco = input.nextLine();
	  
		System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
		int metodoPagamento = TratamentoExc.lerInt();
	  
		System.out.println("\nPertence ao sindicato?\n(1) - Sim\n(0) - Não");
		int isSindicato = TratamentoExc.lerInt();
	  
		if (isSindicato == 1) {
			System.out.print("Digite o valor da taxa sindical:\nR$ ");
			taxaSindical = TratamentoExc.lerDouble();
		}
	  
		System.out.println("\nEscolha o tipo do empregado:\n(1) - Horista\n(2) - Assalariado\n(3) - Comissionado");
		int tipo = TratamentoExc.lerInt();
	  

		if (tipo == 1) {
		  
			horista = new Horista(numEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo, "1 - Semanal", 5);
		 
			horista.entradaSalario();
		  
			if (isSindicato == 1) {
				horista.getSindicato().setNumeroSindicato(numeroSindicato);
				horista.getSindicato().setTaxaSindical(taxaSindical);
				numeroSindicato++;
			}
			
			bancoDados.setListaEmpregados(horista);
		  
	  } else if (tipo == 2) {
		  	assalariado = new Assalariado(numEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo, "Mensal", 31);
		  
		  	assalariado.entradaSalario();
		  
		  	if (isSindicato == 1) {
		  		assalariado.getSindicato().setNumeroSindicato(numeroSindicato);
		  		assalariado.getSindicato().setTaxaSindical(taxaSindical);
		  		numeroSindicato++;
		  	}
		  	
		  	bancoDados.setListaEmpregados(assalariado);
		  
	  	} else if (tipo == 3) {
	  		comissionado = new Comissionado(numEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo, "2 - Semanal", 5);
		  
	  		comissionado.entradaSalario();
		  
	  		if (isSindicato == 1) {
	  			comissionado.getSindicato().setNumeroSindicato(numeroSindicato);
	  			comissionado.getSindicato().setTaxaSindical(taxaSindical);
	  			numeroSindicato++;
	  		}
	  		
	  		bancoDados.setListaEmpregados(comissionado);
		  
	  	} else {
	  		System.out.println("\nErro: Opção Inválida.\n");
	  	}

		System.out.println("\nEmpregado cadastrado com sucesso!\n");
		numEmpregado++;
	}
}
