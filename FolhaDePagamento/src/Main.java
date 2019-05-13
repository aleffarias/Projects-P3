import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		int contador = 0, key = -1;
		Scanner input = new Scanner(System.in);
		
		ArrayList<Empregado> listaEmpregados = new ArrayList<Empregado>();
		
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
				Empregado perfil; 
				perfil = new Empregado();
				
				perfil.codigo = contador;
				
				System.out.println("Digite o nome do empregado:");
				perfil.nome = input.nextLine();
		
				System.out.println("Digite o endereço do empregado:");
				perfil.endereco = input.nextLine();
				
				System.out.println("\n(1) Horista\n(2) - Assalariado\n(3) - Comissionado");
				perfil.tipo = input.nextInt();
				
				// Add atributos associados 
				
				System.out.println("\nMétodo de pagamento:\n(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito em conta bancária");
				perfil.metodoPagamento = input.nextInt();
				
				System.out.println("\nPertence ao sindicato?\n(1) - Sim\n(2) - Não");
				perfil.sindicato = input.nextInt();
				
				
				listaEmpregados.add(perfil);
				contador++;
				break;
				}
			}
			System.out.println(listaEmpregados.get(0).nome);
			input.close();
	}
}

