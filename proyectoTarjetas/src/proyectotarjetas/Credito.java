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
public class Credito extends tarjeta {

    float limite;

    public Credito(float limite, int numeroTarjeta, float saldo, String titular) {
        super(numeroTarjeta, saldo, titular);
        this.limite = limite;
    }

    @Override
    public boolean depositar(float importe) {
        boolean depositar =false;
        float saldoNuevo = getSaldo() - importe;
        setSaldo(saldoNuevo);
        depositar=true;
        return depositar;
    }

    @Override
    public boolean extraer(float compra) {
        boolean extraer = false;
        if (compra + getSaldo()<= limite) { 
            float nuevoSaldo = getSaldo()+ compra;
            setSaldo(nuevoSaldo); 
            extraer = true;
        }
        return extraer;
    }

}
