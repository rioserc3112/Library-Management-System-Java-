/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class Prestamo {
    enum estadoPrestamo {
      ACTIVO,  
      DEVUELTO_A_TIEMPO, 
      DEVUELTO_CON_RETRASO, 
      CANCELADO_NO_RETIRADO
    }
    
    private int contador = 1000; //contador para ID de prestamo
    private int idPrestamo; 
    private Socio socio;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaDevolucionEstimada;
    private String fechaDevolucionReal;
    private estadoPrestamo EstadoPrestamo;
    private double multaGeneradaEstePrestamo; //inicia en 0.0   

    public Prestamo() {
    }

    public Prestamo(int idPrestamo, Socio socio, Libro libro, String fechaPrestamo, String fechaDevolucionEstimada, String fechaDevolucionReal, estadoPrestamo EstadoPrestamo, double multaGeneradaEstePrestamo) {
        this.idPrestamo = contador++;
        this.socio = socio;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEstimada = fechaDevolucionEstimada;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.EstadoPrestamo = EstadoPrestamo;
        this.multaGeneradaEstePrestamo = multaGeneradaEstePrestamo;
    }

   
    
}
