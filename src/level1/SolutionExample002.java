package level1;

import java.util.HashMap;

class Solution002 {
	public String solution(String[] participant, String[] completion) {
		//participant : 참여한 선수
        //completion : 완주한 선수
        String answer = "";
        
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        
        for(String player : participant) {
        	result.put(player, result.getOrDefault(player, 0) + 1);
        }

        System.out.println(result);
        
        
        for(String player : completion) {
        	result.put(player, result.get(player) - 1);
        }
        

        for(String key : result.keySet()) {
        	if(result.get(key) != 0) {
        		answer = key;
        	}
        }
        
        return answer;
	}
}

public class SolutionExample002 {
	public static void main(String[] args) {
		Solution002 solution002 = new Solution002();
		
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		
		System.out.println(solution002.solution(participant, completion));
	}

}
