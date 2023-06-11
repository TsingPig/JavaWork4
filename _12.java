import java.io.*;

public class _12 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:/data.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line =reader.readLine())!=null){
            System.out.println(line);
        }
    }
}
