import java.io.*;

public class _InputStreamReader {
    public static void main(String[] args) throws IOException {
        String fileName = "D:/data.txt";
        FileInputStream fis = new FileInputStream(fileName);
        //将字节流包装为字符流，且为默认字符集编码
        InputStreamReader isr = new InputStreamReader(fis);
        int charRead;
        while ((charRead = isr.read()) != -1) {

            System.out.print((char) charRead);
        }
        fis.close();
        isr.close();
    }
}
