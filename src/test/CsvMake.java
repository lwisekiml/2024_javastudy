package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvMake {
    public static void main(String[] args) {
        String filePath = "G:/test/test.csv";

        File file = null;
        BufferedWriter bw = null;
        String NEWLINE = System.lineSeparator();

        try {
            file = new File(filePath);
//            bw = new BufferedWriter(new FileWriter(file));
            bw = Files.newBufferedWriter(Path.of(filePath), StandardCharsets.UTF_8);
            bw.write("\uFEFF"); // 한글 깨짐 방지(UTF-8-BOM 형식으로 저장)

            bw.write("번호,이름,지역");
            bw.write(NEWLINE);

            bw.write("1,철수,서울");
            bw.write(NEWLINE);
//            bw.write("\n");

            bw.write("2,영희,경기");
            bw.write(NEWLINE);
//            bw.write("\r\n");

            bw.write("3,철희,경북");

            bw.write("\uFEFF");

            bw.flush();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
