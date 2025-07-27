/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author emma3
 */

//Emma 
public class Main {
    
    //Se crean arreglos globales:
    static Libro[] lista_libros = new Libro[50];
    static int contador_libros = 0;
    static Socio[] lista_socios = new Socio[30];
    static Prestamo[] lista_prestamos = new Prestamo[50];
    

    public static void main(String[] args) {

         //Aqui debe ir el Menu Principal
         
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
        
    public static void Agregar_Nuevo_Libro(){
        
        //Se comprueba de que no hayan más de 50 libros
        if(contador_libros >= 50){
            JOptionPane.showMessageDialog(null, "No se pueden agregar más libros");
            //Termine la función
            return;
        }
        
        
        
        //Se piden todos los datos
        
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro");
        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro");
        String editorial = JOptionPane.showInputDialog("Ingrese el editorial del libro");
        Libro.Genra genero = pedir_genero();
        int anio_publicacion = pedir_anio_editorial();
        Libro.Estado estado_libro = pedir_estado();
       
        //public Libro(String titulo, String autor, Genra genero, String editorial, int anioPublicacion, Estado estadoLibro) {
        
        
        //Se suma libro a la lista de libros
        Libro nuevo_libro = new Libro(titulo, autor, genero, editorial, anio_publicacion, estado_libro);
        lista_libros[contador_libros] = nuevo_libro;
        contador_libros++;
        
        String mensaje = "Se agrego correctamente el libro: \n";
        mensaje = mensaje + "ID: " + nuevo_libro.getIsbn() + "\n";
        mensaje = mensaje + "Titulo: " + nuevo_libro.getTitulo() + "\n";
        mensaje = mensaje + "Autor: " + nuevo_libro.getAutor() + "\n";
        mensaje = mensaje + "Editorial: " + nuevo_libro.getEditorial()+ "\n";
        mensaje = mensaje + "Genero: " + nuevo_libro.getGenero() + "\n";
        mensaje = mensaje + "Año publicación: " + nuevo_libro.getAnioPublicacion()+ "\n";
        mensaje = mensaje + "Estado: " + nuevo_libro.getEstadoLibro() + "\n";
        mensaje = mensaje + "Veces prestado: " + nuevo_libro.getVecesPrestado()+ "\n";
        
        
        
        JOptionPane.showMessageDialog(null, mensaje);
        
    }
    
    public static Libro.Estado pedir_estado(){
        while (true){
            
            String[] opciones = {
                "DISPONIBLE",
                "PRESTADO",
                "EN REPARACION",
                "EXTRAVIADO"
            };

            int seleccion = JOptionPane.showOptionDialog(
                null, 
                "Seleccione el estado del libro:", 
                "Estado", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                opciones, 
                opciones[0]
            );


            switch (seleccion){
                case 0:
                    return Libro.Estado.DISPONIBLE;

                case 1:
                    return Libro.Estado.PRESTADO;

                case 2:
                    return Libro.Estado.EN_REPARACION;

                case 3:
                    return Libro.Estado.EXTRAVIADO;         
                    
                default:
                    return Libro.Estado.DISPONIBLE;

            }       
        }         
    }
    
    public static int pedir_anio_editorial(){
        
        while(true){
        
            try{
                int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de publicación del libro"));

                if(anio <= 2025){
                    if(anio > 0){
                        return anio;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Debe ingresar un número positivo");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "¿El libro fue publicado en el futuro?");
                }
            }
            catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Formato de número incorrecto");
                    }
        }
        
        
    }
    
    public static Libro.Genra pedir_genero(){
        while (true){
            
            String[] opciones = {
                "NOVELA",
                "CIENCIA_FICCION",
                "HISTORIA",
                "INFANTIL",
                "POESIA",
                "ENSAYO"
            };

            int seleccion = JOptionPane.showOptionDialog(
                null, 
                "Seleccione el genero del libro:", 
                "Genero", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                opciones, 
                opciones[0]
            );


            switch (seleccion){
                case 0:
                    return Libro.Genra.NOVELA;

                case 1:
                    return Libro.Genra.CIENCIA_FICCION;

                case 2:
                    return Libro.Genra.HISTORIA;

                case 3:
                    return Libro.Genra.INFANTIL;            

                case 4:
                    return Libro.Genra.POESIA;             

                case 5:
                    return Libro.Genra.ENSAYO;     
                    
                default:
                    return Libro.Genra.NOVELA;

            }       
        }        
    }
    
    public static void Mostrar_Catalogo_Completo(){
        Biblioteca();
    }
    
    
    //Si el usuario ingresa una cantidad a mostrar, mostrar esa cantidad de libros
    public static void Biblioteca(int cantidad_mostrar){
        Mostrar_Biblioteca(cantidad_mostrar);

    }
    //Si el usuario NO ingresa una cantidad a mostrar, mostrar 10 libros
    public static void Biblioteca(){
        Mostrar_Biblioteca(10);

    }
    
    public static void Mostrar_Biblioteca(int cantidad_mostrar){
        int contador = 0;
        
        System.out.println("---------------------------------------------------------------------------------");
        
        String mensaje = "|";
        mensaje = mensaje + generar_linea("ISBN");
        mensaje = mensaje + generar_linea("Titulo");
        mensaje = mensaje + generar_linea("Autor");
        mensaje = mensaje + generar_linea("Genero");
        mensaje = mensaje + generar_linea("Estado");
        
        System.out.println(mensaje);
        
        //Muestra la información de cada libro
        for(Libro l: lista_libros){
            if(l != null){
                
                mensaje = "|";
                
                mensaje = mensaje + generar_linea(l.getIsbn());
                mensaje = mensaje + generar_linea(l.getTitulo());
                mensaje = mensaje + generar_linea(l.getAutor());
                mensaje = mensaje + generar_linea(String.valueOf(l.getGenero()));
                mensaje = mensaje + generar_linea(String.valueOf(l.getEstadoLibro()));
                
                System.out.println(mensaje);                
            }
        }

        System.out.println("---------------------------------------------------------------------------------");
        
    }
    
    public static String generar_linea(String texto){
        String mensaje = "";
        
        int espacios_necesarios = calcular_espacios(texto);
                
                if(espacios_necesarios >= 0){
                    mensaje = mensaje + texto + get_n_espacios(espacios_necesarios) + "|";
                }
                else{
                    mensaje = mensaje + String.valueOf(texto).substring(0,15) + "|";
                }
        
                return mensaje;
                
    }
    
    public static int calcular_espacios(String texto){
        
        int espacios_necesarios = 15 - texto.length();
        
        return espacios_necesarios;
    }
    
    public static String get_n_espacios(int espacios_necesarios){
        
        String espacios = "";
        
        for(int i = 0; i < espacios_necesarios; i++){
            espacios = espacios + " ";
        }
        
        return espacios;
        
    }

    public static void Editar_Informacion_Libro(){
    }
    
    public static void Cambiar_Estado_Libro(){

    }
    
    
}

