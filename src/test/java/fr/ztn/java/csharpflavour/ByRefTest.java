package fr.ztn.java.csharpflavour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ByRefTest {
    @Test
    void CreateDefault() {
        assertNull(new ByRef<String>().value);
    }

    @Test
    void CreateInitialized() {
        assertEquals("ztn", new ByRef<>("ztn").value);
    }

    @Test
    void UpdateWrappedReference() {
        ByRef<String> byRef = new ByRef<>("ztn");
        byRef.value = "ZTn";
        assertEquals("ZTn", byRef.value);
    }
}
