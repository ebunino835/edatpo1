/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila;

import java.util.Scanner;

/**
 *
 * @author Selene
 */
public class Pila {
    
    private int [] datos;
    private int tope;
    
    public Pila(int tamano){
        this.datos = new int [tamano];
        this.tope = -1;
    }
    
    public void Push (int x){
        if(PilaLlena()){
            System.out.println("Pila Llena, no se puede agregar");
        }else{
            this.tope++;
            this.datos[tope] = x;
        }
    
}
    public void Pop (){
        if(PilaVacia()){
            System.out.println("La Pila esta vacia, no se puede Eliminar");
        }else{
            this.tope--;
        }
    
}
    public boolean PilaVacia (){
        return this.tope == -1;
}

    public boolean PilaLlena (){
        return (this.tope == (datos.length-1));
}
    public int VerTope(){
        return this.datos[this.tope];
    }
    
    public void PilasOrdenadas(int x){
        if(this.PilaVacia()){
            this.Push(x);
        }else{
             if(this.PilaLlena()){
              System.out.println("Pila Llena");
        }else{
              Pila pilAux= new Pila (this.tope);
              if(this.VerTope()>=x){
                  this.Push(x);
              }else{
                  while(this.VerTope()<x){
                      pilAux.Push(this.VerTope());
                      this.Pop();
                  }
                  this.Push(x);
                  while(!pilAux.PilaVacia()){
                      this.Push(pilAux.VerTope());
                      pilAux.Pop();
                  }
              }
          }     
       }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scn = new Scanner (System.in);
        System.out.print("Tamaño de la Pila: ");
        int aux = scn.nextInt();
        Pila pila1= new Pila(aux);
        
        
         System.out.print("Ingrese elemento: ");
         pila1.Push(scn.nextInt());
         System.out.print("Ingrese elemento: ");
         pila1.Push(scn.nextInt());
         System.out.print("Ingrese elemento: ");
         pila1.Push(scn.nextInt());
  
         
        
        System.out.print("Ingrese elemento a ordenar: ");
        pila1.PilasOrdenadas(scn.nextInt());
        
        while(!pila1.PilaVacia()){
            System.out.println(pila1.VerTope());
            pila1.Pop();
        }
    }
    
}
