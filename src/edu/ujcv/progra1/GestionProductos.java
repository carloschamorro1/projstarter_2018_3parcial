package edu.ujcv.progra1;

import edu.ujcv.progra1.edu.ujcv.progra1.models.Cliente;
import edu.ujcv.progra1.edu.ujcv.progra1.models.Productos;
import edu.ujcv.progra1.util.LectorTeclado;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.EscritorCvsProductos;
import edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio.LectorCvsProductos;

import java.util.ArrayList;

public class GestionProductos {

        private ArrayList<Productos> productos = new ArrayList<>();
//
//    public GestionClientes(){
//        ArrayList<IMenuItem> itemsMenuGestionClientes = new ArrayList<>();
//        itemsMenuGestionClientes.add(new MenuGestionFacturacion());
//        itemsMenuGestionClientes.add(new ExitItem());
//    }

        public void presentarOpciones() {
            System.out.println("1.Presentar lista de productos");
            System.out.println("2.Agregar productos al final");
            System.out.println("3.Eliminar producto");
            System.out.println("4.Obtener producto en especifico");
            System.out.println("5.Salir");
        }

        public int leerYprocesarOpciones() {
            LectorTeclado lt = new LectorTeclado();
            int opcion = lt.leerEntero("Ingrese una opcion", "Ha ingresado un numero no valido");
            switch (opcion) {
                case 1:
                    System.out.println("\n La lista de productos es:");
                    System.out.println("Codigo Producto \t \t Nombre Producto \t \t Tipo Producto \t \t Marca Producto \t \t Precio");
                    getProducts();
                    System.out.println("");
                    break;
                case 2:
                    addProduct();
                    System.out.println("");
                    break;
                case 3:
                    deleteProduct();
                    System.out.println("");
                    break;
                case 4:
                    getProduct();
                    System.out.println("");
                    break;
            }
            return opcion;
        }

        public void getProducts(){
            productos = LectorCvsProductos.readCsvFile("Productos.csv");
            for (Productos producto : productos) {
                System.out.println(producto.getCodigoProducto() + "\t \t" + producto.getNombreProducto() + "\t \t \t \t"
                        + producto.getTipoProducto() + "\t \t \t \t" + producto.getMarcaProducto() + "\t \t \t \t" + producto.getPrecioProducto() );
            }
        }

        public void addProduct(){
            LectorTeclado lt = new LectorTeclado();
            Productos datos = new Productos();
            datos.setCodigoProducto(lt.leerString("Por favor ingrese el codigo"));
            datos.setNombreProducto(lt.leerString("Por favor ingrese el nombre"));
            datos.setTipoProducto(lt.leerString("Por favor ingrese el tipo"));
            datos.setMarcaProducto(lt.leerString("Por favor ingrese la marca"));
            datos.setPrecioProducto(lt.leerString("Ingrese el precio del producto"));
            productos.add(new Productos(datos.getCodigoProducto(),datos.getNombreProducto(),datos.getTipoProducto(),datos.getMarcaProducto(),datos.getPrecioProducto()));
            EscritorCvsProductos.writeCsvFile("Productos.csv",productos,true);
        }

        public void deleteProduct(){
            productos = LectorCvsProductos.readCsvFile("Productos.csv");
            int i = 0;
            for (Productos producto:productos) {
                i++;
                if(productos.size()== i){
                    productos.remove(productos.size()-1);
                    EscritorCvsProductos.writeCsvFileE("Productos.csv",productos,false);
                    productos.add(new Productos("","","","",""));
                }
            }
        }

        public void getProduct(){
            LectorTeclado lt = new LectorTeclado();
            productos = LectorCvsProductos.readCsvFile("Productos.csv");
            int num = lt.leerEntero("Escriba el indice del producto que desea obtener", "Error ha ingresado un numero no valido");
            int i = 0;
            for (Productos producto : productos) {
                i++;
                if(num == i){
                    System.out.println(producto.getCodigoProducto() + "\t \t" + producto.getNombreProducto() + "\t \t \t \t"
                            + producto.getTipoProducto() + "\t \t \t \t" + producto.getMarcaProducto() + "\t \t \t \t" + producto.getPrecioProducto());
                }
            }
            if(productos.size() < num)
                System.out.println("No existe registro de productos en ese indice");
        }
    }
