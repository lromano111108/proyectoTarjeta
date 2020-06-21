/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
int numero
 float saldo
 String titular
 float limite
 * and open the template in the editor.
 */
package proyectotarjetas;

/**
 *
 * @author Lucas
 */
public abstract class tarjeta {
    
    private int numeroTarjeta;
    private float saldo;
    private String titular;

    public tarjeta(int numeroTarjeta, float saldo, String titular) {
        this.numeroTarjeta = numeroTarjeta;
        this.saldo = saldo;
        this.titular = titular;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
   
    public abstract boolean depositar(float importa);
    public abstract boolean extraer(float importa);
            
            
    
    
}
