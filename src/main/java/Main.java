public class Main {
    public static void main(String[] args) {
        Config config;
        if(args.length > 0){

            switch(args[0]){
                    case "staging":
                    case "dev":
                        config = new Config("/config-" + args[0] + ".txt");
                        break;
                    default:
                        config = new Config();
                }

        } else {
            config = new Config();
        }

        System.out.println(config.get("pipeline"));
    }
}
