import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        //1번 for문: 문자열 배열 완성하기
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        //문자열 배열에서 a, b 가져와서 
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // 정렬 후 가장 앞에 있는 값이 0이면, 전부 0이라는 의미
        if (nums[0].equals("0")) return "0";

        StringBuilder answer = new StringBuilder();
        for (String num : nums) {
            answer.append(num);
        }

        //StringBuilder는 하나의 별도 타입(클래스)으로, string 변환 필요
        return answer.toString();
    }
}

