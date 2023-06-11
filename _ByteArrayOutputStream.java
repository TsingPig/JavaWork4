import java.io.*;

public class _ByteArrayOutputStream {
    public static void main(String args[]) throws IOException {
        String inputData_str = "inputData_str";
        byte[] inputData = inputData_str.getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(inputData);
        //将输出流内容“复制”到字符数组中
        byte[] processData = baos.toByteArray();
        for (byte chr : processData) {
            System.out.print((char) chr + " ");
        }
        //通过字符解码将输出流内容“转换”到字符串中
        String processString = baos.toString();
        System.out.print(processString);
    }

}
