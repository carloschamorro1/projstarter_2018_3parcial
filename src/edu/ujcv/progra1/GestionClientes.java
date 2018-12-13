package edu.ujcv.progra1;

import edu.ujcv.progra1.edu.ujcv.progra1.models.Cliente;
import edu.ujcv.progra1.util.LectorTeclado;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.EscritorCvsClientes;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.LectorCvsCliente;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;

public class GestionClientes {
    private ArrayList<Cliente> clientes = new ArrayList<>();
//
//    public GestionClientes(){
//        ArrayList<IMenuItem> itemsMenuGestionClientes = new ArrayList<>();
//        itemsMenuGestionClientes.add(new MenuGestionFacturacion());
//        itemsMenuGestionClientes.add(new ExitItem());
//    }

    public void presentarOpciones() {
        System.out.println("1.Presentar lista de clientes");
        System.out.println("2.Agregar cliente al final");
        System.out.println("3.Eliminar cliente");
        System.out.println("4.Obtener cliente en especifico");
        System.out.println("5.Salir");
    }

    public int leerYprocesarOpciones() {
        LectorTeclado lt = new LectorTeclado();
        int opcion = lt.leerEntero("Ingrese una opcion", "Ha ingresado un numero no valido");
        switch (opcion) {
            case 1:
                System.out.println("\n La lista de cliente es:");
                System.out.println("Identidad \t \t Primer nombre \t \t Primer Apellido \t \t Codigo");
                obtenerClientes();
                System.out.println("\n");
                break;
            case 2:
                addClient();
                System.out.println("\n");
                break;
            case 3:
                deleteClient();
                System.out.println("\n");
                break;
            case 4:
                getClient();
                System.out.println("\n");
                break;
        }
        return opcion;
    }

    public void obtenerClientes(){
       clientes = LectorCvsCliente.readCsvFile("Clientes.csv");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getIdentidad() + "\t \t" + cliente.getPrimerNombre() + "\t \t \t \t"
                    + cliente.getPrimerApellido() + "\t \t \t \t" + cliente.getCodigoCliente());
        }
    }

    public ArrayList<Cliente> addClient(){
        LectorTeclado lt = new LectorTeclado();
        Cliente datos = new Cliente();
        datos.setIdentidad(lt.leerString("Por favor ingrese la identidad"));
        datos.setPrimerNombre(lt.leerString("Por favor ingrese el primer nombre"));
        datos.setPrimerApellido(lt.leerString("Por favor ingrese el primer apellido"));
        datos.setCodigoCliente(lt.leerString("Por favor ingrese el codigo del cliennte"));
        clientes.add(new Cliente(datos.getIdentidad(),datos.getPrimerNombre(),datos.getPrimerApellido(), datos.getCodigoCliente()));
        EscritorCvsClientes.writeCsvFile("Clientes.csv",clientes,true);
        return clientes;
    }

    public void deleteClient() {
        clientes = LectorCvsCliente.readCsvFile("Clientes.csv");
        int i = 0;

    }


    public void getClient(){
        LectorTeclado lt = new LectorTeclado();
        Cliente datos = new Cliente();
        clientes = LectorCvsCliente.readCsvFile("Clientes.csv");
        int num = lt.leerEntero("Escriba el indice del cliente que desea obtener", "Error ha ingresado un numero no valido");
        int i = 0;
        for (Cliente clientes : clientes) {
            i++;
            if(num == i){
                System.out.println(clientes.getIdentidad() + "\t \t" + clientes.getPrimerNombre() + "\t \t \t \t"
                        + clientes.getPrimerApellido() + "\t \t \t \t" + clientes.getCodigoCliente());
            }
        }
    }
}
