import java.util.*;

public class PhoneBook {
    private final Map<String, Person> phoneBookMap = new HashMap<>();
    private final Set<String> emailSet = new HashSet<>();

    public void addPerson(Person person) {
        if (emailSet.contains(person.getEmail()) && !person.getPhoneNumber().equals(getPhoneNumberByEmail(person.getEmail()))) {
            throw new IllegalArgumentException("Ten adres e-mail już istnieje.");
        }
        phoneBookMap.put(person.getPhoneNumber(), person);
        emailSet.add(person.getEmail());
    }

    public void removePerson(String phoneNumber) {
        if (!phoneBookMap.containsKey(phoneNumber)) {
            throw new NoSuchElementException("Nie znaleziono osoby o podanym numerze telefonu.");
        }
        Person removed = phoneBookMap.remove(phoneNumber);
        emailSet.remove(removed.getEmail());
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        return phoneBookMap.get(phoneNumber);
    }

    public List<Person> getSortedPeople() {
        List<Person> sortedList = new ArrayList<>(phoneBookMap.values());
        sortedList.sort(Comparator.comparing(Person::getName));
        return sortedList;
    }

    public List<String> getSortedEmails() {
        List<String> sortedEmails = new ArrayList<>(emailSet);
        Collections.sort(sortedEmails);
        return sortedEmails;
    }

    private String getPhoneNumberByEmail(String email) {
        for (Map.Entry<String, Person> entry : phoneBookMap.entrySet()) {
            if (entry.getValue().getEmail().equals(email)) {
                return entry.getKey();
            }
        }
        return null;
    }
}

