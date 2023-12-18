package webProgramming.recommendTravel.domain.favorite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.dto.userfavorite.response.FavoriteDTORes;

import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zzimID;
    @Column(nullable = false)
    private String destinationName;
    @Column(length = 50)
    private String imgUrl;
    @ManyToOne
    @JoinColumn(name = "cid")
    private User user;

    public Favorite(Long zzimID, String destinationName, String imgUrl, Optional<User> user) {
    }

    public FavoriteDTORes getFavoriteDTO() {
        return new FavoriteDTORes(user.getUserid(), destinationName, imgUrl);
    }
}
