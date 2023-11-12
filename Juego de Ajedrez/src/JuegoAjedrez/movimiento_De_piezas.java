package JuegoAjedrez;

public class movimiento_De_piezas {

    public int movimientoY(int posY) {
        int UposY = 0;
        switch (posY) {
            case 8:
                UposY = 50;
                break;
            case 7:
                UposY = 90;
                break;
            case 6:
                UposY = 130;
                break;
            case 5:
                UposY = 170;
                break;
            case 4:
                UposY = 210;
                break;
            case 3:
                UposY = 250;
                break;
            case 2:
                UposY = 290;
                break;
            case 1:
                UposY = 330;
                break;
        }
        return UposY;
    }
    public int movimientoX(int posX) {
        int UposX = 0;
        switch (posX) {
            case 1:
                UposX = 45;
                break;
            case 2:
                UposX = 90;
                break;
            case 3:
                UposX = 130;
                break;
            case 4:
                UposX = 170;
                break;
            case 5:
                UposX = 210;
                break;
            case 6:
                UposX = 250;
                break;
            case 7:
                UposX = 290;
                break;
            case 8:
                UposX = 330;
                break;
        }
        return UposX;
    }
}
