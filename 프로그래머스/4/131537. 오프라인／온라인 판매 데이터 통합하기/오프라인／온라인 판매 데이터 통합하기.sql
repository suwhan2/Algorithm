-- 코드를 입력하세요
    SELECT date_format(ons.sales_date,'%Y-%m-%d')as sales_date,
        ons.product_id, 
        ons.user_id,
        ons.sales_amount
    FROM online_sale ons
    WHERE date_format(ons.sales_date , "%Y-%m") = '2022-03'

UNION

    SELECT date_format(offs.sales_date,'%Y-%m-%d') as sales_date, offs.product_id, null as user_id, offs.sales_amount
    FROM offline_sale offs
    WHERE date_format(offs.sales_date , "%Y-%m") = '2022-03'
ORDER BY sales_date, product_id, user_id