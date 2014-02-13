/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listassimplementeligadas;

/**
 *
 * @author Alumnos
 */
public class ListasUtils<T> {
    public  int count(Nodo<T> inicio){
        int cuenta=0;
        Nodo<T> aux=inicio;
        while(aux.getLiga()!=null){
           if(aux.getLiga()!=null ){
               aux=aux.getLiga();
               cuenta++;
           }
        }
        return cuenta;
    }
    
    public T getElement(Nodo<T> inicio,int index) throws LinkedListException{
        T info=null;
         Nodo<T> aux=inicio;
        if(index>=count(inicio)){
            throw new LinkedListException("indice fuera del rango");
        }else{
            int cont=0;
            while(cont !=index){
                aux=aux.getLiga();
                cont++;
            }info=aux.getInfo();
            return info;
        }
        }
    
    public T pop(Lista l){
        T info=null;
         Nodo<T> a=l.getInicio();
        if ( a.getLiga()!= null) {
            info = a.getInfo();
            a = a.getLiga();
        }
        return info;
    }
        
        
    }

