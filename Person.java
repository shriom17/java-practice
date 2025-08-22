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
        Student s = new Student("Asish", 20, "BTech");
        Teacher t = new Teacher("Debesh", 40, "Physics");
        Doctor d = new Doctor("Chayan", 35, "Cardiology");

        s.displayDetails();
        t.displayDetails();
        d.displayDetails();
    }
}
