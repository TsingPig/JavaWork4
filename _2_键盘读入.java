import java.io.*;

public class _2_键盘读入 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        FileOutputStream fos = new FileOutputStream("D:/data.txt");
        int byteRead;
        while ((byteRead = in.read()) != -1) {
            fos.write(byteRead);
        }
        fos.close();

    }
}
