package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprites {
	private final int ancho;
	private final int alto;
	public final int[] pixeles;
	
	//Todas las hojas de Sprites
	public static HojaSprites primera = new  HojaSprites("/imagenes/primero.png", 320,320);
	
	//fin

	public HojaSprites(final String ruta, final int ancho, final int alto) {
		this.alto = alto;
		this.ancho = ancho;
		this.pixeles = new int[ancho * alto];

		try {
			BufferedImage imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			System.err.println("Error con Sprites");
			e.printStackTrace();
		}

	}
	public int getAncho() {
		return this.getAncho();
	}

}
