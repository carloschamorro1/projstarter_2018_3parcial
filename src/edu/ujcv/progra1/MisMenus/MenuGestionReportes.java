package edu.ujcv.progra1.MisMenus;

import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.util.LectorTeclado;

public class MenuGestionReportes implements IMenuItem {

    @Override
    public String getLabel() {
        return "Reportes";
    }

    @Override
    public void runAction() {
        LectorTeclado lt = new LectorTeclado();
        int a = lt.leerEntero("ingrese entero a", "ingrese entero");
        int b = lt.leerEntero("ingrese entero b", "ingrese entero");

        System.out.println("el resultado es:" + (a+b) );

    }
}