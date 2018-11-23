package creating_destroying_objects.static_factory;

import java.util.*;

public class Lists {


    public static List getType(final ListType type) {

        Objects.requireNonNull(type);

        if (type == ListType.ARRAY_LIST) {

            return new ArrayList();
        } else if (type == ListType.lINKED_LIST) {

            return new LinkedList();
        } else {
            return Collections.emptyList();
        }


    }

    enum ListType {

        ARRAY_LIST,
        lINKED_LIST,
        EMPTY_LIST;

    }
}
