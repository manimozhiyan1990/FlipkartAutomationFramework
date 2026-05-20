package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvUtils {

    public static String getCsvData(String id) throws IOException {
        String product = "";

        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/testdata/products.csv"));
        String line ;

        br.readLine();

        while ((line = br.readLine())!= null){
            String[] data = line.split(",");

            if (data[0].equals(id)) {

                product = data[1];
                break;
            }
        }
        return product;
    }
}
