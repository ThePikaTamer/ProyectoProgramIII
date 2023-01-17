package Logger;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Date;


public class Main_Log {

 
	 public static void main(String[] args)
	    {
		 try {
			Logger_Escritura_Fichero mylog = new Logger_Escritura_Fichero("./log.txt");
			mylog.addLine("Linea 1");
			mylog.addLine("Linea 2");
			mylog.addLine("Linea 3");
			mylog.addLine("Linea 4");
			mylog.addLine("Linea 5");
			
			String[] lines = mylog.getLines();
			
			for (int i = 0; i<10; i++) {
				System.out.println(lines[i]);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 Logger_Principio.Logger_Principio2();
		 Logger_Final.Logger_Final2();
		 
		 
		
	    }


	 }


			 
			

