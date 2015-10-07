/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**FUENTES:
 * Parte de mi codigo se basa en el codigo de la pagina siguiente
 * https://kenai.com/projects/enemigos1/sources/subversion/content/Enemigos/src/enemigos/ArbolAVL.java?rev=2
 * 
 * @author Julian Herrera Gomez
 */
public class ProyectoED1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Arbol arbolitoAVL=new Arbol();
        arbolitoAVL.insertar(10);
        arbolitoAVL.insertar(5);
        arbolitoAVL.insertar(13);
        arbolitoAVL.insertar(1);
        arbolitoAVL.insertar(6);
        arbolitoAVL.insertar(17);
        arbolitoAVL.insertar(16);
        arbolitoAVL.preOrden(arbolitoAVL.obtenerRaiz());
    }
    
}
