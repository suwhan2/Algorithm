-- 코드를 입력하세요
SELECT CATEGORY, sum(s.SALES) as TOTAL_SALES
from book b join BOOK_SALES s
on b.book_id = s.book_id
where date_format(s.sales_date, "%Y-%m") = '2022-01'
group by b.category
order by CATEGORY
