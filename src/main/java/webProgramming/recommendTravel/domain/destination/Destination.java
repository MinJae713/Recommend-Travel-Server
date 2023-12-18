package webProgramming.recommendTravel.domain.destination;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import webProgramming.recommendTravel.domain.favorite.Favorite;
import webProgramming.recommendTravel.dto.destination.request.DestinationDTOReq;
import webProgramming.recommendTravel.dto.destination.response.DestinationDTORes;
import webProgramming.recommendTravel.dto.destination.response.RecommendDestination;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 4)
    private String mbti;

    @Column(nullable = false)
    private String bestPartner;

    @Column(nullable = false)
    private String worstPartner;

    @Column(name = "destination", nullable = false)
    private String destinationsList;

    @Column(nullable = false, length = 1024)
    private String message;

    @Column(length = 50)
    private String imgUrl1; // `img_url` 필드를 Java에서 camelCase로 변경

    @Column(length = 50)
    private String imgUrl2; // `img_url` 필드를 Java에서 camelCase로 변경

    @Column(length = 50)
    private String imgUrl3; // `img_url` 필드를 Java에서 camelCase로 변경

    @Transient // 데이터베이스에 저장되지 않는 필드
    private List<RecommendedDestination> recommendedDestinations;


    public DestinationDTORes getDestDTO(List<Favorite> favorites) {
        List<RecommendDestination> recomDests = new ArrayList<RecommendDestination>();
        for (Favorite favorite : favorites) {
            String name = favorite.getDestinationName();
            String url = favorite.getImgUrl();
            recomDests.add(new RecommendDestination(name, url));
        }
        return new DestinationDTORes(mbti, recomDests);
    }
}
