import java.util.ArrayList;
//import java.util.GregorianCalendar;
//import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
	
	static ArrayList<String[]> listaEmpregados = new ArrayList<String[]>();
	static ArrayList<int[]> listaCartaoPonto = new ArrayList<int[]>();
	static ArrayList<float[]> listaResultadoVenda = new ArrayList<float[]>();
	static ArrayList<float[]> listaTaxaServico = new ArrayList<float[]>();
	
	public static void main(String[] args) {
		
		int key = -1, numeroFuncionario = 0, numeroSindicato = 0;
		
		// 		  0      |  1	|  	  2	   |  3   |  	4		|	  5  	|  		6	  |		7	|	8
		// N Funcionário | Nome | Endereço | Tipo | Metodo Pag. | Sindicato | N Sindicato | Salario | Taxa Comissão   
		String[] registroEmpregado = new String[9];
		
		//	 	 0  	 |	  1		|   2	  |  3  |  	4  |   5  	|
		// N Funcionário |H Entrada | H Saida | dia |  mes |  ano   |
		int[] registroCartaoPonto = new int[6];
		
		//	 	 0  	 | 1  |  2	|  3  |   4   | 
		// N Funcionário |dia | mes | ano | valor |
		float[] resultadoVenda = new float[5];
		
		//	 	 0  	 | 1  |  2	|  3  |   4   | 
		// N Funcionário |dia | mes | ano | taxa |
		float[] taxaServico = new float[5];
		
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
				System.out.println("\n**  ADICIONAR FUNCIONÁRIO  **\n");
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
				System.out.println("\n**  REMOVER FUNCIONÁRIO  **\n");
				if (listaEmpregados.isEmpty() == true) {
					System.out.println("\nErro: Lista de funcionário Vazia.\n");
					break;
				} else {
					System.out.println("Digite o número do Funcionário:");
					int aux = input.nextInt();
					
					for (int i=0;i <= listaEmpregados.size();i++) {
						if (Integer.parseInt(listaEmpregados.get(i)[0]) == aux) {
							System.out.println("\nFuncionário: " + listaEmpregados.get(i)[1] + " está sendo removido...\n") ;
							listaEmpregados.remove(i);
							System.out.println("Funcionário removido com sucesso!\n");
						} else {
							System.out.println("Erro: Funcionário não existe.\n");
							break;
						}
					}
				}
				
				break;
				
			case 3:
				System.out.println("\n**  LANÇAR CARTÃO DE PONTO  **\n");
				System.out.println("Digite o número do Funcionário:");
				registroCartaoPonto[0] = input.nextInt();
				
				System.out.println("Horário Entrada:");
				registroCartaoPonto[1] = input.nextInt();
				
				System.out.println("Horário Saída:");
				registroCartaoPonto[2] = input.nextInt();
				
				System.out.println("Dia:");
				registroCartaoPonto[3] = input.nextInt();
				
				System.out.println("Mês:");
				registroCartaoPonto[4] = input.nextInt();
				
				System.out.println("Ano:");
				registroCartaoPonto[5] = input.nextInt();
				
				listaCartaoPonto.add(registroCartaoPonto);
				
				break;
				
			case 4:
				System.out.println("\n**  LANÇAR RESULTADO DE VENDA  **\n");
				System.out.println("Digite o número do Funcionário:");
				resultadoVenda[0] = input.nextInt();
				
				System.out.println("Dia da venda:");
				resultadoVenda[1] = input.nextInt();
				
				System.out.println("Mês da venda:");
				resultadoVenda[2] = input.nextInt();
				
				System.out.println("Ano da venda:");
				resultadoVenda[3] = input.nextInt();
				
				System.out.println("Valor da venda:");
				resultadoVenda[4] = input.nextFloat();
				
				listaResultadoVenda.add(resultadoVenda);
				System.out.println("\nResultado da venda registrado com sucesso!\n");
			
			case 5:
				System.out.println("\n**  LANÇAR TAXA DE SERVIÇO  **\n");
				System.out.println("Digite o número do Funcionário:");
				taxaServico[0] = input.nextInt();
				
				System.out.printf("Dia do serviço:");
				taxaServico[1] = input.nextInt();
				
				System.out.println("Mês do serviço:");
				taxaServico[2] = input.nextInt();
				
				System.out.println("Ano do serviço:");
				taxaServico[3] = input.nextInt();
				
				System.out.println("Valor da taxa de serviço:");
				taxaServico[4] = input.nextFloat();
				
				listaTaxaServico.add(taxaServico);
				System.out.println("\nTaxa de serviço registrada com sucesso!\n");
			}
		
			// Teste
			// .get(lista)[indice array]
			//System.out.println(listaEmpregados.get(0)[0]);
		}
		input.close();
	}
	
	public static void salarioHorista() {
		for (int i=0;i <= listaEmpregados.size();i++) {
			if (listaEmpregados.get(i)[3] == "1") {
				for (int k=0 ;k <= listaCartaoPonto.size();i++) {
					if (listaCartaoPonto.get(k)[0] == Integer.parseInt(listaEmpregados.get(i)[0])) {
						// salario = (H saida - H entrada) *  salario hora
					}
				}
			} else {
				System.out.println("Erro: O Empregado não é horista.\n");
			}
		}
		
	}
}