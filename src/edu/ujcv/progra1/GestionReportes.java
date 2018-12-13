package edu.ujcv.progra1;

import edu.ujcv.progra1.edu.ujcv.progra1.models.Reportes;
import edu.ujcv.progra1.util.LectorTeclado;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.LectorCvsReportes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GestionReportes {
    private ArrayList<Reportes> reportes = new ArrayList<>();

    public void presentarOpciones() {
        System.out.println("1..........Presentar lista de facturas");
        System.out.println("2..........Imprimir reporte");
        System.out.println("3..........Salir");
    }

    public int leerYprocesarOpciones() {
        LectorTeclado lt = new LectorTeclado();
        int opcion = lt.leerEntero("Ingrese una opcion", "Ha ingresado un numero no valido");
        switch (opcion) {
            case 1:
                System.out.println("\n La lista de cliente es:");
                System.out.println("Nombre Cliente \t \t RTN Cliente \t \t Cantidad de productos facturados \t \t Total");
                imprimirLista();
                System.out.println("\n");
                break;
            case 2:
                imprimirReporte();
                System.out.println("\n");
                break;
        }
        return opcion;
    }

    public void imprimirLista(){
        reportes = LectorCvsReportes.readCsvFile("Reportes.csv");
        for (Reportes reporte: reportes) {
            System.out.println(reporte.getNombre() + "\t \t \t" + reporte.getRtn() + "\t \t \t " + reporte.getCantidadProductos() + "\t \t \t" + reporte.getTotal());
        }
    }

    public void imprimirReporte(){
        reportes = LectorCvsReportes.readCsvFile("Reportes.csv");
        double x = 0;
        int i = 0;
        int y = 0;
        System.out.println("\n \t \t \t \t \t \t  REPORTE \n \t \t \t \t \t \t  ======= \n");
        System.out.println("\t \t \t \t \t Mercadito Torres");
        System.out.println("\t \t \t \t \t RTN: 08019878659894");
        System.out.println("\t \t \t Centro Comercial Portal de Viera");
        System.out.println("\t \t \t Carretera al Hatillo, Tegucigalpa");
        System.out.println("\t \t \t \t \t Tel: +504 2248-6974");
        System.out.println("\t \t \t Correo: mercadito_torres@gmail.com");
        DateFormat hourdateFormat = new SimpleDateFormat("MMMM/yyyy");
        DateFormat hourdateFormat2 = new SimpleDateFormat("MMMM");
        Date date = new Date();
        System.out.println("\t \t \t \t \t" + hourdateFormat.format(date));
        System.out.println("\n \t \t \t \t" + reportes.size()+ " Facturas en el mes " +hourdateFormat2.format(date)+"\n");
        for (Reportes reporte: reportes) {
            i++;
            System.out.println(reporte.getNombre() + "\t \t \t" + reporte.getRtn() + "\t \t \t " + reporte.getCantidadProductos() + "\t \t \t" + reporte.getTotal());
            x = Double.parseDouble(reporte.getTotal());
            y += x;
            if(i == reportes.size()){
                System.out.println("\n Los ingresos en el mes de " + hourdateFormat2.format(date) +  " han sido de " + "L."+y +".00");
                System.out.println("Los impuestos ha pagar en el mes de " + hourdateFormat2.format(date) +  " han sido de " + "L."+(y*0.15));
                System.out.println("\t \t \t \t \t    *****");
                System.out.println("\t \t \t \t  - Reporte Cerrado -");
            }
        }

    }
}
