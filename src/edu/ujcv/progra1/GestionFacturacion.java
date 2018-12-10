package edu.ujcv.progra1;

import edu.ujcv.progra1.Menu.IMenuItem;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Productos;
import edu.ujcv.progra1.util.LectorTeclado;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.LectorCvsProductos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GestionFacturacion {
    ArrayList<Productos> productos = new ArrayList<>();
    double subtotal = 0;
    double total = 0;
    double isv = 0;
    String nombre = "";
    String rtn = "";

    public void presentarOpciones() {
        int opcion = 1;
        productos = LectorCvsProductos.readCsvFile("Productos.csv");
        for (Productos producto : productos) {
            System.out.println(opcion++ + ".........." + producto.getNombreProducto() + "\t \t \t \t" + producto.getPrecioProducto());
        }
        System.out.println(opcion++ + ".........." + "Facturar");
    }

    public void leerYprocesarOpciones() {
        LectorTeclado lt = new LectorTeclado();
        Productos producto = new Productos();
        productos = LectorCvsProductos.readCsvFile("Productos.csv");
        int opcion = lt.leerEntero("Ingrese una opcion", "Ha ingresado un numero no valido");
        switch (opcion) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                do {
                    facturar();
                        System.out.println("Desea realizar otra compra? Escriba 1 para si y 2 para no");
                        opcion = lt.leerEntero("Ingrese un numero", "Ha ingresado un numero no valido");
                        if (opcion == 1){
                            presentarOpciones();
                            leerYprocesarOpciones();}
                    } while (opcion != 2);
                break;
        }
    }
    
    public void facturar(){
        LectorTeclado lt = new LectorTeclado();
        int op;
            System.out.println("¿Desea la factura con nombre y RTN?");
            do {
                op = lt.leerEntero("Escriba 1 para si o 2 para no", "Ha ingresado un caracter o numero no valido");
                if (op == 1) {
                    nombre =  lt.leerString("Ingrese el nombre que desea en la factura");;
                    rtn = lt.leerString("Ingrese el RTN");
                }
                if (op == 2) {
                    nombre = "Consumidor Final";
                    rtn = "0888888888888";
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
        if (nombre == "S/N") {
            System.out.println("\t \t \t \t \t \t \t " + nombre);
        } else {
            System.out.println("\t \t \t \t Nombre: " + nombre);
        }
        System.out.println(" \t \t \t \t \t RTN: " + rtn);
        System.out.println("\t \t \t \t \t FACTURA ORIGINAL");
        System.out.println("\t \t   CAI: 2H6P98-78J45O-47GH21-21WE63-03S4DF-32");
        System.out.println("\t \t \t \t \t Lo atendio: Carlos \n \n ");

        System.out.println("Subtotal 15% \t \t \t \t \t \t \t \t  L." + String.format("%.2f", subtotal));
        System.out.println("15% ISV \t \t \t \t \t \t \t \t \t \t " + String.format("%.2f", isv));
        System.out.println("Total \t \t \t \t \t \t \t \t \t \t \t L." + String.format("%.2f", total));
        System.out.println("\t \t \t \t \t  G=Gravado");
        System.out.println("\t \t \t \t  Original: Cliente");
        System.out.println("\t \t Copia: Obligado tributario emisor");
        System.out.println("\t \t \t \t \t    *****");
        System.out.println("\t \t \t \t  - Cuenta Cerrada -");
    }
}


