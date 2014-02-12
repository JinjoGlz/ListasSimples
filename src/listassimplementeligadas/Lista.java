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
     
      public void insertaAntesDato(T dato, T datoInicial) throws LinkedListException{
         if (inicio == null){
             throw new LinkedListException("La lista está vacía.");
         } 
         Nodo<T> actual = inicio;
         Nodo<T> anterior = null;
         boolean band = false;
         while(!actual.getInfo().equals(datoInicial) && !band){
             if (actual.getLiga() != null){
                 anterior = actual;
                 actual = actual.getLiga();
             }else{
                 band = true;
             }
                 
         }
         if (!band){
             Nodo<T> nodo = new Nodo<>(dato);
             if (actual == inicio){ // El nodo dado como referencia es el primero
                 nodo.setLiga(inicio);
                 inicio = nodo;
             }else {
                 anterior.setLiga(nodo);
                 nodo.setLiga(actual);
             }
             
         }else{
             throw new LinkedListException("El nodo dado como referencia no está en la lista");
         }
    }
      
      public void insertaDespuesDato(T dato, T datoInicial) throws LinkedListException{
         if (inicio == null){
             throw new LinkedListException("La lista está vacía.");
         } 
         Nodo<T> actual = inicio;
         boolean band = false;
         while(!actual.getInfo().equals(datoInicial) && !band){
             if (actual.getLiga() != null){
                 actual = actual.getLiga();
             }else{
                 band = true;
             }
                 
         }
         if (!band){
             Nodo<T> nodo = new Nodo<>(dato);
             nodo.setLiga(actual.getLiga());
             actual.setLiga(nodo);
         }else{
             throw new LinkedListException("El nodo dado como referencia no está en la lista");
         }
    }
    
    public void clear(){
            inicio = null;
        }   
    
}
