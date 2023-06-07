package seminar03.task2;

/**
 * DONE: Спроектировать класс Freelancer самостоятельно в рамках домашнего задания.
 *  *20*8
 */
public class Freelancer extends Employee {

    public Freelancer(String name, String surname, double salary, int age) {
        super(name, surname, salary, age);
    }


    /**
     * @return возвращает зарплату из расчета 40 рабочих часов в неделю
     */
    @Override
    public double calculateSalary() {
        return salary;
    }

    /**
     * @param workHours - количество рабочих часов
     * @return - возвращает зарплату из расчета фактически отработанных часов
     */
    public double calculateSalary(int workHours) {
        return salary / 40 * workHours;
    }

    public String toString() {
        return String.format("Фрилансер: %s Зарплата (40 час/нед) %.2f",
                super.toString(), calculateSalary());
    }

}
