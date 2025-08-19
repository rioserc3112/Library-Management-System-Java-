/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.util.HashSet;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;
import java.util.Random;

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
    static int contador_socios = 0;
    
    //Para tener un número random
    static Random random = new Random();
    
    public static void main(String[] args) {
        
        //Se generan libros aleatorios
        int cantidad_libros = 0;
        while(true){
            try{
                
                cantidad_libros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de libros aleatorios que desea agregar"));
                
                if(cantidad_libros >= 0 && cantidad_libros <= 50){
                    break;
                }
                else if(cantidad_libros >50){
                    JOptionPane.showMessageDialog(null, "No puede exceder los 50 libros");
                }
                else if(cantidad_libros < 0){
                    JOptionPane.showMessageDialog(null, "Debe ser un número positivo");
                }
                
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Formato de número incorrecto, intente nuevamente");
            }
        }
        
        generar_libros_aleatoriamente(cantidad_libros);
        
        

         //Aqui debe ir el Menu Principal
         MenuPrincipial();
         
    }
    
    
    //Aqui es la parte de Halian
    
    public static void biblioteca(){
        System.out.println("===============LIBROS===============");
        System.out.println("\nISBN == Titulo == Autor == Genero == Estado");
        
    }
    
     public static void prestamos(){
        boolean ciclo = true;
    while (ciclo) {
        String[] opciones = {
            "1. Registrar Prestamo", 
            "2. Registrar Devolucion", 
            "3. Consultar Prestamo por ID", 
            "4. Salir"
        };

        int seleccion = JOptionPane.showOptionDialog(
            null, 
            "Seleccione una opcion:", 
            "Menu de Prestamos", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.INFORMATION_MESSAGE, 
            null, 
            opciones, 
            opciones[0]);

        switch (seleccion) {
            case 0:
                Registar_Prestamo();
                break;
            case 1:
                Registrar_Devolucion();
                break;
            case 2:
                Consultar_Prestamo_ID(); 
                break;
            case 3:
            default:
                ciclo = false;
                break;
        }
      }   
    }   
    static int contador_prestamos = 0;
    static int idPrestamoActual = 100;
    public static void Registar_Prestamo(){
        if (contador_prestamos >= 50){
            JOptionPane.showMessageDialog(null, "Se alcanzo el limite en el sstema.");
            return;
        }
        //Se necesita clase socios para continuar
        Socio socio = null;
        String IDsocio = JOptionPane.showInputDialog(null, "Ingrese ID de socio");
        for (Socio socios : lista_socios){
            
        }
        //Busqueda por libro
        Libro libro = null;
        String isbn = JOptionPane.showInputDialog(null, "Ingrese ISBN del libro");
        for (Libro libros : lista_libros){
            if (libro != null && libro.getIsbn().equalsIgnoreCase(isbn)){
                libro = libros;
                break;
            }
        }
        if (libro == null){
             JOptionPane.showMessageDialog(null, "El libro "+isbn+" no existe o no se encuentra registrado en el sistema");
        return;
        }
        if (libro.getEstadoLibro() != Libro.Estado.DISPONIBLE){
         JOptionPane.showMessageDialog(null,"El libro "+libro.getTitulo()+", se encuentra en estado "+libro.getEstadoLibro() );   
        return;
        }
        //Calculos para fechas de prestamos
 
        //Seccion de prestamos
        String prestamoDate = fechaActual();
        String devoDateAprox = fechaDev(15); //contador que inicia desde el dia del prestamo
    
        //Generamos un prestamo en esta seccion
        Prestamo nuevoPrest = new Prestamo();
    nuevoPrest.setIdPrestamo(idPrestamoActual++);
    nuevoPrest.setSocio(socio);
    nuevoPrest.setLibro(libro);
    nuevoPrest.setFechaPrestamo(prestamoDate);
    nuevoPrest.setFechaDevolucionEstimada(devoDateAprox);
    nuevoPrest.setEstadoPrestamo(Prestamo.estadoPrestamo.ACTIVO);
    nuevoPrest.setFechaDevolucionReal(null);
    nuevoPrest.setMultaGeneradaEstePrestamo(0.0);
   lista_prestamos[contador_prestamos++] = nuevoPrest;
   libro.setEstadoLibro(Libro.Estado.PRESTADO);
   libro.aumentoVecesPrestado();
   socio.aumVecesPrestado();
   
   String salidaRegistrado = "Se registro prestamo. Detalles:\n";
   salidaRegistrado += "ID Prestamo: "+nuevoPrest.getIdPrestamo()+"\n";
   //(Aun se necesita crear clase socio)PrestRegistrado += "Nombre del socio: "+
   salidaRegistrado += "Libro: "+libro.getTitulo()+"\n"; 
   salidaRegistrado += "Fecha en la que se realizo el prestamo: "+prestamoDate+"\n";
   salidaRegistrado += "Fecha estimada de su devolucion: "+devoDateAprox+"\n";
   salidaRegistrado += "Se encuentra en estado: "+nuevoPrest.getEstadoPrestamo()+"\n";
   JOptionPane.showMessageDialog(null,salidaRegistrado);
   
    
   }  
   

    public static String fechaActual(){
        java.time.LocalDate hoy = java.time.LocalDate.now();
        return hoy.format(java.time.format.DateTimeFormatter.ofPattern("dd/mm/aaaa"));
    }
    public static String fechaDev(int dExtras){
        java.time.LocalDate fecha = java.time.LocalDate.now().plusDays(dExtras);
        return fecha.format(java.time.format.DateTimeFormatter.ofPattern("dd/mm/aaaa"));
    }
    
    
    public static void Registrar_Devolucion(){
        String datoDev =JOptionPane.showInputDialog("Digite ID del devolucion de prestamo: ");
        int id;
        try {//Try para buscar ID no registrado, para que programa siga corriendo y busque alternativas
        id = Integer.parseInt(datoDev);
    } 
        catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ID no registrado. Intente de nuevo");
        return;
    }
      Prestamo prestamo = null;
        for (Prestamo presta : lista_prestamos){
            if (presta != null && presta.getIdPrestamo()==id){
                prestamo = presta;
                break;  
    }
   }
        //Si el ID no existe
        if (prestamo == null){
            JOptionPane.showMessageDialog(null, "Prestamo con ID "+id+" no pudo ser encontrado o no existe. Intente de nuevo");
        return;
        }
       if (prestamo.getEstadoPrestamo()!= Prestamo.estadoPrestamo.ACTIVO){
           JOptionPane.showMessageDialog(null, "Prestamo con ID "+id+" se encuentra"+prestamo.getEstadoPrestamo()+". No se puede hacer devolucion.");
        return;
       } 
       
       String fechaDev = fechaActual();
       prestamo.setFechaDevolucionReal(fechaDev);
       java.time.LocalDate fechaEstimada =java.time.LocalDate.parse(prestamo.getFechaDevolucionEstimada(), java.time.format.DateTimeFormatter.ofPattern("dd/mm/aaaa"));
       java.time.LocalDate devReal =java.time.LocalDate.parse(fechaDev, java.time.format.DateTimeFormatter.ofPattern("dd/mm/aaaa")); 
       long diasRetrasados = java.time.temporal.ChronoUnit.DAYS.between(fechaEstimada, devReal);
        if (diasRetrasados > 0) {
        double multa = diasRetrasados * 5; // supponineod que son 5 dias de retraso
        prestamo.setMultaGeneradaEstePrestamo(multa);
        //prestamo.getSocio().sumarMulta(multa);
        prestamo.setEstadoPrestamo(Prestamo.estadoPrestamo.DEVUELTO_CON_RETRASO);
    } else {
        prestamo.setEstadoPrestamo(Prestamo.estadoPrestamo.DEVUELTO_A_TIEMPO);
    } 
        
        //ACUALIZAMOS DATOS
         prestamo.getLibro().setEstadoLibro(Libro.Estado.DISPONIBLE);
         prestamo.getSocio().dismVecesPrestado();

    JOptionPane.showMessageDialog(null, "Libro devuelto exitosamente.\nEstado actualizado: " +prestamo.getEstadoPrestamo()+ "\nMulta: " + prestamo.getMultaGeneradaEstePrestamo());
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
        
        
        mensaje = mensaje + nuevo_libro.mostrar_datos();
        
        
        JOptionPane.showMessageDialog(null, mensaje, "Libro agregado", JOptionPane.INFORMATION_MESSAGE);
        
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

    
    public static void Cambiar_Estado_Libro(){
        
        String isbn = solicitar_ISBN();
        
        int index_libro = get_index_libro_by_ISBN(isbn);
        
        // Si el titulo fue prestado no se cambia el estado
        if(lista_libros[index_libro].getEstadoLibro() == Libro.Estado.PRESTADO){
            JOptionPane.showMessageDialog(null, "El libro " + lista_libros[index_libro].getTitulo() + 
                    " está PRESTADO, su estado no se puede cambiar directamente aquí. Debe ser devuelto primero");
            return;
        }
        
        //Si no ha sido prestado, se cambia el estado
        
        Libro.Estado nuevo_estado = pedir_estado();
        
        lista_libros[index_libro].setEstadoLibro(nuevo_estado);
        
    }
    
    public static String solicitar_ISBN(){
    
        boolean isbn_existe = false;
        
        while(true){
            
            //Pedir el ISBN al usuario
            String input_usuario = JOptionPane.showInputDialog("Ingrese el ISBN");
            
            
            //Se comprueba si el ISBN existe en la lista de libros
            
            for(Libro l: lista_libros){
                
                if(l != null){
                    //Si el ISBN esta en la lista
                    if(l.getIsbn().equalsIgnoreCase(input_usuario)){
                        isbn_existe = true;
                        break;
                    }
                                
                }
            }
            
            if(isbn_existe){
                return input_usuario;
            }
            else{
                JOptionPane.showMessageDialog(null, "El ISBN: " + input_usuario + " no existe, intente con otro");
            }
            
        }
    }
    
    public static int get_index_libro_by_ISBN(String isbn){
        
               
        for(int i = 0; i < lista_libros.length; i++){
            if(lista_libros[i].getIsbn().equalsIgnoreCase(isbn)){
                return i;
            }
        }
        
        return -10;
    }
    
    public static void Editar_Informacion_Libro(){
        
        //Se pide ISBN
        String isbn = solicitar_ISBN();
        int index_libro = get_index_libro_by_ISBN(isbn);
        
        
        //Se muestran datos del libro
        String mensaje = "Los datos actuales del libro son: ";
        mensaje = mensaje + lista_libros[index_libro].mostrar_datos();
        
        JOptionPane.showMessageDialog(null, mensaje, "Información del libro", JOptionPane.INFORMATION_MESSAGE);
            
        //Se muestra menu para ver que se desea editar
        
        while (true){
            
            String[] opciones = {
                "Titulo",
                "Autor",
                "Editorial",
                "Año Pub",
                "Genero",
                "Atrás"
            };

            int seleccion = JOptionPane.showOptionDialog(
                null, 
                "¿Qué desea editar?", 
                "Editar Libro", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                opciones, 
                opciones[0]
            );


            switch (seleccion){
                case 0:
                    //Para editar Titulo
                    String nuevo_titulo = JOptionPane.showInputDialog("Ingrese el nuevo titulo");
                    lista_libros[index_libro].setTitulo(nuevo_titulo);
                    break;

                case 1:
                    //Para editar Autor
                    String nuevo_autor = JOptionPane.showInputDialog("Ingrese el nuevo Autor");
                    lista_libros[index_libro].setAutor(nuevo_autor);
                    break;

                case 2:
                    //Para editar Editorial
                    String nuevo_editorial = JOptionPane.showInputDialog("Ingrese el nuevo Editorial");
                    lista_libros[index_libro].setEditorial(nuevo_editorial);
                    break;

                case 3:
                    //Para editar Año Publicacion
                    int nuevo_anio = pedir_anio_editorial();
                    lista_libros[index_libro].setAnioPublicacion(nuevo_anio);
                    break;
                    

                case 4:
                    //Para editar Genero
                    Libro.Genra nuevo_genero = pedir_genero();
                    lista_libros[index_libro].setGenero(nuevo_genero);                    
                    break;

                default:
                    //Atras
                    return;

            }       
        
            
            //Muestra un mensaje de Si o No
            int eleccion = JOptionPane.showConfirmDialog(null, "¿Desea seguir editando?", "Continuar", JOptionPane.YES_NO_OPTION);


            //Si usuario elije que no entonces se termina la función
            if(eleccion == 1){
                return;
            }

        }    
    }
    
    //Se agrega nuevo método para que while(true) no se salga de la expeción
    public int cantidasSocios(){
int cantidad_socios = 0;
  while (true) {
    try {
        cantidad_socios = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de socios aleatorios (0-30):"));
        if (cantidad_socios >= 0 && cantidad_socios <= 30) break;
        JOptionPane.showMessageDialog(null, "Debe estar entre 0 y 30.");
    } 
    catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Número inválido.");
    }
   }
        return cantidad_socios;
  
    }
    
    public static void generar_libros_aleatoriamente(int cantidad){
        // Listas predefinidas
        String[] titulos = {
            "El Quijote",
            "Cien Anos de Soledad",
            "1984",
            "Moby Dick",
            "Orgullo y Prejuicio",
            "Crimen y Castigo",
            "Los Miserables",
            "La Metamorfosis",
            "El Principito",
            "Don Juan Tenorio",
            "Fahrenheit 451",
            "Dracula",
            "El Retrato de Dorian Gray",
            "Las Aventuras de Sherlock Holmes",
            "La Isla del Tesoro",
            "Guerra y Paz",
            "Madame Bovary",
            "El Conde de Montecristo",
            "Rayuela",
            "El Tunel"
        };

        String[] autores = {
            "Miguel de Cervantes",
            "Gabriel Garcia Marquez",
            "George Orwell",
            "Herman Melville",
            "Jane Austen",
            "Fiodor Dostoievski",
            "Victor Hugo",
            "Franz Kafka",
            "Antoine de Saint Exupery",
            "Jose Zorrilla",
            "Ray Bradbury",
            "Bram Stoker",
            "Oscar Wilde",
            "Arthur Conan Doyle",
            "Robert Louis Stevenson",
            "Leon Tolstoi",
            "Gustave Flaubert",
            "Alexandre Dumas",
            "Julio Cortazar",
            "Ernesto Sabato"
        };

        String[] editoriales = {
            "Planeta",
            "Anagrama",
            "Penguin Random House",
            "Alfaguara",
            "Debolsillo",
            "Tusquets",
            "Seix Barral",
            "Alianza Editorial",
            "Ediciones Destino",
            "Lumen",
            "Siruela",
            "Roca Editorial",
            "Espasa",
            "Salamandra",
            "Acantilado",
            "Nostra Ediciones",
            "Castalia",
            "Editorial Juventud",
            "Porrua",
            "Minotauro"
        };

        Libro.Genra[] generos = {Libro.Genra.NOVELA, Libro.Genra.CIENCIA_FICCION, Libro.Genra.HISTORIA, Libro.Genra.INFANTIL, Libro.Genra.POESIA, Libro.Genra.ENSAYO};
        Libro.Estado[] estados = {Libro.Estado.DISPONIBLE, Libro.Estado.EN_REPARACION};
        
        
        for(int i = 0; i < cantidad; i++){
            // Datos aleatorios
            String titulo = titulos[random.nextInt(titulos.length)];
            String autor = autores[random.nextInt(autores.length)];
            String editorial = editoriales[random.nextInt(editoriales.length)];
            Libro.Genra genero = generos[random.nextInt(generos.length)];
            Libro.Estado estado = estados[random.nextInt(estados.length)];
            
            //Se genera un año entre 1950 y 2023
            int anioPublicacion = 1950 + random.nextInt(2023 - 1950 + 1);
            
            
            //Se crea libro aleatorio y se agrega a lista de libros
            
            lista_libros[i] = new Libro(titulo, autor, genero, editorial, anioPublicacion, estado);
            contador_libros++;
            
            
        }
        
        
        
    }

    
    
