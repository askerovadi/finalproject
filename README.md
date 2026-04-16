# Final Project
**Appointment Booking System**
Manages appointment bookings for various services or professionals, allowing scheduling and cancellation of appointments
## Askerova Diana | COMFCI-25
##  Objectives
The main objective of this project is to develop a console-based appointment booking system for a beauty salon that simplifies and organizes the process of managing client bookings.
The project aims to:
- Allow users to create, view, update, and delete appointments (CRUD functionality)
- Provide a clear and user-friendly command-line interface for interaction
- Ensure data accuracy through input validation for date and time
- Store appointment data persistently using file handling
- Apply Object-Oriented Programming principles such as encapsulation, inheritance, and polymorphism
- Enable data portability through import and export functionality (CSV format)
Additionally, the system is designed to reduce manual errors in booking management and improve overall efficiency in handling customer appointments.
## Project Requirement List
The following requirements define the key features and functionalities implemented in the project:

1. The system must allow users to create new appointments.
2. The system must display all existing appointments.
3. The system must allow users to update appointment details by ID.
4. The system must allow users to delete appointments by ID.
5. The system must provide a clear Command Line Interface (CLI) with menu options.
6. The system must validate user input for date and time formats.
7. The system must store data in a file to ensure persistence between program runs.
8. The system must load existing data from a file when the program starts.
9. The system must use Object-Oriented Programming principles (encapsulation, inheritance, polymorphism).
10. The system must assign a unique ID to each appointment automatically.
11. The system must allow exporting data to a CSV file.
12. The system must allow importing data from a CSV file.

## Documentation
### Algorithms and Logic
The system is based on a simple CRUD (Create, Read, Update, Delete) algorithm for managing appointments.
- Create: A new appointment is created and added to the list with a unique ID.
- Read: All appointments are displayed using a loop through the list.
- Update: The system searches for an appointment by ID and updates its fields.
- Delete: The system removes an appointment by ID using conditional filtering.
The program uses a menu-driven loop to continuously interact with the user until exit.

### Data Structures
- The application uses an ArrayList to store appointment objects.
- ArrayList allows dynamic resizing and easy manipulation of data (add, remove, iterate).

### Functions and Modules
The system is divided into several classes:

- Main
  - Handles user input and menu navigation.
  - Controls program flow.
- AppointmentManager
  - Contains business logic.
  - Implements CRUD operations.
  - Handles file operations (save/load, import/export).
- Appointment
  - Represents a single appointment.
  - Stores all appointment data (id, name, service, date, time).
- Person
  - Parent class for demonstrating inheritance.

### File Handling
- Data is stored in a text file (`appointments.txt`).
- Each appointment is saved as a comma-separated string.
- The system loads data from the file at startup and saves after each change.
Additionally:
- CSV export allows saving data externally.
- CSV import allows restoring data into the system.

### Challenges Faced
During development, several challenges were encountered:
- Implementing correct file reading and writing without data loss
- Maintaining unique ID generation after loading data from file
- Handling invalid user input for date and time
- Designing a modular structure using OOP principles
- Ensuring synchronization between in-memory data and file storage

### Possible Improvements
- Add a graphical user interface (GUI)
- Integrate a database (MySQL, SQLite)
- Add user authentication and roles
- Integrate with Google Calendar for notifications    


    
