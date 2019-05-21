//import java.util.GregorianCalendar;
//import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
	
//        0          1       2         3         4            5             6          7           8                  9
// N Funcionário | Nome | Endereço | Tipo | Metodo Pag. | Sindicato | N Sindicato | Salario | Salario Hora  | Taxa Comissão   
	static int linha = 100, coluna = 10;
	static String[][] empregado = new String[linha][coluna];
	
	
	public static void main(String[] args) {
		
		int key = -1, numeroFuncionario = 0, numeroSindicato = 0, nFunTemp;

		
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
				empregado[numeroFuncionario][7] = "0";
				empregado[numeroFuncionario][0] = Integer.toString(numeroFuncionario);
				
				System.out.println("Digite o nome do empregado:");
				empregado[numeroFuncionario][1] = input.nextLine();
			
				System.out.println("Digite o endereço do empregado:");
				empregado[numeroFuncionario][2] = input.nextLine();
				
				System.out.println("\n(1) - Horista\n(2) - Assalariado\n(3) - Comissionado");
				empregado[numeroFuncionario][3] = input.nextLine();

		
					switch (Integer.parseInt(empregado[numeroFuncionario][3])) {
					case 1:
						System.out.print("Informe o salário por hora trabalhada:\nExemplo: 1.5 - 3\nR$ ");
						empregado[numeroFuncionario][8] = input.nextLine();	

						break;
						
					case 2:
						System.out.print("Informe o salário fixo mensal:\nExemplo: 1500 - 3000.56\nR$ ");
						empregado[numeroFuncionario][7] = input.nextLine();	

						break;
						
					case 3:
						System.out.print("Informe o salário:\nExemplo: 1500 - 3000.56\nR$ ");
						empregado[numeroFuncionario][7] = input.nextLine();
						
						System.out.println("Informe o percentual de comissão:\nExemplo: 1.5 - 0.6");
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
				// Mostrar lista de funcionários
				System.out.println("Digite o número do Funcionário:");
				nFunTemp = input.nextInt();
				
				// Verificar se o funcionário é horista
				
				System.out.println("Horário Entrada:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
				int cartaoPontoE = input.nextInt();
				
				System.out.println("Horário Saída:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
				int cartaoPontoS = input.nextInt();
				
				float salarioH = Float.parseFloat(empregado[nFunTemp][8]);
				empregado[nFunTemp][7] = Double.toString(Double.parseDouble(empregado[nFunTemp][7]) + (salarioHorista(salarioH, cartaoPontoE, cartaoPontoS)));
				
				System.out.println("\nCartão de Ponto registrado com sucesso!\n");
				
				// Imprimir comprovante
				
				break;
				
			case 4:
				System.out.println("\n**  LANÇAR RESULTADO DE VENDA  **\n");
				// Mostrar lista de funcionários
				System.out.println("Digite o número do Funcionário:");
				nFunTemp = input.nextInt();
				
				// Verificar se o funcionário é comissionado
				
				System.out.println("Dia da venda:");
				int diaVenda = input.nextInt();
				
				System.out.println("Mês da venda:");
				int mesVenda = input.nextInt();
				
				System.out.println("Ano da venda:");
				int anoVenda = input.nextInt();
				
				System.out.println("Valor da venda:\nExemplo: 1500 - 3000.56\n");
				float valorVenda = input.nextFloat();
				
				empregado[nFunTemp][7] = Double.toString(Double.parseDouble(empregado[nFunTemp][7]) + (valorVenda * ((Float.parseFloat(empregado[nFunTemp][9]) / 100))));
				
				System.out.println("\nResultado da venda registrado com sucesso!\n");
				
				// Imprimir comprovante
				
				break;
			
			case 5:
				System.out.println("\n**  LANÇAR TAXA DE SERVIÇO  **\n");
				System.out.println("Digite o número do Funcionário:");
				nFunTemp = input.nextInt();
				
				// Verificar se o funcionário é do sindicato
				
				System.out.printf("Serviço prestado:");
				String servicoPrestado = input.nextLine();
				
				System.out.println("Valor da taxa de serviço:");
				float valorServico = input.nextFloat();
				
				System.out.println("\nTaxa de serviço registrada com sucesso!\n");
				
				// Imprimir comprovante
			}
		
			// Teste
			System.out.println(empregado[0][7]);
		}
		input.close();
	}
	
	public static double salarioHorista(double salarioHora, int entrada, int saida) {
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