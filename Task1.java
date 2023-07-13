import java.util.*;

public class Task1 {
    private Map<String, List<String>> phoneBook;

    public Task1() {
        phoneBook = new HashMap<>();
    }

    public void addPhoneNumber(String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public void printPhoneBook() {
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(sortedEntries, (e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ":");
            Collections.sort(phoneNumbers);
            for (String phoneNumber : phoneNumbers) {
                System.out.println("\t" + phoneNumber);
            }
        }
    }

    public static void main(String[] args) {
        Task1 phoneBook = new Task1();
        phoneBook.addPhoneNumber("Иван", "7591325");
        phoneBook.addPhoneNumber("Петя", "6585549");
        phoneBook.addPhoneNumber("Иван", "1255487");
        phoneBook.addPhoneNumber("Леша", "6588456");

        phoneBook.printPhoneBook();
    }
}