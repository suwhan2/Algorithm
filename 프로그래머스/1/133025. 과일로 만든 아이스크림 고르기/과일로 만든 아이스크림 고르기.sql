-- 코드를 입력하세요
SELECT m.FLAVOR
FROM first_half m INNER JOIN icecream_info d
ON m.flavor = d.flavor
WHERE m.total_order > 3000 AND d.ingredient_type ='fruit_based'
ORDER BY total_order desc