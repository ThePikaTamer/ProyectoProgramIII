package paquetePrincipal;

public class Puntuacion implements Comparable {

	private int puntos;

	public Puntuacion() {
		puntos = 0;
	}

	public Puntuacion(int p) {
		puntos = p;
	}

	public int get() {
		return puntos;
	}

	public void inc(int incPuntos) {
		puntos += incPuntos;
	}

	public void reset() {
		puntos = 0;
	}

	@Override
	public int compareTo(Object p) {
		return ((Puntuacion) p).puntos - puntos;
	}
}
