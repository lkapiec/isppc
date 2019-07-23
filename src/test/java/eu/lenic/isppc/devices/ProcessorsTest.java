package eu.lenic.isppc.devices;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProcessorsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findSignature() {
        Signatures signatures;

        Processors procesors = new Processors();

        signatures = procesors.findSignature(new byte[]{ 0x00,0x00,0x00 });
        assertEquals(signatures.getName(), "AT89S53/8252");

        signatures = procesors.findSignature(new byte[]{ 0x00,0x01,0x02 });
        assertEquals(signatures.getName(), "CHIP LOCKED");

        signatures = procesors.findSignature(new byte[]{ (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        assertEquals(signatures.getName(), "");

        signatures = procesors.findSignature(new byte[]{(byte)0xFE, (byte)0xFE, (byte)0xFE });
        assertEquals(signatures, null);

        signatures = procesors.findSignature(new byte[]{ (byte)0xa0,0x24,0x12 });
        assertNotNull(signatures);
    }

    @Test
    void findName() {
        Signatures signatures;

        Processors procesors = new Processors();

        signatures = procesors.findName("");
        assertNotNull(signatures);

        signatures = procesors.findName("AAAAA");
        assertEquals(signatures, null);

        signatures = procesors.findName("AT89S53/8252");
        assertNotNull(signatures);

        signatures = procesors.findName("A");
        assertEquals(signatures, null);

        signatures = procesors.findName("AT24C1024");
        assertNotNull(signatures);
    }
}