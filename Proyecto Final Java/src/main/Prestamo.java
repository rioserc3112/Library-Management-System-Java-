/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class Prestamo {
    enum estadoPrestamo {
      ACTIVO,  DEVUELTO_A_TIEMPO, DEVUELTO_CON_RETRASO, CANCELADO_NO_RETIRADO
    }
    
    private int idPrestamo; //inicia en 1000
    private String socio;
    private String libro;
    private String fechaPrestamo;
    private String fechaDevolucionEstimada;
    private String fechaDevolucionReal;
    private estadoPrestamo estadoPrest;

    public Prestamo() {
    }

    public Prestamo(int idPrestamo, String socio, String libro, String fechaPrestamo, String fechaDevolucionEstimada, String fechaDevolucionReal, estadoPrestamo estadoPrest) {
        this.idPrestamo = idPrestamo;
        this.socio = socio;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEstimada = fechaDevolucionEstimada;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.estadoPrest = estadoPrest;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
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

    public estadoPrestamo getEstadoPrest() {
        return estadoPrest;
    }

    public void setEstadoPrest(estadoPrestamo estadoPrest) {
        this.estadoPrest = estadoPrest;
    }
    
    
}
