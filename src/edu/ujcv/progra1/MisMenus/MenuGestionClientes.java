package edu.ujcv.progra1.MisMenus;

import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Cliente;
import edu.ujcv.progra1.util.LectorTeclado;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.EscritorCvsClientes;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.LectorCvsCliente;
import edu.ujcv.progra1.GestionClientes;

import java.util.ArrayList;

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