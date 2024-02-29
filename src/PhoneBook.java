import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, ArrayList<String>> phoneBook = new HashMap<>();

        // Read the input phone book
        System.out.print("Введите количество контактов: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите номер телефона: ");
            String number = scanner.nextLine();

            if (phoneBook.containsKey(name)) {
                ArrayList<String> numbers = phoneBook.get(name);
                numbers.add(number);
            } else {
                ArrayList<String> numbers = new ArrayList<>();
                numbers.add(number);
                phoneBook.put(name, numbers);
            }
        }

        // Sort the phone book by the number of phone numbers in descending order
        ArrayList<Map.Entry<String, ArrayList<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, ArrayList<String>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<String>> entry1, Map.Entry<String, ArrayList<String>> entry2) {
                return Integer.compare(entry2.getValue().size(), entry1.getValue().size());
            }
        });

        // Print the sorted phone book
        System.out.println("\nPhone Book:");
        for (Map.Entry<String, ArrayList<String>> entry : entries) {
            System.out.println("Name: " + entry.getKey());
            System.out.println("Phone Numbers: " + entry.getValue());
            System.out.println();
        }
    }
}

