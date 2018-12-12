package edu.ujcv.progra1.MisMenus;

import edu.ujcv.progra1.GestionFacturacion;
import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Productos;
import edu.ujcv.progra1.util.LectorTeclado;

import java.util.ArrayList;

public class MenuGestionFacturacion implements IMenuItem {
    int op = 0;
    String nombre = "";
    String rtn = "";

    @Override
    public String getLabel() {
        return "Facturacion";
    }

    @Override
    public void runAction() {
        GestionFacturacion gFacturacion = new GestionFacturacion();
        LectorTeclado lt = new LectorTeclado();
        do {
            gFacturacion.presentarOpciones();
            gFacturacion.leerYprocesarOpciones();
        } while (gFacturacion.opcion != 999);
    }
}