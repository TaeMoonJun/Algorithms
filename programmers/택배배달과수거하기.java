//150369
class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int products, lastPick = -1, lastDeliv = -1;

        for (int i = n-1; i > 0; i--) {
            if (deliveries[i] != 0 && lastDeliv == -1) {
                lastDeliv = i;
            }
            if (pickups[i] != 0 && lastPick == -1) {
                lastPick = i;
            }
            if (lastDeliv != -1 && lastPick != -1) {
                break;
            }
        }

        while (lastDeliv >= 0 || lastPick >= 0) {
            answer += (Math.max(lastDeliv, lastPick)+1)* 2L;
            products = cap;

            while (products > 0 && lastDeliv >=0) {
                int complete = Math.min(products, deliveries[lastDeliv]);
                products -= complete;
                deliveries[lastDeliv] -= complete;
                while (lastDeliv >=0 && deliveries[lastDeliv] == 0) {
                    lastDeliv--;
                }
            }

            products = 0;
            while (products < cap && lastPick >= 0) {
                int complete = Math.min(cap-products, pickups[lastPick]);
                products += complete;
                pickups[lastPick] -= complete;
                while (lastPick >= 0 && pickups[lastPick] == 0) {
                    lastPick--;
                }
            }
        }

        return answer;
    }
}
//그저 구현...