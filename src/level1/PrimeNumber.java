package level1;

// 소수구하기
public class PrimeNumber {

    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        int[] arr = {1, 2, 7, 6, 4};
        System.out.println(primeNumber.solution(arr));
    }

    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if(isPrime(nums[i] + nums[j] + nums[k])) answer++;
                }
            }
        }

        return answer;
    }

    // 소수 판별
    public boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) { // 루트 num 이하의 수를 이용해 소수 판별
            if(num % i == 0) return false;
        }
        return true;
    }

}
