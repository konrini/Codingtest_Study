import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 식 받아오기 (-를 기준으로 구분하여 가져옴)
        // 가장 처음과 마지막 문자는 숫자
        String[] statement = br.readLine().split("-");
        // 최종 결과
        int result = 0;
        // 처음은 무조건 +이니까 처음 체크용
        int cnt = 0;
        for (String str : statement) {
            // 현재 숫자
            String temp = "";
            // 이미 계산된 숫자값
            int num = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '+') {
                    // 저장
                    num += Integer.parseInt(temp);
                    // 초기화
                    temp = "";
                } else {
                    temp += str.charAt(i);
                }
            }
            // 마지막 숫자값을 처리해주기 위함
            // 처음만 양수
            if (cnt == 0) {
                result += (num + Integer.parseInt(temp));
                cnt++;
            }
            // 나머지는 빼기
            else {
                result -= (num + Integer.parseInt(temp));
            }
        }
        bw.write(result + "");
        bw.close();
    }
}