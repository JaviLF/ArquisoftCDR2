import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PlanPrepago implements Plan{
	//propiedades plan
	private double tarifaHorarioNormal=1.45;
	private double tarifaHorarioReducido=0.95;
	private double tarifaHorarioSuperReducido=0.70;
		
		
	PlanPrepago(){	}
		
	public double calcularTarifaPorMinuto(int horaLlamada,String numeroLlamado) {
		double tarifaSegunHora;
		if((horaLlamada<21)&&(horaLlamada>=7))
			tarifaSegunHora= tarifaHorarioNormal;
		else {
			if((horaLlamada<7)&&(horaLlamada>=1))
				tarifaSegunHora= tarifaHorarioSuperReducido;
			else
				tarifaSegunHora= tarifaHorarioReducido;
		}
		return tarifaSegunHora;
	}
	
	public void setTarifaHorarioNormal(double tarifaHorarioNormal) {
		this.tarifaHorarioNormal=tarifaHorarioNormal;
	}
	public void setTarifaHorarioReducido(double tarifaHorarioReducido) {
		this.tarifaHorarioReducido=tarifaHorarioReducido;
	}
	public void setTarifaHorarioSuperReducido(double tarifaHorarioSuperReducido) {
		this.tarifaHorarioSuperReducido=tarifaHorarioSuperReducido;
	}
	
	public LinkedList<String> getDatosPlan(){
		LinkedList<String> datosPlan = new LinkedList<String>();
		datosPlan.add("prepago");
		datosPlan.add(String.valueOf(tarifaHorarioNormal));
		datosPlan.add(String.valueOf(tarifaHorarioReducido));
		datosPlan.add(String.valueOf(tarifaHorarioSuperReducido));
		return datosPlan;
	}
	
}
