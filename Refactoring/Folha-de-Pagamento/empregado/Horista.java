package empregado;

import java.util.ArrayList;

import sistema.TratamentoExc;

public class Horista extends Empregado {
	
	public Horista(int numeroEmpregado, String nome, String endereco, int metodoPagamento, 
					int isSindicato, int tipo, String tipoAgenda, int diaSemana) {
		super(numeroEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo, tipoAgenda, diaSemana);
	}
	
	private double salarioHoristaLiq = 0;
	private double salarioHorista = 0;
	private double salarioHora = 0;
	
	// TEMPLATE METHOD
	@Override
	public void entradaSalario() {
		System.out.print("\nInforme o salário por hora trabalhada:\nExemplo: 1,5 - 3\nR$ ");
		double salarioTemp = TratamentoExc.lerDouble();

		this.salarioHora = salarioTemp;
		
	}
	
	@Override
	public void pagarEmpregado(ArrayList<Empregado> empregado, int index) {
		this.salarioHoristaLiq = salarioHorista - getSindicato().getTaxaSindicall() 
									- getSindicato().getValorTaxaServico();
		System.out.println(empregado.get(index).toString() + "\n");
		
		this.salarioHoristaLiq = 0;
		this.salarioHorista = 0;
	}
	
	
	//======================================= Get/Set =================================================

	
	public double getSalarioHoristaLiq() {
		return salarioHoristaLiq;
	}

	public void setSalarioHoristaLiq(double salarioHoristaLiq) {
		this.salarioHoristaLiq = salarioHoristaLiq;
	}

	public double getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(double salarioHora) {
		this.salarioHora = salarioHora;
	}

	public void setSalarioHorista(double salarioHorista) {
		this.salarioHorista = salarioHorista;
	}

	public double getSalarioHorista() {
		return salarioHorista;
	}
	
	@Override
	public String toString() {
		String string, diaString = null;
		
		string = super.toString();
		
		string += "Tipo: Horista		Salário Hora: R$ " + this.salarioHora;
		string += "\n--------------------------------------------------------------------------------------------------------\n";
		
		if (getDiaFrequencia() == 1) diaString = "Segunda";
		else if (getDiaFrequencia() == 2) diaString = "Terça";
		else if (getDiaFrequencia() == 3) diaString = "Quarta";
		else if (getDiaFrequencia() == 4) diaString = "Quinta";
		else if (getDiaFrequencia() == 5) diaString = "Sexta";
		else if (getDiaFrequencia() == 6) diaString = "Sábado";
		else if (getDiaFrequencia() == 7) diaString = "Domingo";
		
		string += "Agenda de Pagamento: " + this.getTipoAgenda() + "	Dia da semana: " + diaString;
		string += "\n________________________________________________________________________________________________________\n";
		
		if (getIsSindicato() == 1) {
			string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicato().getTaxaSindicall();
			string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicato().getValorTaxaServico();
		}
		
		string += "\nSalário  Bruto Acumulado -------------------------------------------------- (+) R$ " + this.salarioHorista;
		string += "\n\nSalário Líquido --------------------------------------------------------------- R$ " + this.salarioHoristaLiq;
		
		return string;
	}

}
