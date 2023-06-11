import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class _ReadFile {
    public static void main(String[] args) throws IOException {
        String fileName = "D:/data.txt";
        //将文件内容包装进文件输入流，通过向上转型赋值
        // 给InputStream流，可扩展性更强
        //代码耦合度低
        InputStream in = new FileInputStream(fileName);
        int byteRead;
        while ((byteRead = in.read()) != -1) {
            System.out.print((char) byteRead);
        }

    }
}
