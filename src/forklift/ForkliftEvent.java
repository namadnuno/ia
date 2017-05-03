package forklift;

import java.util.EventObject;

public class ForkliftEvent extends EventObject {

    public ForkliftEvent(ForkliftState source) {
        super(source);
    }
}
