import java.util.ArrayList;
import java.util.List;

public class PlanWow implements Plan{
	//propiedades plan
	private double tarifa=0.99;
	List<String> numerosAmigos = new ArrayList<String>();
		
	PlanWow(){ }
		
	PlanWow(List<String> numerosAmigos){
		this.numerosAmigos=numerosAmigos;
	}
		
	public double calcularTarifaPorMinuto(int horaLlamada,String numeroLlamado) {
		double tarifaSegunNumero;
		if(esNumeroAmigo(numeroLlamado))
			tarifaSegunNumero=0.0;
		else
			tarifaSegunNumero=tarifa;
		return tarifaSegunNumero;
	}
		
	public boolean esNumeroAmigo(String numero){
		return (numerosAmigos.contains(numero));
	}
	
}
