import model.KeyModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
            while ((line = br.readLine()) != null) {


                for(int i=0;i<keyModelList.size();i++){
                    for(int j=1;j<keyModelList.get(i).getAttributes().size();j++){
                        String valueToFetch =keyModelList.get(i).getAttributes().get(j);
                        if(line.contains(valueToFetch)){
                            System.out.println("Line ==>"+line);
                            System.out.println("Score 1 " + "value found"+valueToFetch );
                        }

                    }
                }

            }

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
