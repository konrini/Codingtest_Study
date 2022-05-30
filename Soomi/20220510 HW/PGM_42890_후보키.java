import java.util.*;
class PGM_42890_후보키 {
    List<String> Key = new ArrayList<>();
    public int solution(String[][] relation) {

        // 모든 경우의 수 저장할 배열, 속성 개수만큼 초기화
        int temp[] = new int[relation[0].length];       
        
        // 전부 검색
        find(0, relation, temp);
        
        return Key.size();
    }//solution
    public void find(int idx, String[][] relation, int[] temp){
        // 검사 끝
        if(idx== relation[0].length){
            String s = "";
            for(int i=0; i<relation[0].length; i++){
                if(temp[i]==1)
                    s+= String.valueOf(i);
            }
            
            if(s.equals("") || s.equals(null))
                return;
            
            if(!Key.isEmpty()){
                for(int i=0; i<Key.size(); i++){
                    String tempkey = Key.get(i);
                    boolean b = false;
                    
                    for(char c: tempkey.toCharArray()){
                        if(!s.contains(String.valueOf(c))){
                            b = true;
                            break;
                        }
                    }
                    if(!b)
                        return;
                }
            }
            
            Map<String,Integer> check = new HashMap<String,Integer>();

			String[] arr = s.split("");
			for ( int j = 0 ; j < relation.length; j++ ) {
				String s2 = "";
				for ( int i = 0 ; i < arr.length; i++ ) {
					s2 += relation[j][Integer.valueOf(arr[i])];
				}
				if ( check.get(s2) == null ) check.put(s2,1);
				else return;
			}
			Key.add(s);
			return;
        }
        
        // 재귀
        temp[idx] = 0;
        find(idx+1, relation, temp);
        temp[idx] = 1;
        find(idx+1, relation, temp);
        
    }
}