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
    public String MostrarContenido() {
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";

        while (recorrido != null) {
            //Mostrar cola sin contador:
//            Cola += "(" + recorrido.informacion.ID + ")--> "; 
            //Mostrar cola con contador:
            Cola += "[" + recorrido.informacion.ID + "_|_" + recorrido.informacion.contador + "]--> ";
            recorrido = recorrido.siguiente;
        }

        String cadena[] = Cola.split(" ");

        for (int i = cadena.length - 1; i >= 0; i--) {
            ColaInvertida += " " + cadena[i];
        }

//        JOptionPane.showMessageDialog(null, ColaInvertida);
        Cola = "";
        return ColaInvertida;
    }

    public int length() {
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";
        int tamano = 0;
        if (inicioCola == null) {
//            JOptionPane.showMessageDialog(null, tamano);
        } else {
            while (recorrido != null) {
                Cola += "<--[" + recorrido.informacion.ID + "] ";
                recorrido = recorrido.siguiente;
            }

            String cadena[] = Cola.split(" ");
//            System.out.println("Cola prueba es "+ Cola);
//            System.out.println("Cadena es "+ cadena.length);
            tamano = cadena.length;
//            JOptionPane.showMessageDialog(null, tamano);

            Cola = "";

//        return tamano;
        }
        return tamano;
    }

    public void aumentoContador() {
        int tamano = this.length();
//        System.out.println("El tamaño es " + tamano);
        Nodo recorrido = inicioCola;
        for (int i = 0; i < tamano; i++) {
            recorrido.informacion.contador = recorrido.informacion.contador + 1;
            recorrido = recorrido.siguiente;
        }
    }

    public void aumentoContadorR(int maxContador) {
        int tamano = this.length();
        Nodo recorrido = inicioCola;

        for (int i = 0; i < tamano; i++) {
            if (recorrido.informacion.prioridad != 0) {
                recorrido.informacion.contador = recorrido.informacion.contador + 1;
            }

            if (recorrido.informacion.contador == maxContador) {
                recorrido.informacion.contador = 0;
                if (recorrido.informacion.prioridad != 0) {
                    recorrido.informacion.prioridad--;
                }
            }
            recorrido = recorrido.siguiente;
        }

    }

    public Nodo devolverPrimero() {
        return inicioCola;
    }
}
