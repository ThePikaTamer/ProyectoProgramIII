package graficos;


import java.awt.image.BufferedImage;

public class Assets {
	//NAVES
	public static BufferedImage naveBasica;
	public static BufferedImage naveBasica_P1;
	public static BufferedImage naveBasica_P2;

	public static BufferedImage naveDRapido;
	public static BufferedImage naveDRapido_P1;
	public static BufferedImage naveDRapido_P2;

	public static BufferedImage naveVeloz;
	public static BufferedImage naveVeloz_P1;
	public static BufferedImage naveVeloz_P2;


	public static BufferedImage naveTanque;
	public static BufferedImage naveTanque_P1;
	public static BufferedImage naveTanque_P2;
	
	public static BufferedImage disparo;
	//
	//ENEMIGOS
	public static BufferedImage enemigoBasico;
	public static BufferedImage enemigoBasico1;
	public static BufferedImage enemigoReforzado;
	public static BufferedImage enemigoReforzado1;
	public static BufferedImage enemigoVeloz;
	public static BufferedImage enemigoVeloz1;
	//
	//ASTEROIDE
	public static BufferedImage asteroideBasico;
	public static BufferedImage asteroideBasico1;
	public static BufferedImage asteroideBasico2;
	public static BufferedImage asteroideDorado;

	
	
	
	//POWER UP
	
	public static BufferedImage PowerUpHabilidad;
	public static BufferedImage PowerUpHp;

	

	//
	
	//FONDO
	public static BufferedImage fondoPrueba;
	//
	public static void init() {
		naveBasica = Loader.ImagenLoader("/naves/Nave1.png");
		naveBasica_P1 = Loader.ImagenLoader("/naves/Nave1_P1.png");
		naveBasica_P2 = Loader.ImagenLoader("/naves/Nave1_P2.png");
		
		naveDRapido = Loader.ImagenLoader("/naves/Nave2.png");
		naveDRapido_P1 = Loader.ImagenLoader("/naves/Nave2_P1.png");
		naveDRapido_P2 = Loader.ImagenLoader("/naves/Nave2_P2.png");

		naveVeloz = Loader.ImagenLoader("/naves/Nave3.png");
		naveVeloz_P1 = Loader.ImagenLoader("/naves/Nave3_P1.png");
		naveVeloz_P2 = Loader.ImagenLoader("/naves/Nave3_P2.png");

		naveTanque = Loader.ImagenLoader("/naves/Nave4.png");
		naveTanque_P1 = Loader.ImagenLoader("/naves/Nave4_P1.png");
		naveTanque_P2 = Loader.ImagenLoader("/naves/Nave4_P2.png");
		
		
		disparo = Loader.ImagenLoader("/naves/Bullet.png");
		
		
		enemigoBasico = Loader.ImagenLoader("/enemigos/Enemy_1.png");
		enemigoBasico1 = Loader.ImagenLoader("/enemigos/Enemy_1_1.png");
		enemigoVeloz = Loader.ImagenLoader("/enemigos/Enemy_2.png");
		enemigoVeloz1 = Loader.ImagenLoader("/enemigos/Enemy_2_1.png");
		enemigoReforzado = Loader.ImagenLoader("/enemigos/Enemy_3.png");
		enemigoReforzado1 = Loader.ImagenLoader("/enemigos/Enemy_3_1.png");
		
		
		asteroideBasico = Loader.ImagenLoader("/asteroides/asteroid_1.png");
		asteroideBasico1 = Loader.ImagenLoader("/asteroides/asteroid_2.png");
		asteroideBasico2 = Loader.ImagenLoader("/asteroides/asteroid_3.png");
		asteroideDorado = Loader.ImagenLoader("/asteroides/Asteroid_golden.png");
		
		
		PowerUpHabilidad = Loader.ImagenLoader("/powerUp/PowerUp_1.png");
		PowerUpHp = Loader.ImagenLoader("/powerUp/PowerUp_2.png");
	
		
		
		
		
		
		
		fondoPrueba = Loader.ImagenLoader("/fondoEspacio.png");
	}
}
