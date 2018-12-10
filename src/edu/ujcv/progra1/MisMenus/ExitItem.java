package edu.ujcv.progra1.MisMenus;

import edu.ujcv.progra1.Main;
import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.Menu.Menu;

public class ExitItem implements IMenuItem {
    @Override
    public String getLabel() {
        return "Salir!!";
    }

    @Override
    public void runAction() {
            Main.valorSalida = 1;
        }
    }

