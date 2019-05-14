import java.util.ArrayList;
import java.util.Scanner;

public class CartaoPonto {
	public int numeroFuncionario;
	public int horaEntrada;
	public int horaSaida;
	public int dia;
	public int mes;
	public int ano;
	
	public static Scanner input;
	static ArrayList<CartaoPonto> listaCartaoPonto = new ArrayList<CartaoPonto>();
	
	public static void lancarCartaoPonto() {
		
		input = new Scanner(System.in);
		CartaoPonto cartaoPonto = new CartaoPonto();
		
		System.out.println("Digite o número do Funcionário:");
		cartaoPonto.numeroFuncionario = input.nextInt(); // Númeor do funcionário não atualiza quando removido
		
		System.out.println("Hora de entrada:");	// Mudar formato de entrada para 12:00
		cartaoPonto.horaEntrada = input.nextInt();
		
		System.out.println("Hora de saida:");
		cartaoPonto.horaSaida = input.nextInt();
		
		System.out.println("Dia:");
		cartaoPonto.dia = input.nextInt();
		
		System.out.println("Mês:");
		cartaoPonto.mes = input.nextInt();
		
		System.out.println("Ano:");
		cartaoPonto.ano = input.nextInt();
		
		listaCartaoPonto.add(cartaoPonto);
	}
}
