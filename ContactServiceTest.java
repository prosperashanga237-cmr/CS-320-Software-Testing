import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("C001", "Prosper", "Ashanga", "3015550123", "100 Main Street");
    }

    @Test
    void testAddContactWithUniqueId() {
        service.addContact(contact);
        assertEquals(1, service.getContactCount());
        assertEquals(contact, service.getContact("C001"));
    }

    @Test
    void testRejectDuplicateId() {
        service.addContact(contact);
        Contact duplicate = new Contact("C001", "Another", "Person", "2405550199", "200 Second Street");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
        assertEquals(1, service.getContactCount());
    }

    @Test
    void testRejectNullContact() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void testDeleteContactById() {
        service.addContact(contact);
        service.deleteContact("C001");
        assertEquals(0, service.getContactCount());
        assertThrows(IllegalArgumentException.class, () -> service.getContact("C001"));
    }

    @Test
    void testRejectDeleteForUnknownId() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("UNKNOWN"));
    }

    @Test
    void testUpdateFirstName() {
        service.addContact(contact);
        service.updateFirstName("C001", "James");
        assertEquals("James", service.getContact("C001").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        service.addContact(contact);
        service.updateLastName("C001", "Smith");
        assertEquals("Smith", service.getContact("C001").getLastName());
    }

    @Test
    void testUpdatePhone() {
        service.addContact(contact);
        service.updatePhone("C001", "2405550199");
        assertEquals("2405550199", service.getContact("C001").getPhone());
    }

    @Test
    void testUpdateAddress() {
        service.addContact(contact);
        service.updateAddress("C001", "250 Updated Avenue");
        assertEquals("250 Updated Avenue", service.getContact("C001").getAddress());
    }

    @Test
    void testRejectUpdatesForUnknownId() {
        assertThrows(IllegalArgumentException.class,
                () -> service.updateFirstName("UNKNOWN", "James"));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateLastName("UNKNOWN", "Smith"));
        assertThrows(IllegalArgumentException.class,
                () -> service.updatePhone("UNKNOWN", "2405550199"));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateAddress("UNKNOWN", "250 Updated Avenue"));
    }

    @Test
    void testUpdateValidation() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class,
                () -> service.updateFirstName("C001", "ABCDEFGHIJK"));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateLastName("C001", null));
        assertThrows(IllegalArgumentException.class,
                () -> service.updatePhone("C001", "12345"));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateAddress("C001", "1234567890123456789012345678901"));
    }

    @Test
    void testContactIdIsNotUpdatable() {
        service.addContact(contact);
        assertEquals("C001", service.getContact("C001").getContactId());
    }
}
