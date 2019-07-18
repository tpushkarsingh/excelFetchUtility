import model.KeyModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictReader {

    public List<KeyModel> getKeyElement(){
        String dictFile = "egdict.txt";
        BufferedReader br = null;
        String lineBreak = ">>";
        String line;
        String splitOn= "\n";
        List<KeyModel> keyModelList = new ArrayList<KeyModel>();

        try {
            br = new BufferedReader(new FileReader(dictFile));

            List<String> attr = new ArrayList<String>();
            String keyHead="";
            int i =0;

            while ((line = br.readLine()) != null) {
                if(!line.trim().equalsIgnoreCase(lineBreak)){
                    if(i==0){
                        keyHead=line;
                    }
                    else{
                        if(line!=null && line.length()>0) {
                            attr.add(line);
                        }
                    }
                    i++;
                }
                else{
                    i=0;
                    KeyModel keyModel = new KeyModel();
                    keyModel.setAttributes(attr);
                    keyModel.setKeyHeader(keyHead);
                    if(keyHead!=null && keyHead.trim().length()>0) {
                        keyModelList.add(keyModel);
                    }
                    attr =new ArrayList<String>();


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
        return keyModelList;
    }
}
