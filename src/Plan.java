import java.util.LinkedList;
import java.util.List;

public interface Plan {
	public double calcularTarifaPorMinuto(int horaLlamada,String numeroLlamado);
	public LinkedList<String> getDatosPlan();
}
