import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Archivo {
	
	public void guardarCDR(CDR cdr) {
		try {
			File f = new File("cdrs.txt");
			FileWriter fw;
			BufferedWriter bw;
			if(f.exists()){
				fw = new FileWriter(f,true);
				bw = new BufferedWriter(fw);
				bw.newLine();
				bw.write(cdr.getNumeroLlamante() + "%" + cdr.getNumeroLlamado() + "%" + cdr.getHoraLlamada() + "%" + cdr.getDuracionLlamada());
			}else {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				bw.write(cdr.getNumeroLlamante() + "%" + cdr.getNumeroLlamado() + "%" + cdr.getHoraLlamada() + "%" + cdr.getDuracionLlamada());
			}
			bw.close();
			fw.close(); 
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
