//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

printNumbers();

        }

    public static void printNumbers() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz, ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz, ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz, ");
            } else if (i % 7 == 0) {
                System.out.print("Jazz, ");
            } else {
                System.out.print(i + ", ");
            }
            if (i % 10 == 0) {
                System.out.println();
                //كل عشر ارقام ينزل سطر جديد
            }
        }
    }
}
