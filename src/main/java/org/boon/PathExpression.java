package org.boon;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.boon.Boon.atIndex;
import static org.boon.Boon.putl;
import static org.boon.Lists.lazyAdd;
import static org.boon.Lists.list;

/**
 * Created by Richard on 4/1/14.
 */
public class PathExpression {


    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void employeeExtractionBenchBoon(BlackHole bh) throws Exception {
        bh.consume(employeeExtractionBoon());
    }

    private Object employeeExtractionBoon() {
         return  atIndex(departments, "this.employees");
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void employeeExtractionBenchJava(BlackHole bh) throws Exception {
        bh.consume(employeeExtractionJava());
    }

    private Object employeeExtractionJava() {

        List<Employee> employees = new ArrayList();

        for (Department department : departments) {
            employees.addAll(department.getEmployees());
        }
        return employees;
    }




    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void getAllOfTheEmployeesFirstNameFromEmployeeListBoonBench(BlackHole bh) throws Exception {
        bh.consume(getAllOfTheEmployeesFirstNameFromEmployeeListBoon());
    }

    private Object getAllOfTheEmployeesFirstNameFromEmployeeListBoon() {
        return atIndex(allEmployees, "firstName");
    }



    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void getAllOfTheEmployeesFirstNameFromEmployeeListJavaBench(BlackHole bh) throws Exception {
        bh.consume(getAllOfTheEmployeesFirstNameFromEmployeeListJava());
    }

    private Object getAllOfTheEmployeesFirstNameFromEmployeeListJava() {

        List<String> employeesFirstNames = new ArrayList();

        for (Employee employee : allEmployees) {
            employeesFirstNames.add(employee.getFirstName());
        }
        return employeesFirstNames;
    }



    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void getAllOfTheEmployeesFirstNameFromDepartmentBoonBench(BlackHole bh) throws Exception {
        bh.consume(getAllOfTheEmployeesFirstNameFromDepartmentBoon());
    }

    private Object getAllOfTheEmployeesFirstNameFromDepartmentBoon() {
        return atIndex(departments, "employees.firstName");
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void getAllOfTheEmployeesFirstNameFromDepartmentJavaBench(BlackHole bh) throws Exception {
        bh.consume(getAllOfTheEmployeesFirstNameFromDepartmentJava());
    }

    private Object getAllOfTheEmployeesFirstNameFromDepartmentJava() {

        List<String> employeesFirstNames = new ArrayList();

        for (Department department : departments) {
            for (Employee employee : department.getEmployees()) {
                employeesFirstNames.add(employee.getFirstName());
            }
        }
        return employeesFirstNames;
    }



    public static class ContactInfo {
        String address;
        List<String> phoneNumbers;



    }

    public static class Employee {
        int id;
        int salary;
        String firstName;
        String lastName;

        ContactInfo contactInfo = new ContactInfo();

        public Employee() {
        }

        public Employee(int id, int salary, String firstName, String lastName,
                        String... phoneNumbers) {
            this.id = id;
            this.salary = salary;
            this.firstName = firstName;
            this.lastName = lastName;

            for (String phone : phoneNumbers) {
                contactInfo.phoneNumbers = lazyAdd(contactInfo.phoneNumbers, phone);
            }
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Employee employee = (Employee) o;

            if (id != employee.id) return false;
            if (salary != employee.salary) return false;
            if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
            if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + salary;
            result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
            result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", salary=" + salary +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    "}";
        }
    }
    public static class Department {
        private String name;

        private List<Employee> employees;

        public Department() {
        }

        public Department(String name ) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Department add(Employee... employees) {
            this.employees = lazyAdd(this.employees, employees);
            return this;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Department that = (Department) o;

            if (employees != null ? !employees.equals(that.employees) : that.employees != null) return false;
            if (name != null ? !name.equals(that.name) : that.name != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (employees != null ? employees.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    ", employees=" + employees +
                    '}';
        }
    }

    static List<Department> departments = list(
            new Department("Engineering").add(
                    new Employee(1, 100, "Rick", "Hightower", "555-555-1212"),
                    new Employee(2, 200, "John", "Smith", "555-555-1215", "555-555-1214", "555-555-1213"),
                    new Employee(3, 300, "Drew", "Donaldson", "555-555-1216"),
                    new Employee(4, 400, "Nick", "LaySacky", "555-555-1217")

            ),
            new Department("HR").add(
                    new Employee(1, 100, "Dianna", "Hightower", "555-555-1218"),
                    new Employee(2, 200, "Derek", "Smith", "555-555-1219"),
                    new Employee(3, 300, "Tonya", "Donaldson", "555-555-1220"),
                    new Employee(4, 400, "Sue", "LaySacky", "555-555-1221")

            )
    );


    static List<Employee> allEmployees;

    static {

        SortedSet<String> firstNames = RandomWordUtils.generateWords(100_000);
        Set<String> hashLastNames = new HashSet(RandomWordUtils.generateWords(100_000));
        List<String> lastNames = Lists.list(hashLastNames);

        Department department = new Department("FACTORY");


        int index = 0;

        for (String firstName : firstNames) {
            department.add(new Employee(index+20, index, firstName, lastNames.get(index), "555-555-1221"));
            index++;

        }

        departments.add(department);

        allEmployees = (List<Employee>) atIndex(departments, "this.employees");

    }

    public static void main(String... args) {

    }

}
