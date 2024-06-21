import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Company {

  private final List<Employee> employees = new ArrayList<>();
  private double income;

  public double getIncome() {
    return income;
  }

  public void addIncome(double income) {
    if (income > 0) {
      this.income += income;
    }
  }


  public void hire(Employee employee) {
    if (employee != null) {
      employees.add(employee);
    }
  }

  public void hireAll(Collection<Employee> employees) {
    if (employees != null && !employees.isEmpty()) {
      this.employees.addAll(employees);
    }
  }

  public void fire(Employee employee) {
    employees.remove(employee);
    if (employee instanceof Manager) {
      Manager manager = (Manager) employee;
      income -= manager.getEarnings();
    }
  }


  public List<Employee> getTopSalaryStaff(int count) {
    if (count <= 0) {
      return Collections.emptyList();

    }
    return employees.stream()
        .sorted(Comparator.comparing(Employee::getMonthSalary).reversed())
        .limit(count).collect(Collectors.toList());
  }

  public List<Employee> getLowestSalaryStaff(int count) {
    if (count <= 0) {
      return Collections.emptyList();
    }
    return employees.stream()
        .sorted(Comparator.comparing(Employee::getMonthSalary))
        .limit(count).collect(Collectors.toList());
  }

  public void firePercentage(int percentage) {
    if (percentage <= 0 || percentage > 100) {
      return;
    }
    int countToFire = employees.size() * percentage / 100;
    Collections.shuffle(employees);
    List<Employee> employeesToFire = new ArrayList<>(employees.subList(0, countToFire));
    for (Employee employee : employeesToFire) {
      fire(employee);
    }
  }
}
