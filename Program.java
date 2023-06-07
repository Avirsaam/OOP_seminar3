package seminar03.task2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Program {

    static Random random = new Random();

    /**
     * @return генерирует рабочих (Employee) разных типов.
     */
    static Employee generateEmployee(){
        int employeeTypes = 2;
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

        int thisType = random.nextInt(employeeTypes);
        String thisName = names[random.nextInt(names.length)];
        String thisSurname = surnames[random.nextInt(surnames.length)];
        double salary = random.nextDouble(30_000, 100_000);
        int thisAge = random.nextInt(18, 65);


        switch (thisType){
        case 0:
            return new Worker(thisName, thisSurname, salary, thisAge);
        case 1:
            return new Freelancer(thisName, thisSurname, salary, thisAge);
        default:
            throw new IllegalArgumentException("Unknown employee type");
        }
    }


    /**
     * Придумать новые состояния для наших сотрудников - добавлено поле возраст
     * Придумать несколько Comparator'ов для сортировки сотрудников     *
     * по фамилии + имени:
     *   - сортировщик класса Employee переделан под сортировку по Фамилии а затем по имени
     *
     * или по возрасту и уровню ЗП.
     *   - реализовано отдельными компараторами
     *
     */
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmployee();
            System.out.println(employees[i]);
        }

        // Сортировка по Фамилии - имени
        System.out.println("\n Сортировка массива по ФАМИЛИИ + ИМЕНИ");
        System.out.println("-".repeat(20));
        Arrays.sort(employees); // new SalaryComparator()
        for(Employee employee : employees){
            System.out.printf("%s, %s \tвозраст %d\n",
                    employee.getSurname(), employee.getName(), employee.getAge());
            //System.out.println(employee);
        }

        System.out.println("\n Сортировка массива по Возрасту -> ЗП");
        System.out.println("-".repeat(20));
        Arrays.sort(employees, new AgeComparator());

        for(Employee employee : employees){
            System.out.printf("%-15s\t возраст %d,\t зарплата %.2f\n",
                    employee.getSurname(), employee.getAge(), employee.getSalary());
        }
    }
}