//Esta es la parte de Jose Santos

public static void MenuPrincipial () {
    
        boolean continuar = true;

        while (continuar) {
            String[] opciones = {
                "Ver Biblioteca",
                "Gestión de Préstamos",
                "Catálogo de Libros",
                "Administrar Socios",
                "Ver Reportes",
                "Salir del Sistema"
            };

            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Bienvenido al sistema de biblioteca.\nSelecciona lo que deseas hacer:",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (seleccion) {
                case 0:
                    //mostrarBiblioteca();  
                    break;
                case 1:
                    //Prestamos();
                    break;
                case 2:
                    catalogo();
                    break;
                case 3:
                    Socios();
                    break;
                case 4:
                    //Reportes();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "¡Hasta pronto! Cerrando el sistema.");
                    continuar = false;
                    break;
                case -1:
                    // El usuario cerró la ventana
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Volviendo al menú.");
            }
        }

        System.exit(0); 
    }



public static void Socios() {
    boolean continuar = true;
    while (continuar) {
        String[] opciones = {
            "Registrar Nuevo Socio",
            "Consultar Datos de Socio",
            "Actualizar Estado de Socio",
            "Gestionar Multas de Socio",
            "Salir"
        };

        int seleccion = JOptionPane.showOptionDialog(
            null, "Gestión de Socios", "Socios",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, opciones, opciones[0]
        );

        switch (seleccion) {
            case 0: Registrar_Nuevo_Socio(); break;
            case 1: Consultar_Datos_Socio(); break;
            case 2: Actualizar_Estado_Socio(); break;
            case 3: Gestionar_Multas_Socio(); break;
            default: continuar = false; break;
        }
    }
}

