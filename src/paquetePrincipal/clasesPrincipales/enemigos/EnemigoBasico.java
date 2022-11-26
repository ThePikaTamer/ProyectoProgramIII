package paquetePrincipal.clasesPrincipales.enemigos;

import java.util.ArrayList;

public class EnemigoBasico extends Enemigo{

	
	protected static String IMG = "img\\Enemy_1.png";
	
	
	public EnemigoBasico() {
		super(2, 1, 2, 2, 50,IMG );
		this.setCicloAnimacion(new ArrayList<>());
		this.getCicloAnimacion().add(IMG);
		this.getCicloAnimacion().add("img\\Enemy_1_1.png");

	}



	
	
}
