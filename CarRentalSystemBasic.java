import java.util.Scanner;

// Car class
class Car {
    String model;
    String regNumber;
    double rentalPrice;
    boolean available;

    Car(String model, String regNumber, double rentalPrice) {
        this.model = model;
        this.regNumber = regNumber;
        this.rentalPrice = rentalPrice;
        this.available = true;
    }
}

// Customer class
class Customer {
    String name;
    int id;

    Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- LOGIN SYSTEM ---
        String correctUser = "admin";
        String correctPass = "1234";
        boolean loggedIn = false;

        for (int tries = 1; tries <= 3; tries++) {
            System.out.print("Enter username: ");
            String user = sc.next();   // changed from nextLine() to next()

            System.out.print("Enter password: ");
            String pass = sc.next();   // changed from nextLine() to next()

            // Show password as stars
            String stars = "";
            for (int i = 0; i < pass.length(); i++) {
                stars += "*";
            }
            System.out.println("Password entered: " + stars);

            if (user.equals(correctUser) && pass.equals(correctPass)) {
                System.out.println("Login successful!");
                loggedIn = true;
                break;
            } else {
                System.out.println("Wrong username or password.");
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts. Exiting...");
            return;
        }

        // --- SIMPLE CAR RENTAL DEMO ---
        Car[] cars = {
            new Car("Toyota", "KAA123", 2000),
            new Car("Honda", "KBB456", 2500),
            new Car("BMW", "KCC789", 5000)
        };

        Customer cust = new Customer("John Doe", 1);

        System.out.println("Welcome, " + cust.name + "! Here are the cars available:");

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].available) {
                System.out.println(i + ". " + cars[i].model + " (" + cars[i].regNumber + ") Price: " + cars[i].rentalPrice);
            }
        }

        System.out.print("Enter the number of the car to rent: ");
        int choice = sc.nextInt();

        if (choice >= 0 && choice < cars.length && cars[choice].available) {
            cars[choice].available = false;
            System.out.println("You rented " + cars[choice].model);
        } else {
            System.out.println("Car not available.");
        }

        // show updated car list
        System.out.println("Updated car list:");
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i].model + " Available: " + cars[i].available);
        }
    }
}
