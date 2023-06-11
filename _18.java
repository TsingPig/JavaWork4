import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class _18 {
    public static void main(String[] args) {
        String inputFileName = "data.txt";
        String outputFileName = "result.txt";

        try {
            // 读取原始文本文件
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();

            // 统计汉字频率
            Map<Character, Integer> frequencyMap = new HashMap<>();
            String content = stringBuilder.toString();
            for (int i = 0; i < content.length(); i++) {
                char character = content.charAt(i);
                if (isChineseCharacter(character)) {
                    frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
                }
            }

            // 写入统计结果到文本文件
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                writer.write("(" + entry.getKey() + "," + entry.getValue() + ")");
            }
            writer.close();

            System.out.println("汉字频率统计结果已写入" + outputFileName);
        } catch (IOException e) {
            System.out.println("发生IO异常: " + e.getMessage());
        }
    }

    public static boolean isChineseCharacter(char character) {
        // 判断字符是否为汉字（Unicode范围：4E00 - 9FFF）
        return character >= 0x4E00 && character <= 0x9FFF;
    }
}
