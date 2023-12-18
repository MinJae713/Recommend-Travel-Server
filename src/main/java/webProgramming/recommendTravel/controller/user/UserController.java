package webProgramming.recommendTravel.controller.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webProgramming.recommendTravel.common.AccessTokenGenerator;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.dto.UserRequest;
import webProgramming.recommendTravel.service.user.DeleteService;
import webProgramming.recommendTravel.service.user.UserService;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/recommend-travel")
public class UserController {
    // 아이디 비번 api 여기서 받음

    private final UserService userService;

    private final DeleteService deleteService;
    private final AccessTokenGenerator accessTokenGenerator = null;

    @Autowired
    public UserController(UserService userService, DeleteService deleteService) {
        this.userService = userService;
        this.deleteService = deleteService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserRequest userRequest) {
        try {
            userService.registerUser(userRequest.getUserid() ,userRequest.getUsername(),
                    userRequest.getPassword(), userRequest.getEmail(), userRequest.getMbti_type());
            return ResponseEntity.ok()
                    .body(Map.of("status", 200, "message", "사용자 회원가입이 완료되었습니다."));
        } catch (Exception e) {
            // 회원가입 실패 시
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            // 여기서 HttpStatus.BAD_REQUEST를 다른 원하는 상태 코드로 변경할 수 있습니다.
        }

    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserRequest userRequest) {
        User user = userService.loginUser(userRequest.getUserid(), userRequest.getPassword());

        if (user != null) {
            // 로그인 성공 시
            String token = accessTokenGenerator.generateToken(userRequest.getUserid());
            return ResponseEntity.ok()
                    .body(Map.of("status", 200, "message", "로그인이 성공했습니다.",
                            "user", user, "token", token));
        } else {
            // 로그인 실패 시
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("status", 401, "message", "로그인에 실패했습니다."));
            // 여기서 HttpStatus.UNAUTHORIZED를 다른 원하는 상태 코드로 변경할 수 있습니다.
        }
    }

    @DeleteMapping("/delete/{userid}")
    public ResponseEntity<Object> deleteUser(@PathVariable String userid) {
        try {
            // 회원 탈퇴 시, 사용자 정보 삭제
            deleteService.deleteUser(userid);
            return ResponseEntity.ok(Map.of("status", 200, "message", "회원 탈퇴가 완료되었습니다."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("status", 401, "message", "인증 실패. 유효하지 않은 사용자 정보입니다"));
        }
    }




}
