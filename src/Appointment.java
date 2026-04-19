public class Appointment extends Person {

    private int id;
    private String clientName;
    private String service;
    private String date;
    private String time;

    public Appointment(int id, String clientName, String service, String date, String time) {
        super(clientName);
        this.id = id;
        this.clientName = clientName;
        this.service = service;
        this.date = date;
        this.time = time;
    }

    public int getId() { return id; }
    public String getClientName() { return clientName; }
    public String getService() { return service; }
    public String getDate() { return date; }
    public String getTime() { return time; }

    public void setService(String service) { this.service = service; }
    public void setDate(String date) { this.date = date; }
    public void setTime(String time) { this.time = time; }

    public String toFileString() {
        return id + "," + clientName + "," + service + "," + date + "," + time;
    }

    @Override
    public String toString() {
        return id + " | " + clientName + " | " + service + " | " + date + " " + time;
    }

    @Override
    public void display() {
        System.out.println("Appointment for: " + clientName);
    }
}