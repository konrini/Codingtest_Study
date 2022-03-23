import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        // 크로아티아 글자로 바꾸기
        word = word.replaceAll("c=", "0");
        word = word.replaceAll("c-", "0");
        word = word.replaceAll("dz=", "0");
        word = word.replaceAll("d-", "0");
        word = word.replaceAll("lj", "0");
        word = word.replaceAll("nj", "0");
        word = word.replaceAll("s=", "0");
        word = word.replaceAll("z=", "0");
        System.out.println(word.length());
    }
}
