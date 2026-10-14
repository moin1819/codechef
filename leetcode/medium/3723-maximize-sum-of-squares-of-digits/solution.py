class Solution:

  def maxSumOfSquares(self, num: int, sum: int) -> str:
    # Check if the sum is out of the possible range
    if sum < 0 or sum > 9 * num:
      return ""

    q = sum // 9
    r = sum % 9

    # Build the string with 9s first, then the remainder digit, then 0s
    result = []
    result.append("9" * q)
    if r > 0:
      result.append(str(r))

    zeros_needed = num - q - (1 if r > 0 else 0)
    result.append("0" * zeros_needed)

    return "".join(result)