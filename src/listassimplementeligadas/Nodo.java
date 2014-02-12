/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listassimplementeligadas;

/**
 *
 * @author leon
 */
public class Nodo<T> {
    
    Nodo(T dato){
      this.info = dato;
      this.liga = null;
    }
    
     Nodo(){
      
    }
    
    
    /**
     * Este es el inicio de la lista
     */
    private T info;
    private Nodo<T> liga;

    /**
     * @return the info
     */
    public T getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * @return the liga
     */
    public Nodo<T> getLiga() {
        return liga;
    }

    /**
     * @param liga the liga to set
     */
    public void setLiga(Nodo<T> liga) {
        this.liga = liga;
    }
    
    
   
    
}
