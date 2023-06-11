import java.io.*;

class Complex implements Serializable {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

public class _19 {
    public static void main(String[] args) {
        String fileName = "complex.ser";

        // 生成10个复数对象
        Complex[] complexNumbers = new Complex[10];
        for (int i = 0; i < 10; i++) {
            Complex complex = new Complex(i, i + 1);
            complexNumbers[i] = complex;
        }

        // 序列化复数对象到文件
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            for (Complex complex : complexNumbers) {
                outputStream.writeObject(complex);
            }
            outputStream.close();
            System.out.println("复数对象已序列化到文件 " + fileName);
        } catch (IOException e) {
            System.out.println("发生IO异常: " + e.getMessage());
        }

        // 从文件中读取复数对象并输出到屏幕
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
            System.out.println("从文件 " + fileName + " 中读取到的复数对象：");
            for (int i = 0; i < 10; i++) {
                Complex complex = (Complex) inputStream.readObject();
                System.out.println(complex);
            }
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("发生异常: " + e.getMessage());
        }
    }
}
