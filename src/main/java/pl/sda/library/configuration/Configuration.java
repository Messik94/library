package pl.sda.library.configuration;

//SINGLETON

public class Configuration {

    private static Configuration instance;

    private Configuration(){

    }

    public static Configuration getInstance(){
        //TODO
        if (instance == null){
            instance = new Configuration();
        }
        return instance;
    }
}
