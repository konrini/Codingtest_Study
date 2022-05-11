package com.boj.day20220510;

import java.util.HashSet;

	
public class PGS_42890_후보키2 {
	static int rows,col;
    static String[][] table;
    static HashSet<HashSet<Integer>> can;
    
    public int solution(String[][] relation) {
        
        //행 크기
        rows=relation.length;
        //열 크기
        col=relation[0].length;
        //외부에서 relation을 쓰기 위해서 주소 복사해서 넣기
        table=relation;
        
        can=new HashSet<HashSet<Integer>>();
        
        //키의 개수를 순서로 해서 뽑자.
        for(int idx=1;idx<=col;idx++){
            getKeySet(0,idx,new HashSet<Integer>());
        }
        
       
        return can.size();
    }
    
    public void getKeySet(int start, int pick, HashSet<Integer> set){
        
        //원하는 개수만큼 다 뽑았을 때. 즉, 뽑기는 끝
        if(pick==0){
            
            //유일성 체크
            if(!isUnique(set)){
                return;
            }
            
            //최소성 체크
            for(HashSet<Integer> p : can){
                //수정할 거라서 새롭게 temp를 만든다
                HashSet<Integer> temp = new HashSet<>(p);
                
                temp.removeAll(set);
                
                //만약, temp에서 set이 다 제거되었다면, 이는 p와 set이 겹치는 것이기 때문에 최소성에서 위배된다.(개수가 더 많다)
                if(temp.size()==0){
                    return;
                }
            }
            
            //그게 아니라면, 최소성에 맞게 다 뽑은 것이기 때문에 통과
            can.add(set);
            
            return;
        }
        
        //아직 덜 뽑았기 때문에, 
        for (int i = start; i < col; i++) {
          HashSet<Integer> newSet = new HashSet<Integer>(set);
          newSet.add(i);
          getKeySet(i + 1, pick - 1, newSet);
        }
        
        
    }
    
    public boolean isUnique(HashSet<Integer> set) {
        HashSet<String> setResult = new HashSet<String>();

        for (String[] row : table) {
          String value = "";

          for (Integer idx : set) {
            value += row[idx];
          }
            
          //데이터별로 해당 키의 튜플들만 묶어서 문자열을 만든다.
          //그런 다음, 한번에 비교해서 만약 같은 문자열이 있다면 이는 모든 튜플이 겹친다는 의미이기 때문에 유일성에서 탈락하게 된다.
          // 겹치는 값이 하나라도 있으면 값들을 유일하게 식별해낼 수 없음
          if (!setResult.add(value))
            return false;
        }

        return true;
      }
}
