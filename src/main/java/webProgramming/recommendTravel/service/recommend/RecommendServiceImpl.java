package webProgramming.recommendTravel.service.recommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webProgramming.recommendTravel.domain.destination.Destination;

import webProgramming.recommendTravel.domain.destination.RecommendedDestination;
import webProgramming.recommendTravel.dto.customResponse.CustomResponse;
import webProgramming.recommendTravel.repository.destination.DestinationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendServiceImpl implements RecommendService {

    private final DestinationRepository destinationRepository;

    @Autowired
    public RecommendServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public CustomResponse getRecommendationByMbti(String mbtiType) {
        // 데이터베이스에서 MBTI 유형에 해당하는 Destination 객체 조회
        Optional<Destination> optionalDestination = destinationRepository.findByMbti(mbtiType);

        if (!optionalDestination.isPresent()) {
            return null; // 적절한 예외 처리를 추가할 수 있음
        }

        Destination destination = optionalDestination.get();

        // 추천 목적지 목록 생성
        List<RecommendedDestination> recommendedDestinations = parseDestinationsList(destination);

        // CustomResponse 객체 생성 및 반환
        return new CustomResponse(
                destination.getMbti(),
                destination.getMessage(),
                destination.getBestPartner(),
                destination.getWorstPartner(),
                recommendedDestinations
        );
    }

    private List<RecommendedDestination> parseDestinationsList(Destination destination) {
        List<RecommendedDestination> recommendedDestinations = new ArrayList<>();
        String[] destinationNames = destination.getDestinationsList().split(",\\s*");
        String[] imgUrls = {destination.getImgUrl1(), destination.getImgUrl2(), destination.getImgUrl3()};

        for (int i = 0; i < destinationNames.length; i++) {
            long destinationId = (destination.getId() - 1) * 3 + i + 1; // ID 계산
            String url = i < imgUrls.length ? imgUrls[i] : null; // URL 할당

            recommendedDestinations.add(new RecommendedDestination(
                    destinationId,
                    destinationNames[i],
                    url
            ));
        }
        return recommendedDestinations;
    }
}