public static int buscarSocio(String id) {
    for (int i = 0; i < lista_socios.length; i++) {
        if (lista_socios[i] != null && lista_socios[i].getIdSocio().equalsIgnoreCase(id)) {
            return i;
        }
    }
    return -1;
}

public static String pedirIdSocio() {
    while (true) {
        String id = JOptionPane.showInputDialog("Ingrese ID de socio:");
        if (id == null) return null;
        if (buscarSocio(id) != -1) return id;
        JOptionPane.showMessageDialog(null, "No existe ese ID.");
    }
}

public static String generarIdSocio() {
    while (true) {
        String letras = "" + (char)('A' + random.nextInt(26)) + (char)('A' + random.nextInt(26));
        String numeros = "" + random.nextInt(10) + random.nextInt(10);
        String id = "SOC-" + letras + numeros;
        if (buscarSocio(id) == -1) return id;
    }
}

public static String fechaActual() {
    java.time.LocalDateTime ahora = java.time.LocalDateTime.now();
    java.time.format.DateTimeFormatter f = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    return ahora.format(f);
}

//EMPIEZA NUEVO SOCIO
// ---- 1) Registrar ----
public static void Registrar_Nuevo_Socio() {
    if (contador_socios >= 30) {
        JOptionPane.showMessageDialog(null, "Límite de socios alcanzado.");
        return;
    }
    String id = generarIdSocio();
    String nombre = "Socio " + (contador_socios + 1);
    Socio s = new Socio(id, nombre, fechaActual(), Socio.EstadoSocio.ACTIVO, 0.0, 0);
    lista_socios[contador_socios++] = s;

    JOptionPane.showMessageDialog(null,
        "ID: " + s.getIdSocio() + "\n" +
        "Nombre: " + s.getNombreCompleto() + "\n" +
        "Fecha Registro: " + s.getFechaRegistro() + "\n" +
        "Estado: " + s.getEstadoSocio()
    );
}
//TERMINA NUEVO SOCIO


