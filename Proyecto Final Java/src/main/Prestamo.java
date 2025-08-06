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

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucionEstimada() {
        return fechaDevolucionEstimada;
    }

    public void setFechaDevolucionEstimada(String fechaDevolucionEstimada) {
        this.fechaDevolucionEstimada = fechaDevolucionEstimada;
    }

    public String getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(String fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public estadoPrestamo getEstadoPrestamo() {
        return EstadoPrestamo;
    }

    public void setEstadoPrestamo(estadoPrestamo EstadoPrestamo) {
        this.EstadoPrestamo = EstadoPrestamo;
    }

    public double getMultaGeneradaEstePrestamo() {
        return multaGeneradaEstePrestamo;
    }

    public void setMultaGeneradaEstePrestamo(double multaGeneradaEstePrestamo) {
        this.multaGeneradaEstePrestamo = multaGeneradaEstePrestamo;
    }

   
    
}
