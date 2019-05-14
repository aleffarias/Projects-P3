import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int key = -1, indice;
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
			//input.nextLine();
			
			switch (key) {
			case 1:
				Empregado.adicionar();
				break;
			
			case 2:
				Empregado.remover();
				break;
				
			case 3:
				// Lista de empregados
				System.out.println("Digite o código do empregado:");
				indice = input.nextInt();
				
				Empregado.listaEmpregados.add(indice, element);
				break;
			}
		
			input.close();
		}
	}
}