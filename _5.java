import java.io.File;

public class _5 {
    public static void main(String[] args) {
        // 输入文件夹路径
        String folderPath = "C:/abc";

        // 统计文件夹信息
        FolderStatistics stats = getFolderStatistics(folderPath);

        // 输出统计结果
        System.out.println("文件夹 " + folderPath + " 下的子文件夹总数：" + stats.getSubfolderCount());
        System.out.println("文件总数：" + stats.getFileCount());
        System.out.println("文件总空间：" + stats.getTotalSize() + " 字节");
    }

    public static FolderStatistics getFolderStatistics(String folderPath) {
        File folder = new File(folderPath);

        int subfolderCount = 0;
        int fileCount = 0;
        long totalSize = 0;

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        subfolderCount++;
                        FolderStatistics subfolderStats = getFolderStatistics(file.getAbsolutePath());
                        subfolderCount += subfolderStats.getSubfolderCount();
                        fileCount += subfolderStats.getFileCount();
                        totalSize += subfolderStats.getTotalSize();
                    } else {
                        fileCount++;
                        totalSize += file.length();
                    }
                }
            }
        }

        return new FolderStatistics(subfolderCount, fileCount, totalSize);
    }
}

class FolderStatistics {
    private int subfolderCount;
    private int fileCount;
    private long totalSize;

    public FolderStatistics(int subfolderCount, int fileCount, long totalSize) {
        this.subfolderCount = subfolderCount;
        this.fileCount = fileCount;
        this.totalSize = totalSize;
    }

    public int getSubfolderCount() {
        return subfolderCount;
    }

    public int getFileCount() {
        return fileCount;
    }

    public long getTotalSize() {
        return totalSize;
    }
}
