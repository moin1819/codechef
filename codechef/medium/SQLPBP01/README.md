# SQLPBP01

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### List of Movies with Ratings
### Task

Write a query to select only the movie names where the ratings are greater than 7 but less than 9.

Table:  **`Cinema`** 

Movie_id	Movie_name	Description	Rating
1	War	great 3D	8.9
2	Science	fiction	8.5
3	Irish	boring	6.2
4	Ice Song	Fantasy	8.6
5	House Card	Interesting	9.1
6	The Escape	Thriller	7.8
7	Solar Flare	Sci-Fi	8.3
8	The Joker	Drama	9.0
9	Lost Dreams	Mystery	7.5
10	Galaxy War	Action	8.7
### Expected column
- Movie_name

## Solution

**Language:** SQL  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-17T14:44:14.742Z  

```sql
SELECT Movie_name 
FROM Cinema 
WHERE Rating > 7 AND Rating < 9;
```

---

[View on CodeChef](https://www.codechef.com/problems/SQLPBP01)