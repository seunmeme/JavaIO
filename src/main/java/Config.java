import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class Config {
    private static String path = "src/config/config";
    private HashMap<String, String> config;

    public Config(String fileName){
         config = new HashMap<String, String>();

        try(BufferedReader dirFile = new BufferedReader(new FileReader(path + fileName + ".txt"))){

            String input;
            String prefix = "";
            int count = 0;
            while((input = dirFile.readLine()) != null){
                if(input.startsWith("[") && input.endsWith("]")){
                    prefix = input.substring(1, input.length() - 1) + ".";
                    count++;
                }

                if(input.length() == 0 && count < 2){
                    prefix = "";
                }

                if(count > 1){
                    break;
                }

                if(input.contains("=")){
                    String[] data = input.split("=");
                    config.put(prefix + data[0], data[1]);
                }

            }
        } catch (IOException e){
            e.printStackTrace();
        }
}

    public Config (){
        this("");
    }


    public String get(String key){
        return config.get(key);
    }

}
