package webProgramming.recommendTravel.repository.destination;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.destination.Destination;

import java.util.Optional;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Optional<Destination> findByMbti(String mbtiType);
}

