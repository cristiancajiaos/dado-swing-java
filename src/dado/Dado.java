package dado;

import java.util.Random;

public class Dado {

    private int valorObtenidoDado;
    private int totalLanzamientos;
    private int[] valoresObtenidosDado = new int[6];

    public int getValorObtenidoDado() {
        return valorObtenidoDado;
    }

    public void setValorObtenidoDado(int valorObtenidoDado) {
        this.valorObtenidoDado = valorObtenidoDado;
    }
    
    public int getTotalLanzamientos() {
        return totalLanzamientos;
    }

    public void setTotalLanzamientos(int totalLanzamientos) {
        this.totalLanzamientos = totalLanzamientos;
    }

    public int[] getValoresObtenidosDado() {
        return valoresObtenidosDado;
    }

    public void setValorEnPosicion(int posicion, int valor) {
        this.valoresObtenidosDado[posicion] = valor;
    }
    
    public int getValorEnPosicion(int posicion) {
        return this.valoresObtenidosDado[posicion - 1];
    }

    public void setEstadistica(int valorObtenidoDado) {
        this.valoresObtenidosDado[valorObtenidoDado - 1]++;
    }

    public void tirar() {
        Random random = new Random();
        int valorObtenidoDado = random.nextInt(6) + 1;
        this.setValorObtenidoDado(valorObtenidoDado);
        this.setTotalLanzamientos(this.getTotalLanzamientos() + 1);
        this.setEstadistica(valorObtenidoDado);
    }

    public void resetearEstadisticas() {
        for (int i = 0; i < valoresObtenidosDado.length; i++) {
            this.setValorEnPosicion(i, 0);
        }
        this.setTotalLanzamientos(0);
    }

}
