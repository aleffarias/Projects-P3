import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int key = -1, numeroFuncionario = 0, numeroSindicato = 0;
		
		// 		  0      |  1	|  	  2	   |  3   |  	4		|	  5  	|  		6	  |		7	|	8
		// N Funcionário | Nome | Endereço | Tipo | Metodo Pag. | Sindicato | N Sindicato | Salario | Taxa Comissão   
		String[] registroEmpregado = new String[9];
		
		ArrayList<String[]> listaEmpregados = new ArrayList<String[]>();

		Scanner input = new Scanner(System.in);
				
		while (key != 0) {
			
			System.out.println("Escolha uma opção:");
			System.out.println("(1) - Adicionar Empregado");
			System.out.println("(2) - Remover Empregado");
			System.out.println("(3) - Lançar um Cartão de Ponto");
			System.out.println("(4) - Lançar um Resultado Venda");
			System.out.println("(5) - Lançar uma taxa de serviço");
			System.out.println("(6) - Alterar detalhes de um empregado");
			System.out.println("(7) - Rodar a folha de pagamento para hoje");
			System.out.println("(8) - Undo/redo");
			System.out.println("(9) - Agenda de Pagamento");
			System.out.println("(10) - Criação de Novas Agendas de Pagamento");
			System.out.println("(0) - Sair");
			
			key = input.nextInt();
			input.nextLine();
			
			switch (key) {
			case 1:
				registroEmpregado[0] = Integer.toString(numeroFuncionario);
				
				System.out.println("Digite o nome do empregado:");
				registroEmpregado[1] = input.nextLine();
			
				System.out.println("Digite o endereço do empregado:");
				registroEmpregado[2] = input.nextLine();
				
				System.out.println("\n(1) - Horista\n(2) - Assalariado\n(3) - Comissionado");
				registroEmpregado[3] = input.nextLine();

		
					switch (Integer.parseInt(registroEmpregado[3])) {
					case 1:
						System.out.print("Informe o salário por hora trabalhada:\nR$ ");
						registroEmpregado[7] = input.nextLine();	

						break;
						
					case 2:
						System.out.print("Informe o salário fixo mensal:\nR$ ");
						registroEmpregado[7] = input.nextLine();	

						break;
						
					case 3:
						System.out.print("Informe o salário:\nR$ ");
						registroEmpregado[7] = input.nextLine();
						
						System.out.println("Informe o percentual de comissão:\nExemplo: 1,5 - 0,6");
						registroEmpregado[8] = input.nextLine();
						
						break;
					
					default:
						System.out.println("Opção Inválida.");
						
					} 
				
				System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
				registroEmpregado[4] = input.nextLine();
				
				System.out.println("\nPertence ao sindicato?\n(s) - Sim\n(n) - Não");
				registroEmpregado[5] = input.nextLine();
				
					if (registroEmpregado[5] == "s" || registroEmpregado[5] == "S") {
						registroEmpregado[6] = Integer.toString(numeroSindicato);
						numeroSindicato++;
					} else {
						registroEmpregado[6] = Integer.toString(-1);
					}
				
				listaEmpregados.add(registroEmpregado);
				
				System.out.println("\nFuncionário cadastrado com sucesso!\n");
				numeroFuncionario++;

				break;
			
			case 2:
				if (listaEmpregados.isEmpty() == true) {
					System.out.println("\nLista de funcionário Vazia!\n");
					break;
				} else {
					System.out.println("Digite o número do Funcionário:");
					int aux = input.nextInt();
					
					for (int i=0;i <= listaEmpregados.size();i++) {
						if (Integer.parseInt(listaEmpregados.get(i)[0]) == aux) {
							System.out.println("\nFuncionário: " + listaEmpregados.get(i)[1] + "está sendo removido...\n") ;
							listaEmpregados.remove(i);
							System.out.println("Funcionário removido com sucesso!\n");
						}
					}
				}
				
				break;
				
			case 3:
				CartaoPonto.lancarCartaoPonto();
				break;
			}
		
			// Teste
			// .get(lista)[indice array]
			//System.out.println(listaEmpregados.get(0)[0]);
		}
		input.close();
	}
}