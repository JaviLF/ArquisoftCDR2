import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class SQLTest {

	@Test
	void test() {
		Almacenamiento alm=new AlmacenamientoSQL();
		CDR cdr = new CDR("1111","2222222",12,2.5);
		Plan planDeJavier = new PlanPrepago();
		Linea lineaDeJavier=new Linea("1111","Javier Loayza",planDeJavier);
		Assert.assertEquals(3.625,cdr.calcularTarifaParaLinea(lineaDeJavier));
		//alm.guardarCDR(cdr);
		alm.cargarCDRs();
	}
	
}
