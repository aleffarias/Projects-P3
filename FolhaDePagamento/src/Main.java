import java.util.Scanner;

public class Main {
	
/*        0          1       2         3         4            5             6            7               8                9    
   N Funcionário | Nome | Endereço | Tipo | Metodo Pag. | Sindicato | N Sindicato | Salario Bruto| Salario Hora  | Taxa Comissão 
	
	   10           11          12                     13                               14                   15
  Taxa Sindical | Agenda | Nova Agenda | Dia (mensal) ou Frequencia (semanal) | Dia semana (semanal) | Salario Liquido
*/
	static int linha = 100, coluna = 16, dia = 1, semana = 1, mes = 1, ano = 2019, diaSemana = 1;
	static String[][] empregado = new String[linha][coluna];
	
	
	public static void main(String[] args) {
		
		int key = -1, key1 = -1, numeroFuncionario = 1, numeroSindicato = 1, nFunTemp, opcao1, opcao2, opcao3, aux;
		String opcao;
		
		Scanner input = new Scanner(System.in);
				
		while (key != 0) {
			
			System.out.println("Dia: " + dia + " Mês: " + mes + " Ano: " + ano);
			
			System.out.println("\nEscolha uma opção:");
			System.out.println("(1) - Adicionar Empregado");
			System.out.println("(2) - Remover Empregado");
			System.out.println("(3) - Lançar um Cartão de Ponto");
			System.out.println("(4) - Lançar um Resultado Venda");
			System.out.println("(5) - Lançar uma taxa de serviço");
			System.out.println("(6) - Alterar detalhes de um empregado");
			System.out.println("(7) - Rodar a folha de pagamento para hoje (após rodar, avança 1 dia)");
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
				empregado[numeroFuncionario][15] = "0";
				empregado[numeroFuncionario][0] = Integer.toString(numeroFuncionario);
				
				System.out.println("Digite o nome do empregado:");
				empregado[numeroFuncionario][1] = input.nextLine();
			
				System.out.println("\nDigite o endereço do empregado:");
				empregado[numeroFuncionario][2] = input.nextLine();
				
				System.out.println("\nEscolha o tipo do empregado:\n(1) - Horista\n(2) - Assalariado\n(3) - Comissionado");
				empregado[numeroFuncionario][3] = input.nextLine();

					if (Integer.parseInt(empregado[numeroFuncionario][3]) == 1) {
						empregado[numeroFuncionario][11] = "1"; // Semanalmente
						empregado[numeroFuncionario][12] = "Padrão - Semanal";
						empregado[numeroFuncionario][13] = "1"; // Frequência: Toda semana
						empregado[numeroFuncionario][14] = "5"; // Sexta
						
						System.out.print("\nInforme o salário por hora trabalhada:\nExemplo: 1.5 - 3\nR$ ");
						empregado[numeroFuncionario][8] = input.nextLine();
	
					} else if (Integer.parseInt(empregado[numeroFuncionario][3]) == 2) {
						empregado[numeroFuncionario][11] = "2"; // Mensalmente
						empregado[numeroFuncionario][12] = "Padrão - Mensal";
						empregado[numeroFuncionario][13] = "30"; // Ultimo dia do mês
						
						System.out.print("\nInforme o salário fixo mensal:\nExemplo: 1500 - 3000.56\nR$ ");
						empregado[numeroFuncionario][7] = input.nextLine();	
						empregado[numeroFuncionario][15] = empregado[numeroFuncionario][7];
	
					} else if (Integer.parseInt(empregado[numeroFuncionario][3]) == 3) {
						empregado[numeroFuncionario][11] = "3"; // Bi-semanalmente
						empregado[numeroFuncionario][12] = "Padrão - Bi-semanal";
						empregado[numeroFuncionario][13] = "2"; // Frequência: Toda semana
						empregado[numeroFuncionario][14] = "5"; // Sexta
						
						System.out.print("\nInforme o salário:\nExemplo: 1500 - 3000.56\nR$ ");
						empregado[numeroFuncionario][7] = input.nextLine();	
						empregado[numeroFuncionario][15] = empregado[numeroFuncionario][7];
						
						System.out.println("\nInforme o percentual de comissão:\nExemplo: 1.5 - 0.6");
						empregado[numeroFuncionario][9] = input.nextLine();
						
					} else {
						System.out.println("\nErro: Opção Inválida.\n");			
					}
					
				System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
				empregado[numeroFuncionario][4] = input.nextLine();
				
				System.out.println("\nPertence ao sindicato?\n(1) - Sim\n(0) - Não");
				empregado[numeroFuncionario][5] = input.nextLine();
				
					if (Integer.parseInt(empregado[numeroFuncionario][5]) == 1) {
						empregado[numeroFuncionario][6] = Integer.toString(numeroSindicato);
						
						System.out.print("Digite o valor da taxa sindical:\nR$ ");
						empregado[numeroFuncionario][10] = input.nextLine();
						
						numeroSindicato++;
					} else {
						empregado[numeroFuncionario][6] = Integer.toString(-1);
					}
				
					
				System.out.println("\nEmpregado cadastrado com sucesso!\n");
				numeroFuncionario++;

				break;
			
			case 2:	
				todosEmpregados(0);
				
				System.out.println("\n\t**  	REMOVER FUNCIONÁRIO  	**\n");
				System.out.println("Digite o número do Empregado:\n");
				nFunTemp = input.nextInt();
				
				System.out.println("\nRemovendo empregado...");
				for (int i=0;i < coluna;i++) {
					empregado[nFunTemp][i] = null; 
				}
				
				System.out.println("\nEmpregado removido com sucesso!\n");
				break;
				
			case 3:			
				System.out.println("\n**  	LANÇAR CARTÃO DE PONTO  	**\n");		
				System.out.println("Digite o número do Empregado:");
				nFunTemp = input.nextInt();
				
				if ((Integer.parseInt(empregado[nFunTemp][3])) == 1) { // Verifica se o funcionário é horista
				
					System.out.println("\nHorário Entrada:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
					int cartaoPontoE = input.nextInt();
					
					System.out.println("\nHorário Saída:\nDigite sem ':' Exemplo: 0703(07:03) - 1256(12:56)");
					int cartaoPontoS = input.nextInt();
					
					float salarioH = Float.parseFloat(empregado[nFunTemp][8]);
					empregado[nFunTemp][15] = Double.toString(Double.parseDouble(empregado[nFunTemp][15]) + (salarioHorista(salarioH, cartaoPontoE, cartaoPontoS)));
					
					System.out.println("\nCartão de Ponto registrado com sucesso!\n");
					
					// Imprimir comprovante
					
				} else {
					System.out.println("\nErro: Empregado não é horista.\n");
				}
					
				break;
				
			case 4:	
				System.out.println("\n**  	LANÇAR RESULTADO DE VENDA  		**\n");
				System.out.println("Digite o número do Empregado:");
				nFunTemp = input.nextInt();
				
				if ((Integer.parseInt(empregado[nFunTemp][3])) == 3) { // Verificar se o funcionário é comissionado
					
					System.out.println("\nDia da venda:");
					int diaVenda = input.nextInt();
					
					System.out.println("\nMês da venda:");
					int mesVenda = input.nextInt();
					
					System.out.println("\nAno da venda:");
					int anoVenda = input.nextInt();
					
					System.out.print("\nValor da venda:\nExemplo: 1500 - 3000.56\nR$ ");
					float valorVenda = input.nextFloat();
					
					empregado[nFunTemp][15] = Double.toString(Double.parseDouble(empregado[nFunTemp][7]) + (valorVenda * ((Float.parseFloat(empregado[nFunTemp][9]) / 100))));
					
					System.out.println("\nResultado da venda registrado com sucesso!\n");
					
				} else {
					System.out.println("\nErro: Empregado não é comissionado.\n");
				}
				
				break;
			
			case 5:
				System.out.println("\n**  	LANÇAR TAXA DE SERVIÇO  	**\n");
				System.out.println("Digite o número do Empregado:");
				nFunTemp = input.nextInt();
				input.nextLine();
				
				if (((Integer.parseInt(empregado[nFunTemp][5])) == 1) ) { // Verificar se o funcionário é do sindicato

					System.out.println("\nServiço prestado:");
					String servicoPrestado = input.nextLine();
					
					System.out.println("\nValor da taxa de serviço:");
					double valorServico = input.nextDouble();
					input.nextLine();
					
					System.out.println("\nTaxa de serviço registrada com sucesso!\n");
					
					empregado[nFunTemp][15] = Double.toString(Double.parseDouble(empregado[nFunTemp][15]) - valorServico);
					
				} else {
					System.out.println("\nErro: Empregado não pertence ao sindicato.\n");
				}
				
				break;
			case 6:				
				System.out.println("\n**  	ALTERAR DETALHES DO EMPREGADO  	**\n");
				System.out.println("Digite o número do Funcionário:");
				nFunTemp = input.nextInt();
				
				key1 = -1;
				
				while (key1 != 0) {
					System.out.println("Escolha uma opção:");
					System.out.println("(1) - Alterar nome");
					System.out.println("(2) - Alterar endereço");
					System.out.println("(3) - Alterar tipo");
					System.out.println("(4) - Alterar método de pagamento");
					System.out.println("(5) - Alterar sindicato");
					System.out.println("(0) - Sair");
					
					key1 = input.nextInt();
					input.nextLine();
					
					switch (key1) {
					case 1:
						System.out.println("\nDigite o nome do empregado:");
						empregado[nFunTemp][1] = input.nextLine();
						
						System.out.println("\nNome do empregado alterado com sucesso!\n");
						
						break;
						
					case 2:						
						System.out.println("\nDigite o endereço do empregado:");
						empregado[nFunTemp][2] = input.nextLine();
						
						System.out.println("\nEndereço do empregado alterado com sucesso!\n");
						
						break;
						
					case 3:
						System.out.println("\nEscolha o tipo do empregado:\n(1) - Horista\n(2) - Assalariado\n(3) - Comissionado");
						empregado[nFunTemp][3] = input.nextLine();
				
							if (Integer.parseInt(empregado[nFunTemp][3]) == 1) {
								
								System.out.print("\nInforme o salário por hora trabalhada:\nExemplo: 1.5 - 3\nR$ ");
								empregado[nFunTemp][8] = input.nextLine();
								
								System.out.println("Agenda de pagamento padrão (Semanalmente)?\n(1) - Sim\n(2) - Não");
								aux = input.nextInt();
								
								if (aux == 1) {
									empregado[nFunTemp][11] = "1"; // Semanalmente
									empregado[nFunTemp][12] = "Padrão - Semanal";
									empregado[nFunTemp][13] = "1"; // Frequência: Toda semana
									empregado[nFunTemp][14] = "5"; // Sexta
								}

							} else if (Integer.parseInt(empregado[nFunTemp][3]) == 2) {
								
								System.out.print("\nInforme o salário fixo mensal:\nExemplo: 1500 - 3000.56\nR$ ");
								empregado[nFunTemp][7] = input.nextLine();	
								empregado[nFunTemp][15] = empregado[nFunTemp][7];
								
								System.out.println("Agenda de pagamento padrão (Mensal)?\n(1) - Sim\n(2) - Não");
								aux = input.nextInt();
								
								if (aux == 1) {
									empregado[nFunTemp][11] = "2"; // Mensalmente
									empregado[nFunTemp][12] = "Padrão - Mensal";
									empregado[nFunTemp][13] = "30"; // Ultimo dia do mês
								}							

							} else if (Integer.parseInt(empregado[nFunTemp][3]) == 3) {
								
								System.out.print("\nInforme o salário:\nExemplo: 1500 - 3000.56\nR$ ");
								empregado[nFunTemp][7] = input.nextLine();	
								empregado[nFunTemp][15] = empregado[nFunTemp][7];
								
								System.out.println("\nInforme o percentual de comissão:\nExemplo: 1.5 - 0.6");
								empregado[nFunTemp][9] = input.nextLine();
								
								System.out.println("Agenda de pagamento padrão (Bi-semanalmente)?\n(1) - Sim\n(2) - Não");
								aux = input.nextInt();
								
								if (aux == 1) {
									empregado[nFunTemp][11] = "3"; // Bi-semanalmente
									empregado[nFunTemp][12] = "Padrão - Bi-Semanal";
									empregado[nFunTemp][13] = "2"; // Frequência: Toda semana
									empregado[nFunTemp][14] = "5"; // Sexta
									
								}
								
							} else {
								System.out.println("\nErro: Opção Inválida.\n");			
							}
						
							System.out.println("\nTipo do empregado alterado com sucesso!\n");
							
						break;
						
					case 4:
						System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
						empregado[nFunTemp][4] = input.nextLine();
						
						System.out.println("\nMétodo de pagamento do empregado alterado com sucesso!\n");
						
						break;
						
					case 5:
						System.out.println("\nPertence ao sindicato?\n(1) - Sim\n(0) - Não");
						empregado[nFunTemp][5] = input.nextLine();
						
							if (Integer.parseInt(empregado[nFunTemp][5]) == 1) {
																
								empregado[nFunTemp][6] = Integer.toString(numeroSindicato);
								
								System.out.print("Digite o valor da taxa sindical:\nR$");
								empregado[nFunTemp][10] = input.nextLine();
								
								numeroSindicato++;
							} else {
								empregado[nFunTemp][6] = Integer.toString(-1);
							}
							
						System.out.println("\nSindicato do empregado alterado com sucesso!\n");
						
						break;
					case 0:
						key1 = 0;
						
						break;
					}
				}
				
				break;
			case 7:
				System.out.println("\n**  	RODAR A FOLHA DE PAGAMENTO  	**\n");
				
				System.out.println("Verificando Empregados...");
	
				for (int i = 0; i < linha; i++) {
					if (empregado[i][0] != null) {

                        // Frequencia da semana
                        boolean check = false;
                        if (Integer.parseInt(empregado[i][13]) == 1) {
                            check = true;
                        } else if (Integer.parseInt(empregado[i][13]) == 2) {
                            if (semana == 2 || semana == 4){
                                check = true;
                            }
                        } else if (Integer.parseInt(empregado[i][13]) == 3) {
                            if (semana == 3){
                                check = true;
                            }
                        } else if (Integer.parseInt(empregado[i][13]) == 4) {
                            if (semana == 4){
                                check = true;
                            }
                        } else {
                            check = false;
                        }
                        

						if ((((Integer.parseInt(empregado[i][11]) == 1) || (Integer.parseInt(empregado[i][11]) == 3) || (Integer.parseInt(empregado[i][11]) == 5)) 
							&& (check == true)) && (Integer.parseInt(empregado[i][14]) == diaSemana)) {
								
							contracheque(i);
							empregado[i][15] = "0"; // Zera salário após pagamento
							
						} else if (((Integer.parseInt(empregado[i][11]) == 2) || (Integer.parseInt(empregado[i][11]) == 4)) && (Integer.parseInt(empregado[i][13]) == dia)) {
							
							System.out.println("Entrou assalariado");
							contracheque(i);
							empregado[i][15] = "0"; // Zera salário após pagamento
						}
					}
                }
                
                System.out.println("\nData: " + dia + "/ " + mes + " / " + ano + " -  Folha de pagamento executada com sucesso!\n");
				
				dia++;
				diaSemana++; // semana
				
				break;
			
			case 8:
				System.out.println("\n**  	UNDU/REDO  	**\n");
				
				break;
			
			case 9:
				System.out.println("\n**  				AGENDA DE PAGAMENTO 				**\n");
				
				// Agenda padrão
				System.out.println("\nEMPREGADOS PAGOS SEMANALMENTE");	
				todosEmpregados(1);
					
				System.out.println("\nEMPREGADOS PAGOS BI-SEMANALMENTE");				
				todosEmpregados(3);	
				
				System.out.println("\nEMPREGADOS PAGOS MENSALMENTE");			
				todosEmpregados(2);
				
				// Empregados com nova agenda de pagamento
				System.out.println("\nNOVA AGENDA: MENSAL");			
				todosEmpregados(4);
				
				System.out.println("\nNOVA AGENDA: SEMANAL");			
				todosEmpregados(5);
				
				System.out.println("\n");
				
				break;
			
			case 10:
				System.out.println("\n**  	CRIAR AGENDA DE PAGAMENTO 	**\n");
				
				System.out.println("Digite o número do Funcionário:");
				nFunTemp = input.nextInt();
				
				System.out.println("\nEscolha uma opção:\n(1) - Mensal\n(2) - Semanal");
				opcao1 = input.nextInt();
				input.nextLine();
				
				if (opcao1 == 1) {
					System.out.println("\nEscolha o dia ou digite $ para o último dia do mês");
					opcao = input.nextLine();
                    
					String string = "$";
                    if (opcao == string) {
						opcao = "Último dia do mês";
					}

					empregado[nFunTemp][11] = "4"; // Nova Agenda: Mensal
					empregado[nFunTemp][12] =  "Mensalmente 		Dia: " + opcao;
					empregado[nFunTemp][13] = opcao; // DIa do mês
					
					System.out.println("\nNova agenda de pagamento criada com sucesso!\n");
					
				} else if (opcao1 == 2) {
					System.out.println("\nEscolha a frequencia:\n1 - Toda semana\n2 - A cada duas semanas\n3 - A cada três semanas\n...");
					opcao2 = input.nextInt();
					input.nextLine();
					
					System.out.println("\nEscolha o dia da semana:\n1 - Segunda\n2 - Terça\n3 - Quarta\n4 - Quinta\n5 - Sexta");
					opcao3 = input.nextInt();
					input.nextLine();
					
					empregado[nFunTemp][11] = "5";	// Nova Agenda: Semanal
					empregado[nFunTemp][12] = "A cada " + opcao2 + " semana(s)	Dia da semana: " + opcao3;
					empregado[nFunTemp][13] = Integer.toString(opcao2); // Frequencia semanas 
					empregado[nFunTemp][14] = Integer.toString(opcao3); // Dia da semana
					
					System.out.println("\nNova agenda de pagamento criada com sucesso!\n");
					
				} else {
					System.out.println("\nErro: Opção Inváida.\n");
				}
				
				break;
				
			case 0:
				System.exit(0);
				
			default:
				System.out.println("\nErro: Opção Inválida.\n");
			}
			
			// Data		
			if (diaSemana == 8) {
				semana++;
				diaSemana = 1;
			}
			
			if (dia == 31 && mes != 12) {
				dia = 1;
				semana = 1;
				mes++;
			}
			
			if (dia == 31 && mes == 12) {
				dia = 1;
				mes = 1;
				ano++;
			}
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
	
	public static void todosEmpregados (int agenda) {
		String tipo = "";
		String metPagamento = "";
		String sindicato = "";
		String salario = "";

		for (int i=0; i < linha ;i++) {
			if (empregado[i][0] != null) {
				if ((Integer.parseInt(empregado[i][11])) == agenda || agenda == 0){
					System.out.println("==================================================================================");
					System.out.printf("Número do empregado: %s		Nome: %s\n", empregado[i][0], empregado[i][1]);
					System.out.println("--------------------------------------------------------------------------");
					System.out.printf("Endereço: %s\n", empregado[i][2]);
					System.out.println("--------------------------------------------------------------------------");
					
					if (Integer.parseInt(empregado[i][3]) == 1) {
						tipo = "Horista";
						salario = "Salário Hora: R$ " + String.format("%.2f", Double.parseDouble(empregado[i][8]));
					} else if (Integer.parseInt(empregado[i][3]) == 2){
						tipo = "Assalariado";
						salario = "Salário Bruto: R$ " + String.format("%.2f", Double.parseDouble(empregado[i][7]));
					} else if (Integer.parseInt(empregado[i][3]) == 3) {
						tipo = "Comissionado";
						salario = "Salário Bruto: R$ " + String.format("%.2f", Double.parseDouble(empregado[i][7])) + "	Comissão: " + Double.parseDouble(empregado[i][9]) + " %";
					}
					
					if (Integer.parseInt(empregado[i][4]) == 1) {
						metPagamento = "Cheque pelos correios";
					} else if (Integer.parseInt(empregado[i][4]) == 2) {
						metPagamento = "Cheque em mãos";
					} else if (Integer.parseInt(empregado[i][4]) == 3) {
						metPagamento = "Depósito em conta bancária";
					}
					
					if (Integer.parseInt(empregado[i][6]) == -1) {
						sindicato = "Não Pertence";
					} else {
						sindicato = empregado[i][6] + "		Taxa Sindical: R$ " + String.format("%.2f", Double.parseDouble(empregado[i][10]));
					}
									
					System.out.printf("Tipo: %s		%s\n", tipo, salario);
					System.out.println("--------------------------------------------------------------------------");
					System.out.printf("Agenda de pagamento: %s\n", empregado[i][12]);
					System.out.println("--------------------------------------------------------------------------");
					System.out.printf("Método de pagamento: %s\n", metPagamento);
					System.out.println("--------------------------------------------------------------------------");
					System.out.printf("Número do sindicato: %s\n", sindicato);
					System.out.println("==================================================================================\n");
				} 
			}
		}
	}
	
	public static void contracheque (int i) {
			String tipo = "";
			String metPagamento = "";
			String sindicato = "";
			String salario = "";		
			
			System.out.println("===============================CONTRACHEQUE=======================================");
			System.out.printf("Número do empregado: %s		Nome: %s\n", empregado[i][0], empregado[i][1]);
			System.out.println("--------------------------------------------------------------------------");
			System.out.printf("Endereço: %s\n", empregado[i][2]);
			System.out.println("--------------------------------------------------------------------------");
			
			if (Integer.parseInt(empregado[i][3]) == 1) {
				tipo = "Horista";
				salario = "Salário Hora: R$ " + String.format("%.2f", Double.parseDouble(empregado[i][8]));
			} else if (Integer.parseInt(empregado[i][3]) == 2){
				tipo = "Assalariado";
				salario = "Salário Bruto: R$ " + String.format("%.2f", Double.parseDouble(empregado[i][7]));
			} else if (Integer.parseInt(empregado[i][3]) == 3) {
				tipo = "Comissionado";
				salario = "Salário Bruto: R$ " + String.format("%.2f", Double.parseDouble(empregado[i][7])) + "	Comissão: " + Double.parseDouble(empregado[i][9]) + " %";
			}
			
			if (Integer.parseInt(empregado[i][4]) == 1) {
				metPagamento = "Cheque pelos correios";
			} else if (Integer.parseInt(empregado[i][4]) == 2) {
				metPagamento = "Cheque em mãos";
			} else if (Integer.parseInt(empregado[i][4]) == 3) {
				metPagamento = "Depósito em conta bancária";
			}
			
			if (Integer.parseInt(empregado[i][6]) == -1) {
				sindicato = "Não Pertence";
			} else {
				sindicato = empregado[i][6] + "		Taxa Sindical: R$ " + String.format("%.2f", Double.parseDouble(empregado[i][10]));
				empregado[i][15] = Double.toString((Double.parseDouble(empregado[i][15]) - Double.parseDouble(empregado[i][10])));
			}
							
			System.out.printf("Tipo: %s		%s\n", tipo, salario);
			System.out.println("--------------------------------------------------------------------------");
			System.out.printf("Agenda de pagamento: %s\n", empregado[i][12]);
			System.out.println("--------------------------------------------------------------------------");
			System.out.printf("Método de pagamento: %s\n", metPagamento);
			System.out.println("--------------------------------------------------------------------------");
			System.out.printf("Número do sindicato: %s\n", sindicato);
			System.out.println("\n__________________________________________________________________________");
			System.out.printf("\nSalário Liquido: R$ %s\n", String.format("%.2f", Double.parseDouble(empregado[i][15])));
			System.out.println("==================================================================================\n");
		
	}	
}
