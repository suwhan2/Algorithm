-- 코드를 입력하세요
SELECT MONTH(start_date) as MONTH , CAR_ID, count(*) as RECORDS
FROM car_rental_company_rental_history
where date_format(start_date, "%Y-%m") between '2022-08' and '2022-10'and
    car_id in (
    select car_id
    from car_rental_company_rental_history
    where date_format(start_date, "%Y-%m") between '2022-08' and '2022-10'
    group by car_id
    having count(car_id) >= 5 
    )
group by car_id , MONTH(start_date)
having RECORDS >= 1
ORDER BY MONTH , car_id desc