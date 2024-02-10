package level1;

public class ShortageCash {

    public static void main(String[] args) {
        ShortageCash sc = new ShortageCash();
        System.out.println(sc.solution(3, 20, 4));
    }

    public long solution(int price, int money, int count) {
        long answer = -1;
        long priceCount = 0;

        for (int i = 1; i <= count; i++) {
            priceCount = priceCount + (price * i);
        }

        answer = (priceCount <= money) ? 0 : (priceCount - money);

        return answer;
    }
}
