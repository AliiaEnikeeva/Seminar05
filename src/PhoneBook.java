//Реализуйте структуру телефонной книги с помощью HashMap,
//учитывая, что 1 человек может иметь несколько телефонов.

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    private HashMap<String, List> contacts;

    public PhoneBook() {
        contacts = new HashMap<String, List>();
    }

    public void addPhoneNumber(String name, String number) {
        List numbers;
        if (contacts.containsKey(name)) {
            numbers = contacts.get(name);
        }
        else {
            numbers = new ArrayList();
            contacts.put(name,numbers);
        }
        numbers.add(number);
    }

    public void printAllNumbers() {
        for (String name:contacts.keySet()) {
            System.out.print(name + ":");
            List numbers = contacts.get(name);
            for (Object number:numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 to add a phone number or 2 to print all numbers:");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter name:");
                String name = scanner.next();
                System.out.println("Enter phone number:");
                String number = scanner.next();
                phoneBook.addPhoneNumber(name, number);
            } else if (choice == 2) {
                phoneBook.printAllNumbers();
            }
        }
    }
}
