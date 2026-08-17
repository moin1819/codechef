# SQLPBP13

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Distinct Companies
### Task

Write a query to select all the distinct companies (`company_name`) in the `Works` table.
Table name:  **`Works`** 

employee_id	company_name	salary
1	TechCorp	75000.00
2	InnovateLtd	62000.50
3	HealthPlus	54000.75
4	EduWorks	48000.00
5	GreenTech	68000.00
6	TechCorp	80000.00
7	InnovateLtd	66000.20
8	HealthPlus	50000.10
9	EduWorks	51000.00
10	GreenTech	72000.00
### Expected Column
- company_name

## Solution

**Language:** SQL  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-17T14:41:23.443Z  

```sql
SELECT DISTINCT company_name 
FROM Works;
```

---

[View on CodeChef](https://www.codechef.com/problems/SQLPBP13)