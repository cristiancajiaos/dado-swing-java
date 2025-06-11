package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import modelos.DadoModelo;
import vista.Vista;

public class Controlador implements ActionListener {
    private Vista vista;
    private DadoModelo dadoModelo;
    private JLabel[] etiquetasEstadisticas = new JLabel[6];

    public Controlador(Vista vista, DadoModelo dadoModelo) {
        this.vista = vista;
        this.dadoModelo = dadoModelo;
        this.vista.btnTirarDado.addActionListener(this);
        this.vista.btnResetearEstadisticas.addActionListener(this);
    }

    public JLabel[] getEtiquetasEstadisticas() {
        return etiquetasEstadisticas;
    }
    
    public JLabel getEtiquetaEstadistica(int numeroEtiqueta) {
        return etiquetasEstadisticas[numeroEtiqueta];
    }

    public void setEtiquetasEstadisticas(int numeroEtiqueta, JLabel label) {
        this.etiquetasEstadisticas[numeroEtiqueta] = label;
    }
    
    public void cambiarEtiquetaEstadistica(int numeroEtiqueta) {
        int valorActual = Integer.parseInt(this.etiquetasEstadisticas[numeroEtiqueta - 1].getText());
        String nuevoValor = String.valueOf(valorActual + 1);
        this.etiquetasEstadisticas[numeroEtiqueta - 1].setText(nuevoValor);
    }
    
    public void resetearEtiquetaEstadistica(int numeroEtiqueta) {
        this.etiquetasEstadisticas[numeroEtiqueta - 1].setText("0");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnTirarDado) {
            this.tirarDado();
        } else if (e.getSource() == this.vista.btnResetearEstadisticas) {
            this.resetearEstadisticas();
        }
        
    }
    
    public void tirarDado() {
        this.dadoModelo.tirar();
        int valorObtenido = this.dadoModelo.getValorObtenidoDado();
        
        this.setEtiquetasEstadisticas(0, this.vista.etiquetaEstadisticasUno);
        this.setEtiquetasEstadisticas(1, this.vista.etiquetaEstadisticasDos);
        this.setEtiquetasEstadisticas(2, this.vista.etiquetaEstadisticasTres);
        this.setEtiquetasEstadisticas(3, this.vista.etiquetaEstadisticasCuatro);
        this.setEtiquetasEstadisticas(4, this.vista.etiquetaEstadisticasCinco);
        this.setEtiquetasEstadisticas(5, this.vista.etiquetaEstadisticasSeis);
        
        this.cambiarEtiquetaEstadistica(valorObtenido);
    }
    
    public void resetearEstadisticas() {
        this.setEtiquetasEstadisticas(0, this.vista.etiquetaEstadisticasUno);
        this.setEtiquetasEstadisticas(1, this.vista.etiquetaEstadisticasDos);
        this.setEtiquetasEstadisticas(2, this.vista.etiquetaEstadisticasTres);
        this.setEtiquetasEstadisticas(3, this.vista.etiquetaEstadisticasCuatro);
        this.setEtiquetasEstadisticas(4, this.vista.etiquetaEstadisticasCinco);
        this.setEtiquetasEstadisticas(5, this.vista.etiquetaEstadisticasSeis);
        
        for (int i = 0; i < this.etiquetasEstadisticas.length; i++) {
            this.resetearEtiquetaEstadistica(i+1);
        }
    }

    
}
