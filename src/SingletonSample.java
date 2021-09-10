public class SingletonSample {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton == enumSingleton2);

    }
}

class Singleton{
    private static volatile Singleton instance;
    private int i;

    private Singleton() {
    }


    public int getValue(){
        return i;
    }

    static Singleton getInstance() {
        if(instance == null){
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
enum EnumSingleton{
    INSTANCE;

    private int i;

    public int getValue() {
        return i;
    }
}
