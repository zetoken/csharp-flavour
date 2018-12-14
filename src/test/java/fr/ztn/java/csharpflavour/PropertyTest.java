package fr.ztn.java.csharpflavour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyTest {

    @Test
    void Create() {
        ByRef<Integer> backingField = new ByRef<>(42);
        Property<Integer> property = new Property<>(
                () -> backingField.value,
                (v) -> backingField.value = v
        );

        assertEquals((Integer) 42, property.get());
    }

    @Test
    void Update() {
        ByRef<Integer> backingField = new ByRef<>(42);
        Property<Integer> property = new Property<>(
                () -> backingField.value,
                (v) -> backingField.value = v
        );

        property.set(666);

        assertEquals((Integer) 666, property.get());
    }

    @Test
    void UpdateIsPublishedToObservers() {
        ByRef<Integer> backingField = new ByRef<>(42);
        Property<Integer> property = new Property<>(
                () -> backingField.value,
                (v) -> backingField.value = v
        );

        ByRef<Integer> caughtChange = new ByRef<>(42);
        property.onChanged.add((s, e) -> caughtChange.value = (int) e.getNewValue());
        property.set(666);

        assertEquals(666, (int) caughtChange.value);
    }
}
