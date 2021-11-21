import java.util.Scanner;
public class Juego {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("¿Cual es tu nombre?");
		String nombre = scan.next();
		empezarPartida(nombre, scan);
		
		scan.close();
	}
	
	public static void empezarPartida(String nombre, Scanner scan) {
		Conexion conexion = new Conexion();
		long empieza_partida = System.currentTimeMillis() / 1000;
		long tiempo_partida = 0;
		Mapas mapa = new Mapas();
		Jugador jugador = new Jugador(nombre);
		Movimiento mover = new Movimiento();
		int posY = 0;
		int posX = 0;
		char posYChar = ' ';
		char posXChar = ' ';
		
		while(mover.ganaste != true) {
			mapa.mostrarMapa();
			
			System.out.println("MovimientoY: ");
			posYChar = Character.toUpperCase(scan.next().charAt(0));
			
			System.out.println("MovimientoX: ");
			posXChar = Character.toUpperCase(scan.next().charAt(0));
			
			
			for (int i = 0; i < mapa.comparacion.length; i++) {
				if(mapa.comparacion[i] == posYChar) {
					posY = i;
				}
				if(mapa.comparacion[i] == posXChar) {
					posX = i;
				}
			}
			
			mover.comprobarMovimiento(jugador.posY, posY, jugador.posX, posX);
			if(mover.movimiento_correcto == true) {
				mapa.laberinto_parte_uno[jugador.posY][jugador.posX] = " ";
				mapa.laberinto_parte_uno[posY][posX] = "X";
				jugador.posY = posY;
				jugador.posX = posX;
			}
			tiempo_partida = (System.currentTimeMillis() / 1000) - empieza_partida;
		}
		mapa.mostrarMapa();


		String query = "INSERT INTO partidas (nombre, tiempo) values ('" + jugador.nombre_jugador + "', " + tiempo_partida + ")";

		conexion.insertarDatos(query);
		
		conexion.closeConn();
	}

}
