class Solution:
    def minAddToMakeValid(self, s):
        open_needed = 0
        moves = 0

        for char in s:
            if char == '(':
                open_needed += 1
            else:
                if open_needed > 0:
                    open_needed -= 1
                else:
                    moves += 1

        return moves + open_needed