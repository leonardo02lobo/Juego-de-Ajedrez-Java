package BarraCarga;

////Importacion de los paquetes requeridos
import JuegoAjedrez.Ventana_Inicio;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class BarraCarga extends JFrame {

    //atributos 
    JPanel panel;
    public JLabel etq1, etq2;
    public JProgressBar barra;
    public Timer t;
    ActionListener ac;
    int x = 0;

    //metodo constructor principal
    public BarraCarga() {

        this.setSize(500, 500);
        setTitle("Mini Juego");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        run();
    }

    //metodo de arranque 
    private void run() {

        panel();
        etiqueta();
        barra();

    }

    //metodo para crear el panel
    private void panel() {

        panel = new JPanel();

        panel.setLayout(null);
        this.getContentPane().add(panel);

    }

    //metodo para las etiquetas 
    private void etiqueta() {

        etq1 = new JLabel();

        etq1.setText("JUEGO DE AJEDREZ");
        etq1.setBackground(Color.black);
        etq1.setBounds(80, 100, 400, 40);
        etq1.setFont(new Font("calibri", 0, 40));
        panel.add(etq1);

        etq1 = new JLabel();

        etq1.setText("Cargando...");
        etq1.setBackground(Color.black);
        etq1.setBounds(150, 200, 400, 40);
        etq1.setFont(new Font("calibri", 0, 40));
        panel.add(etq1);

    }

    //metodo para la barra de carga
    private void barra() {

        barra = new JProgressBar();

        barra.setBounds(20, 300, 450, 30);
        barra.setMaximum(100);
        panel.add(barra);
        cargar();

    }

    //esta accion permite que la barra de carga de desplace 
    private void cargar() {

        ac = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                x = x + 1;
                barra.setMaximum(100);
                barra.setValue(x);

                if (barra.getValue() == 100) {
                    dispose();
                    t.stop();
                    Ventana_Inicio v = new Ventana_Inicio();

                    v.setVisible(true);
                }

            }
        };
        t = new Timer(10, ac);
        t.start();
    }
}
