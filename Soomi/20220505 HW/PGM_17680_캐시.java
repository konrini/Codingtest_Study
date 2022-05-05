import java.util.*;

class Solution {
    public static int cachehit = 1;
    public static int cachemiss = 5;
    public int solution(int cacheSize, String[] cities) {
        
        if(cacheSize==0)
            return 5 * cities.length;
        
        int answer = 0;
        
        LinkedList<String> cache = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++){
            String name = cities[i].toUpperCase();
            
            if(cache.remove(name)){
                cache.addFirst(name);
                answer += cachehit;
            }else{
                int size = cache.size();
                if(size==cacheSize)
                    cache.pollLast();
                cache.addFirst(name);
                answer += cachemiss;
            }
        }
        
        return answer;
    }
}