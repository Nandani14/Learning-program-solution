// Builder Pattern Example - Building a Student Profile

class Student {
    // required fields
    private String name;
    private int age;

    // optional fields
    private String course;
    private String email;

    // private constructor
    private Student(StudentBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.course = builder.course;
        this.email = builder.email;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        if (course != null) System.out.println("Course: " + course);
        if (email != null) System.out.println("Email: " + email);
    }

    // Static Builder Class
    public static class StudentBuilder {
        private String name;
        private int age;
        private String course;
        private String email;

        public StudentBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public StudentBuilder setCourse(String course) {
            this.course = course;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        // Nandani builds her profile step-by-step
        Student nandani = new Student.StudentBuilder("Nandani", 22)
                                    .setCourse("Java Full Stack")
                                    .setEmail("nandani@example.com")
                                    .build();

        nandani.showDetails();
    }
}

