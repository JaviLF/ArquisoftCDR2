import java.util.ArrayList;
import java.util.LinkedList;
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
	
	public void addNumeroAmigo(String numero) {
		if(this.numerosAmigos.size()<3)
			this.numerosAmigos.add(numero);
	}
	public void setTarifa(double tarifa) {
		this.tarifa=tarifa;
	}
	
	public LinkedList<String> getDatosPlan(){
		LinkedList<String> datosPlan = new LinkedList<String>();
		datosPlan.add("wow");
		datosPlan.add(String.valueOf(tarifa));
		datosPlan.add(String.valueOf(numerosAmigos.size()));
		for(int i=0;i<numerosAmigos.size();i++) {
			datosPlan.add(numerosAmigos.get(i));
		}
		return datosPlan;
	}
}
