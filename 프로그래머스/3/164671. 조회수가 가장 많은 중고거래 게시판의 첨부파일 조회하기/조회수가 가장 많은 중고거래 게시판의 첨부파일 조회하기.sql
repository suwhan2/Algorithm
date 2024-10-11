-- 코드를 입력하세요
SELECT concat("/home/grep/src/", u.board_id,"/",f.FILE_ID,f.file_name,f.file_ext) AS FILE_PATH
from used_goods_board u join used_goods_file f
on u.board_id = f.board_id
where views = (select max(views) from used_goods_board) 
order by file_id desc