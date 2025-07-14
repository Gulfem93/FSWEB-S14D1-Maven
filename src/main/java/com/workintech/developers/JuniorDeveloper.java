package com.workintech.developers;

public class JuniorDeveloper extends Employee {
    public JuniorDeveloper(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public void work() {
        System.out.println("Junior Developer starts coding with supervision");
        setSalary(getSalary() * 1.05); // %5 zam
    }
}