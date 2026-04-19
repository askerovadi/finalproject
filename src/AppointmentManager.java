import java.io.*;
import java.util.*;

public class AppointmentManager {

    private List<Appointment> appointments = new ArrayList<>();
    private int nextId = 1;
    private final String FILE_NAME = "appointments.txt";

    public void addAppointment(String name, String service, String date, String time) {
        Appointment a = new Appointment(nextId++, name, service, date, time);
        appointments.add(a);
        saveToFile();
        System.out.println("Appointment added!");
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments yet.");
            return;
        }

        for (Appointment a : appointments) {
            Person p = a;
            p.display();
            System.out.println(a);
        }
    }

    public void deleteAppointment(int id) {
        boolean removed = appointments.removeIf(a -> a.getId() == id);

        if (removed) {
            saveToFile();
            System.out.println("Appointment deleted!");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public void updateAppointment(int id, String service, String date, String time) {
        for (Appointment a : appointments) {
            if (a.getId() == id) {
                a.setService(service);
                a.setDate(date);
                a.setTime(time);
                saveToFile();
                System.out.println("Appointment updated!");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Appointment a : appointments) {
                writer.println(a.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                Appointment a = new Appointment(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4]
                );

                appointments.add(a);
                nextId = Math.max(nextId, a.getId() + 1);
            }
        } catch (IOException e) {
            System.out.println("No previous data.");
        }
    }

    public void exportToCSV() {
        try (PrintWriter writer = new PrintWriter("appointments_export.csv")) {
            for (Appointment a : appointments) {
                writer.println(a.toFileString());
            }
            System.out.println("Exported to CSV");
        } catch (Exception e) {
            System.out.println("Error exporting file");
        }
    }

    public void importFromCSV() {
        appointments.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("appointments_export.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                Appointment a = new Appointment(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4]
                );

                appointments.add(a);
                nextId = Math.max(nextId, a.getId() + 1);
            }
            System.out.println("Imported from CSV");
        } catch (Exception e) {
            System.out.println("Error importing file");
        }
    }
}
