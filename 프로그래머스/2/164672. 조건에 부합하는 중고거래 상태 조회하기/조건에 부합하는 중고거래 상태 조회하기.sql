-- 코드를 입력하세요
SELECT a.board_id,a.writer_id, a.title, a.price, (
    CASE
        WHEN a.STATUS='SALE' THEN '판매중'
           WHEN a.status = 'RESERVED' THEN '예약중' 
        ELSE '거래완료'
   END
) as STATUS
from used_goods_board a
where CREATED_DATE ='2022-10-05'
order by board_id desc