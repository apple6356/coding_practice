package level2;

public class ParkingFee {

    public static void main(String[] args) {
        int[] fees = new int[]{180, 5000, 10, 600};
        String[] records = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(solution(fees, records));

        fees = new int[]{120, 0, 60, 591};
        records = new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        System.out.println(solution(fees, records));

        fees = new int[]{1, 461, 1, 10};
        records = new String[]{"00:00 1234 IN"};
        System.out.println(solution(fees, records));
    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};


        return answer;
    }
}
