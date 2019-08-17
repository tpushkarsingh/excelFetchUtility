import java.io.File;

public class FileIterator {
    public static void main(String[] args) {
        File dir = new File("datafiles");
        File[] directoryListing = dir.listFiles();
        if(directoryListing!=null){
            for(File child: directoryListing){
                ExcelUtil excelUtil = new ExcelUtil();
                String filePath = child.getAbsolutePath();
                String outputPath = filePath.substring(0,filePath.lastIndexOf('\\')+1)+"output"+child.getName();
                excelUtil.execute(filePath,outputPath);
            }
        }


    }

}
