import java.util.ArrayList;
import java.util.Scanner;

public class Empregado { 
		
	public static Scanner input;
	static ArrayList<RegistroEmpregado> listaEmpregados = new ArrayList<RegistroEmpregado>();
	
	static int numeroFuncionario = 00, numeroSindicato = 00;

	public static void adicionar() {

		input = new Scanner(System.in);
		
		RegistroEmpregado perfil = new RegistroEmpregado();
		
		
		perfil.numeroFuncionario = numeroFuncionario;
		
		System.out.println("Digite o nome do empregado:");
		perfil.nome = input.nextLine();
	
		System.out.println("Digite o endereço do empregado:");
		perfil.endereco = input.nextLine();
		
		System.out.println("\n(1) - Horista\n(2) - Assalariado\n(3) - Comissionado");
		perfil.tipo = input.nextInt();
		
			switch (perfil.tipo) {
			case 1:
				System.out.print("Informe o salário por hora trabalhada:\nR$ ");
				perfil.salarioHorista = input.nextFloat();						
				break;
				
			case 2:
				System.out.print("Informe o salário fixo mensal:\nR$ ");
				perfil.salarioFixo = input.nextFloat();						
				break;
				
			case 3:
				System.out.print("Informe o salário:\nR$ ");
				perfil.salarioComissionado = input.nextFloat();
				System.out.println("Informe o percentual de comissão:\nExemplo: 1,5 - 0,6");
				perfil.percentualComissao = input.nextFloat();
				
				break;
			
			default:
				System.out.println("Opção Inválida.");
				
			} 
		
		System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
		perfil.metodoPagamento = input.nextInt();
		
		System.out.println("\nPertence ao sindicato?\n(1) - Sim\n(2) - Não");
		perfil.sindicato = input.nextInt();
		
			if (perfil.sindicato == 1) {
				perfil.numeroSindicato = numeroSindicato;
				numeroSindicato++;
			} else {
				perfil.numeroSindicato = -1;
			}
		
		
		listaEmpregados.add(perfil);
		System.out.println("Funcionário cadastrado com sucesso!\n");
		numeroFuncionario++;
		
	}
	
	public static void remover() {
		// Imprimir todos os funcionários
		
		System.out.println("Digite o número do Funcionário:");
		int aux = input.nextInt();
		listaEmpregados.remove(aux);
		numeroFuncionario--;
		
		// Teste
		System.out.println(listaEmpregados.get(0).nome);
		System.out.println(listaEmpregados.get(1).nome);
		
	}
	
}
