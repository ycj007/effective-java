package creating_destroying_objects.static_factory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {


    public static Map newHashMap() {
        return new HashMap<>();
    }

    public static Map newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static Map newTreeMap() {
        return new TreeMap();
    }

    public static Map newConcurrentHashMap() {
        return new ConcurrentHashMap();
    }
}
