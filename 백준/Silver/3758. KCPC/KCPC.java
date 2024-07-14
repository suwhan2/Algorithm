import java.util.*;
import java.io.*;

class Info {
    int totalScore, totalTry, lastTry;

    public Info(int totalScore, int totalTry, int lastTry) {
        this.totalScore = totalScore;
        this.totalTry = totalTry;
        this.lastTry = lastTry;
    }
}

public class Main {
    static int TeamCount, QuizCount, MyTeamId, LogCount;
    static int TeamID, QuizNum, Score;
    static int[][] scoreBoard;
    static Info[] teamInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            TeamCount = Integer.parseInt(st.nextToken());
            QuizCount = Integer.parseInt(st.nextToken());
            MyTeamId = Integer.parseInt(st.nextToken());
            LogCount = Integer.parseInt(st.nextToken());

            scoreBoard = new int[TeamCount + 1][QuizCount + 1];
            teamInfo = new Info[TeamCount + 1];
            for (int i = 1; i <= TeamCount; i++) {
                teamInfo[i] = new Info(0, 0, 0);
            }

            for (int i = 0; i < LogCount; i++) {
                st = new StringTokenizer(br.readLine());
                TeamID = Integer.parseInt(st.nextToken());
                QuizNum = Integer.parseInt(st.nextToken());
                Score = Integer.parseInt(st.nextToken());

                if (scoreBoard[TeamID][QuizNum] < Score) {
                    teamInfo[TeamID].totalScore += (Score - scoreBoard[TeamID][QuizNum]);
                    scoreBoard[TeamID][QuizNum] = Score;
                }
                teamInfo[TeamID].totalTry++;
                teamInfo[TeamID].lastTry = i;
            }

            // 정렬
            Integer[] teamIndices = new Integer[TeamCount];
            for (int i = 0; i < TeamCount; i++) {
                teamIndices[i] = i + 1;
            }

            Arrays.sort(teamIndices, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (teamInfo[o1].totalScore != teamInfo[o2].totalScore) {
                        return teamInfo[o2].totalScore - teamInfo[o1].totalScore;
                    }
                    if (teamInfo[o1].totalTry != teamInfo[o2].totalTry) {
                        return teamInfo[o1].totalTry - teamInfo[o2].totalTry;
                    }
                    return teamInfo[o1].lastTry - teamInfo[o2].lastTry;
                }
            });

            // 결과 출력
            for (int i = 0; i < TeamCount; i++) {
                if (teamIndices[i] == MyTeamId) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}
