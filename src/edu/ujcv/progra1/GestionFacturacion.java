package edu.ujcv.progra1;

import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.Menu.Menu;
import edu.ujcv.progra1.MisMenus.*;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Productos;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Reportes;
import edu.ujcv.progra1.util.LectorTeclado;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.EscritorCvsReportes;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.LectorCvsProductos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GestionFacturacion {
    ArrayList<Productos> productos = new ArrayList<>();
    ArrayList<Productos> cantidad = new ArrayList<>();
    ArrayList<Reportes> reportes = new ArrayList<>();
    public static int valorSalida = 0;
    Reportes rep = new Reportes();
    double subtotal = 0;
    public double total = 0;
    double isv = 0;
    public int opcion;

    public int presentarOpciones() {
        int opcion1 = 1;
        int salida = 999;
        productos = LectorCvsProductos.readCsvFile("Productos.csv");
        for (Productos producto : productos) {
            System.out.println(opcion1++ + ".........." + producto.getNombreProducto() + "\t \t \t \t" + producto.getPrecioProducto());
        }
        System.out.println(salida + "..........Facturar");
        return opcion1;
    }

    public int leerYprocesarOpciones() {
        int salida = 999;
        LectorTeclado lt = new LectorTeclado();
        productos = LectorCvsProductos.readCsvFile("Productos.csv");
        opcion = lt.leerEntero("Ingrese una opcion", "Ha ingresado un numero no valido");
        int i = 0;
        for (Productos producto : productos) {
            i++;
                    if(opcion == i){
                    subtotal += Double.parseDouble(producto.getPrecioProducto());
                    System.out.println("Usted ha agregado 1 " + producto.getNombreProducto());
                    cantidad.add(new Productos(producto.getCodigoProducto(),producto.getNombreProducto(),
                            producto.getTipoProducto(),producto.getMarcaProducto(),producto.getPrecioProducto()));
                    }
        }
        if(opcion == salida)
            facturar();
        return opcion;
    }

    public void facturar(){
        LectorTeclado lt = new LectorTeclado();
        Scanner sc = new Scanner(System.in);
        int op;
        isv = subtotal *0.15;
        subtotal = subtotal - isv;
        total = subtotal + isv;
        rep.setTotal(String.valueOf(total));
            System.out.println("¿Desea la factura con nombre y RTN?");
            do {
                op = lt.leerEntero("Escriba 1 para si o 2 para no", "Ha ingresado un caracter o numero no valido");
                if (op == 1) {
                    rep.setNombre(lt.leerString("Ingrese el nombre que desea en la factura"));
                    rep.setRtn(lt.leerString("Ingrese el RTN"));
                }
                if (op == 2) {
                    rep.setNombre("Consumidor Final");
                    rep.setRtn("0888888888888");
                }
            }while(op != 1 && op !=2);
        System.out.println("\n \t \t \t \t \t \t  FACTURA \n \t \t \t \t \t \t  ======= \n");
        System.out.println("\t \t \t \t \t Mercadito Torres");
        System.out.println("\t \t \t \t \t RTN: 08019878659894");
        System.out.println("\t \t \t Centro Comercial Portal de Viera");
        System.out.println("\t \t \t Carretera al Hatillo, Tegucigalpa");
        System.out.println("\t \t \t \t \t Tel: +504 2248-6974");
        System.out.println("\t \t \t Correo: mercadito_torres@gmail.com");
        DateFormat hourdateFormat = new SimpleDateFormat("hh:mm:ss a dd/MM/yyyy");
        Date date = new Date();
        System.out.println("\t \t \t \t \t" + hourdateFormat.format(date));
        if (rep.getNombre() == "Consumidor Final") {
            System.out.println("\t \t \t \t \t \t \t " + rep.getNombre());
        } else {
            System.out.println("\t \t \t \t Nombre: " + rep.getNombre());
        }
        System.out.println(" \t \t \t \t \t RTN: " + rep.getRtn());
        System.out.println("\t \t \t \t \t FACTURA ORIGINAL");
        System.out.println("\t \t   CAI: 2H6P98-78J45O-47GH21-21WE63-03S4DF-32");
        System.out.println("\t \t \t \t \t Lo atendio: Carlos \n \n ");
        rep.setCantidadProductos(String.valueOf(cantidad.size()));
        for (Productos producto: cantidad) {
            System.out.println(producto.getNombreProducto() + "\t \t \t \t \t \t \t \t \t \t \t" + producto.getPrecioProducto() + "G");
        }
        System.out.println("Subtotal 15% \t \t \t \t \t \t \t \t  L." + String.format("%.2f", subtotal));
        System.out.println("15% ISV \t \t \t \t \t \t \t \t \t \t " + String.format("%.2f", isv));
        System.out.println("Total \t \t \t \t \t \t \t \t \t \t \t L." + String.format("%.2f", total));
        System.out.println("\t \t \t \t \t  G=Gravado");
        System.out.println("\t \t \t \t  Original: Cliente");
        System.out.println("\t \t Copia: Obligado tributario emisor");
        System.out.println("\t \t \t \t \t    *****");
        System.out.println("\t \t \t \t  - Cuenta Cerrada -");
        System.out.println("\n \n");
        reportes.add(new Reportes(rep.getNombre(), rep.getRtn(),rep.getCantidadProductos(),rep.getTotal()));
        EscritorCvsReportes.writeCsvFile("Reportes.csv",reportes,true);
    }

}


