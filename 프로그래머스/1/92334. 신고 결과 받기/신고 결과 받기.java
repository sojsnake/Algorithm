//map 2개, set 1개
//<신고 당한 사람, 횟수>
//<신고자, 신고한 리스트>
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        //set으로 중복 없애기
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        //Map<신고 당한 사람, 횟수>
        Map<String, Integer> reportCount = new HashMap<>();
        //<신고자, 신고한 리스트>
        Map<String, List<String>> iReportWho = new HashMap<>();
        
        for(String s : reportSet){
            String[] parts = s.split(" ");
            String from = parts[0]; //신고자
            String to = parts[1]; //신고 당한 사람
            
            //map1 완성
            reportCount.put(to, reportCount.getOrDefault(to, 0) + 1);
            
            //map2 완성
            if(!iReportWho.containsKey(from)){
                iReportWho.put(from, new ArrayList<>());
            }
            //리스트에 추가
            iReportWho.get(from).add(to);
        }
        
        //answer 완성
        for(int i=0; i<id_list.length; i++){
            String reporter = id_list[i];
            //reporter에 해당하는 리스트 가져와서 각 신고 당한사람별 count가 k이상
            for(String reportee : iReportWho.getOrDefault(reporter, new ArrayList<>())){
                if(reportCount.get(reportee) >= k)
                    answer[i]++;
            }
        }
        
        
        return answer;
    }
}