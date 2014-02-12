/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listassimplementeligadas;

import java.util.Scanner;

/**
 *
 * @author leon
 */
public class Lista<T> {
    
    private Nodo<T> inicio;
    
    
     public String generaStringComoLista(){
        String resultado = "";
        if (getInicio() == null){
          return "Lista vacía";   
        }else{
           Nodo<T> aux = inicio;
           while (aux != null){
               resultado = resultado + aux.getInfo().toString()+"=>";
               aux = aux.getLiga();
           }
        }
        return resultado+"nil";
    }
     
    public String toString(){
        String resultado = "{";
        if (getInicio() == null){
          return "Lista vacía";   
        }else{
           Nodo<T> aux = inicio;
           while (aux != null){
               resultado = resultado + aux.getInfo().toString()+",";
               aux = aux.getLiga();
           }
        }
        return resultado.substring(0, resultado.length()-1)+"}";
                
    }

    /**
     * @return the inicio
     */
    public Nodo<T> getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }
    
    public void insertaInicio(T dato){
            Nodo<T> nuevo = new Nodo<>(dato);
            nuevo.setLiga(inicio);
            inicio = nuevo;
        
        
        
    }
    
     public void insertaFinal(T dato){
         Nodo<T> nuevo = new Nodo<>(dato);
         Nodo<T> aux=inicio;
        if (inicio == null){
            inicio = nuevo;
        }else {
            while (aux.getLiga() != null){
                aux = aux.getLiga();
            }
            aux.setLiga(nuevo);
            
        }
        
        
    }
    
   
    
}
