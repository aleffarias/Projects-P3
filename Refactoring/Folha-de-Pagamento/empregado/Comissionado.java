package empregado;

import java.util.ArrayList;

import sistema.TratamentoExc;

public class Comissionado extends Empregado {
	
	public Comissionado(int numeroEmpregado, String nome, String endereco, int metodoPagamento, 
						int isSindicato, int tipo, String tipoAgenda, int diaSemana) {
		super(numeroEmpregado, nome, endereco, metodoPagamento, isSindicato, tipo, tipoAgenda, diaSemana);
	}
	
	
	private double salarioComissionadoFixo;
	private double salarioComissionadoLiq;
	private double valorComissao;
	private double comissao;
	
	// TEMPLATE METHOD
	@Override
	public void entradaSalario() {
		System.out.print("\nInforme o salário:\nExemplo: 1500 - 3000,56\nR$ ");
		double salarioTemp = TratamentoExc.lerDouble();

		System.out.println("\nInforme o percentual de comissão:\nExemplo: 15 para 15% 1.5 para 1.5%");
		this.comissao = TratamentoExc.lerDouble();
		
		this.salarioComissionadoFixo = salarioTemp;
		
	}
	
	@Override
	public void pagarEmpregado(ArrayList<Empregado> empregado, int index) {
		this.salarioComissionadoLiq = salarioComissionadoFixo + valorComissao - getSindicato().getTaxaSindicall() - getSindicato().getValorTaxaServico();
		System.out.println(empregado.get(index).toString() + "\n");
		
		this.salarioComissionadoLiq = 0;
		this.valorComissao = 0;
		
	}
	
	
	//======================================= Get/Set =================================================

	public double getSalarioComissionadoFixo() {
		return salarioComissionadoFixo;
	}

	public double getSalarioComissionadoCom() {
		return salarioComissionadoLiq;
	}

	public double getComissao() {
		return comissao;
	}
	
	public double getValorComissao() {
		return valorComissao;
	}

	public void setValorComissao(double valorComissao) {
		this.valorComissao = valorComissao;
	}

	@Override
	public String toString() {
		String string, diaString = null;
		
		string = super.toString();
		
		string += "Tipo: Comissionado		Salário Bruto: R$ " + this.salarioComissionadoFixo + "	Comissão: " + this.comissao + "%";
		string += "\n--------------------------------------------------------------------------------------------------------\n";
		
		if (getDiaFrequencia() == 1) diaString = "Segunda";
		else if (getDiaFrequencia() == 2) diaString = "Terça";
		else if (getDiaFrequencia() == 3) diaString = "Quarta";
		else if (getDiaFrequencia() == 4) diaString = "Quinta";
		else if (getDiaFrequencia() == 5) diaString = "Sexta";
		else if (getDiaFrequencia() == 6) diaString = "Sábado";
		else if (getDiaFrequencia() == 7) diaString = "Domingo";
		
		string += "Agenda de Pagamento: " + getTipoAgenda() + "	Dia da semana: " + diaString;
		string += "\n_________________________________________________________________________________________________________\n";
		
		if (getIsSindicato() == 1) {
			string += "Taxa Sindical ------------------------------------------------------------- (-) R$ " + getSindicato().getTaxaSindicall();
			string += "\nTotal de Serviços --------------------------------------------------------- (-) R$ " + getSindicato().getValorTaxaServico();
		}
		
		string += "\nComissão de vendas -------------------------------------------------------- (+) R$ " + this.valorComissao;
		string += "\n\nSalário Líquido  -------------------------------------------------------------- R$ " + this.salarioComissionadoLiq;
		
		return string;
	}
	
}
