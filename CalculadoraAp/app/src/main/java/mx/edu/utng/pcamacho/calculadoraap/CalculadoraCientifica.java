package mx.edu.utng.pcamacho.calculadoraap;

/**
 * Created by gerar on 01/10/2017.
 */

public class CalculadoraCientifica extends AbstractCalculadora{

    public CalculadoraCientifica(){

    }

    @Override
    public double sumar(double n1, double n2) {
        return n1+n2;
    }

    @Override
    public double restar(double n1, double n2) {
        return n1-n2;
    }

    public int factoria(int n){
        if (n==0){
            return 1;
        }else {
            return n*factoria(n-1);
        }
    }
}
