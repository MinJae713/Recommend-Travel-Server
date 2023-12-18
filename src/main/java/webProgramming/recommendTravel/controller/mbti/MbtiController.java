package webProgramming.recommendTravel.controller.mbti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webProgramming.recommendTravel.service.mbti.MbtiService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/recommend-travel")
public class MbtiController {
    private static final Logger log = LoggerFactory.getLogger(MbtiController.class);

    private final MbtiService mbtiService;

    @Autowired
    public MbtiController(MbtiService mbtiService) {
        this.mbtiService = mbtiService;
    }

    @PostMapping("/mbti-test")
    public ResponseEntity<String> evaluateMbti(@RequestBody List<String[]> answers) {
        log.info("Received data: {}", answers);
        String mbtiResult = mbtiService.evaluateMbti(answers);
        return ResponseEntity.ok(mbtiResult);
    }
}
