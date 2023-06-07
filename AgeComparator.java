package seminar03.task2;

import java.util.Comparator;

public class AgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        int result = Integer.compare(o1.getAge(), o2.getAge());
        if (result == 0)
            return Double.compare(o1.getSalary(), o2.getSalary());
        return result;
    }
}
