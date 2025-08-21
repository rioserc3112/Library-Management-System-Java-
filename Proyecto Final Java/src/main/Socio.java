/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class Socio {
    enum sociosEstado{
        ACTIVO, MOROSO, SUSPENDIDO, INACTIVO
    }
    
 private int cantLibrosPrestados;   

    public enum EstadoSocio { ACTIVO, MOROSO, SUSPENDIDO, INACTIVO }

    private String idSocio;
    private String nombreCompleto;
    private String fechaRegistro;
    private EstadoSocio estadoSocio;
    private double multasAcumuladas;
    private int cantidadLibrosPrestadosActual;

    public Socio(String idSocio, String nombreCompleto, String fechaRegistro,
                 EstadoSocio estadoSocio, double multasAcumuladas, int cantidadLibrosPrestadosActual) {
        this.idSocio = idSocio;
        this.nombreCompleto = nombreCompleto;
        this.fechaRegistro = fechaRegistro;
        this.estadoSocio = estadoSocio;
        this.multasAcumuladas = multasAcumuladas;
        this.cantidadLibrosPrestadosActual = cantidadLibrosPrestadosActual;
    }

    public String getIdSocio() { return idSocio; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getFechaRegistro() { return fechaRegistro; }
    public EstadoSocio getEstadoSocio() { return estadoSocio; }
    public void setEstadoSocio(EstadoSocio estadoSocio) { this.estadoSocio = estadoSocio; }
    public double getMultasAcumuladas() { return multasAcumuladas; }
    public void setMultasAcumuladas(double multasAcumuladas) { this.multasAcumuladas = multasAcumuladas; }
    public int getCantidadLibrosPrestadosActual() { return cantidadLibrosPrestadosActual; }
    public void setCantidadLibrosPrestadosActual(int cantidadLibrosPrestadosActual) {
        this.cantidadLibrosPrestadosActual = cantidadLibrosPrestadosActual;
    }
    private int cantLibrosPrestados;   

    public Socio() {
    }

    public Socio(int cantLibrosPrestados) {
        this.cantLibrosPrestados = cantLibrosPrestados;
    }
    public void aumVecesPrestado(){
        this.cantLibrosPrestados++;
    }
    public void dismVecesPrestado(){
        if(this.cantLibrosPrestados > 0 ){
            this.cantLibrosPrestados--;
        }
    }
}

}
