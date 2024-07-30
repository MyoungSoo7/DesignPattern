package com.backend.bakckend.programmers.strings;

import java.util.HashMap;

public class MarathonPlayer {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hash_num = new HashMap<String,Integer>();
        for(int i=0; i<participant.length; i++) {
            if(!hash_num.isEmpty() && hash_num.containsKey(participant[i])) {
                hash_num.replace(participant[i], hash_num.get(participant[i])+1);
            } else {
                hash_num.put(participant[i], 1);
            }
        }

        for(int i=0; i<completion.length; i++) {
           hash_num.replace(completion[i], hash_num.get(completion[i])-1);
        }

        for(String key : hash_num.keySet()) {
            if(hash_num.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MarathonPlayer marathonPlayer = new MarathonPlayer();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String notComplete = marathonPlayer.solution(participant, completion);
        System.out.println(notComplete);

    }
}
