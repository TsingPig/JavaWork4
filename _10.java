import java.io.*;

public class _10 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:/data.txt"; // 替换为你的文本文件路径

        Reader reader = new InputStreamReader(new FileInputStream(fileName));
        int charCode;
        while ((charCode = reader.read()) != -1) {
            char character = (char) charCode;
            System.out.print(character);
        }

        reader.close();
    }
}
