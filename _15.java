import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入起始数p：");
        int p = scanner.nextInt();
        System.out.print("请输入结束数s：");
        int s = scanner.nextInt();
        System.out.print("请输入每行质数的个数t：");
        int t = scanner.nextInt();

        scanner.close();

        List<Integer> primeNumbers = generatePrimeNumbers(p, s);
        writePrimeNumbersToFile(primeNumbers, t);
    }

    public static List<Integer> generatePrimeNumbers(int p, int s) {
        List<Integer> primes = new ArrayList<>();
        for (int i = p; i <= s; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void writePrimeNumbersToFile(List<Integer> primeNumbers, int t) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("primes.txt"))) {
            int count = 0;
            int sum = 0;
            for (int number : primeNumbers) {
                writer.write(String.valueOf(number));
                writer.write(" ");
                sum += number;
                count++;
                if (count % t == 0) {
                    writer.write(String.valueOf(sum));
                    writer.newLine();
                    sum = 0;
                }
            }
            if (count % t != 0) {
                writer.write(String.valueOf(sum));
                writer.newLine();
            }
            System.out.println("质数已成功写入primes.txt文件。");
        } catch (IOException e) {
            System.out.println("发生IO异常: " + e.getMessage());
        }
    }
}
