import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PlanPostpago implements Plan{
	//propiedades plan
	private double tarifa=0.99;
		
	PlanPostpago(){	}
		
	public double calcularTarifaPorMinuto(int horaLlamada,String numeroLlamado) {
		return tarifa;
	}
	
	public void setTarifa(double tarifa) {
		this.tarifa=tarifa;
	}
	
	public LinkedList<String> getDatosPlan(){
		LinkedList<String> datosPlan = new LinkedList<String>();
		datosPlan.add("postpago");
		datosPlan.add(String.valueOf(tarifa));
		return datosPlan;
	}
}
