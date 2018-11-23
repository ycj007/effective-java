package creating_destroying_objects.static_factory;

public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {
        if (instance != null) {
            throw new IllegalStateException();
        }
    }

    public static Singleton getInstance() {

        return instance;
    }
}
