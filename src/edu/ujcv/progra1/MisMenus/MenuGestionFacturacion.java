package edu.ujcv.progra1.MisMenus;

import edu.ujcv.progra1.GestionFacturacion;
import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.util.LectorTeclado;



public class MenuGestionFacturacion implements IMenuItem {

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