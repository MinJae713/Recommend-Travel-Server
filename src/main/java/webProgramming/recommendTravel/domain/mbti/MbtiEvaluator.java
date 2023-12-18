package webProgramming.recommendTravel.domain.mbti;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MbtiEvaluator {

    public String evaluateMbti(List<String[]> answers) {
        int totalE = 0, totalI = 0, totalS = 0, totalN = 0, totalT = 0, totalF = 0, totalJ = 0, totalP = 0;

        for (String[] answer : answers) {
            totalE += countOccurrences(answer, "E");
            totalI += countOccurrences(answer, "I");
            totalS += countOccurrences(answer, "S");
            totalN += countOccurrences(answer, "N");
            totalT += countOccurrences(answer, "T");
            totalF += countOccurrences(answer, "F");
            totalJ += countOccurrences(answer, "J");
            totalP += countOccurrences(answer, "P");
        }

        return buildMbtiResult(totalE, totalI, totalS, totalN, totalT, totalF, totalJ, totalP);
    }

    private int countOccurrences(String[] array, String targetValue) {
        return (int) Arrays.stream(array).filter(targetValue::equals).count();
    }

    private String buildMbtiResult(int totalE, int totalI, int totalS, int totalN, int totalT, int totalF, int totalJ, int totalP) {
        String mbtiResult = "";
        mbtiResult += (totalE >= totalI) ? "E" : "I";
        mbtiResult += (totalS >= totalN) ? "S" : "N";
        mbtiResult += (totalT >= totalF) ? "T" : "F";
        mbtiResult += (totalJ >= totalP) ? "J" : "P";
        return mbtiResult;
    }
}

