import java.io.*;

public class _0 {
    public static void copyFile(String sourceFile, String destFile) throws IOException {
        InputStream in = new FileInputStream(sourceFile);
        OutputStream out = new FileOutputStream(destFile);

        int byteRead;
        while ((byteRead = in.read()) != -1) {

            out.write(byteRead);
        }

        System.out.println("已成功复制完成");

        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        String sourceFile = "D:/1.dat";
        String destFile = "E:/1_copy.dat";


        copyFile(sourceFile, destFile);
    }
}
