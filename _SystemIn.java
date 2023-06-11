import java.io.*;

public class _SystemIn {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;

        OutputStream os = new FileOutputStream("D:/data.txt");
        int readByte;
        while ((readByte = in.read()) != -1) {
            os.write(readByte);
        }
        in.close();
        os.close();
    }
}
