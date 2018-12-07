package edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio;

import edu.ujcv.progra1.edu.ujcv.progra1.models.Productos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscritorCvsProductos {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "codigoProducto,nombreProducto,tipoProducto, marcaProducto,precioProducto";
    public static void writeCsvFile(String fileName, ArrayList<Productos> productos) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName,false);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER);

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (Productos producto : productos) {
                fileWriter.append(String.valueOf(producto.getCodigoProducto()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(producto.getNombreProducto());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(producto.getTipoProducto());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(producto.getMarcaProducto());
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(producto.getPrecioProducto());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

}
