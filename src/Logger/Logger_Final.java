package Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Logger_Final {
	
	public static void Logger_Final2() {

	// Creamos el Logger de Salida
    Logger loggerSalida
    = Logger.getLogger(
        Main_Log.class.getName());

// log messages using log(Level level, String msg)
    loggerSalida.log(Level.INFO, "Salida del juego");
}
}

