//12945
class 피보나치수 {
    public int solution(int n) {
        int[] fibo = new int[n+1];
        fibo[1] = 1;

        for(int i=2;i<n+1;i++){
            fibo[i] = (fibo[i-1] + fibo[i-2])%1234567;
        }

        return fibo[n];
    }
}