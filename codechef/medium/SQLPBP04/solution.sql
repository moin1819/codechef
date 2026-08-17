SELECT DISTINCT p.player_name, p.score
FROM Players p
JOIN Matches m ON p.player_name = m.winner
ORDER BY p.score DESC
LIMIT 3;