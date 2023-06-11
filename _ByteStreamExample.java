import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class _ByteStreamExample {
    public static void main(String[] args) {
        String inputData_str="inputData_str";
        byte[] inputData=inputData_str.getBytes();
        //byte[] inputData = {1, 2, 3, 4, 5};
        ByteArrayInputStream bais = new ByteArrayInputStream(inputData);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int dataRead;
        while ((dataRead = bais.read()) != -1) {
            baos.write(dataRead);
        }
        byte[] processedData = baos.toByteArray();
        for (byte data : processedData) {
            System.out.print((char)data + " ");
        }
    }
}
/*
*
   // 假设有一个输入流，将数据从输入流读取并写入字节数组输出流
        //输入数据，希望输入到磁盘中
        byte[] inputData = {10, 20, 30, 40, 50};
        //将输入数据的字节数组封装成字节输入流方便读取
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        //创建字符输出流，作为内存中的缓冲区，减少频繁的磁盘IO读写
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // 从输入流读取数据，并写入字节数组输出流
        int data;
        while ((data = inputStream.read()) != -1) {
            outputStream.write(data);   //写入int
        }

        // 从字节数组输出流获取处理后的数据
        byte[] processedData = outputStream.toByteArray();

        // 打印处理后的数据（实际上应该写入磁盘这里省略成输出）
        System.out.println("Processed Data:");
        for (byte value : processedData) {
            System.out.println(value);
        }

* */