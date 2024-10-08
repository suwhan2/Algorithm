-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(hire_ymd, '%Y-%m-%d') as HIRE_YMD
from doctor
where mcdp_cd = 'GS' or mcdp_cd = 'CS'
order by hire_ymd desc , dr_name asc