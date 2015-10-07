/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Julian Herrera Gomez
 * 
 * Esta clase define el las operaciones del arbol. Hasta el momento tiene definidas buscar e insertar. Hace falta eliminar
 */
public class Arbol {
    private Nodo raiz;
    public Arbol(){
        raiz=null;
    }
    public Nodo obtenerRaiz(){
        return raiz;
    }
    //Metodo para buscar un nodo.
    public Nodo buscar(int d, Nodo r){
        if(raiz==null){
            return null;
        }else if(r.dato==d){
            return r;
        }else if(r.dato <d){
            return buscar(d, r.hijoDerecho);
        }else{
            return buscar(d, r.hijoIzquierdo);
        }
    }
    //Obtener el Factor de Equilibrio
    public int obtenerFE(Nodo x){
        if(x==null){
            return -1;
        }else{
            return x.FE;
        }
    }
    //Rotacion simple a la izquierda
    public Nodo rotacionIzquierda(Nodo c){
        Nodo auxiliar=c.hijoIzquierdo;
        c.hijoIzquierdo= auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=c;
        c.FE=Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        auxiliar.FE=Math.max(obtenerFE(auxiliar.hijoIzquierdo),obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }
    //Rotacion simple a la derecha
    public Nodo rotacionDerecha(Nodo c){
        Nodo auxiliar=c.hijoDerecho;
        c.hijoDerecho= auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo=c;
        c.FE=Math.max(obtenerFE(c.hijoDerecho),obtenerFE(c.hijoIzquierdo))+1;
        auxiliar.FE=Math.max(obtenerFE(auxiliar.hijoDerecho),obtenerFE(auxiliar.hijoIzquierdo))+1;
        return auxiliar;
    }
    //Rotacion doble a la izquierda
    public Nodo rotacionDobleIzquierda(Nodo c){
        Nodo temporal;
        c.hijoIzquierdo=rotacionDerecha(c.hijoIzquierdo);
        temporal=rotacionIzquierda(c);
        return temporal;    
    }
    //Rotacion Doble a la derecha
    public Nodo rotacionDobleDerecha(Nodo c){
        Nodo temporal;
        c.hijoDerecho=rotacionIzquierda(c.hijoDerecho);
        temporal=rotacionDerecha(c);
        return temporal;
    }
    //Metodo para insertar AVL
    public Nodo insertarAVL(Nodo a, Nodo b){
        Nodo nuevoPadre= b;
        if(a.dato<b.dato){
            if(b.hijoIzquierdo==null){
                b.hijoIzquierdo=a;
            }else{
                b.hijoIzquierdo=insertarAVL(a, b.hijoIzquierdo);
                if((obtenerFE(b.hijoIzquierdo)- obtenerFE(b.hijoDerecho)== 2)){
                    if(a.dato<b.hijoIzquierdo.dato){
                        nuevoPadre=rotacionIzquierda(b);
                    }else{
                        nuevoPadre=rotacionDobleIzquierda(b);
                    }
                }
            }
        }else if(a.dato >b.dato){
            if(b.hijoDerecho==null){
                b.hijoDerecho= a;
            }else{
                b.hijoDerecho = insertarAVL(a, b.hijoDerecho);
                if((obtenerFE(b.hijoDerecho)-obtenerFE(b.hijoIzquierdo)==2)){
                   if(a.dato>b.hijoDerecho.dato){
                       nuevoPadre=rotacionDerecha(b);
                   }else{
                       nuevoPadre=rotacionDobleDerecha(b);
                   } 
                }              
            }
        }else{
            System.out.println("Nodo Duplicado");
        }
        //Actualizando la altura
        if((b.hijoIzquierdo==null)&&(b.hijoDerecho!=null)){
            b.FE=b.hijoDerecho.FE +1;            
        }else if((b.hijoDerecho==null)&&(b.hijoIzquierdo!=null)){
            b.FE=b.hijoIzquierdo.FE+1;
        }else{
            b.FE=Math.max(obtenerFE(b.hijoIzquierdo), obtenerFE(b.hijoDerecho))+1;
        }
        return nuevoPadre;   
    }
    //Metodo para insertar
    public void insertar(int d){
        Nodo nuevo= new Nodo(d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo, raiz);
        }
    }
    //Recorridos
    //Metodo para recorrer el Arbol inOrden
    public void inOrden(Nodo r){
        if(r!=null){
            inOrden(r.hijoIzquierdo);
            System.out.print(r.dato+ ", ");
            inOrden(r.hijoDerecho);
        }
    }
    //Metodo para recorrer al Arbol PreOrden
    public void preOrden(Nodo r){
        if(r!=null){
            System.out.print(r.dato+ ", ");
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
        } 
    }
    //Metodo para recorrer el Arbol PostOrden
    public void postOrden(Nodo r){
        if(r!=null){
            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
            System.out.print(r.dato+ ", ");
        }
    }
}
