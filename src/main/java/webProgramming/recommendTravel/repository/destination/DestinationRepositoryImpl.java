//package webProgramming.recommendTravel.repository.destination;
//
//import org.springframework.stereotype.Repository;
//import webProgramming.recommendTravel.domain.destination.Destination;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Repository
//public class DestinationRepositoryImpl implements DestinationRepository {
//    private static final Map<String, Destination> MBTI_RECOMMENDATIONS = new HashMap<>();
//
//    static {
//        MBTI_RECOMMENDATIONS.put("ESTP", new Destination(
//                new String[]{"뉴질랜드", "바르셀로나", "바하마"},
//                "ISFJ", "INTJ",
//                "여행 계획을 세우는 것보다 즉흥적인 여행을 즐기는 당신! 항상 새로운 경험을 찾는 ESTP 유형은 여행을 통해 자유로움을 느낍니다. 여행 중에 가장 중요하게 생각하는 것은 자극적인 활동과 모험! 가장 즐거운 순간은 뜨거운 햇볕 속에서 즉흥적으로 만난 인연과의 만남일 것입니다."
//        ));
//        MBTI_RECOMMENDATIONS.put("ENTP", new Destination(
//                new String[]{"도쿄", "베를린", "뉴욕"},
//                "INFJ", "ISTJ",
//                "논리적이면서 독창적인 여행을 즐기는 당신, ENTP! 여행은 당신에게 새로운 아이디어를 얻는 좋은 기회입니다. 여행 중에는 항상 도전적이고 새로운 경험을 추구하는군요. 여행지 선택에는 자유로움과 창의성이 뒤섞여 있을 것입니다."
//        ));
//        MBTI_RECOMMENDATIONS.put("ESTJ", new Destination(
//                new String[]{"시드니", "도쿄 디즈니랜드", "런던"},
//                "ISFP", "INFP",
//                "계획적이고 조직적인 여행을 선호하는 당신, ESTJ! 여행 전에는 철저한 계획을 세우고 여행 일정을 따라가려 노력합니다. 여행 중에는 효율성과 조직력이 높아져 여행이 원활하게 진행될 것입니다."
//        ));
//        MBTI_RECOMMENDATIONS.put("ESFJ", new Destination(
//                new String[]{"프라하", "카이로", "더블린"},
//                "ISFP", "INFP",
//                "타인과의 소통과 협력을 중요시하는 여행을 좋아하는 당신, ESFJ! 여행 중에는 항상 동행과 함께 즐기는 것이 중요합니다. 다양한 인연과의 소통이 여행의 즐거움을 더해줄 것입니다."
//        ));
//        MBTI_RECOMMENDATIONS.put("ENFJ", new Destination(
//                new String[]{"마드리드", "싱가포르", "리스본"},
//                "INTP", "ISTP",
//                "타인을 배려하고 도우며 즐기는 여행을 선호하는 당신, ENFJ! 여행 중에는 주변의 사람들과의 연결이 여행의 핵심이겠네요. 특별한 순간을 함께 만들어가는 것이 여행의 즐거움입니다."
//        ));
//        MBTI_RECOMMENDATIONS.put("ENTJ", new Destination(
//                new String[]{"맨체스터", "캘리포니아", "오사카"},
//                "INTP", "ISTP",
//                "목표지향적이고 리더십을 발휘하는 여행을 즐기는 당신, ENTJ! 여행은 당신에게 새로운 도전과 목표를 설정하는 기회일 것입니다. 조직력과 목표 의식이 높아 여행 계획을 철저히 세우고 이끌어 나갈 것입니다."
//        ));
//        MBTI_RECOMMENDATIONS.put("ESFP", new Destination(
//                new String[]{"리오 데 자네이로", "발리", "산타페"},
//                "ISFP", "INTP",
//                "즉흥적이고 활기찬 여행을 좋아하는 당신, ESFP! 여행은 당신에게 삶의 즐거움과 열정을 더해줍니다. 여행을 할 때 중요하게 생각하는 것은 좋은 음식과 자유로운 분위기! 여행 중에는 항상 눈에 띄는 곳에서 활동하며 즐거움을 찾는군요."
//        ));
//        MBTI_RECOMMENDATIONS.put("ENFP", new Destination(
//                new String[]{"파리", "호치민시티", "신주쿠"},
//                "INFJ", "ISTJ",
//                "상상력 풍부하고 새로운 경험을 추구하는 ENFP 유형! 여행을 통해 자유롭고 창의적인 에너지를 느낄 수 있습니다. 여행 중에는 항상 새로운 이야기와 친구를 만나는 것이 중요하겠네요. 당신의 여행은 항상 긍정적인 에너지로 가득할 것입니다."
//        ));
//        MBTI_RECOMMENDATIONS.put("ISTJ", new Destination(
//                new String[]{"부다페스트", "오스로프", "크라쿠프"},
//                "ESFP", "ENFP",
//                "계획적이고 조직적인 여행을 선호하는 ISTJ! 여행 전에는 철저한 계획을 세우고 여행 일정을 따라가려 노력하겠죠. 여행 중에는 효율성과 조직력이 높아져 여행이 원활하게 진행될 것입니다."
//        ));
//        MBTI_RECOMMENDATIONS.put("ISFJ", new Destination(
//                new String[]{"키예프", "사토리니아", "프라이부르크"},
//                "ESTP", "ENTP",
//                "다른 사람을 배려하고 도우며 여행을 즐기는 ISFJ! 여행 중에는 동행이 있으면 더 즐겁겠죠. 다양한 경험을 통해 소중한 추억을 만들어 나갈 것입니다."
//        ));
//        MBTI_RECOMMENDATIONS.put("INFJ", new Destination(
//                new String[]{"암스테르담", "푸켓", "사르디니아"},
//                "ENFP", "ESTP",
//                "이해심 깊고 창의적인 여행을 선호하는 INFJ! 여행은 당신에게 새로운 아이디어와 깊은 체험을 안겨줄 것입니다. 여행 중에는 자연과 문화에 대한 탐험이 여행의 즐거움을 높일 것입니다."
//        ));
//        MBTI_RECOMMENDATIONS.put("INTJ", new Destination(
//                new String[]{"오스카", "소치", "그리니치"},
//                "ENTP", "ESFP",
//                "목표지향적이고 계획적인 여행을 좋아하는 INTJ! 여행은 당신에게 목표 달성과 자기 발전의 기회일 것입니다. 도전적인 여행을 통해 새로운 아이디어와 경험을 얻을 수 있을 것입니다."
//        ));
//        MBTI_RECOMMENDATIONS.put("ISTP", new Destination(
//                new String[]{"퀸즈타운", "밴프", "캐나다", "파타고니아"},
//                "ESFJ", "ENFJ",
//                "호기심이 많고 현실적인 여행을 선호하는 ISTP! 여행 중에는 다양한 액티비티와 체험을 통해 새로운 도전에 나서는 것이 즐거울 것입니다."
//        ));
//        MBTI_RECOMMENDATIONS.put("ISFP", new Destination(
//                new String[]{"코스타 브라바", "히말라야 산맥", "아르버 주립공원"},
//                "ESTJ", "ENTJ",
//                "자연과 예술을 즐기며 즉흥적인 여행을 좋아하는 ISFP! 여행은 당신에게 예술과 자연 속에서의 평화로움을 안겨줄 것입니다. 여유롭게 즐기며 새로운 발견을 기대해보세요."
//        ));
//        MBTI_RECOMMENDATIONS.put("INFP", new Destination(
//                new String[]{"키자르즈", "하와이", "보라카이"},
//                "ENTJ", "ESTJ",
//                "이상적인 여행과 창의적인 경험을 즐기는 INFP! 여행은 당신에게 창의성과 감수성을 불러일으킬 것입니다. 자유로운 분위기와 아름다운 풍경을 즐길 수 있는 여행지를 찾아보세요."
//        ));
//        MBTI_RECOMMENDATIONS.put("INTP", new Destination(
//                new String[]{"크라이스트처치", "레이캬비크", "헤르미온느"},
//                "ENFJ", "ESFJ",
//                "논리적이면서 독창적인 여행을 선호하는 INTP! 여행은 당신에게 새로운 아이디어와 흥미로운 지식을 제공할 것입니다. 독특한 경험과 도전적인 여행을 즐겨보세요."
//        ));
//    }
//
//    @Override
//    public Destination findDestinationByMbti(String mbtiType) {
//        return MBTI_RECOMMENDATIONS.getOrDefault(mbtiType,
//                new Destination(new String[]{}, "최고의 파트너가 없습니다.","최악의 파트너가 없습니다.","해당 MBTI 유형에 대한 추천 정보가 없습니다"));
//    }
//}
