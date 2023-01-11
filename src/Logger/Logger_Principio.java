package Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Logger_Principio {
	

	public static void Logger_Principio2(){
    
	// Creamos el Logger de Entrada
    Logger loggerEntrada
        = Logger.getLogger(
            Logger_Principio.class.getName());

    // log messages using log(Level level, String msg)
    loggerEntrada.log(Level.INFO, "Entrada al juego");
	// TODO Auto-generated method stub
	

}
}

