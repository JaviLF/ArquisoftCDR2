import java.util.Scanner;

public class testeador {
	
	public static void verTablaCDRs() {
		System.out.println("Mostrando Tabla CDR");
	}
	
	public static void menu() {
		int option = 0;
		Scanner capt = new Scanner(System.in);
		do {
			
			System.out.println("Menu");
			System.out.println("FULL SQL");
			System.out.println("1 Ver tabla CDRS");
			System.out.println("25 Salir");
			System.out.println("Opcion: ");
			option = capt.nextInt();
			
			switch(option) {
			  case 1:
			    verTablaCDRs();
			    break;
			  case 25:
			    System.out.println("Saliendo");
			    break;
			  default:
			    // code block
			}
		}while(option != 25);
		capt.close();
	}

	public static void main(String[] args) {
		menu();
	}

}
