package level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution001 {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		
		//HashSet : 순서대로 입력되지 않고, 일정하게 유지되지 않는게 특징 중복을 걸려냄
		Map<String, HashSet<String>> reportedMap = new HashMap();
		Map<String,Integer> answerMap = new HashMap<>();
		
		//1. map 초기화
		for(int i = 0; i < id_list.length; i++) {
			HashSet<String> reportingId = new HashSet<String>();
			reportedMap.put(id_list[i], reportingId);
			answerMap.put(id_list[i], 0);
		}
		
		//2. 신고기록
		for(String reportList : report) {
			String[] reportStr = reportList.split(" ");
			String reportingID = reportStr[0];
			String reportedID = reportStr[1];
			reportedMap.get(reportedID).add(reportingID);
		}
		
		System.out.println("key : " + reportedMap.keySet());
		
        for(String reportedUser : reportedMap.keySet()) {
            HashSet<String> userForSend = reportedMap.get(reportedUser);
            if (userForSend.size() >= k) { // 신고된 횟수가 K번 이상일 경우
				for (String userId : userForSend) {
					answerMap.put(userId, answerMap.get(userId) + 1); 
				}
			}
        }
        
        for (int i = 0; i < id_list.length; i++) {
			answer[i] = answerMap.get(id_list[i]);
			System.out.println("[STEP 4] answer : " + answer[i]);
		}
		
		
		return answer;
	}
}

public class SolutionExample001 {
	public static void main(String[] args) {
		Solution001 solution001 = new Solution001();
		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		System.out.println(solution001.solution(id_list, report, k));
	}

}
