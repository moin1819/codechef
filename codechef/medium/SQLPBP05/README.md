# SQLPBP05

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Player Details
### Task

Write a query to retrieve the details of the  **last five matches**  played, including the match ID, the names of the players who participated, the name of the winning player, match date, and the final score of the winner.

There are two tables named  **`Players`**  and  **`Matches`**.

### Expected Output Columns:
- match_id
- player_1
- player_2
- winner
- match_date
- score
### Expected Output:

```
┌──────────┬──────────┬──────────┬────────┬────────────┬───────┐
│ match_id │ player_1 │ player_2 │ winner │ match_date │ score │
├──────────┼──────────┼──────────┼────────┼────────────┼───────┤
│ 106      │ Frank    │ Hank     │ Frank  │ 2024-01-29 │ 1450  │
│ 101      │ Alice    │ Bob      │ Bob    │ 2024-01-25 │ 1500  │
│ 110      │ David    │ Eve      │ David  │ 2024-01-24 │ 1600  │
│ 108      │ Jack     │ Alice    │ Jack   │ 2024-01-19 │ 1400  │
│ 103      │ Eve      │ Bob      │ Bob    │ 2024-01-17 │ 1500  │
└──────────┴──────────┴──────────┴────────┴────────────┴───────┘

```

## Solution

**Language:** SQL  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-17T14:48:16.378Z  

```sql
SELECT 
    m.match_id, 
    m.player_1, 
    m.player_2, 
    m.winner, 
    m.match_date, 
    p.score
FROM Matches m
JOIN Players p ON m.winner = p.player_name
ORDER BY m.match_date DESC
LIMIT 5;
```

---

[View on CodeChef](https://www.codechef.com/problems/SQLPBP05)