-- 코드를 작성해주세요
SELECT COUNT(*) AS FISH_COUNT
FROM fish_info fi JOIN fish_name_info fni
ON fi.fish_type = fni.fish_type
WHERE fni.fish_name = 'BASS' or fni.fish_name = 'SNAPPER'
