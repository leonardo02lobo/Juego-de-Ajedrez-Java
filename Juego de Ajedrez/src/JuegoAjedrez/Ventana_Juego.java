package JuegoAjedrez;

//Importacion de los paquetes requeridos
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventana_Juego extends JFrame {

    //atributos necesarios 
    movimiento_De_piezas movi = new movimiento_De_piezas();
    PiezaElegir elegir = new PiezaElegir();
    final int ancho = 25, largo = 25;
    boolean reinaBlanca = true, reinaNegra = true;
    int[] posPiezasFilasBlancas = {8, 8, 8, 8}, posPiezasColumnasBlancas = {1, 3, 5, 7},
            posPiezasFilasNegros = {1, 1, 1, 1}, posPiezasColumnasNegras = {2, 4, 6, 8};
    int pieza = 0, piezaMovida = 0, vidasNegras = 4, vidasBlancas = 4,
            cambioReinaBlanca = 0, cambioReinaNegra = 0, xBlanco = 0, xNegro = 180;
    JPanel panel, panel2T;
    JTextField txtFilaJ1, txtColJ1, txtFilaJ2, txtColJ2;
    JLabel lbJugador1, lbJugador2, lbPiezasJugar, lbPiezasMover, lbFilaJugar,
            lbColJugar, lbFilaMover, lbColMover, lbImagen, tablero1;
    ImageIcon lbPeonBlanco = new ImageIcon("imagenes/peon1.gif"), lbPeonNegro = new ImageIcon("imagenes/peon2.gif"), tablero;
    JButton btnMover;
    String jugador1, jugador2, Jugador = "Blanca";
    JLabel[] peonesBlancos = new JLabel[4], peonesNegros = new JLabel[4];

    //constructor principal para inicializar el JFrame
    public Ventana_Juego() {

        super.setSize(800, 440);
        super.setTitle("Juego de Ajedrez Leonardo Lobo");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        run();
    }

    //metodo para llamar/cargar los demas metodos 
    private void run() {

        panel();
        etiquetas();
        cajatexto();
        boton();
        imagenes();

    }

    //metodo setter para traer los nombres de la ventana de inicio
    public void setJugador(String jugador1, String jugador2) {
        this.jugador1 = jugador1;
        lbJugador1.setText(jugador1);
        this.jugador2 = jugador2;
        lbJugador2.setText(jugador2);

    }

    //metodo para implementar dos paneles 
    //uno para los componenetes y otro para el trablero y las piezas
    private void panel() {

        //llamar al panel de los componentes 
        panel = new JPanel();

        panel.setLayout(null);
        this.getContentPane().add(panel);

        //llamar el panel del tablero
        panel2T = new JPanel();

        panel2T.setBounds(0, 0, 400, 400);
        panel2T.setLayout(null);
        panel.add(panel2T);

    }

    //metodo para cargar las piezas y el tablero 
    public void imagenes() {

        //llamar los peones Blancos     
        int xBlanco = 45;

        for (int i = 0; i < peonesBlancos.length; i++) {
            peonesBlancos[i] = new JLabel(lbPeonBlanco);
            peonesBlancos[i].setBounds(xBlanco, 50, ancho, largo);
            panel2T.add(peonesBlancos[i]);
            xBlanco += 80;
        }

        int xNegro = 80;

        for (int i = 0; i < peonesNegros.length; i++) {
            peonesNegros[i] = new JLabel(lbPeonNegro);
            peonesNegros[i].setBounds(xNegro, 340, ancho, largo);
            panel2T.add(peonesNegros[i]);
            xNegro += 80;
        }

        //llamar al Tablero
        tablero = new ImageIcon("imagenes/tablero.jpg");
        tablero1 = new JLabel();
        tablero1.setBounds(0, 0, 400, 400);
        tablero1.setIcon(new ImageIcon(tablero.getImage().getScaledInstance(tablero1.getWidth(), tablero1.getHeight(), Image.SCALE_SMOOTH)));
        panel2T.add(tablero1);

    }

    //metodo que contiene las etiquetas de texto
    private void etiquetas() {

        JLabel txtj1 = new JLabel();

        txtj1.setText("jugador 1: ");
        txtj1.setBounds(450, 20, 200, 20);
        panel.add(txtj1);

        JLabel txtj2 = new JLabel();

        txtj2.setText("jugador 2: ");
        txtj2.setBounds(650, 20, 200, 20);
        panel.add(txtj2);

        lbJugador1 = new JLabel();

        lbJugador1.setText(jugador1);
        lbJugador1.setBounds(510, 20, 200, 20);
        panel.add(lbJugador1);

        lbJugador2 = new JLabel();

        lbJugador2.setText(jugador2);
        lbJugador2.setBounds(710, 20, 200, 20);
        panel.add(lbJugador2);

        lbPiezasJugar = new JLabel();

        lbPiezasJugar.setText("Pieza a Jugar : " + Jugador);
        lbPiezasJugar.setBounds(450, 50, 300, 20);
        lbPiezasJugar.setFont(new Font("calibiri", 1, 15));
        panel.add(lbPiezasJugar);

        lbFilaJugar = new JLabel();

        lbFilaJugar.setText("Fila: ");
        lbFilaJugar.setBounds(410, 100, 50, 20);
        panel.add(lbFilaJugar);

        lbFilaMover = new JLabel();

        lbFilaMover.setText("Columna: ");
        lbFilaMover.setBounds(540, 100, 80, 20);
        panel.add(lbFilaMover);

        lbPiezasMover = new JLabel();

        lbPiezasMover.setText("A donde quiere mover");
        lbPiezasMover.setBounds(450, 150, 200, 20);
        lbPiezasMover.setFont(new Font("calibiri", 1, 15));
        panel.add(lbPiezasMover);

        lbColJugar = new JLabel();

        lbColJugar.setText("Fila: ");
        lbColJugar.setBounds(410, 200, 50, 20);
        panel.add(lbColJugar);

        lbColMover = new JLabel();

        lbColMover.setText("Columna: ");
        lbColMover.setBounds(540, 200, 80, 20);
        panel.add(lbColMover);

    }

    //metodo para las cajas de texto que permiten ingresar las posiciones de las piezas
    private void cajatexto() {

        txtFilaJ1 = new JTextField();

        txtFilaJ1.setBounds(450, 100, 50, 20);
        panel.add(txtFilaJ1);

        txtColJ1 = new JTextField();

        txtColJ1.setBounds(600, 100, 50, 20);
        panel.add(txtColJ1);

        txtFilaJ2 = new JTextField();

        txtFilaJ2.setBounds(450, 200, 50, 20);
        panel.add(txtFilaJ2);

        txtColJ2 = new JTextField();

        txtColJ2.setBounds(600, 200, 50, 20);
        panel.add(txtColJ2);

        accionControlar1();
        accionControlar2();
        accionControlar3();
        accionControlar4();
    }

    //metodo para el boton de mover las piezas
    private void boton() {

        btnMover = new JButton();

        btnMover.setText("Mover");
        btnMover.setBounds(700, 150, 80, 30);
        panel.add(btnMover);
        accionMover();

    }

    //las siguientes 4 acciones hacen exactamente lo mismo
    //esta accion permite el control al momento de ingresar una letra o mas de un numero en la posicion de las piezas
    private void accionControlar1() {

        KeyListener evento = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();

                if (c < '1' || c > '8') {

                    getToolkit().beep();
                    e.consume();
                }
                if (txtFilaJ1.getText().length() >= 1) {
                    e.consume();
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        txtFilaJ1.addKeyListener(evento);
    }

    private void accionControlar2() {

        KeyListener evento = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();

                if (c < '1' || c > '8') {

                    getToolkit().beep();
                    e.consume();
                }
                if (txtFilaJ2.getText().length() >= 1) {
                    e.consume();
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        txtFilaJ2.addKeyListener(evento);
    }

    private void accionControlar3() {

        KeyListener evento = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();

                if (c < '1' || c > '8') {

                    getToolkit().beep();
                    e.consume();
                }
                if (txtColJ1.getText().length() >= 1) {
                    e.consume();
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        txtColJ1.addKeyListener(evento);
    }

    private void accionControlar4() {

        KeyListener evento = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();

                if (c < '1' || c > '8') {

                    getToolkit().beep();
                    e.consume();
                }
                if (txtColJ2.getText().length() >= 1) {
                    e.consume();
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        txtColJ2.addKeyListener(evento);
    }

    //esta accion de tipo MouseListener permite el moviemiento de las piezas en dichas posiciones 
    private void accionMover() {
        MouseAdapter evento = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel2T.removeAll();

                int fila1 = Integer.parseInt(txtFilaJ1.getText());
                int fila2 = Integer.parseInt(txtFilaJ2.getText());
                int col1 = Integer.parseInt(txtColJ1.getText());
                int col2 = Integer.parseInt(txtColJ2.getText());
                int posY = movi.movimientoY(fila2);
                int posX = movi.movimientoX(col2);

                if (pieza == 0) {
                    piezaBlanca(fila1, fila2, col1, col2, posX, posY);
                } else {
                    piezaMiCompaElErik(fila1, fila2, col1, col2, posX, posY);
                }
                cambiarTurno();
                elegir.Pieza(pieza);
                Posicion();
                victoria();
            }
        };
        btnMover.addMouseListener(evento);

    }

    private void cambiarTurno() {
        lbPiezasJugar.removeAll();
        if (pieza == 0) {
            Jugador = "Negra";
            lbPiezasJugar.setText("Pieza a Jugar : " + Jugador);
            pieza = 1;
        } else if (pieza == 1) {
            Jugador = "Blanca";
            lbPiezasJugar.setText("Pieza a Jugar : " + Jugador);
            pieza = 0;
        }
        lbColJugar.revalidate();
        lbColJugar.repaint();
    }

    private void Posicion() {

        for (int i = 0; i < peonesBlancos.length; i++) {
            panel2T.add(peonesBlancos[i]);
        }
        for (int i = 0; i < peonesNegros.length; i++) {
            panel2T.add(peonesNegros[i]);
        }
        panel2T.add(tablero1);
        panel2T.revalidate();
        panel2T.repaint();
        txtFilaJ1.setText("");
        txtFilaJ2.setText("");
        txtColJ1.setText("");
        txtColJ2.setText("");
    }

    private void cambioAReinaBlanca(int col2) {

        for (int i = 0; i < posPiezasFilasBlancas.length; i++) {
            if (posPiezasFilasBlancas[i] == 1 && (col2 == 1 || col2 == 2 || col2 == 3 || col2 == 4
                    || col2 == 5 || col2 == 6 || col2 == 7 || col2 == 8)) {
                lbPeonBlanco = new ImageIcon("imagenes/reina1.gif");
                peonesBlancos[i].setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peonesBlancos[i].getWidth(), peonesBlancos[i].getHeight(), Image.SCALE_SMOOTH)));
                reinaBlanca = false;
                cambioReinaBlanca = i;
            }
        }
    }

    private void cambioAReinaNegra(int col2) {

        for (int i = 0; i < posPiezasFilasNegros.length; i++) {
            if (posPiezasFilasNegros[i] == 8 && (col2 == 1 || col2 == 2 || col2 == 3 || col2 == 4
                    || col2 == 5 || col2 == 6 || col2 == 7 || col2 == 8)) {
                lbPeonNegro = new ImageIcon("imagenes/reina2.gif");
                peonesNegros[i].setIcon(new ImageIcon(lbPeonNegro.getImage().getScaledInstance(peonesNegros[i].getWidth(), peonesNegros[i].getHeight(), Image.SCALE_SMOOTH)));
                reinaNegra = false;
                cambioReinaNegra = i;
            }
        }
    }

    public void piezaBlanca(int fila1, int fila2, int col1, int col2, int posX, int posY) {

        for (int i = 0; i < posPiezasFilasBlancas.length; i++) {
            if (posPiezasFilasBlancas[i] == fila1 && posPiezasColumnasBlancas[i] == col1) {
                if (fila1 == (fila2 - 2) && col2 == (col1 - 2) || fila2 == (fila1 - 2) && col2 == (col1 + 2)) {//para comer piezas
                    SeComeLaPieza(fila1, fila2, col1, col2);
                    peonesBlancos[i].setBounds(posX, posY, ancho, largo);
                    posPiezasFilasBlancas[i] = fila2;
                    posPiezasColumnasBlancas[i] = col2;
                } else if (fila1 == (fila2 + 1) && col1 == col2) {//para mover las piezas
                    peonesBlancos[i].setBounds(posX, posY, ancho, largo);
                    posPiezasFilasBlancas[i] = fila2;
                    posPiezasColumnasBlancas[i] = col2;
                } else if (fila1 == fila2 && col1 == col2) {
                    JOptionPane.showMessageDialog(null, "No se puede mover en la misma casilla");
                } else {
                    JOptionPane.showMessageDialog(null, "los peones solo se pueden mover una casilla");
                }
            }
        }
        if (reinaBlanca) {
            cambioAReinaBlanca(col2);
        }
    }

    private void piezaMiCompaElErik(int fila1, int fila2, int col1, int col2, int posX, int posY) {
        for (int i = 0; i < posPiezasFilasNegros.length; i++) {
            if (posPiezasFilasNegros[i] == fila1 && posPiezasColumnasNegras[i] == col1) {
                if (fila1 == (fila2 - 2) && col2 == (col1 - 2) || fila2 == (fila1 - 2) && col2 == (col1 + 2)) {
                    SeComeLaPieza(fila1, fila2, col1, col2);
                    peonesNegros[i].setBounds(posX, posY, ancho, largo);
                    posPiezasFilasNegros[i] = fila2;
                    posPiezasColumnasNegras[i] = col2;
                } else if ((fila1 + 1) == fila2 && col1 == col2) {
                    peonesNegros[i].setBounds(posX, posY, ancho, largo);
                    posPiezasFilasNegros[i] = fila2;
                    posPiezasColumnasNegras[i] = col2;
                } else if (fila1 == fila2 && col1 == col2) {
                    JOptionPane.showMessageDialog(null, "No se puede mover en la misma casilla");
                } else {
                    JOptionPane.showMessageDialog(null, "los peones solo se pueden mover una casilla");
                }

            }
        }

        if (reinaNegra) {
            cambioAReinaNegra(col2);
        }
    }

    private void SeComeLaPieza(int fila1, int fila2, int col1, int col2) {

        for (int i = 0; i < posPiezasFilasBlancas.length; i++) {
            if ((fila1 - 1) == (fila2 + 1) && (col1 + 1) == (col2 - 1)) {

                if ((posPiezasFilasNegros[i] == fila2 + 1) && (posPiezasColumnasNegras[i] == col2 - 1)) {
                    peonesNegros[i].setBounds(xBlanco, 0, ancho, largo);
                    vidasNegras--;
                    xBlanco += 30;
                }
            } else if ((fila1 + 1) == (fila2 - 1) && (col1 - 1) == (col2 + 1)) {

                if ((posPiezasFilasBlancas[i] == fila2 - 1) && (posPiezasColumnasBlancas[i] == col2 + 1)) {
                    peonesBlancos[i].setBounds(xNegro, 0, ancho, largo);
                    vidasBlancas--;
                    xNegro += 30;
                }
            }
        }

    }

    private void victoria() {
        if (vidasBlancas == 0) {
            JOptionPane.showMessageDialog(null, "Ganaron las piezas Negras");
            dispose();
        }
        if (vidasNegras == 0) {
            JOptionPane.showMessageDialog(null, "Ganaron las piezas Blancas");
            dispose();
        }

    }
}
