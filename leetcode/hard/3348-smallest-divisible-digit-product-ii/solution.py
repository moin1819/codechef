class Solution:
    def smallestNumber(self, num: str, t: int) -> str:
        temp_t = t
        req2 = req3 = req5 = req7 = 0
        
        while temp_t % 2 == 0: req2 += 1; temp_t //= 2
        while temp_t % 3 == 0: req3 += 1; temp_t //= 3
        while temp_t % 5 == 0: req5 += 1; temp_t //= 5
        while temp_t % 7 == 0: req7 += 1; temp_t //= 7
        if temp_t > 1:
            return "-1"

        def count_factor(n: int, p: int) -> int:
            cnt = 0
            while n > 0 and n % p == 0:
                cnt += 1
                n //= p
            return cnt

        def min_suffix(r2: int, r3: int, r5: int, r7: int) -> str:
            """Greedily combine prime factors to minimize suffix length."""
            c9, r3 = divmod(r3, 2)
            c8, r2 = divmod(r2, 3)
            c7 = r7
            c5 = r5

            c6 = 0
            if r2 == 2 and r3 == 1:
                c6, r2, r3 = 1, 1, 0
            elif r2 == 1 and r3 == 1:
                c6, r2, r3 = 1, 0, 0

            c4, r2 = divmod(r2, 2)
            c3 = r3
            c2 = r2

            return ('2' * c2 + '3' * c3 + '4' * c4 + 
                    '5' * c5 + '6' * c6 + '7' * c7 + 
                    '8' * c8 + '9' * c9)

        n = len(num)
        pref2, pref3, pref5, pref7 = [0]*(n+1), [0]*(n+1), [0]*(n+1), [0]*(n+1)

        first_zero = n
        for i in range(n):
            if num[i] == '0':
                first_zero = i
                break
            d = int(num[i])
            pref2[i + 1] = pref2[i] + count_factor(d, 2)
            pref3[i + 1] = pref3[i] + count_factor(d, 3)
            pref5[i + 1] = pref5[i] + count_factor(d, 5)
            pref7[i + 1] = pref7[i] + count_factor(d, 7)
        if first_zero == n and (pref2[n] >= req2 and pref3[n] >= req3 and 
                                pref5[n] >= req5 and pref7[n] >= req7):
            return num
        for i in range(min(n - 1, first_zero), -1, -1):
            start_digit = int(num[i]) + 1

            for d in range(start_digit, 10):
                c2 = pref2[i] + count_factor(d, 2)
                c3 = pref3[i] + count_factor(d, 3)
                c5 = pref5[i] + count_factor(d, 5)
                c7 = pref7[i] + count_factor(d, 7)

                r2 = max(0, req2 - c2)
                r3 = max(0, req3 - c3)
                r5 = max(0, req5 - c5)
                r7 = max(0, req7 - c7)

                suf = min_suffix(r2, r3, r5, r7)
                rem_len = (n - 1) - i

                if len(suf) <= rem_len:
                    return num[:i] + str(d) + ('1' * (rem_len - len(suf))) + suf
        suf = min_suffix(req2, req3, req5, req7)
        target_len = max(n + 1, len(suf))
        return ('1' * (target_len - len(suf))) + suf