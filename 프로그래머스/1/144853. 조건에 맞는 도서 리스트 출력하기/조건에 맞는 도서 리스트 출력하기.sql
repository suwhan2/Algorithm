select BOOK_ID, date_format(PUBLISHED_DATE,'%Y-%m-%d') as PUBLISHED_DATE
from BOOK
where date_format(PUBLISHED_DATE,'%Y')='2021' and CATEGORY='인문'