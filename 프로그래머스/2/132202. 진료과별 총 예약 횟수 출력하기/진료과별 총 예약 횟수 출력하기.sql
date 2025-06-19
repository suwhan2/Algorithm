select MCDP_CD as '진료과코드', count(PT_NO) as '5월예약건수'
from APPOINTMENT
where YEAR(APNT_YMD) = '2022' and MONTH(APNT_YMD) = '05'
group by MCDP_CD
order by 5월예약건수 ,진료과코드