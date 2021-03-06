package sistema;

import java.util.ArrayList;
import empregado.Empregado;

public class BancoDadosSingleton {
	
	private static BancoDadosSingleton uniqueInstance;
	private BancoDadosSingleton() {	}
	
	private ArrayList<Empregado> listaEmpregados = new ArrayList<Empregado>();
	
	public static synchronized BancoDadosSingleton getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new BancoDadosSingleton();
		
		return uniqueInstance;
	}
	
	public int searchEmpregado(){
		int i;
		
		System.out.println("Digite o número do Empregado:");
		int nEmpregado = TratamentoExc.lerInt();
		
		if (listaEmpregados.isEmpty()) {
			System.out.println("\nErro: Não há empregados cadastrados.\n");
			return -1;
		}
		
		for (i=0; i < listaEmpregados.size(); i++) {
			if (listaEmpregados.get(i).getNumeroEmpregado() == nEmpregado) {
				break;	
			}
		}
		
		return i;
	}
	
	
	public void removeEmpregado() {
		System.out.println("\n\t**  	REMOVER FUNCIONÁRIO  	**\n");
		
		int index = searchEmpregado();
		if (index == -1) return;
		
		System.out.println("\nRemovendo empregado...");
		
		try {
			listaEmpregados.remove(index);
			System.out.println("\nEmpregado removido com sucesso!\n");
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\nErro: Empregado não existe.\n");
		} 
	}
	
	//======================================= Get/Set =================================================
	
	public ArrayList<Empregado> getListaEmpregados() {
		return listaEmpregados;
	}

	public void setListaEmpregados(Empregado empregado) {
		this.listaEmpregados.add(empregado);
	}
	
}
