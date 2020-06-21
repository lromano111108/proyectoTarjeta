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

    private ArrayList<Tarjeta> tarjetas;

    public Banco() {
        this.tarjetas = new ArrayList();
    }

    public ArrayList<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void agregarTarjeta(Tarjeta nuevaTarjeta) {
        tarjetas.add(nuevaTarjeta);
    }

    public boolean extraer(int nroTarjeta, int tipoTarjeta, float importe) {
        boolean extraccion = false;
        for (Tarjeta tarjeta : tarjetas) {
            if (tipoTarjeta == 0) { //TARJETA DEBITO
                if (tarjeta instanceof Debito && nroTarjeta == tarjeta.getNumeroTarjeta()) {
                    extraccion = tarjeta.extraer(importe);
                    break;
                }
            } else if (tipoTarjeta == 1 && tarjeta instanceof Credito && tarjeta.getNumeroTarjeta() == nroTarjeta) {//TARJETA DE CREDITO
                extraccion = tarjeta.extraer(importe);
                break;
            }

        }
        return extraccion;
    }

    public boolean depositar(int nroTarjeta, int tipoTarjeta, float importe) {
        boolean deposito = false;
        for (Tarjeta tarjeta : tarjetas) {
            if (tipoTarjeta == 0) {
                if (tarjeta instanceof Debito && nroTarjeta == tarjeta.getNumeroTarjeta()) {
                    deposito = tarjeta.depositar(importe);
                    break;
                }
            } else if (tipoTarjeta == 1) {
                if (tarjeta instanceof Credito && nroTarjeta == tarjeta.getNumeroTarjeta()) {
                    deposito = tarjeta.depositar(importe);
                    break;

                }
            }
        }
        return deposito;
    }

    public float saldoTotalTarjetaDebito() {
        float saldoTotal = 0;
        for (Tarjeta tarjeta : tarjetas) {
            if (tarjeta instanceof Debito) {
                saldoTotal += tarjeta.getSaldo();
            }
        }
        return saldoTotal;
    }

    public float promedioTotalTarjetaCredito() {
        float promedioTotal = 0;
        float acum = 0;
        int contador = 0;
        for (Tarjeta tarjeta : tarjetas) {
            if (tarjeta instanceof Credito) {
                acum += tarjeta.getSaldo();
                contador++;
            }
        }
        promedioTotal = acum / contador;
        return promedioTotal;
    }

}
