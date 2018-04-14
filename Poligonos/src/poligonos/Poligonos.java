/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligonos;

import modelo.linea;
import modelo.punto;

/**
 *
 * @author cavr0
 */
public class Poligonos {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        punto p1 = new punto(7,3);
        linea l1 = new linea(2,2,3,7);
        linea l2 = new linea (0,4,5,6);
        System.out.println(l2);
        
        System.out.println(l2.orientacion(p1));; //colineal (extemsión de la recta), sentido de reloj
        System.out.println("Intersección "+l1.Interseccion(l2));
    }
    
}
//lcase linea que verifique que las lineas no se crecun
//poligono
//que no se intersectan
