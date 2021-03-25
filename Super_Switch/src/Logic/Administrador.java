/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Administrador {

    public int totalCreado = 0;
    public Cola p1; // Cola de prioridad 1 
    public Cola p2; // Cola de prioridad 2
    public Cola p3; // Cola de prioridad 3 
    public Cola colaR; // Cola de Revision 
    ArrayList<superSwitch> listaSS = new ArrayList<superSwitch>();

    public Administrador(Cola p1, Cola p2, Cola p3, Cola colaR) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.colaR = colaR; // cola de revisión
    }

    public void crearSS() {
        this.listaSS.add(new superSwitch(this));
        System.out.println("Creada consola numero " + listaSS.get(totalCreado).ID);
        totalCreado += 1;
//        p2.Insertar(listaSS.get(listaSS.size() - 1));
        if (listaSS.get(listaSS.size() - 1).prioridad == 0) {
            this.p1.Insertar(listaSS.get(listaSS.size() - 1));
        }
        if (listaSS.get(listaSS.size() - 1).prioridad == 1) {
            this.p2.Insertar(listaSS.get(listaSS.size() - 1));
        }
        if (listaSS.get(listaSS.size() - 1).prioridad == 2) {
            this.p3.Insertar(listaSS.get(listaSS.size() - 1));
        
        }
    }

    public superSwitch consola() {//extraer la switch que esta al inicio de la cola prioridad más alta y lo retorna
        superSwitch consola;
        if (p1.ColaVacia()) {
            if (p2.ColaVacia()) {
                consola = p3.Extraer();
//                consola.contador = 0;
                p3.aumentoContador();
                return consola;
            } else {
                consola = p2.Extraer();
//                consola.contador = 0;
                p2.aumentoContador();
                p3.aumentoContador();
                return consola;
            }
        } else {
            consola = p1.Extraer();
            p2.aumentoContador();
            p3.aumentoContador();
//            consola2 = p1.Extraer();
//            System.out.println("Este es el contador: "+ consola.contador);
//            System.out.println("Este es el contador: "+ consola2.contador);
//            consola.contador = 0;
            return consola;
        }
    }

    public void robot(Robot bot, superSwitch ss) {//envía la switch al robot
        bot.revision(ss);
    }

    public void revisionColas() {  //Verificar el contador de las consolas en la cola
        int tamano2 = p2.length();
        int tamano3 = p3.length();
        superSwitch consolaAux;
        for (int i = 0; i < tamano2; i++) {
            if (p2.inicioCola.informacion.contador == 15) {
                consolaAux = p2.Extraer();
                consolaAux.contador = 0;
                consolaAux.prioridad--;
                p1.Insertar(consolaAux);
            }
        }
        for (int j = 0; j < tamano3; j++) {
            if (p3.inicioCola.informacion.contador == 15) {
                consolaAux = p3.Extraer();
                consolaAux.contador = 0;
                consolaAux.prioridad--;
                p2.Insertar(consolaAux);
            }
        }
    }

    public void reparacion_prioridad() {//Devuelve la primera consola de la cola de reparaciones y la inserta en la cola de su prioridad
        double random = Math.random();
        superSwitch consolaAuxR;
        if (random < 0.45) {
            consolaAuxR = colaR.Extraer();
            System.out.println(consolaAuxR.ID);
            System.out.println(consolaAuxR.prioridad);
            if (consolaAuxR.prioridad == 1) {
                p2.Insertar(consolaAuxR);
            }if (consolaAuxR.prioridad == 0) {
                p1.Insertar(consolaAuxR);
            }if (consolaAuxR.prioridad == 2) {
                p3.Insertar(consolaAuxR);
            }

                
            
        }

    }
}
