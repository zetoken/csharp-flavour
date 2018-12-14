package fr.ztn.java.csharpflavour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AutoPropertyTest {

    @Test
    void Create() {
        AutoProperty<Integer> property = new AutoProperty<>();

        assertNull(property.get());
    }

    @Test
    void Update() {
        AutoProperty<Integer> property = new AutoProperty<>();

        property.set(666);

        assertEquals((Integer) 666, property.get());
    }

    @Test
    void UpdateIsPublishedToObservers() {
        AutoProperty<Integer> property = new AutoProperty<>();

        ByRef<Integer> caughtChange = new ByRef<>(42);
        property.onChanged.add((s, e) -> caughtChange.value = (int) e.getNewValue());
        property.set(666);

        assertEquals((Integer) 666, caughtChange.value);
    }
}
