package edu.ujcv.progra1.MisMenus;

import edu.ujcv.progra1.Menu.IMenuItem;

import java.util.ArrayList;

public class Test1 implements IMenuItem {

    @Override
    public String getLabel() {
        return "Gestionar Clientes";
    }

    @Override
    public void runAction() {
        System.out.println("ejecutando menu test1!!");

        System.out.println("aqui podes agregar otro menu o procesar un accion.");
    }

}
