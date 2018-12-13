package edu.ujcv.progra1.MisMenus;

import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.GestionClientes;


public class MenuGestionClientes implements IMenuItem {

    @Override
    public String getLabel() {
        return "Gestionar Clientes";
    }

    @Override
    public void runAction() {
    GestionClientes gClientes = new GestionClientes();
    gClientes.presentarOpciones();
    gClientes.leerYprocesarOpciones();
    }

}