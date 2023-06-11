import java.io.File;

public class _7 {
    public static void main(String[] args) {
        // 输入要移动的文件夹路径和目标文件夹路径
        String sourceFolderPath = "C:/abc";
        String targetFolderPath = "D:/def";

        // 移动文件夹
        boolean moved = moveFolder(sourceFolderPath, targetFolderPath);

        // 输出移动结果
        if (moved) {
            System.out.println("移动完成！");
        } else {
            System.out.println("移动失败！");
        }
    }

    public static boolean moveFolder(String sourceFolderPath, String targetFolderPath) {
        File sourceFolder = new File(sourceFolderPath);
        File targetFolder = new File(targetFolderPath);

        // 确保源文件夹存在且是文件夹
        if (!sourceFolder.exists() || !sourceFolder.isDirectory()) {
            return false;
        }

        // 确保目标文件夹存在且是文件夹
        if (!targetFolder.exists() || !targetFolder.isDirectory()) {
            return false;
        }

        try {
            // 构建目标文件夹路径
            String newFolderPath = targetFolder.getAbsolutePath() + File.separator + sourceFolder.getName();
            File newFolder = new File(newFolderPath);

            // 移动文件夹
            boolean moved = sourceFolder.renameTo(newFolder);

            return moved;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
