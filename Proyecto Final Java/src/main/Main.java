/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import javax.swing.JOptionPane;

/**
 *
 * @author emma3
 */

//Emma 
public class Main {

    public static void main(String[] args) {

         System.out.println("Hola mundo, Halian =)"); 

         System.out.println("Hola mundo =)"); 
         System.out.println("Hola equipo =)"); 
         System.out.println("Hola Jose, pura vida=)"); 
         
         
         catalogo();
    }
    
    
    
    public static void catalogo(){
        
        //Menu Principal de Catalogo
        
        boolean ciclo = true;
        while (ciclo){
            
            String[] opciones = {
                "1. Mostrar Catalogo Completo", 
                "2. Agregar Nuevo Libro", 
                "3. Editar Informacion de Libro", 
                "4. Cambiar Estado de Libro", 
                "5. Salir"};
            
            
           //Se pregunta 
            int seleccion = JOptionPane.showOptionDialog(
                null, 
                "Seleccione una opción:", 
                "Menú Principal", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                opciones, 
                opciones[0]
            );
            
       
        }
        
    }
}

