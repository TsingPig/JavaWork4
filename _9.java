import java.nio.charset.Charset;

class _9 {
    public static void main(String[] args) {
        // 获取本平台字符流中所采用的默认的字符集
        Charset defaultCharset = Charset.defaultCharset();

        // 获取汉字字符集名称
        String chineseCharset = defaultCharset.displayName();

        // 输出结果
        System.out.println("本平台字符流中所采用的默认的汉字字符集是：" + chineseCharset);
    }
}
