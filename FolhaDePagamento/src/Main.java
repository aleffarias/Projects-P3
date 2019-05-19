import java.util.ArrayList;
//import java.util.GregorianCalendar;
//import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
	
//		0			1		2		3			4			5			6				7			8				9
// N Funcionário | Nome | Endereço | Tipo | Metodo Pag. | Sindicato | N Sindicato | Salario | Salario Hora  | Taxa Comissão   
	static int linha = 100, coluna = 10;
	static String[][] empregado = new String[linha][coluna];
	
	
	public static void main(String[] args) {
		
		int key = -1, numeroFuncionario = 0, numeroSindicato = 0, nFunTemp;
		
		//
		// N Funcionário |H Entrada | H Saida | dia |  mes |  ano   |
		int[] registroCartaoPonto = new int[6];
		
		//	
		// N Funcionário |dia | mes | ano | valor |
		float[] resultadoVenda = new float[5];
		
		//
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
				empregado[numeroFuncionario][0] = Integer.toString(numeroFuncionario);
				
				System.out.println("Digite o nome do empregado:");
				empregado[numeroFuncionario][1] = input.nextLine();
			
				System.out.println("Digite o endereço do empregado:");
				empregado[numeroFuncionario][2] = input.nextLine();
				
				System.out.println("\n(1) - Horista\n(2) - Assalariado\n(3) - Comissionado");
				empregado[numeroFuncionario][3] = input.nextLine();

		
					switch (Integer.parseInt(empregado[numeroFuncionario][3])) {
					case 1:
						System.out.print("Informe o salário por hora trabalhada:\nR$ ");
						empregado[numeroFuncionario][8] = input.nextLine();	

						break;
						
					case 2:
						System.out.print("Informe o salário fixo mensal:\nR$ ");
						empregado[numeroFuncionario][7] = input.nextLine();	

						break;
						
					case 3:
						System.out.print("Informe o salário:\nR$ ");
						empregado[numeroFuncionario][7] = input.nextLine();
						
						System.out.println("Informe o percentual de comissão:\nExemplo: 1,5 - 0,6");
						empregado[numeroFuncionario][9] = input.nextLine();
						
						break;
					
					default:
						System.out.println("Opção Inválida.");
						
					} 
				
				System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
				empregado[numeroFuncionario][4] = input.nextLine();
				
				System.out.println("\nPertence ao sindicato?\n(s) - Sim\n(n) - Não");
				empregado[numeroFuncionario][5] = input.nextLine();
				
					if (empregado[numeroFuncionario][5] == "s" || empregado[numeroFuncionario][5] == "S") {
						empregado[numeroFuncionario][6] = Integer.toString(numeroSindicato);
						numeroSindicato++;
					} else {
						empregado[numeroFuncionario][6] = Integer.toString(-1);
					}
							
				System.out.println("\nFuncionário cadastrado com sucesso!\n");
				numeroFuncionario++;

				break;
			
			case 2:
				System.out.println("\n**  REMOVER FUNCIONÁRIO  **\n");
				// Mostrar lista de funcionários
				System.out.println("Digite o número do Funcionário:");
				nFunTemp = input.nextInt();
				
				System.out.println("Removendo funcionário...");
				for (int i=0;i <= coluna;i++) {
					empregado[nFunTemp][i] = null; 
				}
				
				System.out.println("Funcionário removido com sucesso!");
				break;
				
			case 3:
				System.out.println("\n**  LANÇAR CARTÃO DE PONTO  **\n");
				System.out.println("Digite o número do Funcionário:");
				nFunTemp = input.nextInt();
				
				System.out.println("Horário Entrada:");
				int cartaoPontoE = input.nextInt();
				
				System.out.println("Horário Saída:");
				int cartaoPontoS = input.nextInt();
				
				float salarioH = Float.parseFloat(empregado[nFunTemp][8]);
				empregado[nFunTemp][7] = salarioHorista(salarioH, cartaoPontoE, cartaoPontoS);
				
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
				
				System.out.println("\nTaxa de serviço registrada com sucesso!\n");
			}
		
			// Teste
			// .get(lista)[indice array]
			//System.out.println(listaEmpregados.get(0)[0]);
		}
		input.close();
	}
	
	public static float salarioHorista(float salarioHora, int entrada, int saida) {
		float salario;
		
		salario = (saida - entrada) * salarioHora;
		
		return salario;
	}
}