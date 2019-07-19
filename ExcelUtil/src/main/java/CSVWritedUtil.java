import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWritedUtil {

    public void writeOutputToCSV(CSVWriter writer, String line, double score, StringBuffer headers){
        String[] data1 = { line,Double.toString(score) ,headers.toString() };
        writer.writeNext(data1);

    }


}
