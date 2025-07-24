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
    
    
    //Aqui es la parte de Halian
    
    public static void biblioteca(){
        System.out.println("===============LIBROS===============");
        System.out.println("\nISBN == Titulo == Autor == Genero == Estado");
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Aqui es la parte de Emma
    
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
            
            
           //Se muestran botones con JOptionPane
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

            switch(seleccion){
                case 0:
                    Mostrar_Catalogo_Completo();
                    break;

                case 1:
                    Agregar_Nuevo_Libro();
                    break;
                case 2:
                    Editar_Informacion_Libro();
                    break;

                case 3:
                    Cambiar_Estado_Libro();
                    break;
                case 4:
                    //Salir
                    ciclo = false;
                    break;
            }
            
        }
    }
    
    public static void Mostrar_Catalogo_Completo(){
    }
    
    public static void Agregar_Nuevo_Libro(){
    }
    
    public static void Editar_Informacion_Libro(){
    }
    
    public static void Cambiar_Estado_Libro(){

            
            switch(seleccion){
                case 0:
                    Mostrar_Catalogo_Completo();
                    break;
                case 1:
                    Agregar_Nuevo_Libro();
                    break;
                case 2:
                    Editar_Informacion_Libro();
                    break;
                case 3:
                    Cambiar_Estado_Libro();
                    break;
                case 4:
                    //Salir
                    ciclo = false;
                    break;
            }
        }
    }
}

