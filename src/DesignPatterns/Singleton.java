package DesignPatterns;

public class Singleton {
    private static Singleton instance;
    // if you know Singleton is used atleast once then go with eager initialization
    // private static Singleton instance = new Singleton(); or
//    static {
//         instance = new Singleton();
//    }
    private Singleton(){

    }
    public static Singleton getInstance(){
        synchronized (Singleton.class){ // to ensure thread safe , add synchronized and ( lock class) so that only 1 thread can be accessed at once
            if(instance == null){
                instance =  new Singleton();
            }
        }
            return  instance;
    }

}
