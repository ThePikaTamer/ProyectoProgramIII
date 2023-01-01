package Logger;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;

public class Main_Log {
	static Logger log;
/*
 * Vale lo que tengo pensado con el logger para utilizarlo que al entrar al juego es decir al abrir la primera ventana
 * que salga un mensaje por pantalla diciendo algo como "Entrada al juego" con una fecha/hora y que al salir tambien
 * salga un mensaje de "Salida del juego" con la fecha) hora
 */
		public static void main(String[] args) {
			try {
				log = Logger.getAnonymousLogger( "prueba-logger");
			}catch (Exception e) {
				{
					log.log(Level.INFO, "Inicio EdicionSprites" + (new Date()) );
					try {
						UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
						}catch (Exception e1) {}
					VentanaEdicionSprites v = new VentanaEdicionSprites();					
					}
				}
			}
}
