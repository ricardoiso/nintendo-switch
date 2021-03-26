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
    public int tiempo = 7;

    public void start() {
        Administrador adminG = new Administrador(p1, p2, p3, colaR);
        Robot bot = new Robot(adminG);
        JOptionPane.showMessageDialog(null, "Se ha creado la primera consola.");
        adminG.crearSS();
        Interfaz.contador.setText("Sin operar");
        Interfaz.colaUno.setText(adminG.p1.MostrarContenido());
        Interfaz.colaDos.setText(adminG.p2.MostrarContenido());
        Interfaz.colaTres.setText(adminG.p3.MostrarContenido());
        Interfaz.colaRevisados.setText(adminG.colaR.MostrarContenido());
        Interfaz.colaMercado.setText(bot.mercado.MostrarContenido());
        //JOptionPane.showMessageDialog(null, bot.mercado.length());
//        for (int i = 0; i < 10; i++) {
//            adminG.crearSS();
//        }
        int contador = 1;
        while (true) {
            if (p1.ColaVacia() && p2.ColaVacia() && p3.ColaVacia() && contador != 2) {
                if (colaR.ColaVacia()) {
                    adminG.crearSS();
                } else {
                    adminG.reparacion_prioridad();
                }
            }
            
            adminG.colaR.aumentoContadorR(adminG.maxContador);
            
            
            if (contador == 2) {
                adminG.crearSS();
                Interfaz.colaUno.setText(adminG.p1.MostrarContenido());
                Interfaz.colaDos.setText(adminG.p2.MostrarContenido());
                Interfaz.colaTres.setText(adminG.p3.MostrarContenido());
                Interfaz.colaRevisados.setText(adminG.colaR.MostrarContenido());
                Interfaz.colaMercado.setText(bot.mercado.MostrarContenido());
                JOptionPane.showMessageDialog(null, "Consola Nintendo Super Switch creada.");
                contador = 1;
                double random = Math.random();
                if (!colaR.ColaVacia() && random <= 0.7) {
                    //JOptionPane.showMessageDialog(null, "Se reinsertará en su cola respectiva al primer elemento de la cola de reparación.");
                    adminG.reparacion_prioridad();
                }
            }
            contador++;
            try {

                Thread.sleep(2000);

                System.out.println("\n+La Cola uno tiene " + adminG.p1.length() + " consolas.");
                System.out.println("+La Cola dos tiene " + adminG.p2.length() + " consolas.");
                System.out.println("+La Cola tres tiene " + adminG.p3.length() + " consolas.\n");

                JOptionPane.showMessageDialog(null, "El Administrador ha iniciado a operar.");
                Thread.sleep(1000);

                Interfaz.colaUno.setText(adminG.p1.MostrarContenido());
                Interfaz.colaDos.setText(adminG.p2.MostrarContenido());
                Interfaz.colaTres.setText(adminG.p3.MostrarContenido());
                Interfaz.colaRevisados.setText(adminG.colaR.MostrarContenido());
                Interfaz.colaMercado.setText(bot.mercado.MostrarContenido());

                superSwitch consolaAuxiliar;
//            for (int i = 0; i < 50; i++) {
                consolaAuxiliar = adminG.consola();
                adminG.revisionColas();

                //primer ciclo
//            System.out.println("\n*La consola Auxiliar tiene prioridad " + consolaAuxiliar.prioridad);
                Interfaz.colaUno.setText(adminG.p1.MostrarContenido());
                Interfaz.colaDos.setText(adminG.p2.MostrarContenido());
                Interfaz.colaTres.setText(adminG.p3.MostrarContenido());
                Interfaz.colaRevisados.setText(adminG.colaR.MostrarContenido());
                Interfaz.colaMercado.setText(bot.mercado.MostrarContenido());
                JOptionPane.showMessageDialog(null, "El robot revisa la consola " + consolaAuxiliar.ID);
                Interfaz.tiempo.setText(String.valueOf(consolaAuxiliar.ID));
                Interfaz.contador.setText("Sin operar");
                int time = 0;
                for (int i = 0; i < tiempo+1; i++) {
                    Interfaz.contador.setText(String.valueOf(time)+" s");
                    Thread.sleep(1000);
                    time++;
                }
                Interfaz.contador.setText("Sin operar");
                adminG.robot(bot, consolaAuxiliar);
                Interfaz.tiempo.setText("x");
                
                

                Interfaz.colaUno.setText(adminG.p1.MostrarContenido());
                Interfaz.colaDos.setText(adminG.p2.MostrarContenido());
                Interfaz.colaTres.setText(adminG.p3.MostrarContenido());
                Interfaz.colaRevisados.setText(adminG.colaR.MostrarContenido());
                Interfaz.colaMercado.setText(bot.mercado.MostrarContenido());
//            System.out.println("\nEl contador de la Segunda Cola es " + adminG.p2.devolverPrimero().informacion.contador);

                //segundo ciclo
//        superSwitch consola2 = adminG.consola();
//        System.out.println("Esta es la prioridad: " +consola2.prioridad);
//            }//fin for
            } catch (InterruptedException e) {
                System.out.println("Errorrrrr: " + e);
            }
        }
    }
}
