import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact must not be null.");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        requireContact(contactId);
        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        requireContact(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        requireContact(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        requireContact(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        requireContact(contactId).setAddress(address);
    }

    public Contact getContact(String contactId) {
        return requireContact(contactId);
    }

    public int getContactCount() {
        return contacts.size();
    }

    private Contact requireContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("No contact exists for the supplied contact ID.");
        }
        return contacts.get(contactId);
    }
}
