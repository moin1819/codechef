class Solution:
    def validSequence(self, word1: str, word2: str) -> list[int]:
        n1, n2 = len(word1), len(word2)
        
        # suffix[j] stores the largest index in word1 from which 
        # word2[j:] can be matched EXACTLY as a subsequence.
        suffix = [-1] * n2
        p1 = n1 - 1
        for j in range(n2 - 1, -1, -1):
            while p1 >= 0 and word1[p1] != word2[j]:
                p1 -= 1
            if p1 >= 0:
                suffix[j] = p1
                p1 -= 1
            else:
                break
        
        res = []
        changed = False
        i = 0
        
        for j in range(n2):
            while i < n1:
                is_match = (word1[i] == word2[j])
                can_finish_exact = (j == n2 - 1) or (suffix[j + 1] > i)
                
                if is_match:
                    if can_finish_exact or not changed:
                        res.append(i)
                        i += 1
                        break
                else:
                    if not changed and can_finish_exact:
                        res.append(i)
                        changed = True
                        i += 1
                        break
                
                i += 1
            else:
                return []
                
        return res