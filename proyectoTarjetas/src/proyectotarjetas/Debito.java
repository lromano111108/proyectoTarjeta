/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotarjetas;

/**
 *
 * @author Lucas
 */
public class Debito extends Tarjeta {

    public Debito(int numeroTarjeta, float saldo, String titular) {
        super(numeroTarjeta, saldo, titular);
    }

    @Override
    public boolean depositar(float importe) {
        boolean depositar = false;
        float nuevoSaldo = getSaldo() + importe;
        setSaldo(nuevoSaldo);
        depositar = true;
        return depositar;
    }

    @Override
    public boolean extraer(float importe) {
        boolean extraer = false;
        if (getSaldo() >= importe) {
            float nuevoSaldo = getSaldo() - importe;
            setSaldo(nuevoSaldo);
            extraer = true;
        }
        return extraer;
    }

}
