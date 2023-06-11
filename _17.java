import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class _17 {
    public static void main(String[] args) {
        String outputFileName = "result.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            for (int number = 100; number <= 999; number++) {
                int square = number * number;
                String squareString = String.valueOf(square);

                if (squareString.contains(String.valueOf(number))) {
                    writer.write(String.format("%-6d %-8d%n", number, square));
                }
            }

            writer.close();
            System.out.println("结果已写入" + outputFileName);
        } catch (IOException e) {
            System.out.println("发生IO异常: " + e.getMessage());
        }
    }
}
