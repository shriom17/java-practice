public class Calculator {
    private static int totalCalculations = 0;

    public void add(int a, int b) {
        totalCalculations++;
        System.out.println("Addition: " + (a + b));
    }

    public static void showOperationCount() {
        System.out.println("Total Calculations: " + totalCalculations);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add(5, 10);
        calc.add(3, 7);
        Calculator.showOperationCount();
    }
}
