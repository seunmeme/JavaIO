import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class Config {
//    make path work for every OS.
    private File file = new File("src/config/config");
    private String path = file.getAbsolutePath();

    private HashMap<String, String> config;

//    constructor with argument
    public Config(String fileName){
         config = new HashMap<String, String>();
         if(fileName == "dev" || fileName == "staging"){
             path += "-";
         }

        try(BufferedReader dirFile = new BufferedReader(new FileReader(path + fileName + ".txt"))){

            String input;
            String prefix = "";
            int count = 0;
            String[] keyValuePair;

            while((input = dirFile.readLine()) != null){
//              check if string has square brackets and make it a prefix if it is.
//                Also keep track of number of times the operation was performed.
                if(input.startsWith("[") && input.endsWith("]")){
                    prefix = input.substring(1, input.length() - 1) + ".";
                    count++;
                }

//              remove prefix if an empty line is encountered while reading data
                if(input.length() == 0 && count < 2){
                    prefix = "";
                }

//                stop reading data if a prefix is added the second time.
                if(count > 1){
                    break;
                }

//               add valid string into HashMap
                if(input.contains("=")){
                    keyValuePair = input.split("=");
                    config.put(prefix + keyValuePair[0], keyValuePair[1]);
                }

            }
//            System.out.println(path);
        } catch (IOException e){
            e.printStackTrace();
        }
}

//    constructor without argument
    public Config (){
        this("");
    }

//    method for getting values in config.
    public String get(String key){
        return config.get(key);
    }

}
