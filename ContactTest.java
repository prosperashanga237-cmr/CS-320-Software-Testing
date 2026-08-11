import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testValidContact() {
        Contact contact = new Contact("1234567890", "Prosper", "Ashanga", "3015550123", "100 Main Street");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Prosper", contact.getFirstName());
        assertEquals("Ashanga", contact.getLastName());
        assertEquals("3015550123", contact.getPhone());
        assertEquals("100 Main Street", contact.getAddress());
    }

    @Test
    void testBoundaryLengthsAreAccepted() {
        Contact contact = new Contact(
                "1234567890",
                "ABCDEFGHIJ",
                "KLMNOPQRST",
                "0123456789",
                "123456789012345678901234567890");
        assertEquals(10, contact.getContactId().length());
        assertEquals(10, contact.getFirstName().length());
        assertEquals(10, contact.getLastName().length());
        assertEquals(10, contact.getPhone().length());
        assertEquals(30, contact.getAddress().length());
    }

    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "Prosper", "Ashanga", "3015550123", "100 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "Prosper", "Ashanga", "3015550123", "100 Main Street"));
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", null, "Ashanga", "3015550123", "100 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "ABCDEFGHIJK", "Ashanga", "3015550123", "100 Main Street"));
    }

    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Prosper", null, "3015550123", "100 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Prosper", "ABCDEFGHIJK", "3015550123", "100 Main Street"));
    }

    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Prosper", "Ashanga", null, "100 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Prosper", "Ashanga", "301555012", "100 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Prosper", "Ashanga", "30155501234", "100 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Prosper", "Ashanga", "30155A0123", "100 Main Street"));
    }

    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Prosper", "Ashanga", "3015550123", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Prosper", "Ashanga", "3015550123",
                        "1234567890123456789012345678901"));
    }

    @Test
    void testSettersEnforceRequirements() {
        Contact contact = new Contact("1", "Prosper", "Ashanga", "3015550123", "100 Main Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("ABCDEFGHIJK"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345"));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setAddress("1234567890123456789012345678901"));
    }
}
