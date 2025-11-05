package testingCode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashingAndEquals {
    public static void main(String[] args) {
        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee("Pratik", "pratik@gmail.com"));
        employees.add(new Employee("Pratik", "pratik@gmail.com"));


        System.out.println(employees.size());
    }
}

class Employee{
    private String name;
    private String email;

    public Employee(String name, String email){
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        Employee emp = (Employee) obj;
        return this.name == emp.name && this.email == emp.email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}


