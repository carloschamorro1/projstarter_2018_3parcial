package edu.ujcv.progra1;

import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.Menu.Menu;
import edu.ujcv.progra1.MisMenus.*;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Productos;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.EscritorCvsProductos;

import java.util.ArrayList;

public class Main {
    // no hacer esto ya que no es una variable privada y de paso es estatica!!!
    public static int valorSalida = 0;

    public static void main(String[] args) {
	// write your code here

        ArrayList<IMenuItem> itemsMenuPrincipal = new ArrayList<>();
        ArrayList<Productos> productosItems = new ArrayList<>();
        Menu menu = new Menu();

        productosItems.add(new Productos("a","b", "c", "d","e"));
        EscritorCvsProductos.writeCsvFile("Productos.csv",productosItems);
        itemsMenuPrincipal.add(new MenuGestionClientes());
        itemsMenuPrincipal.add(new TestItem2());
        itemsMenuPrincipal.add(new TestItem3());
        itemsMenuPrincipal.add(new TestItem4());
        itemsMenuPrincipal.add(new ExitItem());
        Menu menuPrincipal = new Menu(itemsMenuPrincipal);

        while (valorSalida == 0) {
            menuPrincipal.mostrarMenu();
            menuPrincipal.leerOpcionLuegoProcessar();
        }
    }
}
