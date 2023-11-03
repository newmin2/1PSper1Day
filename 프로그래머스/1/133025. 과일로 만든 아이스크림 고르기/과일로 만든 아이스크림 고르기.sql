-- 코드를 입력하세요
SELECT a.FLAVOR
from FIRST_HALF a join ICECREAM_INFO b on a.FLAVOR = b.FLAVOR 
where TOTAL_ORDER>3000 and INGREDIENT_TYPE='fruit_based'
order by TOTAL_ORDER DESC;