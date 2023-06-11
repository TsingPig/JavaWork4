import java.io.*;
import java.util.Random;

public class _3_DataStream {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        FileOutputStream fos = new FileOutputStream("D:/data.bat");
        DataOutputStream dos = new DataOutputStream(fos);
        //DataOutputStream对原本的fos进行包装
        //提供了对基本数据类型的输出功能
        for (int i = 0; i < 100; i++) {
            dos.writeInt(i);
        }
        dos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("D:/data.bat");
        DataInputStream dis = new DataInputStream(fis);

        int dataRead;
        while (dis.available() > 0) {
            dataRead=dis.readInt();
            System.out.print(dataRead + " ");
        }
        fis.close();
        dis.close();
    }
}
