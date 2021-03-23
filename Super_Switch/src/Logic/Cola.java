/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class Cola {

    public Nodo inicioCola, finalCola;
    String Cola = "";

    public Cola() {
        inicioCola = null;
        finalCola = null;
    }

    //Método para saber si la cola esta vacia
    public boolean ColaVacia() {
        if (inicioCola == null) {
            return true;
        } else {
            return false;
        }
    }

    //Método para insertar a la cola
    public void Insertar(superSwitch informacion) {
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.informacion = informacion;
        nuevo_nodo.siguiente = null;

        if (ColaVacia()) {
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }
    }

    //Método para extraer de la cola
    public superSwitch Extraer() {
        if (!ColaVacia()) {
            superSwitch informacion = inicioCola.informacion;

            if (inicioCola == finalCola) {
                inicioCola = null;
                finalCola = null;
            } else {
                inicioCola = inicioCola.siguiente;
            }
            return informacion;
        } else {
            return null; //pendiente con esto
        }
    }

    //Método para mostrar el contenido de la cola
    public void MostrarContenido() {
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";

        while (recorrido != null) {
            Cola += recorrido.informacion + " ";
            recorrido = recorrido.siguiente;
        }

        String cadena[] = Cola.split(" ");

        for (int i = cadena.length - 1; i >= 0; i--) {
            ColaInvertida += " " + cadena[i];
        }

        JOptionPane.showMessageDialog(null, ColaInvertida);
        Cola = "";
    }

    public int length() {
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";
        int tamano = 0;
        if (inicioCola == null) {
//            JOptionPane.showMessageDialog(null, tamano);
        } else {
            while (recorrido != null) {
                Cola += recorrido.informacion + " ";
                recorrido = recorrido.siguiente;
            }

            String cadena[] = Cola.split(" ");
//            System.out.println(cadena);
            tamano = cadena.length;
            //JOptionPane.showMessageDialog(null, tamano);

            Cola = "";

//        return tamano;
        }
        return tamano;
    }

    public void aumentoContador() {
        int tamano = this.length();
        Nodo recorrido = inicioCola;
        for (int i = 0; i < tamano; i++) {
            recorrido.informacion.contador = recorrido.informacion.contador + 1;
            recorrido = recorrido.siguiente;
        }

    }

    public Nodo devolverPrimero() {
        return inicioCola;
    }
}
