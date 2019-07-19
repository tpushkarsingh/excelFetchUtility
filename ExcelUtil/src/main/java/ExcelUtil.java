import com.opencsv.CSVWriter;
import model.KeyModel;

import java.io.*;
import java.util.List;

public class ExcelUtil {
    public static void main(String[] args) {
        DictReader dr = new DictReader();
        List<KeyModel> keyModelList =dr.getKeyElement();
        String csvFile = "sample.csv";
        BufferedReader br = null;
        String line = "";


        try {

            br = new BufferedReader(new FileReader(csvFile));
            File file = new File("output.csv");
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);

            while ((line = br.readLine()) != null) {
                double score=0;
                StringBuffer headers= new StringBuffer();
                for(int i=0;i<keyModelList.size();i++){
                    for(int j=0;j<keyModelList.get(i).getAttributes().size();j++){
                        String valueToFetch =keyModelList.get(i).getAttributes().get(j);
                        if(line.contains(valueToFetch)){
                            score++;
                            headers.append(keyModelList.get(i).getKeyHeader()+" ,");
                        }

                    }
                }
                if(score>1){
                    score=0.5;
                    System.out.println("Line ==>"+line);
                    System.out.println("Score 1 " + "value found"+headers );
                }
                CSVWritedUtil cw = new CSVWritedUtil();
                cw.writeOutputToCSV(writer,line,score,headers);
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
