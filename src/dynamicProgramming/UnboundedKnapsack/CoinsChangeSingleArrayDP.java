package dynamicProgramming.UnboundedKnapsack;

public class CoinsChangeSingleArrayDP {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int minCoins = coinsChange(coins, amount);

        System.out.println(minCoins);
    }

    public static int coinsChange(int[] arr, int amount){
        if(amount < 1){
            return 0;
        }

        int n = arr.length;
        int[] dp = new int[amount+1];

        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;

            for(int coin : arr){
                if(coin <= i && dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }

        return dp[amount];
    }
}
