
package main;

/**
 *
 * @author Emmanuel Rios Castro
 */
public class Libro {
  //Hola mundo   
    
    //Se crean contadores de IDs:
    static int id_libro = 0;
    
    enum Genra{ //Genra
    NOVELA, 
    CIENCIA_FICCION, 
    HISTORIA, 
    INFANTIL, 
    POESIA, 
    ENSAYO
}
    
    enum Estado{
        DISPONIBLE, 
        PRESTADO, 
        EN_REPARACION, 
        EXTRAVIADO
    }

    private String isbn;
    private String titulo;
    private String autor;
    private Genra genero;
    private String editorial;
    private int anioPublicacion;
    private Estado estadoLibro;
    private int vecesPrestado;

        public Libro(String titulo, String autor, Genra genero, String editorial, int anioPublicacion, Estado estadoLibro) {
            this.titulo = titulo;
            this.autor = autor;
            this.genero = genero;
            this.editorial = editorial;
            this.anioPublicacion = anioPublicacion;
            this.estadoLibro = estadoLibro;
            
            //Se crea ID unico de libro
            this.isbn = generar_id_libro();
            
        }
        
        public String generar_id_libro(){
            
            String nuevo_ID = "LIB-";
            
            id_libro ++;
            
            nuevo_ID = nuevo_ID + id_libro;
            
            return nuevo_ID;      
            
        }
        
        public String mostrar_datos(){
            String mensaje = "";
            
            mensaje = mensaje + "ID: " + this.isbn + "\n";
            mensaje = mensaje + "Titulo: " + this.titulo + "\n";
            mensaje = mensaje + "Autor: " + this.autor + "\n";
            mensaje = mensaje + "Editorial: " + this.editorial + "\n";
            mensaje = mensaje + "Genero: " + this.genero + "\n";
            mensaje = mensaje + "Año publicación: " + this.anioPublicacion + "\n";
            mensaje = mensaje + "Estado: " + this.estadoLibro + "\n";
            mensaje = mensaje + "Veces prestado: " + this.vecesPrestado + "\n";
            
            return mensaje;
        }
    
    
    // ---------- Getters and Setters ---------- //
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Genra getGenero() {
        return genero;
    }

    public void setGenero(Genra genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Estado getEstadoLibro() {
        return estadoLibro;
    }

    public void setEstadoLibro(Estado estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

    public int getVecesPrestado() {
        return vecesPrestado++;
    }

    public void setVecesPrestado(int vecesPrestado) {
        this.vecesPrestado = vecesPrestado;
    }

   public void aumentoVecesPrestado(){
       this.vecesPrestado++;
   }   
}
