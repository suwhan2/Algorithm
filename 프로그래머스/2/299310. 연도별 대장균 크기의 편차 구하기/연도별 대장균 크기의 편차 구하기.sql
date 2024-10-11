-- 코드를 작성해주세요
with big as (
    SELECT  YEAR(DIFFERENTIATION_DATE) as YEAR , max(size_of_colony) as max_size
    from ecoli_data
    group by YEAR
)



select YEAR(e.DIFFERENTIATION_DATE) AS YEAR , (b.max_size - e.SIZE_OF_COLONY) as YEAR_DEV, ID
from ECOLI_DATA e join big b
ON YEAR(e.DIFFERENTIATION_DATE) = b.YEAR
order by YEAR, YEAR_DEV