//EMPIEZA GENERAR DATOS SOCIO
// ---- 2) Consultar ----
public static void Consultar_Datos_Socio() {
    String id = pedirIdSocio();
    if (id == null) return;
    Socio s = lista_socios[buscarSocio(id)];
    JOptionPane.showMessageDialog(null,
        "ID: " + s.getIdSocio() + "\n" +
        "Nombre: " + s.getNombreCompleto() + "\n" +
        "Fecha Registro: " + s.getFechaRegistro() + "\n" +
        "Estado: " + s.getEstadoSocio() + "\n" +
        "Multas: " + s.getMultasAcumuladas() + "\n" +
        "Libros Prestados: " + s.getCantidadLibrosPrestadosActual()
    );
}
//TERMINA GENERAR DATOS SOCIO

//EMPIEZA GENERAR ESTADO SOCIO
// ---- 3) Actualizar Estado ----
public static void Actualizar_Estado_Socio() {
    String id = pedirIdSocio();
    if (id == null) return;
    Socio s = lista_socios[buscarSocio(id)];

    String[] opciones = {"ACTIVO", "SUSPENDIDO", "INACTIVO", "Cancelar"};
    int seleccion = JOptionPane.showOptionDialog(
        null, "Estado actual: " + s.getEstadoSocio(),
        "Actualizar Estado", JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]
    );

    if (seleccion == 0 && s.getMultasAcumuladas() > 0) {
        s.setEstadoSocio(Socio.EstadoSocio.MOROSO);
        JOptionPane.showMessageDialog(null, "Tiene multas pendientes. Se mantiene MOROSO.");
        return;
    }
    if (seleccion == 0) s.setEstadoSocio(Socio.EstadoSocio.ACTIVO);
    if (seleccion == 1) s.setEstadoSocio(Socio.EstadoSocio.SUSPENDIDO);
    if (seleccion == 2) s.setEstadoSocio(Socio.EstadoSocio.INACTIVO);

    if (seleccion >= 0 && seleccion <= 2)
        JOptionPane.showMessageDialog(null, "Estado actualizado a: " + s.getEstadoSocio());
}
//TERMINA GENERAR ESTADO SOCIO

