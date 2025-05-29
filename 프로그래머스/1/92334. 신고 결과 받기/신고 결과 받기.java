import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //set 사용해서 report 중복 제거
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        //각자 신고 당한 횟수 저장하는 map
        Map<String, Integer> reportCount = new HashMap<>();
        //각자 신고한 사람 리스트 저장하는 map
        Map<String, List<String>> iReportList = new HashMap<>();

        //map 2개 완성
        for(String rs : reportSet){
            String[] re = rs.split(" ");
            String from = re[0]; //신고한 사람
            String to = re[1]; //신고 당한 사람

            //신고 당한 횟수 저장
            reportCount.put(to, reportCount.getOrDefault(to, 0)+1);

            //신고한 사람 리스트에 없으면
            if(!iReportList.containsKey(from)){
                iReportList.put(from, new ArrayList<>());
            }
            iReportList.get(from).add(to);
        }

        //k 이상인 애들 찾아서 answer 증가
        for(int i=0; i<id_list.length; i++){
            String reporter = id_list[i];
            for(String reportee : iReportList.getOrDefault(reporter, new ArrayList<>())){
                if(reportCount.get(reportee) >= k){
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}