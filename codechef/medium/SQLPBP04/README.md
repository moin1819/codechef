# SQLPBP04

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Player Performance Insights
### Task

Write a query to find the names of the  **top 3 distinct players**  by highest score who have  **won**  matches, including their  **scores**.

Table 1:  **Players** 

player_id	player_name	score	rank
1	Alice	1200	5
2	Bob	1500	2
3	Charlie	1300	4
4	David	1600	1
5	Eve	1100	6

Table 2:  **Matches** 

match_id	player1	player2	winner	match_date
101	Alice	Bob	Bob	2024-01-15
102	Charlie	David	David	2024-01-16
103	Eve	Bob	Bob	2024-01-17
104	Alice	David	David	2024-01-18
105	Charlie	Eve	Charlie	2024-01-19
### Expected Output Columns:

```
┌─────────────┬───────┐
│ player_name │ score │
├─────────────┼───────┤
│ David       │ 1600  │
│ Bob         │ 1500  │
│ Charlie     │ 1300  │
└─────────────┴───────┘

```

## Solution

**Language:** SQL  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-17T14:47:00.256Z  

```sql
SELECT DISTINCT p.player_name, p.score
FROM Players p
JOIN Matches m ON p.player_name = m.winner
ORDER BY p.score DESC
LIMIT 3;
```

---

[View on CodeChef](https://www.codechef.com/problems/SQLPBP04)