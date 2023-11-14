package JuegoAjedrez;

//Importacion de los paquetes requeridos
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana_Juego extends JFrame {

    //atributos necesarios 
    movimiento_De_piezas movi = new movimiento_De_piezas();
    PiezaElegir elegir = new PiezaElegir();
    final int ancho = 25, largo = 25;
    boolean reinaBlanca = true, reinaNegra = true;
    int pieza = 0, posPieza1FilaBlanca = 8, posPieza1colBlanca = 1,
            posPieza2FilaBlanca = 8, posPieza2colBlanca = 3, posPieza3FilaBlanca = 8, posPieza3colBlanca = 5,
            posPieza4FilaBlanca = 8, posPieza4colBlanca = 7,
            posPieza1FilaNegra = 1, posPieza1colNegra = 2,
            posPieza2FilaNegra = 1, posPieza2colNegra = 4, posPieza3FilaNegra = 1, posPieza3colNegra = 6,
            posPieza4FilaNegra = 1, posPieza4colNegra = 8, piezaMovida = 0, vidasNegras = 4, vidasBlancas = 4,
            cambioReinaBlanca = 0,cambioReinaNegra = 0;
    JPanel panel, panel2T;
    JTextField txtFilaJ1, txtColJ1, txtFilaJ2, txtColJ2;
    JLabel lbJugador1, lbJugador2, lbPiezasJugar, lbPiezasMover, lbFilaJugar,
            lbColJugar, lbFilaMover, lbColMover, lbImagen, peones1, peones2,
            peones3, peones4, peonesN1, peonesN2, peonesN3, peonesN4, tablero1;
    ImageIcon lbPeonBlanco, lbPeonNegro, tablero;
    JButton btnMover;
    String jugador1, jugador2, Jugador = "Blanca";

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
        lbPeonBlanco = new ImageIcon("imagenes/peon1.gif");
        peones1 = new JLabel();
        peones1.setBounds(45, 50, ancho, largo);
        peones1.setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peones1.getWidth(), peones1.getHeight(), Image.SCALE_SMOOTH)));
        panel2T.add(peones1);

        lbPeonBlanco = new ImageIcon("imagenes/peon1.gif");
        peones2 = new JLabel();
        peones2.setBounds(130, 50, ancho, largo);
        peones2.setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peones2.getWidth(), peones2.getHeight(), Image.SCALE_SMOOTH)));
        panel2T.add(peones2);

        lbPeonBlanco = new ImageIcon("imagenes/peon1.gif");
        peones3 = new JLabel();
        peones3.setBounds(210, 50, ancho, largo);
        peones3.setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peones3.getWidth(), peones3.getHeight(), Image.SCALE_SMOOTH)));
        panel2T.add(peones3);

        lbPeonBlanco = new ImageIcon("imagenes/peon1.gif");
        peones4 = new JLabel();
        peones4.setBounds(290, 50, ancho, largo);
        peones4.setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peones4.getWidth(), peones4.getHeight(), Image.SCALE_SMOOTH)));
        panel2T.add(peones4);

        //llamar los peones Negros
        lbPeonNegro = new ImageIcon("imagenes/peon2.gif");
        peonesN1 = new JLabel();
        peonesN1.setBounds(80, 340, ancho, largo);
        peonesN1.setIcon(new ImageIcon(lbPeonNegro.getImage().getScaledInstance(peonesN1.getWidth(), peonesN1.getHeight(), Image.SCALE_SMOOTH)));
        panel2T.add(peonesN1);

        lbPeonNegro = new ImageIcon("imagenes/peon2.gif");
        peonesN2 = new JLabel();
        peonesN2.setBounds(160, 340, ancho, largo);
        peonesN2.setIcon(new ImageIcon(lbPeonNegro.getImage().getScaledInstance(peonesN2.getWidth(), peonesN2.getHeight(), Image.SCALE_SMOOTH)));
        panel2T.add(peonesN2);

        lbPeonNegro = new ImageIcon("imagenes/peon2.gif");
        peonesN3 = new JLabel();
        peonesN3.setBounds(240, 340, ancho, largo);
        peonesN3.setIcon(new ImageIcon(lbPeonNegro.getImage().getScaledInstance(peonesN3.getWidth(), peonesN3.getHeight(), Image.SCALE_SMOOTH)));
        panel2T.add(peonesN3);

        lbPeonNegro = new ImageIcon("imagenes/peon2.gif");
        peonesN4 = new JLabel();
        peonesN4.setBounds(320, 340, ancho, largo);
        peonesN4.setIcon(new ImageIcon(lbPeonNegro.getImage().getScaledInstance(peonesN4.getWidth(), peonesN4.getHeight(), Image.SCALE_SMOOTH)));
        panel2T.add(peonesN4);

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
        panel2T.add(peones1);
        panel2T.add(peones2);
        panel2T.add(peones3);
        panel2T.add(peones4);
        panel2T.add(peonesN1);
        panel2T.add(peonesN2);
        panel2T.add(peonesN3);
        panel2T.add(peonesN4);
        panel2T.add(tablero1);
        panel2T.revalidate();
        panel2T.repaint();
        txtFilaJ1.setText("");
        txtFilaJ2.setText("");
        txtColJ1.setText("");
        txtColJ2.setText("");
    }

    private void cambioAReinaBlanca(int col2) {

        if (posPieza1FilaBlanca == 1 && (col2 == 1 || col2 == 2 || col2 == 3 || col2 == 4
                || col2 == 5 || col2 == 6 || col2 == 7 || col2 == 8)) {
            lbPeonBlanco = new ImageIcon("imagenes/reina1.gif");
            peones1.setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peones1.getWidth(), peones1.getHeight(), Image.SCALE_SMOOTH)));
            reinaBlanca = false;
            cambioReinaBlanca = 1;
        } else if (posPieza2FilaBlanca == 1 && (col2 == 1 || col2 == 2 || col2 == 3 || col2 == 4
                || col2 == 5 || col2 == 6 || col2 == 7 || col2 == 8)) {
            lbPeonBlanco = new ImageIcon("imagenes/reina1.gif");
            peones2.setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peones1.getWidth(), peones1.getHeight(), Image.SCALE_SMOOTH)));
            reinaBlanca = false;
            cambioReinaBlanca = 2;
        } else if (posPieza3FilaBlanca == 1 && (col2 == 1 || col2 == 2 || col2 == 3 || col2 == 4
                || col2 == 5 || col2 == 6 || col2 == 7 || col2 == 8)) {
            lbPeonBlanco = new ImageIcon("imagenes/reina1.gif");
            peones3.setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peones1.getWidth(), peones1.getHeight(), Image.SCALE_SMOOTH)));
            reinaBlanca = false;
            cambioReinaBlanca = 3;
        } else if (posPieza4FilaBlanca == 1 && (col2 == 1 || col2 == 2 || col2 == 3 || col2 == 4
                || col2 == 5 || col2 == 6 || col2 == 7 || col2 == 8)) {
            lbPeonBlanco = new ImageIcon("imagenes/reina1.gif");
            peones4.setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peones1.getWidth(), peones1.getHeight(), Image.SCALE_SMOOTH)));
            reinaBlanca = false;
            cambioReinaBlanca = 4;
        }
    }

    private void cambioAReinaNegra(int col2) {

        if (posPieza1FilaNegra == 8 && (col2 == 1 || col2 == 2 || col2 == 3 || col2 == 4
                || col2 == 5 || col2 == 6 || col2 == 7 || col2 == 8)) {
            lbPeonNegro = new ImageIcon("imagenes/reina2.gif");
            peonesN1.setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peones1.getWidth(), peones1.getHeight(), Image.SCALE_SMOOTH)));
            reinaNegra = false;
            cambioReinaNegra = 1;
        } else if (posPieza2FilaNegra == 8 && (col2 == 1 || col2 == 2 || col2 == 3 || col2 == 4
                || col2 == 5 || col2 == 6 || col2 == 7 || col2 == 8)) {
            lbPeonNegro = new ImageIcon("imagenes/reina2.gif");
            peonesN2.setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peones1.getWidth(), peones1.getHeight(), Image.SCALE_SMOOTH)));
            reinaNegra = false;
            cambioReinaNegra = 2;
        } else if (posPieza3FilaNegra == 8 && (col2 == 1 || col2 == 2 || col2 == 3 || col2 == 4
                || col2 == 5 || col2 == 6 || col2 == 7 || col2 == 8)) {
            lbPeonNegro = new ImageIcon("imagenes/reina2.gif");
            peonesN3.setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peones1.getWidth(), peones1.getHeight(), Image.SCALE_SMOOTH)));
            reinaNegra = false;
            cambioReinaNegra = 3;
        } else if (posPieza4FilaNegra == 8 && (col2 == 1 || col2 == 2 || col2 == 3 || col2 == 4
                || col2 == 5 || col2 == 6 || col2 == 7 || col2 == 8)) {
            lbPeonNegro = new ImageIcon("imagenes/reina2.gif");
            peonesN4.setIcon(new ImageIcon(lbPeonBlanco.getImage().getScaledInstance(peones1.getWidth(), peones1.getHeight(), Image.SCALE_SMOOTH)));
            reinaNegra = false;
            cambioReinaNegra = 4;
        }
    }

    private void piezaBlanca(int fila1, int fila2, int col1, int col2, int posX, int posY) {
        if (posPieza1FilaBlanca == fila1 && posPieza1colBlanca == col1) {
            if (fila1 == (fila2 - 2) && col2 == (col1 - 2) || fila2 == (fila1 - 2) && col2 == (col1 + 2)) {//para comer piezas
                SeComeLaPieza(fila1, fila2, col1, col2);
                peones1.setBounds(posX, posY, ancho, largo);
                posPieza1FilaBlanca = fila2;
                posPieza1colBlanca = col2;
            } else if (fila1 == (fila2 + 1) && col1 == col2) {//para mover las piezas
                peones1.setBounds(posX, posY, ancho, largo);
                posPieza1FilaBlanca = fila2;
                posPieza1colBlanca = col2;
            } else if (fila1 == fila2 && col1 == col2) {
                JOptionPane.showMessageDialog(null, "No se puede mover en la misma casilla");
            } else {
                JOptionPane.showMessageDialog(null, "los peones solo se pueden mover una casilla");
            }
        } else if (posPieza2FilaBlanca == fila1 && posPieza2colBlanca == col1) {
            if (fila1 == (fila2 - 2) && col2 == (col1 - 2) || fila2 == (fila1 - 2) && col2 == (col1 + 2)) {
                SeComeLaPieza(fila1, fila2, col1, col2);
                peones2.setBounds(posX, posY, ancho, largo);
                posPieza2FilaBlanca = fila2;
                posPieza2colBlanca = col2;
            } else if (fila1 == (fila2 + 1) && col1 == col2) {
                peones2.setBounds(posX, posY, ancho, largo);
                posPieza2FilaBlanca = fila2;
                posPieza2colBlanca = col2;
            } else if (fila1 == fila2 && col1 == col2) {
                JOptionPane.showMessageDialog(null, "No se puede mover en la misma casilla");
            } else {
                JOptionPane.showMessageDialog(null, "los peones solo se pueden mover una casilla");
            }

        } else if (posPieza3FilaBlanca == fila1 && posPieza3colBlanca == col1) {
            if (fila1 == (fila2 - 2) && col2 == (col1 - 2) || fila2 == (fila1 - 2) && col2 == (col1 + 2)) {
                SeComeLaPieza(fila1, fila2, col1, col2);
                peones3.setBounds(posX, posY, ancho, largo);
                posPieza3FilaBlanca = fila2;
                posPieza3colBlanca = col2;
            } else if (fila1 == (fila2 + 1) && col1 == col2) {
                peones3.setBounds(posX, posY, ancho, largo);
                posPieza3FilaBlanca = fila2;
                posPieza3colBlanca = col2;
            } else if (fila1 == fila2 && col1 == col2) {
                JOptionPane.showMessageDialog(null, "No se puede mover en la misma casilla");
            } else {
                JOptionPane.showMessageDialog(null, "los peones solo se pueden mover una casilla");
            }

        } else if (posPieza4FilaBlanca == fila1 && posPieza4colBlanca == col1) {
            if (fila1 == (fila2 - 2) && col2 == (col1 - 2) || fila2 == (fila1 - 2) && col2 == (col1 + 2)) {
                SeComeLaPieza(fila1, fila2, col1, col2);
                peones4.setBounds(posX, posY, ancho, largo);
                posPieza4FilaBlanca = fila2;
                posPieza4colBlanca = col2;
            } else if (fila1 == (fila2 + 1) && col1 == col2) {
                peones4.setBounds(posX, posY, ancho, largo);
                posPieza4FilaBlanca = fila2;
                posPieza4colBlanca = col2;
            } else if (fila1 == fila2 && col1 == col2) {
                JOptionPane.showMessageDialog(null, "No se puede mover en la misma casilla");
            } else {
                JOptionPane.showMessageDialog(null, "los peones solo se pueden mover una casilla");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay una pieza en esta casilla");
        }

        if (reinaBlanca) {
            cambioAReinaBlanca(col2);
        }
    }

    private void piezaMiCompaElErik(int fila1, int fila2, int col1, int col2, int posX, int posY) {
        if (posPieza1FilaNegra == fila1 && posPieza1colNegra == col1) {
            if (fila1 == (fila2 - 2) && col2 == (col1 - 2) || fila2 == (fila1 - 2) && col2 == (col1 + 2)) {
                SeComeLaPieza(fila1, fila2, col1, col2);
                peonesN1.setBounds(posX, posY, ancho, largo);
                posPieza1FilaNegra = fila2;
                posPieza1colNegra = col2;
            } else if ((fila1 + 1) == fila2 && col1 == col2) {
                peonesN1.setBounds(posX, posY, ancho, largo);
                posPieza1FilaNegra = fila2;
                posPieza1colNegra = col2;
            } else if (fila1 == fila2 && col1 == col2) {
                JOptionPane.showMessageDialog(null, "No se puede mover en la misma casilla");
            } else {
                JOptionPane.showMessageDialog(null, "los peones solo se pueden mover una casilla");
            }

        } else if (posPieza2FilaNegra == fila1 && posPieza2colNegra == col1) {

             if (fila1 == (fila2 - 2) && col2 == (col1 - 2) || fila2 == (fila1 - 2) && col2 == (col1 + 2)) {
                SeComeLaPieza(fila1, fila2, col1, col2);
                peonesN2.setBounds(posX, posY, ancho, largo);
                posPieza2FilaNegra = fila2;
                posPieza2colNegra = col2;
            } else if ((fila1 + 1) == fila2 && col1 == col2) {
                peonesN2.setBounds(posX, posY, ancho, largo);
                posPieza2FilaNegra = fila2;
                posPieza2colNegra = col2;
            } else if (fila1 == fila2 && col1 == col2) {
                JOptionPane.showMessageDialog(null, "No se puede mover en la misma casilla");
            } else {
                JOptionPane.showMessageDialog(null, "los peones solo se pueden mover una casilla");
            }

        } else if (posPieza3FilaNegra == fila1 && posPieza3colNegra == col1) {
            if (fila1 == (fila2 - 2) && col2 == (col1 - 2) || fila2 == (fila1 - 2) && col2 == (col1 + 2)) {
                SeComeLaPieza(fila1, fila2, col1, col2);
                peonesN3.setBounds(posX, posY, ancho, largo);
                posPieza3FilaNegra = fila2;
                posPieza3colNegra = col2;
            } else if ((fila1 + 1) == fila2 && col1 == col2) {
                peonesN3.setBounds(posX, posY, ancho, largo);
                posPieza3FilaNegra = fila2;
                posPieza3colNegra = col2;
            } else if (fila1 == fila2 && col1 == col2) {
                JOptionPane.showMessageDialog(null, "No se puede mover en la misma casilla");
            } else {
                JOptionPane.showMessageDialog(null, "los peones solo se pueden mover una casilla");
            }

        } else if (posPieza4FilaNegra == fila1 && posPieza4colNegra == col1) {
             if (fila1 == (fila2 - 2) && col2 == (col1 - 2) || fila2 == (fila1 - 2) && col2 == (col1 + 2)) {
                SeComeLaPieza(fila1, fila2, col1, col2);
                peonesN4.setBounds(posX, posY, ancho, largo);
                posPieza4FilaNegra = fila2;
                posPieza4colNegra = col2;
            } else if ((fila1 + 1) == fila2 && col1 == col2) {
                peonesN4.setBounds(posX, posY, ancho, largo);
                posPieza4FilaNegra = fila2;
                posPieza4colNegra = col2;
            } else if (fila1 == fila2 && col1 == col2) {
                JOptionPane.showMessageDialog(null, "No se puede mover en la misma casilla");
            } else {
                JOptionPane.showMessageDialog(null, "los peones solo se pueden mover una casilla");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay una pieza en esta casilla");
        }
        if (reinaNegra) {
            cambioAReinaNegra(col2);
        }
    }

    private void SeComeLaPieza(int fila1, int fila2, int col1, int col2) {
        if ((fila1 - 1) == (fila2 + 1) && (col1 + 1) == (col2 - 1)) {
            if ((posPieza1FilaNegra == fila2 + 1) && (posPieza1colNegra == col2 - 1)) {
                peonesN1.setBounds(0, 0, ancho, largo);
                vidasNegras--;
            } else if ((posPieza2FilaNegra == fila2 + 1) && (posPieza2colNegra == col2 - 1)) {
                peonesN2.setBounds(30, 0, ancho, largo);
                vidasNegras--;
            } else if ((posPieza3FilaNegra == fila2 + 1) && (posPieza3colNegra == col2 - 1)) {
                peonesN3.setBounds(60, 0, ancho, largo);
                vidasNegras--;
            } else if ((posPieza4FilaNegra == fila2 + 1) && (posPieza4colNegra == col2 - 1)) {
                peonesN4.setBounds(90, 0, ancho, largo);
                vidasNegras--;
            }
        } else if ((fila1 + 1) == (fila2 - 1) && (col1 - 1) == (col2 + 1)) {
            if ((posPieza1FilaBlanca == fila2 - 1) && (posPieza1colBlanca == col2 + 1)) {
                peones1.setBounds(180, 0, ancho, largo);
                vidasBlancas--;
            } else if ((posPieza2FilaBlanca == fila2 - 1) && (posPieza2colBlanca == col2 + 1)) {
                peones2.setBounds(210, 0, ancho, largo);
                vidasBlancas--;
            } else if ((posPieza3FilaBlanca == fila2 - 1) && (posPieza3colBlanca == col2 + 1)) {
                peones3.setBounds(240, 0, ancho, largo);
                vidasBlancas--;
            } else if ((posPieza4FilaBlanca == fila2 - 1) && (posPieza4colBlanca == col2 + 1)) {
                peones4.setBounds(270, 0, ancho, largo);
                vidasBlancas--;
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
