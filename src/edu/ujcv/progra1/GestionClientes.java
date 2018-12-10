package edu.ujcv.progra1;

import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.Menu.Menu;
import edu.ujcv.progra1.MisMenus.ExitItem;
import edu.ujcv.progra1.MisMenus.TestItem3;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Cliente;
import edu.ujcv.progra1.util.LectorTeclado;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.LectorCvsCliente;

import java.util.ArrayList;

public class GestionClientes {
//
//    public GestionClientes(){
//        ArrayList<IMenuItem> itemsMenuGestionClientes = new ArrayList<>();
//        itemsMenuGestionClientes.add(new TestItem3());
//        itemsMenuGestionClientes.add(new ExitItem());
//    }

    public void presentarOpciones() {
        System.out.println("1.Presentar lista de clientes");
        System.out.println("2.Agregar cliente al final");
        System.out.println("3.Eliminar cliente");
        System.out.println("4.Obtener cliente en especifico");
        System.out.println("5.Salir");
    }

    public int leerYprocesarOpciones() {
        LectorTeclado lt = new LectorTeclado();
        int opcion = lt.leerEntero("Ingrese una opcion", "Ha ingresado un numero no valido");
        switch (opcion) {
            case 1:
                ArrayList<Cliente> clientes = LectorCvsCliente.readCsvFile("Clientes.csv");
                System.out.println("\n La lista de cliente es:");
                System.out.println("Identidad \t \t Primer nombre \t \t Primer Apellido \t \t Codigo");
                for (Cliente cliente : clientes) {
                    System.out.println(cliente.getIdentidad() + "\t \t" + cliente.getPrimerNombre() + "\t \t \t \t"
                            + cliente.getPrimerApellido() + "\t \t \t \t" + cliente.getCodigoCliente());
                }
                System.out.println("\n");
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
        return opcion;
    }
}
