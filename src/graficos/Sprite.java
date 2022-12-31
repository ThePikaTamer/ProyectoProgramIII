package graficos;

public class Sprite {
	private final int lado;

	private int x;
	private int y;

	public int[] pixeles;
	private final HojaSprites hoja;
	
	
	//Todos los Sprites
	public static Sprite espada = new Sprite(32, 0, 0, HojaSprites.primera);
	//Fin
	
	public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja) {
		this.lado = lado;
		this.pixeles = new int[this.lado * this.lado];
		this.x = columna * this.lado;
		this.y = fila * this.lado;
		this.hoja = hoja;
		for (int yi = 0; yi < lado; yi++) {
			for(int xi = 0; xi < lado ; xi++) {
				pixeles[(x + y) * lado] = hoja.pixeles[((xi+this.x) + (yi + this.y)) *hoja.getAncho()];
			}
		}
	}






}
