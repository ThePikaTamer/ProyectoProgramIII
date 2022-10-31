package paquetePrincipal;

import java.util.ArrayList;

public abstract class Objeto implements Animable
{
	protected static String image;
	protected double velX;
	protected double velY;
	protected double posX;
	protected double posY;
	protected ArrayList<String> cicloAnimacion= new ArrayList<>();
	
	
	
	
	
	
	@Override
	public void setDibujoInicial() {
		if (this.cicloAnimacion.size() != 0) {
			this.image = this.cicloAnimacion.get(0);
		}else {
			System.err.println("El array está vacio");
		}

	}

	@Override
	public void siguienteDibujo() {
		String dibujoActual = this.image;
		if (this.cicloAnimacion.indexOf(dibujoActual) == (this.cicloAnimacion.size() - 1)) {
			this.setDibujoInicial();
		}else {
			this.image = this.cicloAnimacion.get(this.cicloAnimacion.indexOf(dibujoActual)+1);
		}
		
	}
}
