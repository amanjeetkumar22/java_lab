class University {
    String universityName;
    String location;

    // Constructor of outer class
    University(String universityName, String location) {
        this.universityName = universityName;
        this.location = location;
    }

    // Inner class
    class Department {
        String deptName;
        String hodName;

        // Constructor of inner class
        Department(String deptName, String hodName) {
            this.deptName = deptName;
            this.hodName = hodName;
        }

        // Method to display details
        void display() {
            System.out.println("University Name: " + universityName);
            System.out.println("Location: " + location);
            System.out.println("Department Name: " + deptName);
            System.out.println("HOD Name: " + hodName);
        }
    }

    // Method to create inner class object
    void createDepartment() {
        Department d = new Department("Computer Science", "Dr. Sharma");
        d.display();
    }

    // Main method
    public static void main(String[] args) {
        University u = new University("KIIT University", "Bhubaneswar");
        u.createDepartment();
    }
}
