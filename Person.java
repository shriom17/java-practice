import java.util.*;
public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    String course;

    Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("---- Student Details ----");
        super.displayDetails();
        System.out.println("Course: " + course);
        System.out.println("------------------------");
    }
}

class Teacher extends Person {
    String subject;
    
    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("---- Teacher Details ----");
        super.displayDetails();
        System.out.println("Subject: " + subject);
        System.out.println("------------------------");
    }
}

class Doctor extends Person {
    String specialization;
    
    Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("---- Doctor Details ----");
        super.displayDetails();
        System.out.println("Specialization: " + specialization);
        System.out.println("------------------------");
    }
}

class Main {
   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Enter student name: ");
    String studentName = scanner.nextLine();
    
    System.out.print("Enter student age: ");
    int studentAge = scanner.nextInt();
    scanner.nextLine(); 
    System.out.print("Enter student course: ");
    String studentCourse = scanner.nextLine();
    
    Student student = new Student(studentName, studentAge, studentCourse);
    

    System.out.print("Enter teacher name: ");
    String teacherName = scanner.nextLine();

    System.out.print("Enter teacher age: ");
    int teacherAge = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enter teacher subject: ");
    String teacherSubject = scanner.nextLine();

    Teacher teacher = new Teacher(teacherName, teacherAge, teacherSubject);
    

    System.out.print("Enter doctor name: ");
    String doctorName = scanner.nextLine();

    System.out.print("Enter doctor age: ");
    int doctorAge = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enter doctor specialization: ");
    String doctorSpecialization = scanner.nextLine();

    Doctor doctor = new Doctor(doctorName, doctorAge, doctorSpecialization);
    
    student.displayDetails();
    teacher.displayDetails();
    doctor.displayDetails();

    scanner.close();
}
}
