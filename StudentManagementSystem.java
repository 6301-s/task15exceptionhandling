import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Map<String, Student> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Retrieve Student");
            System.out.println("3. List All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Student Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        Student student = new Student(id, name, age);
                        System.out.println(student);
                        studentList.add(student);
                        studentMap.put(id, student);
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter Student ID to retrieve: ");
                        String retrieveId = scanner.nextLine();
                        Student retrievedStudent = studentMap.get(retrieveId);
                        if (retrievedStudent != null) {
                            System.out.println("Retrieved Student Details:");
                            System.out.println(retrievedStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 3:
                        System.out.println("List of All Students:");
                        for (Student s : studentList) {
                            System.out.println(s);
                        }
                        break;
                    case 4:
                        System.out.println("Exiting the program.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid option.");
                scanner.nextLine(); 
            }
        }
    }
}
