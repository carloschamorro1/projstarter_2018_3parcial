package edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio;

import edu.ujcv.progra1.edu.ujcv.progra1.models.Reportes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscritorCvsReportes {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ";";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "nombre;rtn;numeroFactura;total";

    public static void writeCsvFile(String fileName, ArrayList<Reportes> reportes, boolean append) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName,append);

//            //Write the CSV file header
//            fileWriter.append(FILE_HEADER);
//
//            //Add a new line separator after the header
//            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (Reportes reporte : reportes) {
                fileWriter.append(String.valueOf(reporte.getNombre()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(reporte.getRtn());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(reporte.getCantidadProductos());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(reporte.getTotal());
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