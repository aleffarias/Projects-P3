package folhapagamento.empregado;

import java.util.Scanner;

public class Assalariado extends Empregado {
	
	Scanner input = new Scanner(System.in);
	
	// Construtor 
	public Assalariado(int numeroEmpregado, String nome, String endereco, int tipo, int metodoPagamento,
			int isSindicato) {
		super(numeroEmpregado, nome, endereco, tipo, metodoPagamento, isSindicato);
	}
	
	// Agenda Padrão
	private String agenda = "mensal";
	private int dia = 30;
	
	
	// Salário
	private double salarioAssalariadoFixo;
	private double salarioAssalariadoLiq;
	
	@Override
	public void salario() {
		System.out.print("\nInforme o salário fixo mensal:\nExemplo: 1500 - 3000.56\nR$ ");
		double salarioTemp = input.nextDouble();
		this.salarioAssalariadoFixo = salarioTemp;
		
	}
	
	//======================================= Get/Set =================================================
	
	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public double getSalarioAssalariadoFixo() {
		return salarioAssalariadoFixo;
	}

	public double getSalarioAssalariadoLiq() {
		return salarioAssalariadoLiq;
	}

	public String toString() {
		String string;
		
		string = super.toString();
		
		string += "Tipo: Horista		Agenda de Pagamento: " + agenda;
		string += "\n--------------------------------------------------------------------------------------------------------\n";
		string += "Salário Bruto: R$ " + salarioAssalariadoFixo;
		string += "\n__________________________________________________________________________\n";
		string += "Salário Líquido: R$ " + salarioAssalariadoLiq;
		
		return string;
	}

}
