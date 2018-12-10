package edu.ujcv.progra1;

import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Productos;
import edu.ujcv.progra1.util.LectorTeclado;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.LectorCvsProductos;

import java.util.ArrayList;

public class GestionFacturacion {
    ArrayList<Productos> productos = new ArrayList<>();
    double subtotal = 0;
    double total = 0;
    double isv = 0;

    public void presentarOpciones() {
        int opcion = 1;
        productos = LectorCvsProductos.readCsvFile("Productos.csv");
        for (Productos producto : productos) {
            System.out.println(opcion++ + ".........." + producto.getNombreProducto() + "\t \t \t \t" + producto.getPrecioProducto());
        }
    }

    public void leerYprocesarOpciones() {
        LectorTeclado lt = new LectorTeclado();
        int opcion = lt.leerEntero("Ingrese una opcion", "Ha ingresado un numero no valido");
        switch (opcion) {
            case 1:
                System.out.println("\n La lista de cliente es:");
                System.out.println("Identidad \t \t Primer nombre \t \t Primer Apellido \t \t Codigo");
                System.out.println("\n");
                break;
            case 2:

                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}


