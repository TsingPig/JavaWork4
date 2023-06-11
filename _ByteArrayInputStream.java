import java.io.*;


public class _ByteArrayInputStream {
    public static void main(String[] args) throws IOException {
        String lowerCase = "lowerCase";
        byte[] byteBuffer = lowerCase.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(byteBuffer);
        /*
         byte[] byteBuffer=lowerCase.getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(buf);
        */
        int byteRead;
        while ((byteRead = bais.read()) != -1) {
            char upperCase = Character.toUpperCase((char) byteRead);
            System.out.print(upperCase + "");
        }
        bais.close();
    }
}
