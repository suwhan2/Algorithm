-- 코드를 입력하세요
SELECT *
from food_product
where price = (SELECT MAX(PRICE) from food_product)