public class Operator implements Employee {

  private double fixedSalary;

  public Operator(double fixedSalary) {
    this.fixedSalary = fixedSalary;
  }

  @Override
  public double getMonthSalary() {
    return fixedSalary;
  }
}
