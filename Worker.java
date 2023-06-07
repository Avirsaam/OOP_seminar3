package seminar03.task2;

public class Worker extends Employee {

    public Worker(String name, String surname, double salary, int age) {
        super(name, surname, salary, age);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Рабочий: %s Зарплата (фикс. ставка) %.2f",
                super.toString(), calculateSalary() );
    }
}
