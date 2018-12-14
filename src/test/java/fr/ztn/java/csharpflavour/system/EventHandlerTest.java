package fr.ztn.java.csharpflavour.system;

import fr.ztn.java.csharpflavour.ByRef;
import fr.ztn.java.csharpflavour.ReadOnlyProperty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventHandlerTest {

    class MyEventArgs extends EventArgs {
        private String _hiddenMessage;
        final ReadOnlyProperty<String> message = new ReadOnlyProperty<>(() -> _hiddenMessage);

        MyEventArgs(String message) {
            _hiddenMessage = message;
        }
    }

    @Test
    void FireAnEVentToObservers() {
        EventHandler<MyEventArgs> event = new EventHandler<>();

        ByRef<String> caughtMessage = new ByRef<>();
        event.add((s, e) -> caughtMessage.value = e.message.get());
        ByRef<String> otherCaughtMessage = new ByRef<>();
        event.add((s, e) -> otherCaughtMessage.value = e.message.get() + " again");
        event.invoke(this, new MyEventArgs("ztn"));

        assertEquals("ztn", caughtMessage.value);
        assertEquals("ztn again", otherCaughtMessage.value);
    }
}
