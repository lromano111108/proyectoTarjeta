/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotarjetas;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Banco {

    private ArrayList<tarjeta> tarjetas;

    public Banco() {
        this.tarjetas = new ArrayList();
    }

    public ArrayList<tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void agregarTarjeta(tarjeta nuevaTarjeta) {
        tarjetas.add(nuevaTarjeta);
    }

    public boolean extraer(int nroTarjeta, int tipoTarjeta, float importe) {
        boolean extraccion = false;
        for (tarjeta tarjeta1 : tarjetas) {
            if (tipoTarjeta == 0) { //TARJETA DEBITO
                if (tarjeta1 instanceof Debito && nroTarjeta == tarjeta1.getNumeroTarjeta()) {
                    extraccion = tarjeta1.extraer(importe);
                    break;
                }
            } else if (tipoTarjeta == 1 && tarjeta1 instanceof Credito && tarjeta1.getNumeroTarjeta() == nroTarjeta) {//TARJETA DE CREDITO
                extraccion= tarjeta1.extraer(importe);
                break;
            }

        }
        return extraccion;
    }
    
    public boolean depositar (int nroTarjeta, int tipoTarjeta, float importe){
        boolean deposito=false;
        for (tarjeta tarjeta1 : tarjetas) {
            if (tipoTarjeta==0) {
                if (tarjeta1 instanceof Debito && nroTarjeta == tarjeta1.getNumeroTarjeta()) {
                    deposito= tarjeta1.depositar(importe);
                    break;                    
                }                
            }
            else if (tipoTarjeta == 1) {
                if (tarjeta1 instanceof Credito && nroTarjeta== tarjeta1.getNumeroTarjeta()) {
                    deposito = tarjeta1.depositar(importe);
                    
                }                
            }
        }
        return deposito;
    }
    
    
    public float saldoTotalTarjetaDebito(){
        float saldoTotal=0;
        for (tarjeta tarjeta1 : tarjetas) {
            if (tarjeta1 instanceof Debito) {
                saldoTotal+= tarjeta1.getSaldo();                
            }          
        }
        return saldoTotal;
    }
    
    public float promedioTotalTarjetaCredito(){
        float promedioTotal=0;
        float acum=0;
        int contador=0;
        for (tarjeta tarjeta1 : tarjetas) {
            if (tarjeta1 instanceof Credito) {
                acum+=tarjeta1.getSaldo();
                contador++;                
            }            
        }
        return promedioTotal=acum/contador;
    }

}
