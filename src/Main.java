import java.util.*;
import java.io.*;

// ================= USER (BASE CLASS) =================
class User {
    protected int id;
    protected String name;

    public User(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID!");
        }
        this.id = id;
        this.name = name;
    }
}

// ================= STUDENT (INHERITANCE) =================
class Student extends User {

    public Student(int id, String name) {
        super(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// ================= ATTENDANCE RECORD =================
class AttendanceRecord {
    protected Student student;
    protected HashMap<String, Boolean> attendance;

    public AttendanceRecord(Student student) {
        this.student = student;
        attendance = new HashMap<>();
    }

    public void markAttendance(String date, boolean status) {
        attendance.put(date, status);
    }

    // POLYMORPHISM METHOD
    public void showDetails() {
        System.out.println("Basic Attendance Record");
    }

    public void showAttendance() {
        System.out.println("Attendance of " + student.getName());
        for (String date : attendance.keySet()) {
            System.out.println(date + " : " + (attendance.get(date) ? "Present" : "Absent"));
        }
    }

    public double getPercentage() {
        int total = attendance.size();
        int present = 0;

        for (boolean val : attendance.values()) {
            if (val) present++;
        }

        if (total == 0) return 0;
        return (present * 100.0) / total;
    }

    public Student getStudent() {
        return student;
    }
}

// ================= POLYMORPHISM (OVERRIDING) =================
class DetailedAttendanceRecord extends AttendanceRecord {

    public DetailedAttendanceRecord(Student student) {
        super(student);
    }

    @Override
    public void showDetails() {
        System.out.println("Detailed Attendance Report for " + student.getName());
    }
}

// ================= MANAGER CLASS =================
class AttendanceManager {
    private ArrayList<AttendanceRecord> records;

    public AttendanceManager() {
        records = new ArrayList<>();
    }

    public void addStudent(Student s) {
        records.add(new DetailedAttendanceRecord(s));
    }

    public AttendanceRecord findRecord(int id) {
        for (AttendanceRecord r : records) {
            if (r.getStudent().getId() == id) {
                return r;
            }
        }
        return null;
    }

    public void markAttendance(int id, String date, boolean status) {
        AttendanceRecord r = findRecord(id);
        if (r != null) {
            r.markAttendance(date, status);
        } else {
            System.out.println("Student not found!");
        }
    }

    public void showReport(int id) {
        AttendanceRecord r = findRecord(id);
        if (r != null) {
            r.showDetails(); // polymorphism
            r.showAttendance();
            System.out.println("Percentage: " + r.getPercentage() + "%");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void showAllStudents() {
        for (AttendanceRecord r : records) {
            System.out.println(r.getStudent().getId() + " - " + r.getStudent().getName());
        }
    }

    // ================= FILE HANDLING =================
    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter("students.txt");
            for (AttendanceRecord r : records) {
                fw.write(r.getStudent().getId() + "," + r.getStudent().getName() + "\n");
            }
            fw.close();
            System.out.println("Data saved to file!");
        } catch (IOException e) {
            System.out.println("Error saving file!");
        }
    }
}

// ================= MAIN CLASS =================
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();

        while (true) {
            System.out.println("\n--- Attendance System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Report");
            System.out.println("4. Show All Students");
            System.out.println("5. Save to File");
            System.out.println("6. Exit");

            try {
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        manager.addStudent(new Student(id, name));
                        break;

                    case 2:
                        System.out.print("Enter Student ID: ");
                        int sid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Date: ");
                        String date = sc.nextLine();
                        System.out.print("Present? (true/false): ");
                        boolean status = sc.nextBoolean();

                        manager.markAttendance(sid, date, status);
                        break;

                    case 3:
                        System.out.print("Enter Student ID: ");
                        int rid = sc.nextInt();
                        manager.showReport(rid);
                        break;

                    case 4:
                        manager.showAllStudents();
                        break;

                    case 5:
                        manager.saveToFile();
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Try again.");
                sc.nextLine(); // clear buffer
            }
        }
    }
}