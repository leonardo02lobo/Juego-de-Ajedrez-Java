package JuegoAjedrez;

import javax.swing.JOptionPane;

public class PiezaElegir {
    
    public void Pieza(int n){
        if(n == 0){
            JOptionPane.showMessageDialog(null, "El turno es para las piezas Blancas");
        }else{
            JOptionPane.showMessageDialog(null, "El turno es para las piezas Negras");
        }
    }
}
