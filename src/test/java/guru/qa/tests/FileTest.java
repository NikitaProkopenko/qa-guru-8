package guru.qa.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {
    @Test
    void txtFileTest() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("files/example.txt")) {
            String txtResult;
            txtResult = new String(is.readAllBytes(), "UTF-8");
            assertThat(txtResult).contains("Homework-7 QA.GURU");
        }
    }

    @Test
    void pdfFileTest() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("files/test.pdf")) {
            PDF parsed = new PDF(is);
            assertThat(parsed.text).contains("Test Homework");
        }
    }

    @Test
    void xlsxFileTest() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("files/example.xlsx")) {
            XLS parsed = new XLS(is);
            assertThat(parsed.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue())
                    .isEqualTo("Test");
        }
    }
}
