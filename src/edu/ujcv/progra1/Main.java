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
        Menu menu = new Menu();
        itemsMenuPrincipal.add(new MenuGestionClientes());
        itemsMenuPrincipal.add(new MenuGestionProductos());
        itemsMenuPrincipal.add(new MenuGestionFacturacion());
        itemsMenuPrincipal.add(new MenuGestionReportes());
        itemsMenuPrincipal.add(new ExitItem());
        Menu menuPrincipal = new Menu(itemsMenuPrincipal);
        while (valorSalida == 0) {
            menuPrincipal.mostrarMenu();
            menuPrincipal.leerOpcionLuegoProcessar();
        }
    }
}
