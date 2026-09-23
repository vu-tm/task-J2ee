package com.example._12.Service;

import tools.jackson.core.type.TypeReference; //jackson3
import tools.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CaptchaService {

    private final Map<String, String> captchaAnswers;

    public CaptchaService(ObjectMapper objectMapper) {
        try {
            ClassPathResource resource = new ClassPathResource(
                            "static/capcha/answer.json" // /resources/static/capcha/answer.json
                    );

            // Mo file - try tu dong close file khi xong
            try (InputStream inputStream = resource.getInputStream()) {
                captchaAnswers = objectMapper.readValue(
                        inputStream,
                        new TypeReference<Map<String, String>>() {}
                        // JSON -> Map<String(key), String(value)> . Du lieu luu trong captchaAnswers
                );
            }
        } catch (Exception e) {
            throw new RuntimeException( "Không thể đọc file answer.json", e );
        }
    }

    public String getRandomImageName() {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 21);
        return "capcha" + randomNumber + ".png";
    }

    public String getAnswer(String imageName) {
        return captchaAnswers.get(imageName);
    }
}
