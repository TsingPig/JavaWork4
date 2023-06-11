import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _14 {
    public static void main(String[] args) {
        String inputFileName = "score.txt";
        String outputFileName = "result.txt";
        List<Student> studentList = new ArrayList<>();

        try {
            // 读取学生成绩数据
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+"); // 使用空格分隔每个部分
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    int chineseScore = Integer.parseInt(parts[2]);
                    int mathScore = Integer.parseInt(parts[3]);
                    Student student = new Student(id, name, chineseScore, mathScore);
                    studentList.add(student);
                }
            }
            reader.close();

            // 计算平均分和总分
            int chineseSum = 0;
            int mathSum = 0;
            int totalStudents = studentList.size();
            for (Student student : studentList) {
                chineseSum += student.getChineseScore();
                mathSum += student.getMathScore();
            }
            double chineseAverage = (double) chineseSum / totalStudents;
            double mathAverage = (double) mathSum / totalStudents;

            // 写入结果到文件
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            writer.write("语文平均分：" + String.format("%.1f", chineseAverage));
            writer.newLine();
            writer.write("数学平均分：" + String.format("%.1f", mathAverage));
            writer.newLine();
            for (Student student : studentList) {
                writer.write(student.getId() + "  " + student.getName() + "  总分：" + student.getTotalScore());
                writer.newLine();
            }
            writer.close();

            System.out.println("成绩统计完成，结果已写入" + outputFileName);
        } catch (IOException e) {
            System.out.println("发生IO异常: " + e.getMessage());
        }
    }

    static class Student {
        private String id;
        private String name;
        private int chineseScore;
        private int mathScore;

        public Student(String id, String name, int chineseScore, int mathScore) {
            this.id = id;
            this.name = name;
            this.chineseScore = chineseScore;
            this.mathScore = mathScore;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getChineseScore() {
            return chineseScore;
        }

        public int getMathScore() {
            return mathScore;
        }

        public int getTotalScore() {
            return chineseScore + mathScore;
        }
    }
}
