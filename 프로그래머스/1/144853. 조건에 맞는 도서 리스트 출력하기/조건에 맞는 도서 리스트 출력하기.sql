-- 코드를 입력하세요
SELECT book_id, DATE_FORMAT(published_date,"%Y-%m-%d") as published_Date
from book
where DATE_FORMAT(published_date,"%Y") = '2021' and category='인문'
order by published_date