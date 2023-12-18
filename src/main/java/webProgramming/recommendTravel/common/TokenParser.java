package webProgramming.recommendTravel.common;

import java.util.HashMap;
import java.util.Map;


public class TokenParser {
    public static String extractUserIdFromToken(String token) {
        // "|"을 기준으로 토큰과 사용자 ID를 분리
        String[] tokenParts = token.split("\\|");

        if (tokenParts.length == 2) {
            // "{"과 "}"로 둘러싸인 부분을 제거하여 사용자 ID만 추출
            String userIdPayload = tokenParts[1].replaceAll("[{}]", "");
            String[] keyValuePairs = userIdPayload.split(",");
            for (String pair : keyValuePairs) {
                String[] entry = pair.split("=");
                if ("userid".equals(entry[0].trim())) {
                    return entry[1].trim();
                }
            }

            // 사용자 ID가 없는 경우에 대한 예외 처리 또는 오류 메시지 반환
            throw new IllegalArgumentException("토큰에서 사용자 ID를 찾을 수 없습니다.");
        } else {
            // 적절한 예외 처리 또는 오류 메시지 반환
            throw new IllegalArgumentException("토큰 형식이 올바르지 않습니다.");
        }
    }

}
