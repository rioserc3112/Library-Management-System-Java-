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


