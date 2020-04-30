import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class CDRTest {

	@Test
	public void testForEmptyCreator() {
		 CDR llamada1 = new CDR();
		 Assert.assertEquals("0000",llamada1.getNumeroLlamante());
		 Assert.assertEquals("1111",llamada1.getNumeroLlamado());
		 Assert.assertEquals(0,llamada1.getHoraLlamada());
		 Assert.assertEquals(0.0,llamada1.getDuracionLlamada());
	}
	@Test
	public void testForCreator() {
		 CDR llamada1 = new CDR("12345678","0000",21,4.2);
		 Assert.assertEquals("12345678",llamada1.getNumeroLlamante());
		 Assert.assertEquals("0000",llamada1.getNumeroLlamado());
		 Assert.assertEquals(21,llamada1.getHoraLlamada());
		 Assert.assertEquals(4.2,llamada1.getDuracionLlamada());
	}
	@Test
	public void testForSetAndGetNumeros() {
		 CDR llamada1 = new CDR();
		 String numeroDeHenry="12345678";
		 String numeroDeSergio="0000";
		 llamada1.setNumeroLlamante(numeroDeHenry);
		 llamada1.setNumeroLlamado(numeroDeSergio);
		 Assert.assertEquals("12345678",llamada1.getNumeroLlamante());
		 Assert.assertEquals("0000",llamada1.getNumeroLlamado());
	}
	@Test
	public void testForSetAndGetHoraLlamada() {
		CDR llamada1 = new CDR();
		llamada1.setHoraLlamada(16);
		Assert.assertEquals(16,llamada1.getHoraLlamada());  
	}
	@Test
	public void testForSetAndGetDuracionLlamada() {
		CDR llamada1 = new CDR();
		llamada1.setDuracionLlamada(4.53);
		Assert.assertEquals(4.53,llamada1.getDuracionLlamada());  
	}
	@Test
	public void testForCalculateTarifaPrepago() {
		Plan planDeJavier = new PlanPrepago();
		Linea lineaDeJavier=new Linea("prepago","1111","Javier Loayza",planDeJavier);
		CDR llamada1 = new CDR("1111","0000",5,2.5);
		Assert.assertEquals(1.75,llamada1.calcularTarifaParaLinea(lineaDeJavier));
		llamada1.setHoraLlamada(8);
		Assert.assertEquals(3.625,llamada1.calcularTarifaParaLinea(lineaDeJavier));
		llamada1.setHoraLlamada(22);
		Assert.assertEquals(2.375,llamada1.calcularTarifaParaLinea(lineaDeJavier));
	}
	@Test
	public void testForCalculateTarifaPostpago() {
		Plan planDeHenry = new PlanPostpago();
		Linea lineaDeHenry=new Linea("postpago","1111","Henry Torrico",planDeHenry);
		CDR llamada1 = new CDR("1111","0000",22,2.5);
		Assert.assertEquals(2.475,llamada1.calcularTarifaParaLinea(lineaDeHenry));
	}
	@Test
	public void testForCalculateTarifaWow() {
		List<String> numerosAmigos = new ArrayList<String>();
		numerosAmigos.add("0000");
		Plan planDeSergio = new PlanWow(numerosAmigos);
		Linea lineaDeSergio=new Linea("wow","1111","Sergio Rivera",planDeSergio);
		CDR llamada1 = new CDR("1111","0000",22,2.5);
		Assert.assertEquals(0.0,llamada1.calcularTarifaParaLinea(lineaDeSergio));
		llamada1.setNumeroLlamado("3333");
		Assert.assertEquals(2.475,llamada1.calcularTarifaParaLinea(lineaDeSergio));
	}


}
