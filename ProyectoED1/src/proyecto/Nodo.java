/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Julian Herrera Gomez
 */
public class Nodo {
    int dato;
    int FE;
    Nodo hijoIzquierdo;
    Nodo hijoDerecho;        
    public Nodo(int d){
        this.dato=d;
        this.FE=0;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }   
}
