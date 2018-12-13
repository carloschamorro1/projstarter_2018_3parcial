package edu.ujcv.progra1.util.edu.ujcv.progra1.util.fileio;

import edu.ujcv.progra1.edu.ujcv.progra1.models.Reportes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

    public class LectorCvsReportes {
        //Delimiter used in CSV file
        private static final String COMMA_DELIMITER = ";";

        //Student attributes index
        private static final int REP_NAME_IDX = 0;
        private static final int REP_RTN_IDX = 1;
        private static final int REP_NUMF_IDX = 2;
        private static final int REP_TOTAL_IDX = 3;

        public static ArrayList<Reportes> readCsvFile(String fileName) {

            BufferedReader fileReader = null;
            ArrayList<Reportes> reportes = new ArrayList();
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
                        Reportes reporte = new Reportes(tokens[REP_NAME_IDX], tokens[REP_RTN_IDX], tokens[REP_NUMF_IDX], tokens[REP_TOTAL_IDX]);
                        reportes.add(reporte);
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
            return reportes;
        }

    }
