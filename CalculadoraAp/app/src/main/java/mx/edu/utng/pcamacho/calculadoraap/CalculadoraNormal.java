package mx.edu.utng.pcamacho.calculadoraap;

/**
 * Created by gerar on 01/10/2017.
 */

public class CalculadoraNormal extends AbstractCalculadora {

    public CalculadoraNormal(){

    }

    @Override
    public double sumar(double n1, double n2) {
        return n1+n2;
    }

    @Override
    public double restar(double n1, double n2) {
        return n1-n2;
    }

    public double multiplicar(double n1, double n2) {
        return n1*n2;
    }

    public double dividir(double n1, double n2) {
        return n1/n2;
    }
}

