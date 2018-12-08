package edu.ujcv.progra1.MisMenus;

import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Cliente;
import edu.ujcv.progra1.util.LectorTeclado;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.EscritorCvsClientes;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.LectorCvsCliente;


import java.util.ArrayList;

public class Test1 implements IMenuItem {

    @Override
    public String getLabel() {
        return "Gestionar Clientes";
    }

    @Override
    public void runAction() {
        LectorTeclado lt = new LectorTeclado();
        System.out.println("1.Presentar lista de clientes");
        System.out.println("2.Agregar cliente al final");
        System.out.println("3.Eliminar cliente");
        System.out.println("4.Obtener cliente en especifico");
        System.out.println("5.Limpiar");
        System.out.println("6.Salir");
        int opcion = lt.leerEntero("Ingrese una opcion", "Ha ingresado un numero no valido");
        switch (opcion) {
            case 1:
                ArrayList<Cliente> clientes = LectorCvsCliente.readCsvFile("Clientes.csv");
                System.out.println("\n La lista de cliente es:");
                System.out.println("Identidad \t \t Primer nombre \t \t Primer Apellido \t \t Codigo");
                for (Cliente cliente: clientes) {
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
    }
}