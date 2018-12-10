package edu.ujcv.progra1.MisMenus;

import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Productos;
import edu.ujcv.progra1.util.LectorTeclado;

import java.util.ArrayList;

public class TestItem3 implements IMenuItem {
    @Override
    public String getLabel() {
        return "Facturacion";
    }

    @Override
    public void runAction() {
        ArrayList<Productos> productos = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < productos.size() ; i++) {
            System.out.println("KKKKKKKKKKKk");
        }
    }
}
