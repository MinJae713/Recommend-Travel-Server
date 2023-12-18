package webProgramming.recommendTravel.controller.zzim;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webProgramming.recommendTravel.dto.destination.response.DestinationDTORes;
import webProgramming.recommendTravel.dto.userfavorite.request.FavoriteDTOReq;
import webProgramming.recommendTravel.dto.userfavorite.response.FavoriteDTORes;
import webProgramming.recommendTravel.service.zzim.ZZIMService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/recommend-travel/favorites")
@Slf4j
public class ZZIMController {
    // 찜 api 여기서 받음
    @Autowired
    private ZZIMService zzimService;

    @PostMapping("/add-to-favorites")
    public ResponseEntity<FavoriteDTORes> doZZim(@RequestBody FavoriteDTOReq dto) {
        log.info("리퀘 : " + dto.toString());
        FavoriteDTORes favorite = zzimService.doZZim(dto);
        log.info("페이보릿 : " + favorite.toString());
        return favorite != null ?
                 ResponseEntity.status(HttpStatus.OK).body(favorite) :
                 ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/{user_id}")
    public ResponseEntity<DestinationDTORes> retrieveList(@PathVariable String user_id) {
        DestinationDTORes destinationDTORes = zzimService.retrieveList(user_id);
        return destinationDTORes != null ?
                ResponseEntity.status(HttpStatus.OK).body(destinationDTORes) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
