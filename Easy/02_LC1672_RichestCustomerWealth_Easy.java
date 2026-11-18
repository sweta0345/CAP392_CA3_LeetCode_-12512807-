class LC1672_RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {

        int richest = 0;

        for (int[] customer : accounts) {

            int wealth = 0;

            for (int money : customer) {
                wealth = wealth + money;
            }

            richest = Math.max(richest, wealth);
        }

        return richest;
    }
}
