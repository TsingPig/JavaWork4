import java.io.*;

public class _11 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:/data.txt";

        Reader reader = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
        int charCode;
        while ((charCode = reader.read()) != -1) {
            char character = (char) charCode;
            System.out.print(character);
        }

        reader.close();
    }
}
