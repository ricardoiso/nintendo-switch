package Logic;

import Visual.Interfaz;

/**
 *
 * @author this_serra
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Control app = new Control();
//        new Interfaz(app).setVisible(true);
        app.start();
    }

}
