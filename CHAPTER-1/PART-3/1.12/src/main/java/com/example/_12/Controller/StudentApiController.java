package com.example._12.Controller;

import com.example._12.Model.StudentPoint;
import com.example._12.Service.StudentPointService;
import com.example._12.Service.UserTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentApiController {

    private final StudentPointService spService;
    private final UserTokenService utService;
    public StudentApiController(StudentPointService spService, UserTokenService utService){
        this.spService = spService;
        this.utService = utService;
    }

    @GetMapping("/students/{sbd}")
    public ResponseEntity<?> getStudentPoint(
            @PathVariable String sbd,
            @RequestHeader("User-Token") String userToken
    ) {
        // if User-Token khong hop le
        if (!utService.isValid(userToken)) {
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("success", false);
            response.put("message", "User-Token không hợp lệ");
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(response);
        }
        // if SBD khong hop le
        if (sbd == null || sbd.isBlank()) {
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("success", false);
            response.put("message", "SBD không được để trống");
            return ResponseEntity
                    .badRequest()
                    .body(response);
        }

        // Tìm sinh viên trong file Excel (sv ko hop le)
        StudentPoint student = spService.findByMssv(sbd);
        if (student == null) {
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("success", false);
            response.put("message", "Không tìm thấy thí sinh có SBD: " + sbd);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }

        // ELSE (TRUE)
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", "Tra cứu điểm thành công");
        response.put("data", student);
        return ResponseEntity.ok(response);
    }
}
