package com.example._11.Controller;

import com.example._11.Model.StudentPoint;
import com.example._11.Service.CaptchaService;
import com.example._11.Service.StudentPointService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CapchaController {

    // Inject
    private final StudentPointService spService;
    private final CaptchaService cService;
    public CapchaController(StudentPointService spService,CaptchaService cService) {
        this.spService = spService;
        this.cService = cService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        createNewCaptcha(model, session); // Tao capcha
        return "index";
    }

    private void createNewCaptcha(Model model, HttpSession session) {
        String imageName = cService.getRandomImageName();
        String answer = cService.getAnswer(imageName);

        model.addAttribute("imgName", imageName); // vo model -> view lay & hien thi
        session.setAttribute("captchaAnswer", answer); // dapan -> session
    }

    @PostMapping("/search")
    public String search( // Nhận mssv, capcha từ form
            @RequestParam String mssv,
            @RequestParam String captcha,
            Model model,
            HttpSession session
    ) {
        // Lấy đáp án capcha từ session
        String correctCaptcha = (String) session.getAttribute("captchaAnswer");

        if (correctCaptcha == null || captcha == null ||
                !correctCaptcha.equalsIgnoreCase(captcha.trim())
        ) {
            model.addAttribute("error","Mã CAPTCHA không đúng.");
            model.addAttribute("mssv", mssv); // Giữ nguyên gtri user nhập (ko đổi)
            createNewCaptcha(model, session); // refresh capcha
            return "index";
        }

        // mssv
        if (mssv == null || mssv.trim().isBlank()) {
            model.addAttribute("error","Vui lòng nhập MSSV.");
            createNewCaptcha(model, session);
            return "index";
        }

        // Find sv in excel
        StudentPoint student =spService.findByMssv(mssv);
        if (student == null) {
            model.addAttribute("error","Không tìm thấy thí sinh có MSSV: " + mssv);
        } else {
            model.addAttribute("student", student);
        }

        createNewCaptcha(model, session);
        return "index";
    }
}
