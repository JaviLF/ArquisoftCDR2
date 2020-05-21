import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ArchivoTest {

	@Test
	void testForSavePlanes() {
		Plan planPre=new PlanPrepago();
		Plan planPost=new PlanPostpago();
		List<String> numerosAmigos = new ArrayList<String>();
		numerosAmigos.add("0000");
		numerosAmigos.add("1111");
		Plan planWow = new PlanWow(numerosAmigos);
		Almacenamiento archive = new AlmacenamientoArchivosTexto();
		archive.guardarPlan(planPre);
		archive.guardarPlan(planPost);
		archive.guardarPlan(planWow);
		List<Plan> planes = archive.cargarPlanes();
		Assert.assertEquals(false,planes.isEmpty());
		//Assert.assertEquals(planPre.getDatosPlan(),planes.get(1).getDatosPlan());
	}
	
	@Test
	void testForSaveCDRs() {
		Almacenamiento archivo = new AlmacenamientoArchivosTexto();
		CDR cdr = new CDR("1111","2222222",12,2.5);
		Plan planDeJavier = new PlanPrepago();
		Linea lineaDeJavier=new Linea("1111","Javier Loayza",planDeJavier);
		Assert.assertEquals(3.625,cdr.calcularTarifaParaLinea(lineaDeJavier));
		archivo.guardarCDR(cdr);
		
		CDR cdr2 = new CDR("1111","333333",12,2.5);
		Assert.assertEquals(3.625,cdr.calcularTarifaParaLinea(lineaDeJavier));
		archivo.guardarCDR(cdr2);
		
		List<CDR> CDRs = archivo.cargarCDRs();
		Assert.assertEquals(false,CDRs.isEmpty());
		
	}
}
