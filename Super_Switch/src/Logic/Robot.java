/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import Visual.Interfaz;

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
        System.out.println(random);
        if (0 <= random && random < 0.3) { //agregar a mercado
            mercado.add(ss);
            System.out.println(mercado);
        }
        if (0.3 <= random && random < 0.5) {
            admin.colaR.Insertar(ss);
            Interfaz.colaRevisados.setText(Integer.toString(admin.colaR.length()));
            System.out.println(admin.colaR.length());
        }
        if (0.5 <= random && random <= 1) {
            if (ss.prioridad == 0) {
                admin.p1.Insertar(ss);
                Interfaz.colaUno.setText(Integer.toString(admin.p1.length()));
                System.out.println(admin.p1.length());
            } else if (ss.prioridad == 1) {
                admin.p2.Insertar(ss);
                Interfaz.colaDos.setText(Integer.toString(admin.p2.length()));
                System.out.println(admin.p2.length());
            } else if (ss.prioridad == 2) {
                admin.p3.Insertar(ss);
                Interfaz.colaTres.setText(Integer.toString(admin.p3.length()));
                System.out.println(admin.p3.length());
            }
        }

    }
}
