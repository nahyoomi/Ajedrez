import java.awt.*;
import java.io.*;
import java.util.*;

public class Juego {
    public static void main(String[] args) {
        // Crear dos objetos Posicion
        Posicion PrimeraPosicion = new Posicion();
        // Crear dos objetos Pieza
        Pieza pieza1 = new Pieza("blanco",  PrimeraPosicion , false);
        Pieza pieza2 = new Pieza("negro",  PrimeraPosicion, false);

        // Crear dos objetos tablero
        Tablero tablero = new Tablero(8);

        // Colocar piezas en el tablero
        tablero.colocarPieza(pieza1, 1, 1);
        tablero.colocarPieza(pieza2, 7, 6);

        // Mostrar el tablero
        System.out.println(tablero.toString());

        // Mover una pieza
        tablero.moverPieza(1, 1, 3, 1);
        System.out.println(tablero.toString());

        // Eliminar una pieza
        tablero.eliminarPieza(7, 6);
        System.out.println(tablero.toString());

        // Obtener una pieza
        Pieza piezaObtenida = tablero.obtenerPieza(3, 1);
        if (piezaObtenida != null) {
            System.out.println("La pieza en la posición 3,1 es: " + piezaObtenida.toString());
        } else {
            System.out.println("No hay pieza en la posición 3,1");
        }



    }


    //Clase Pieza Ej1.

    public static class Pieza {
        private String color;
        private Posicion posicion;
        private boolean capturada;

        //construtor
        public Pieza(String color, Posicion posicion, boolean capturada) {
            this.color = color;
            this.posicion = posicion;
            this.capturada = capturada;
        }

        //metodos get y set
        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Posicion getPosicion() {
            return posicion;
        }

        public void setPosicion(Posicion posicion) {
            this.posicion = posicion;
        }

        public boolean isCapturada() {
            return capturada;
        }

        public void setCapturada(boolean capturada) {
            this.capturada = capturada;
        }

        //metodo tostring
        @Override
        public String toString() {
            return "Pieza {color=" + color + ", posición=" + posicion + ", capturada=" + capturada + "}";
        }
    }

    //Clase Posicion Ej2.

    public static class Posicion {
        private int fila;
        private int columna;

        //Constructores
        public Posicion() {
            this.fila = 1;
            this.columna = 1;
        }

        public Posicion(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }

        //metodos get y set
        public int getFila() {
            return fila;
        }

        public void setFila(int fila) {
            this.fila = fila;
        }

        public int getColumna() {
            return columna;
        }

        public void setColumna(int columna) {
            this.columna = columna;
        }

        //metodo tostring
        @Override
        public String toString() {
            return "Posición {fila=" + fila + ", columna=" + columna + "}";
        }
    }

    // Clase Tablero Ej3.
    public static class Tablero {
        private Pieza[][] piezas;
        private int tamaño;
        private static final int MAX_TAMAÑO = 8;


        //constructores
        public Tablero(int tamaño) {
            this.tamaño = tamaño;
            this.piezas = new Pieza[tamaño][tamaño];
        }

        //metodo tostring imprimir tablero
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tamaño; i++) {
                for (int j = 0; j < tamaño; j++) {
                    if (piezas[i][j] == null) {
                        sb.append("[ ]");
                    } else {
                        sb.append(piezas[i][j].toString());
                    }
                    sb.append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }

        //funcionalidades
        public void colocarPieza(Pieza pieza, int fila, int columna) {
            piezas[fila][columna] = pieza;
            pieza.setPosicion(new Posicion(fila, columna));
        }

        public void moverPieza(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
            Pieza pieza = piezas[filaOrigen][columnaOrigen];
            piezas[filaOrigen][columnaOrigen] = null;
            piezas[filaDestino][columnaDestino] = pieza;
            pieza.setPosicion(new Posicion(filaDestino, columnaDestino));
        }

        public void eliminarPieza(int fila, int columna) {
            piezas[fila][columna] = null;
        }

        public Pieza obtenerPieza(int fila, int columna) {
            return piezas[fila][columna];
        }
    }

}
