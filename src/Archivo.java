import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
	
	public void cargarCDRs() {
		try {
			File f = new File("cdrs.txt");
			if(f.exists()) {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while((linea = br.readLine()) != null) {
					String [] contacto = linea.split("%");
					CDR cdr = new CDR();
					
					cdr.setNumeroLlamante(contacto[0]);
					cdr.setNumeroLlamado(contacto[1]);
					cdr.setHoraLlamada(Integer.parseInt(contacto[2]));
					cdr.setDuracionLlamada(Float.parseFloat(contacto[3]));
					
					System.out.println(cdr.getNumeroLlamante());
					System.out.println(cdr.getNumeroLlamado());
					System.out.println(cdr.getHoraLlamada());
					System.out.println(cdr.getDuracionLlamada());
					System.out.println("******************");
				}
				br.close();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
