package fr.ztn.java.csharpflavour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReadOnlyPropertyTest {

    @Test
    void Create() {
        ByRef<Integer> backingField = new ByRef<>(42);
        ReadOnlyProperty<Integer> property = new ReadOnlyProperty<>(
                () -> backingField.value
        );

        assertEquals((Integer) 42, property.get());
    }

    @Test
    void Update() {
        ByRef<Integer> backingField = new ByRef<>(42);
        ReadOnlyProperty<Integer> property = new ReadOnlyProperty<>(
                () -> backingField.value
        );

        backingField.value = 666;

        assertEquals((Integer) 666, property.get());
    }
}