//EMPIEZA GENERAR MULTAS
// ---- 4) Gestionar Multas ----
public static void Gestionar_Multas_Socio() {
    String id = pedirIdSocio();
    if (id == null) return;
    Socio s = lista_socios[buscarSocio(id)];

    String[] opciones = {"Pagar Todo", "Pagar Parcial", "Cancelar"};
    int seleccion = JOptionPane.showOptionDialog(
        null, "Multas: " + s.getMultasAcumuladas(),
        "Multas", JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]
    );

    if (seleccion == 0) {
        s.setMultasAcumuladas(0.0);
        if (s.getCantidadLibrosPrestadosActual() == 0 || s.getEstadoSocio() == Socio.EstadoSocio.MOROSO)
            s.setEstadoSocio(Socio.EstadoSocio.ACTIVO);
        JOptionPane.showMessageDialog(null, "Multas pagadas. Saldo 0. Estado: " + s.getEstadoSocio());
    }
    else if (seleccion == 1) {
        if (s.getMultasAcumuladas() <= 0) {
            JOptionPane.showMessageDialog(null, "No hay multas.");
            return;
        }
        while (true) {
            String in = JOptionPane.showInputDialog("Monto a pagar (saldo: " + s.getMultasAcumuladas() + "):");
            if (in == null) return;
            try {
                double m = Double.parseDouble(in);
                if (m <= 0 || m > s.getMultasAcumuladas()) {
                    JOptionPane.showMessageDialog(null, "Monto inválido.");
                    continue;
                }
                s.setMultasAcumuladas(s.getMultasAcumuladas() - m);
                if (s.getMultasAcumuladas() > 0) s.setEstadoSocio(Socio.EstadoSocio.MOROSO);
                else if (s.getCantidadLibrosPrestadosActual() == 0) s.setEstadoSocio(Socio.EstadoSocio.ACTIVO);
                JOptionPane.showMessageDialog(null, "Pago parcial registrado. Saldo: " + s.getMultasAcumuladas() + ". Estado: " + s.getEstadoSocio());
                return;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido.");
            }
        }
    }
}
//TERMINA GENERAR MULTAS

//EMPIEZA GENERAR SOCIOS
// ---- Generador aleatorio de socios con IF para multas ----
public static void generar_socios_aleatoriamente(int cantidad) {
    if (cantidad > 30) cantidad = 30;

    int creados = 0;
    while (creados < cantidad && contador_socios < 30) {
        String id = generarIdSocio();
        String nombre = "Socio " + (contador_socios + 1);
        boolean moroso = random.nextInt(100) < 15;

        double multa;
        if (moroso) {
            multa = 1000.0;
        } else {
            multa = 0.0;
        }

        Socio s = new Socio(
            id,
            nombre,
            fechaActual(),
            moroso ? Socio.EstadoSocio.MOROSO : Socio.EstadoSocio.ACTIVO,
            multa,
            0
        );

        lista_socios[contador_socios] = s;
        contador_socios++;
        creados++;
    }
   } 
  //TERMINA GENERAR SOCIOS
}