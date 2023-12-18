package webProgramming.recommendTravel.dto.customResponse;

import webProgramming.recommendTravel.domain.destination.RecommendedDestination;

import java.util.List;

public class CustomResponse {
    private String mbti;
    private String message;
    private String bestPartner;
    private String worstPartner;
    private List<RecommendedDestination> recommendedDestinations;



    // getters, setters, constructors
    public CustomResponse(String mbti, String message, String bestPartner, String worstPartner, List<RecommendedDestination> recommendedDestinations) {
        this.mbti = mbti;
        this.message = message;
        this.bestPartner = bestPartner;
        this.worstPartner = worstPartner;
        this.recommendedDestinations = recommendedDestinations;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBestPartner() {
        return bestPartner;
    }

    public void setBestPartner(String bestPartner) {
        this.bestPartner = bestPartner;
    }

    public String getWorstPartner() {
        return worstPartner;
    }

    public void setWorstPartner(String worstPartner) {
        this.worstPartner = worstPartner;
    }

    public List<RecommendedDestination> getRecommendedDestinations() {
        return recommendedDestinations;
    }

    public void setRecommendedDestinations(List<RecommendedDestination> recommendedDestinations) {
        this.recommendedDestinations = recommendedDestinations;
    }
}
