
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
	
}
