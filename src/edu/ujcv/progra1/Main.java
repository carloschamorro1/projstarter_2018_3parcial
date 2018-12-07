package edu.ujcv.progra1;

import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.Menu.Menu;
import edu.ujcv.progra1.MisMenus.Test1;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Cliente;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        Cliente cliente = new Cliente("g","k","y","s");
        // = new ArrayList<>();
//        clientes.add(cliente);
//        EscritorCvsClientes.writeCsvFile("Clientes.csv",clientes);
        ArrayList<IMenuItem> menuItems =  new ArrayList<>();
        menuItems.add(new Test1());
        menuItems.add(new Test1());
        menuItems.add(new Test1());
        Menu menu = new Menu(menuItems);
        menu.mostrarMenu();
        ArrayList<Cliente> clientes = LectorCvsCliente.readCsvFile("Clientes.csv");

        for (Cliente cliente: clientes) {
            System.out.println(cliente.getPrimerNombre());
        }
    }
}
