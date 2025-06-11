package dado;

import java.util.Random;

public class Dado {

    private int valorObtenidoDado;
    private int[] valoresObtenidosDado = new int[6];

    public int getValorObtenidoDado() {
        return valorObtenidoDado;
    }

    public void setValorObtenidoDado(int valorObtenidoDado) {
        this.valorObtenidoDado = valorObtenidoDado;
    }

    public int[] getValoresObtenidosDado() {
        return valoresObtenidosDado;
    }

    public void setValorEnPosicion(int posicion, int valor) {
        this.valoresObtenidosDado[posicion] = valor;
    }

    public void setEstadistica(int valorObtenidoDado) {
        this.valoresObtenidosDado[valorObtenidoDado - 1]++;
    }

    public void tirar() {
        Random random = new Random();
        int valorObtenidoDado = random.nextInt(6) + 1;
        this.setValorObtenidoDado(valorObtenidoDado);
        this.setEstadistica(valorObtenidoDado);
    }

    public void resetearEstadisticas() {
        for (int i = 0; i < valoresObtenidosDado.length; i++) {
            this.setValorEnPosicion(i, 0);
        }
    }

}
