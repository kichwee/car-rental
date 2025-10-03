import java.util.Scanner;
import com.carrentalsystem.models.Car;
import com.carrentalsystem.models.Customer;
import com.carrentalsystem.utils.LoginSystem;

public class CarRentalSystemBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- LOGIN SYSTEM ---
        String correctUser = "admin";
        String correctPass = "1234";
        boolean loggedIn = LoginSystem.login(sc, correctUser, correctPass);

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
            if (cars[i].isAvailable()) {
                System.out.println(i + ". " + cars[i].getModel() + " (" + cars[i].getRegNumber() + ") Price: " + cars[i].getRentalPrice());
            }
        }

        System.out.print("Enter the number of the car to rent: ");
        int choice = sc.nextInt();

        if (choice >= 0 && choice < cars.length && cars[choice].isAvailable()) {
            cars[choice].setAvailable(false);
            System.out.println("You rented " + cars[choice].getModel());
        } else {
            System.out.println("Car not available.");
        }

        // show updated car list
        System.out.println("Updated car list:");
        for (Car car : cars) {
            System.out.println(car.getModel() + " Available: " + car.isAvailable());
        }
    }
}