
public class Movimiento {

	boolean ganaste = false;
	boolean movimiento_correcto = false;

	public void comprobarMovimiento(int posYOrigen, int posY, int posXOrigen, int posX) {
		Mapas mapa = new Mapas();
		if(((posYOrigen + 1) == posY || (posYOrigen - 1) == posY || posYOrigen == posY 
				&& (posXOrigen + 1) == posX || (posXOrigen - 1) == posX || posXOrigen == posX)
				&& mapa.laberinto_parte_uno[posY][posX] == " ") {
			System.out.println(mapa.laberinto_parte_uno[posY][posX]);
			movimiento_correcto = true;
			if(posY == 20 && posX == 14) {
				ganaste = true;
			}
		}else {
			System.out.println("No ha sido un buen movimiento");
			movimiento_correcto = false;
		}
	}
}