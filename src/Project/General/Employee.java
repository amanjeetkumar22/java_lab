package Project.General;
public class Employee {
    protected int empid;
    private String ename;
    protected double basic;

    public Employee(int empid, String ename, double basic)
            throws InvalidNameException, InvalidSalaryException {

        if (!ename.matches("[a-zA-Z]+")) {
            throw new InvalidNameException("Name must contain only alphabets");
        }

        if (basic < 0) {
            throw new InvalidSalaryException("Basic salary cannot be negative");
        }

        this.empid = empid;
        this.ename = ename.toUpperCase();
        this.basic = basic;
    }

    public double earnings() {
        double da = 0.80 * basic;
        double hra = 0.15 * basic;
        return basic + da + hra;
    }

    public String getEname() {
        return ename;
    }

    public int getEmpid() {
        return empid;
    }
}