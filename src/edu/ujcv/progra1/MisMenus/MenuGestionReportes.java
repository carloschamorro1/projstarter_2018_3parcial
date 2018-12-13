package edu.ujcv.progra1.MisMenus;

import edu.ujcv.progra1.GestionReportes;
import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.util.LectorTeclado;

public class MenuGestionReportes implements IMenuItem {

    @Override
    public String getLabel() {
        return "Reportes";
    }

    @Override
    public void runAction() {
        GestionReportes gReportes = new GestionReportes();
        gReportes.presentarOpciones();
        gReportes.leerYprocesarOpciones();
    }
}
