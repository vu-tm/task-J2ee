package com.example._11.Service;

import com.example._11.Model.StudentPoint;
import jakarta.annotation.PostConstruct;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentPointService {

    private final List<StudentPoint> students = new ArrayList<>();

    // Chạy 1 lần khi Spring khởi tạo Bean -> Nạp dữ liệu ban đầu
    @PostConstruct
    public void loadExcel() {
        try {
            ClassPathResource resource = new ClassPathResource("Point.xlsx"); // /resources

            try (
                    InputStream inputStream = resource.getInputStream();
                    Workbook workbook = WorkbookFactory.create(inputStream)
            ) {
                Sheet sheet = workbook.getSheetAt(0); // Sheet dau tien

                // Duyet tu dong 1 (avoid Tieu de)
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);

                    if (row == null) {
                        continue;
                    }

                    String mssv = getStringValue(row.getCell(0));
                    String hoTen = getStringValue(row.getCell(1));

                    if (mssv.isBlank()) {
                        continue; // bỏ qua dòng đấy
                    }

                    double diemToan =
                            getDoubleValue(row.getCell(2));
                    double diemVan =
                            getDoubleValue(row.getCell(3));
                    double diemAnhVan =
                            getDoubleValue(row.getCell(4));

                    StudentPoint student = new StudentPoint(
                            mssv,
                            hoTen,
                            diemToan,
                            diemVan,
                            diemAnhVan
                    );

                    students.add(student); // Add to list
                }
            }
        } catch (Exception e) {
            throw new RuntimeException( "Không thể đọc file Point.xlsx", e );
        }
    }

    public StudentPoint findByMssv(String mssv) {
        if (mssv == null || mssv.isBlank()) {
            return null;
        }

        // stream giúp lọc / tìm kiếm gọn hơn
        return students.stream()
                .filter(student ->
                        student.getMssv().equalsIgnoreCase(mssv.trim())
                )
                .findFirst()
                .orElse(null);
    }

    // Lấy dữ liệu ô Excel
    private String getStringValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        // Đọc chữ, so, ngay thang -> String
        DataFormatter formatter = new DataFormatter();
        return formatter
                .formatCellValue(cell) // -> String
                .trim(); // bo khoang trang (dau + cuoi)
    }

    private double getDoubleValue(Cell cell) {
        if (cell == null) {
            return 0;
        }

        if (cell.getCellType() == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        }

        String value = getStringValue(cell)
                .replace(",", ".")
                .trim();

        if (value.isBlank()) {
            return 0;
        }

        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
