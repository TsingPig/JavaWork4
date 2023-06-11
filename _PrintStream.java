import java.io.*;

public class _PrintStream {
    public static void main(String[] args) throws IOException {
        String fileName = "D:/data.txt";
        FileOutputStream fos = new FileOutputStream(fileName);
        //将文件输出流类包装成输出流
        PrintStream ps = new PrintStream(fos);
        int[][] triangle = new int[11][];
        triangle[0] = triangle[1] = new int[]{1};

        for (int i = 2; i <= 10; i++) {
            triangle[i] = new int[i];
            triangle[i][0] = triangle[i][i - 1] = 1;
            for (int j = 1; j <= i - 2; j++)
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
        }
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                ps.print(triangle[i][j]+" ");
            }
            ps.println();
        }

    }
}
