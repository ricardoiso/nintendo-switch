/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Random;

/**
 *
 * @author gabri
 */
public class superSwitch {

    public int ID;
    public int prioridad;
    public int contador;
    Random dado = new Random();

    public superSwitch(Administrador admin) {
        this.ID = 1 + admin.totalCreado;
        this.prioridad = dado.nextInt(3);
        this.contador = 0;
    }
}
