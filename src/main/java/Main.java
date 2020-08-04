public class Main {
    public static void main(String[] args) {
        Config config;
        if(args.length > 0){

            switch(args[0]){
                    case "staging":
                    case "dev":
                        config = new Config("-" + args[0]);
                        break;
                    default:
                        config = new Config();
                }

        } else {
            config = new Config();
        }

    }
}
