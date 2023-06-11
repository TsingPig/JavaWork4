import java.io.File;

public class _8 {
    public static void main(String[] args) {
        // 输入文件夹路径
        String folderPath = "C:/abc";

        // 显示以.doc为扩展名的文件
        System.out.println("以.doc为扩展名的文件如下：");
        displayDocFiles(folderPath);
    }

    public static void displayDocFiles(String folderPath) {
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".doc")) {
                        System.out.println(file.getName());
                    }

                    if (file.isDirectory()) {
                        displayDocFiles(file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
