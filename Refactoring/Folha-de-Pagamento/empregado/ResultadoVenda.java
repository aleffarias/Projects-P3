package empregado;

import sistema.BancoDadosSingleton;
import sistema.TratamentoExc;

public class ResultadoVenda {
	
	private BancoDadosSingleton bancoDados = BancoDadosSingleton.getInstance();
	private Comissionado comissionado;
	
	public boolean verificaComissionado() {
		int index = bancoDados.searchEmpregado();
		if (index == -1) return false;
		
		if (bancoDados.getListaEmpregados().get(index) instanceof Comissionado) {
			comissionado = (Comissionado) bancoDados.getListaEmpregados().get(index);
			
			return true;
		}
		
		else return false;
	}
	
	public void lancarResultadoVenda() {
		
		if (verificaComissionado() == true) {
		
			System.out.println("\nDia da venda:");
			int diaVenda = TratamentoExc.lerInt();
			
			System.out.println("\nMês da venda:");
			int mesVenda = TratamentoExc.lerInt();
			
			System.out.println("\nAno da venda:");
			int anoVenda = TratamentoExc.lerInt();
			
			System.out.print("\nValor da venda:\nExemplo: 1500 - 3000.56\nR$ "); 
			double valorVenda = TratamentoExc.lerDouble();
			
			comissionado.setValorComissao((valorVenda * comissionado.getComissao())/100);
			
			System.out.println("\n===============================Registro de Venda=================================");
			System.out.println("Nome: " + comissionado.getNome() + "		Número do empregado: " + comissionado.getNumeroEmpregado());
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("Data da venda: " + diaVenda + "/ " + mesVenda + "/" + anoVenda + "		Valor da comissão: R$ " + ((valorVenda * comissionado.getComissao())/100));
			System.out.println("==================================================================================");
			
			System.out.println("\nResultado da venda registrado com sucesso!\n");
		
		} else {System.out.println("\nErro: Empregado não é comissionado.\n");}
	}
}
