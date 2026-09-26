class Solution:
    def evaluate(self, s: str, knowledge: list[list[str]]) -> str:
        # Step 1: Convert knowledge list into a hash map
        know_map = {key: val for key, val in knowledge}
        
        res = []
        in_bracket = False
        curr_key = []
        
        # Step 2: Parse through the string
        for char in s:
            if char == '(':
                in_bracket = True
            elif char == ')':
                in_bracket = False
                key_str = "".join(curr_key)
                # Lookup key in map; substitute "?" if missing
                res.append(know_map.get(key_str, "?"))
                curr_key = []
            elif in_bracket:
                curr_key.append(char)
            else:
                res.append(char)
                
        return "".join(res)