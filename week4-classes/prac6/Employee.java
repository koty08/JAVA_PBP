import java.util.Objects;

public class Employee {
    private final String name;
    private final Double salary;

    public Employee(String name, Double salary){
        this.name = name; this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public Double getSalary(){
        return salary;
    }

    @Override
    public String toString(){
        return String.format("%s %.1f", name, salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}
