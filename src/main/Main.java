package main;

import controladores.Controlador;
import modelos.DadoModelo;
import vista.Vista;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        DadoModelo dadoModelo = new DadoModelo();
        Controlador controlador = new Controlador(vista, dadoModelo);
        vista.setVisible(true);
    }
    
}
