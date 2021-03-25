package Logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import Visual.Interfaz;

/**
 *
 * @author this_serra
 */
public class Control extends Thread {

    public Cola p1 = new Cola();
    public Cola p2 = new Cola();
    public Cola p3 = new Cola();
    public Cola colaR = new Cola();
    public Robot bot;

    public void start() {
        Administrador adminG = new Administrador(p1, p2, p3, colaR);
        Robot bot = new Robot(adminG);
        for (int i = 0; i < 10; i++) {
            adminG.crearSS();
        }

        try {
            JOptionPane.showMessageDialog(null, "Consolas Nintendo Super Switch creadas.");
            Thread.sleep(1000);

            System.out.println("\n+La Cola uno tiene " + adminG.p1.length() + " consolas.");
            System.out.println("+La Cola dos tiene " + adminG.p2.length() + " consolas.");
            System.out.println("+La Cola tres tiene " + adminG.p3.length() + " consolas.\n");

            JOptionPane.showMessageDialog(null, "El Administrador ha iniciado a operar.");
            Thread.sleep(1000);
            
            Interfaz.colaUno.setText(adminG.p1.MostrarContenido());
            Interfaz.colaDos.setText(adminG.p2.MostrarContenido());
            Interfaz.colaTres.setText(adminG.p3.MostrarContenido());
            Interfaz.colaRevisados.setText(adminG.colaR.MostrarContenido());

            superSwitch consolaAuxiliar;
            for (int i = 0; i < 2; i++) {
                consolaAuxiliar = adminG.consola();

                //primer ciclo
//            System.out.println("\n*La consola Auxiliar tiene prioridad " + consolaAuxiliar.prioridad);
                JOptionPane.showMessageDialog(null, "El robot revisa la consola " + consolaAuxiliar.ID);
                adminG.robot(bot, consolaAuxiliar);
                Thread.sleep(7000);
//            System.out.println("\nEl contador de la Segunda Cola es " + adminG.p2.devolverPrimero().informacion.contador);

                //segundo ciclo
//        superSwitch consola2 = adminG.consola();
//        System.out.println("Esta es la prioridad: " +consola2.prioridad);
            }

            Interfaz.colaRevisados.setText(adminG.colaR.MostrarContenido());
        } catch (InterruptedException e) {
            System.out.println("Errorrrrr: " + e);
        }
    }
}
