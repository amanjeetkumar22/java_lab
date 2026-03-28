package Project.HR;


import Project.General.Employee;
import Project.General.InvalidNameException;
import Project.General.InvalidSalaryException;

public class Manager extends Employee {

    public Manager(int empid, String ename, double basic)
            throws InvalidNameException, InvalidSalaryException {
        super(empid, ename, basic);
    }

    public double bonus() {
        return 0.20 * earnings();
    }
}