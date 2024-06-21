import java.util.List;

public class Main {

  public static void main(String[] args) {
    Company company = new Company();
    for (int i = 0; i < 180; i++) {
      company.hire(new Operator(30000));
    }
    for (int i = 0; i < 80; i++) {
      company.hire(new Manager(50000, company));
    }
    for (int i = 0; i < 10; i++) {
      company.hire(new TopManager(100000, company));
    }
    List<Employee> topSalaryStaff = company.getTopSalaryStaff(10);
    System.out.println("10 самых высоких зарплат:");
    for (Employee employee : topSalaryStaff) {
      System.out.println(employee.getMonthSalary());
    }

    List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(30);
    System.out.println("30 самых низких зарплат:");
    for (Employee employee : lowestSalaryStaff) {
      System.out.println(employee.getMonthSalary());
    }

    company.firePercentage(50);
    topSalaryStaff = company.getTopSalaryStaff(10);
    System.out.println("10 самых высоких зарплат после увольнения:");
    for (Employee employee : topSalaryStaff) {
      System.out.println(employee.getMonthSalary());
    }

    lowestSalaryStaff = company.getLowestSalaryStaff(30);
    System.out.println("30 самых низких зарплат после увольнения:");
    for (Employee employee : lowestSalaryStaff) {
      System.out.println(employee.getMonthSalary());
    }
  }

}
