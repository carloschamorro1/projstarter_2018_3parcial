package edu.ujcv.progra1.MisMenus;

import edu.ujcv.progra1.GestionProductos;
import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.Menu.Menu;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Productos;
import edu.ujcv.progra1.util.LectorTeclado;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.LectorCvsProductos;

import java.util.ArrayList;

public class MenuGestionProductos implements IMenuItem {


    @Override
    public String getLabel() {
        return "Gestionar Productos";
    }

    @Override
    public void runAction() {
        GestionProductos gProductos = new GestionProductos();
        gProductos.presentarOpciones();
        gProductos.leerYprocesarOpciones();
    }
}
