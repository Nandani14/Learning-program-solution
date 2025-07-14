// MVC Pattern Example - Managing student records

class Student {
    private String name;
    private String rollNo;

    public Student(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}

class StudentView {
    public void displayStudentDetails(String studentName, String studentRollNo) {
        System.out.println("----- Student Details -----");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}

class StudentController {
    private Student student;
    private StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public void setStudentRollNo(String rollNo) {
        student.setRollNo(rollNo);
    }

    public String getStudentName() {
        return student.getName();
    }

    public String getStudentRollNo() {
        return student.getRollNo();
    }

    public void updateView() {
        view.displayStudentDetails(student.getName(), student.getRollNo());
    }
}


public class MVCPattern {
    public static void main(String[] args) {
        // Nandani is the student
        Student nandani = new Student("Nandani", "CSIT1023");

        StudentView view = new StudentView();
        StudentController controller = new StudentController(nandani, view);

        controller.updateView(); // Initial display

        System.out.println("\nUpdating student name...");
        controller.setStudentName("Nandani Goswami");
        controller.updateView(); // Updated display
    }
}

