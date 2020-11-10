class Solution(object):
    def maxProfit(self, prices, fee):
        cash, hold = 0, -prices[0]
        for i in range(len(prices)):
            cash = max(cash, hold + prices[i] - fee)
            hold = max(hold, cash - prices[i])
        return cash