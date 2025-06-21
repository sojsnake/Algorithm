import java.util.*;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 리스트로 변환
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        // 초기화
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int l : lost) lostList.add(l);
        for (int r : reserve) reserveList.add(r);

        // 1단계: 여벌 있지만 도난도 당한 학생 정리
        List<Integer> realLost = new ArrayList<>();
        List<Integer> realReserve = new ArrayList<>();

        for (int l : lostList) {
            if (reserveList.contains(l)) {
                reserveList.remove(Integer.valueOf(l)); // 이 학생은 빌려줄 수 없음
            } else {
                realLost.add(l); // 진짜 잃어버린 사람
            }
        }

        realReserve.addAll(reserveList); // 아직 남은 여벌 있는 학생들

        // 2단계: 앞뒤 번호에게 체육복 빌려주기
        for (int l : realLost) {
            if (realReserve.contains(l - 1)) {
                realReserve.remove(Integer.valueOf(l - 1));
            } else if (realReserve.contains(l + 1)) {
                realReserve.remove(Integer.valueOf(l + 1));
            } else {
                n--; // 못 빌렸다면 체육 수업 못 들음
            }
        }

        return n;
    }
}
