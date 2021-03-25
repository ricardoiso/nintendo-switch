/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import Visual.Interfaz;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class Robot {

    public Cola mercado = new Cola();
    private Administrador admin;

    public Robot(Administrador admin) {
        this.admin = admin;
    }

    public void revision(superSwitch ss) {
        double random = Math.random();
//        System.out.println("El random de robot es " + random);
        Interfaz.tiempo.setText(Integer.toString(ss.ID));

        if (0 <= random && random < 0.3) { //agregar a mercado
            mercado.Insertar(ss);
            System.out.println("El mercado tiene " + mercado.length()+ " cantidad de consolas");
            JOptionPane.showMessageDialog(null, "La consola "+ss.ID+" fue reinsertada en la cola del mercado");
        }
        if (0.3 <= random && random < 0.5) {
            admin.colaR.Insertar(ss);
//            Interfaz.colaRevisados.setText(Integer.toString(admin.colaR.length()));
            System.out.println("La cola de Revision tiene " + admin.colaR.length() + " consolas.");
            JOptionPane.showMessageDialog(null, "La consola "+ss.ID+" fue reinsertada en la cola del reparación");
        }
        if (0.5 <= random && random <= 1) {
            switch (ss.prioridad) {
                case 0:
//                    System.out.println("La prioridad esta vez es 0");
                    admin.p1.Insertar(ss);
                    JOptionPane.showMessageDialog(null, "La consola "+ss.ID+" fue reinsertada en la cola 1");
//                    System.out.println("La cola uno tiene "+admin.p1.length() + " consolas");
                    break;
                case 1:
//                    System.out.println("La prioridad esta vez es 1");
                    admin.p2.Insertar(ss);
                    JOptionPane.showMessageDialog(null, "La consola "+ss.ID+" fue reinsertada en la cola 2");
//                    Interfaz.colaDos.setText(Integer.toString(admin.p2.length()));
//                    System.out.println("La cola dos tiene "+admin.p2.length() + " consolas");
                    break;
                case 2:
//                    System.out.println("La prioridad esta vez es 2");
                    admin.p3.Insertar(ss);
                    JOptionPane.showMessageDialog(null, "La consola"+ss.ID+" fue reinsertada en la cola 3");
//                    Interfaz.colaTres.setText(Integer.toString(admin.p3.length()));
//                    System.out.println("La cola tres tiene "+admin.p3.length() + " consolas");
                    break;
                default:
                    break;
            }
        }

    }
}
