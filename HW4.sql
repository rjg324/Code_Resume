select last_name || ' earns $' ||salary || ' monthly but wants $'|| salary*3 "Dream Salary"
from EMPLOYEES


select last_name , hire_date, to_char(hire_date,'Day') "Day"
from EMPLOYEES
order by to_char(hire_date -1,'d')


select job_id, decode(job_id,
'AD_PRES', 'A',
'ST_MAN', 'B',
'IT_PROG', 'C',
'SA_REP', 'D',
'ST_CLERK', 'E',
'None of the above', '0') Grade
from EMPLOYEES


SELECT job_id, CASE job_id
WHEN 'ST_CLERK' THEN 'E'
WHEN 'SA_REP' THEN 'D'
WHEN 'IT_PROG' THEN 'C'
WHEN 'ST_MAN' THEN 'B'
WHEN 'AD_PRES' THEN 'A'
ELSE '0' END GRADE
FROM employees;