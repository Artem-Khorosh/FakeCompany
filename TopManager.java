public class TopManager implements Employee {

  private double fixedSalary;
  private Company company;

  public TopManager(double fixedSalary, Company company) {
    this.fixedSalary = fixedSalary;
    this.company = company;
  }

  @Override
  public double getMonthSalary() {
    if (company.getIncome() > 10000000) {
      return fixedSalary * 2.5;
    } else {
      return fixedSalary;
    }
  }
}
