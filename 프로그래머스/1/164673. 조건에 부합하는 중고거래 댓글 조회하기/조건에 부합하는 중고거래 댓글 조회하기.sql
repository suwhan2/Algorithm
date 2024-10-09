-- 코드를 입력하세요
SELECT ugb.title,ugb.board_id,ugr.reply_id,ugr.writer_id,ugr.contents,DATE_FORMAT(ugr.created_date,'%Y-%m-%d') as created_date
from used_goods_board ugb join used_goods_reply ugr
on ugb.board_id = ugr.board_id
where DATE_FORMAT(ugb.created_date,'%Y-%m')='2022-10'
order by  created_date , ugb.title 
                                                        