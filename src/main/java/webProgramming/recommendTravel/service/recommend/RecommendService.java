package webProgramming.recommendTravel.service.recommend;


import webProgramming.recommendTravel.domain.destination.Destination;
import webProgramming.recommendTravel.dto.customResponse.CustomResponse;

public interface RecommendService {
    CustomResponse getRecommendationByMbti(String mbtiType);
}