/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;


import java.util.*;

/**
 *
 * @author gabri
 */
public class Robot {

    ArrayList<superSwitch> mercado = new ArrayList<superSwitch>();
    private Administrador admin;

    public Robot(Administrador admin) {
        this.admin = admin;
    }

    public void revision(superSwitch ss) {
        double random = Math.random();
//        System.out.println("El random de robot es " + random);
        
        if (0 <= random && random < 0.3) { //agregar a mercado
            mercado.add(ss);
            System.out.println("El mercado tiene " + mercado.size() + " cantidad de consolas");
        }
        if (0.3 <= random && random < 0.5) {
            admin.colaR.Insertar(ss);
//            Interfaz.colaRevisados.setText(Integer.toString(admin.colaR.length()));
            System.out.println("La cola de Revision tiene " + admin.colaR.length() + " consolas.");
        }
        if (0.5 <= random && random <= 1) {
            switch (ss.prioridad) {
                case 0:
//                    System.out.println("La prioridad esta vez es 0");
                    admin.p1.Insertar(ss);
//                    System.out.println("La cola uno tiene "+admin.p1.length() + " consolas");
                    break;
                case 1:
//                    System.out.println("La prioridad esta vez es 1");
                    admin.p2.Insertar(ss);
//                    Interfaz.colaDos.setText(Integer.toString(admin.p2.length()));
//                    System.out.println("La cola dos tiene "+admin.p2.length() + " consolas");
                    break;
                case 2:
//                    System.out.println("La prioridad esta vez es 2");
                    admin.p3.Insertar(ss);
//                    Interfaz.colaTres.setText(Integer.toString(admin.p3.length()));
//                    System.out.println("La cola tres tiene "+admin.p3.length() + " consolas");
                    break;
                default:
                    break;
            }
        }

    }
}
