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

    public int totalCreado=0;
    public Cola p1;
    public Cola p2;
    public Cola p3;
    public Cola colaR;
    ArrayList<superSwitch> listaSS = new ArrayList<superSwitch>();

    public Administrador(Cola p1, Cola p2, Cola p3, Cola colaR) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.colaR = colaR;
    }
   

    

    public void crearSS() {
        this.listaSS.add(new superSwitch(this));
        System.out.println(listaSS.get(totalCreado).ID);
        totalCreado +=1;
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

    public superSwitch consola() {
        superSwitch consola;
         superSwitch consola2;
        if (p1.ColaVacia()) {
            if (p2.ColaVacia()) {
                consola = p3.Extraer();
                consola.contador = 0;
                return consola;
            } else {
                consola = p2.Extraer();
                consola.contador = 0;
                return consola;
            }
        } else {
            consola = p1.Extraer();
            p1.aumentoContador();
//            consola2 = p1.Extraer();
//            System.out.println("Este es el contador: "+ consola2.contador);
            consola.contador = 0;
            return consola;
        }
    }
    
    public void robot(Robot bot, superSwitch ss){
        bot.revision(ss);
        
    }
    
}
