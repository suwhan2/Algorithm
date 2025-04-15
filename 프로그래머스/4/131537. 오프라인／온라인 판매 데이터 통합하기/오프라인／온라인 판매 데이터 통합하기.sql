select date_format(SALES_DATE,'%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE
where date_format(sales_date,'%Y-%m')='2022-03'
union
select date_format(SALES_DATE,'%Y-%m-%d') as SALES_DATE, PRODUCT_ID, null , SALES_AMOUNT
from OFFLINE_SALE
where date_format(sales_date,'%Y-%m')='2022-03'
order by SALES_DATE, PRODUCT_ID, USER_ID