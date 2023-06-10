import java.io.ByteArrayInputStream;
import java.io.IOException;

public class _ByteArrayInputStream {
    public static void main(String[] args) throws IOException{
        String lowerCaseStr = "str";
        byte[] byteBuffer = lowerCaseStr.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(byteBuffer);
        int lowerCase = bais.read();
        while (lowerCase != -1) {
            char upperCase = Character.toUpperCase((char) lowerCase);
            System.out.print(upperCase + "");
            lowerCase=bais.read();
        }
        bais.close();
    }
}
