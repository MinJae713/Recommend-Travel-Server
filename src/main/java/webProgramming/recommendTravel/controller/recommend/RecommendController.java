package webProgramming.recommendTravel.controller.recommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webProgramming.recommendTravel.domain.destination.Destination;
import webProgramming.recommendTravel.dto.customResponse.CustomResponse;
import webProgramming.recommendTravel.service.recommend.RecommendService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/recommend-travel")
public class RecommendController {

    private final RecommendService recommendService;

    @Autowired
    public RecommendController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    @GetMapping("/recommend-destinations")
    public ResponseEntity<CustomResponse> recommendDestinations(@RequestParam String mbti) {
        CustomResponse recommendation = recommendService.getRecommendationByMbti(mbti);
        if (recommendation != null) {
            return ResponseEntity.ok(recommendation);
        } else {
            // 목적지를 찾지 못했을 때 적절한 HTTP 상태 코드와 메시지를 반환
            return ResponseEntity.notFound().build();
        }
    }
}