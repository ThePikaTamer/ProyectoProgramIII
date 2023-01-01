package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {

	public static BufferedImage ImagenLoader(String ruta) {

		try {
			return ImageIO.read(Loader.class.getResource(ruta));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}