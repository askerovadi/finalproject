import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AppointmentManager manager = new AppointmentManager();

        manager.loadFromFile();

        while (true) {
            System.out.println("\nBeauty Room ");
            System.out.println("1. Add Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Delete Appointment");
            System.out.println("4. Update Appointment");
            System.out.println("5. Export to CSV");
            System.out.println("6. Import from CSV");
            System.out.println("7. Exit");

            int choice;

            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Please enter a number.");
                    scanner.nextLine();
                }
            }

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                while (name.isBlank()) {
                    System.out.print("Name cannot be empty. Enter name: ");
                    name = scanner.nextLine();
                }
                System.out.println("Choose service:");
                System.out.println("1. Nails");
                System.out.println("2. Eyelashes");
                System.out.println("3. Eyebrows");
                System.out.println("4. Haircut");
                System.out.println("5. Styling");

                int serviceChoice = scanner.nextInt();
                scanner.nextLine();

                String service = switch (serviceChoice) {
                    case 1 -> "Nails";
                    case 2 -> "Eyelashes";
                    case 3 -> "Eyebrows";
                    case 4 -> "Haircut";
                    case 5 -> "Styling";
                    default -> "Nails";
                };

                LocalDate date;
                while (true) {
                    try {
                        System.out.print("Enter date (YYYY-MM-DD): ");
                        date = LocalDate.parse(scanner.nextLine());
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid date!");
                    }
                }

                LocalTime time;
                while (true) {
                    try {
                        System.out.print("Enter time (HH:MM): ");
                        time = LocalTime.parse(scanner.nextLine());
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid time!");
                    }
                }

                manager.addAppointment(name, service, date.toString(), time.toString());

            } else if (choice == 2) {
                manager.viewAppointments();

            } else if (choice == 3) {
                System.out.print("Enter ID to delete: ");
                int id = scanner.nextInt();
                manager.deleteAppointment(id);

            } else if (choice == 4) {
                System.out.print("Enter ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("New service: ");
                String service = scanner.nextLine();

                System.out.print("New date: ");
                String date = scanner.nextLine();

                System.out.print("New time: ");
                String time = scanner.nextLine();

                manager.updateAppointment(id, service, date, time);

            } else if (choice == 5) {
                manager.exportToCSV();

            } else if (choice == 6) {
                manager.importFromCSV();
            } else if (choice == 7) {
                break;
            }
        }
    }
}