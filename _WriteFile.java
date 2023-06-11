
import java.io.*;

class _WriteFile {
    public static void main(String[] args) throws IOException {
        String fileName = "D:/data.txt";
        OutputStream os = new FileOutputStream(fileName, true);
        int cnt = 0;
        for (int i = 100; i <= 200; i++) {
            if (i % 3 == 0) {
                cnt++;
                String data = i + " ";
                if (cnt % 10 == 0)
                    data += "\n";
                //需要将写入的数据以字节数组的形式表示
                os.write(data.getBytes());
                //getBytes将字符串转换为字符数组，采用默认编码方式UTF-8
                //而直接写入的都是以二进制形式存储的整数或者其他数据类型
            }
        }
    }
}
