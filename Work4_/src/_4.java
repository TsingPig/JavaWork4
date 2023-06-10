import java.io.FileInputStream;
import java.io.IOException;

public class _4 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("image.bmp");

            // 读取文件头
            byte[] fileHeader = new byte[14];
            fis.read(fileHeader);
            parseFileHeader(fileHeader);

            // 读取位图信息头
            byte[] infoHeader = new byte[40];
            fis.read(infoHeader);
            parseInfoHeader(infoHeader);

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseFileHeader(byte[] headerData) {
        // 提取文件头的相关数据
        int fileSize = byteArrayToInt(headerData, 2, 4);
        int dataOffset = byteArrayToInt(headerData, 10, 4);

        // 输出文件头数据
        System.out.println("File Header");
        System.out.println("File Size: " + fileSize + " bytes");
        System.out.println("Data Offset: " + dataOffset + " bytes");
        System.out.println();
    }

    private static void parseInfoHeader(byte[] headerData) {
        // 提取位图信息头的相关数据
        int width = byteArrayToInt(headerData, 4, 4);
        int height = byteArrayToInt(headerData, 8, 4);
        int colorDepth = byteArrayToInt(headerData, 14, 2);
        int compressionMethod = byteArrayToInt(headerData, 16, 4);

        // 输出位图信息头数据
        System.out.println("Info Header");
        System.out.println("Width: " + width + " pixels");
        System.out.println("Height: " + height + " pixels");
        System.out.println("Color Depth: " + colorDepth + " bits per pixel");
        System.out.println("Compression Method: " + compressionMethod);
        System.out.println();
    }

    private static int byteArrayToInt(byte[] bytes, int offset, int length) {
        int value = 0;
        for (int i = 0; i < length; i++) {
            value |= (bytes[offset + i] & 0xFF) << (8 * i);
        }
        return value;
    }
}
