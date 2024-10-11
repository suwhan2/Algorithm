-- 코드를 작성해주세요
SELECT ID, coalesce(
       ( SELECT count(*)
        from ecoli_data
        group by parent_id
        having parent_id = ID),0
    ) AS CHILD_COUNT

FROM ecoli_data
ORDER BY id







