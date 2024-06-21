import java.util.Random;

public class Manager implements Employee {

  private double fixedSalary;
  private double bonus;
  private Company company;
  private double earnings;


  public Manager(double fixedSalary, Company company) {
    this.fixedSalary = fixedSalary;
    this.company = company;
    Random random = new Random();
     earnings = 115000 + (140000 - 115000) * random.nextDouble();
    this.bonus = earnings * 0.05;
    this.company.addIncome(earnings);
  }
  public double getEarnings() {
    return earnings;
  }

  @Override
  public double getMonthSalary() {
    return fixedSalary + bonus;
  }
}
