package edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio;

import edu.ujcv.progra1.edu.ujcv.progra1.models.Productos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorCvsProductos {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ";";

    //Student attributes index
    private static final int PRO_CODPRO_IDX = 0;
    private static final int PRO_PRONAME_IDX = 1;
    private static final int PRO_TPRO_IDX = 2;
    private static final int PRO_MAPRO_IDX = 3;
    private static final int PRO_PREPRO_IDX = 4;


    public static ArrayList<Productos> readCsvFile(String fileName) {

        BufferedReader fileReader = null;
        ArrayList<Productos> productos = new ArrayList();
        try {

            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            //Read the CSV file header to skip it
            fileReader.readLine();

            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    Productos producto = new Productos(tokens[PRO_CODPRO_IDX], tokens[PRO_PRONAME_IDX], tokens[PRO_TPRO_IDX], tokens[PRO_MAPRO_IDX], tokens[PRO_PREPRO_IDX]);
                    productos.add(producto);
                }
            }

        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return productos;
    }

}
