package graficos;

import java.awt.image.BufferedImage;

public class Assets {
	//NAVES
	public static BufferedImage naveBasica;
	//
	//ENEMIGOS
	public static BufferedImage enemigoBasico;
	public static BufferedImage enemigoReforzado;
	public static BufferedImage enemigoVeloz;
	//
	public static void init() {
		naveBasica = Loader.ImagenLoader("/naves/player.png");
		enemigoBasico = Loader.ImagenLoader("/enemigos/Enemy_1.png");
		enemigoReforzado = Loader.ImagenLoader("/enemigos/Enemy_2.png");
//		enemigoVeloz = Loader.ImagenLoader("/enemigos/Enemy_3.png");
		
	}
}
