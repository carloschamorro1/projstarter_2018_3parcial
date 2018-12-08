package edu.ujcv.progra1.MisMenus;

import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.Menu.Menu;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Productos;
import edu.ujcv.progra1.util.LectorTeclado;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.LectorCvsProductos;

import java.util.ArrayList;

public class TestItem2 implements IMenuItem {


    @Override
    public String getLabel() {
        return "Gestionar Productos";
    }

    @Override
    public void runAction() {
        LectorTeclado lt = new LectorTeclado();
        System.out.println("1.Presentar lista de productos");
        System.out.println("2.Agregar producto al final");
        System.out.println("3.Eliminar producto");
        System.out.println("4.Obtener producto en especifico");
        System.out.println("5.Limpiar");
        System.out.println("6.Salir");
        int opcion = lt.leerEntero("Ingrese una opcion", "Ha ingresado un numero no valido");
        switch (opcion) {
            case 1:
                ArrayList<Productos> productos = LectorCvsProductos.readCsvFile("Productos.csv");
                System.out.println("\n La lista de productos es: \n");
                System.out.println("Codigo Producto \t \t Nombre Producto \t \t Tipo Producto \t \t Marca Producto \t \t Precio Producto");
                for (Productos producto : productos) {
                    System.out.println(producto.getCodigoProducto() + "\t \t" + producto.getNombreProducto() + "\t \t \t \t"
                            + producto.getTipoProducto() + "\t \t \t \t" + producto.getMarcaProducto() + "\t \t \t \t" + producto.getPrecioProducto());
                }
                System.out.println("\n");
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
}
