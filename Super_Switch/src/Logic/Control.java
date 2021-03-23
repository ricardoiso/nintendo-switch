


package Logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

/**
 *
 * @author this_serra
 */
public class Control {
    public Cola p1 = new Cola();
    public Cola p2 = new Cola();
    public Cola p3 = new Cola();
    public Cola colaR = new Cola();
    public Robot bot;
    
    public void start() {
        Administrador adminG = new Administrador(p1,p2,p3,colaR);
        Robot bot = new Robot(adminG);
        for (int i = 0; i < 10; i++) {
            adminG.crearSS();
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(adminG.p1.length());
        System.out.println(adminG.p2.length());
        System.out.println(adminG.p3.length());
        superSwitch consola1 = adminG.consola();
        //primer ciclo
        System.out.println(consola1.prioridad);
        adminG.robot(bot, consola1);
        System.out.println(adminG.p2.devolverPrimero().informacion.contador);
        }
        
        //segundo ciclo
//        superSwitch consola2 = adminG.consola();
//        System.out.println("Esta es la prioridad: " +consola2.prioridad);
//        System.out.println("\n");
        
        
        
        
        
        
        
//        JOptionPane.showConfirmDialog(null, "Este si lo reventamos ???", "Proyectazo", 0, JOptionPane.QUESTION_MESSAGE);
        
    }
    
}
