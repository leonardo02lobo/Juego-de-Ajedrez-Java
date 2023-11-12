package JuegoAjedrez;

//Importacion de los paquetes requeridos
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana_Inicio extends JFrame {

    //Atributos 
    JPanel panel;
    JLabel lbJugador1, lbJugador2;
    JTextField txtJugador1, txtJugador2;
    JButton btnIniciar;
    public String jugador1, jugador2;

    //metodo constructor prioncipal
    public Ventana_Inicio() {

        this.setSize(613, 346);
        setTitle("Juego de Ajedrez Leonardo Lobo");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        run();

    }

    //metodo que ejecuta todo
    private void run() {

        Panel();
        Boton();
        Etiquetas();
        CajaTexto();

    }

    //metodo para crear el panel
    private void Panel() {

        panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.gray);
        this.getContentPane().add(panel);
        panel.setFocusable(true);

    }

    //metodo para crear etiquetas en le panel 
    private void Etiquetas() {

        lbJugador1 = new JLabel();

        lbJugador1.setText("Jugador 1");
        lbJugador1.setBounds(150, 80, 100, 20);
        lbJugador1.setFont(new Font("calibri", 0, 20));
        panel.add(lbJugador1);

        lbJugador2 = new JLabel();

        lbJugador2.setText("Jugador 2");
        lbJugador2.setBounds(350, 80, 100, 20);
        lbJugador2.setFont(new Font("calibri", 0, 20));
        panel.add(lbJugador2);

    }

    //metodo para crear las cajas de Texto 
    private void CajaTexto() {

        txtJugador1 = new JTextField();

        txtJugador1.setText("");
        txtJugador1.setBounds(150, 120, 130, 20);
        panel.add(txtJugador1);
        jugador1 = txtJugador1.getText();

        txtJugador2 = new JTextField();

        txtJugador2.setText("");
        txtJugador2.setBounds(350, 120, 130, 20);
        panel.add(txtJugador2);

    }

    //metodo para crear el boton de ingreso al juego
    private void Boton() {

        btnIniciar = new JButton();

        btnIniciar.setText("Iniciar Juego");
        btnIniciar.setBounds(230, 200, 150, 40);
        btnIniciar.setFont(new Font("calibri", 0, 20));
        panel.add(btnIniciar);
        accionComprobar();
    }

    //esta accion comprueba si las dos cajas de texto estan llenas 
    private void accionComprobar() {

        MouseListener evento = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (txtJugador1.getText().isEmpty() || txtJugador2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltan datos a rellenar");
                } else {
                    if (btnIniciar.isEnabled()) {
                        Ventana_Juego juego = new Ventana_Juego();
                        juego.setJugador(txtJugador1.getText(), txtJugador2.getText());
                        juego.setVisible(true);
                        dispose();

                    }
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        btnIniciar.addMouseListener(evento);
    }
}
