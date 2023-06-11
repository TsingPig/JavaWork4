import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _16 {
    public static void main(String[] args) {
        String inputFileName = "data.txt";
        String outputFileName = "data90.txt";

        try {
            // 读取原始数据文件
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            String line;
            String[][] data = null;
            int rows = 0;
            int columns = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (data == null) {
                    rows = parts.length;
                    columns = 1;
                    data = new String[rows][columns];
                } else {
                    columns++;
                    String[][] newData = new String[rows][columns];
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns - 1; j++) {
                            newData[i][j] = data[i][j];
                        }
                    }
                    data = newData;
                }
                for (int i = 0; i < parts.length; i++) {
                    data[i][columns - 1] = parts[i];
                }
            }
            reader.close();

            // 转置数据
            String[][] transposedData = new String[columns][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    transposedData[j][i] = data[i][j];
                }
            }

            // 写入转置后的数据到文件
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    writer.write(transposedData[i][j]);
                    if (j < rows - 1) {
                        writer.write(" ");
                    }
                }
                writer.newLine();
            }
            writer.close();

            System.out.println("数据转置完成，结果已写入" + outputFileName);
        } catch (IOException e) {
            System.out.println("发生IO异常: " + e.getMessage());
        }
    }
}
