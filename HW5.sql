/*4,6,11 */

SELECT 
max(salary) "Maximum",
min(salary)"Minimum",
sum(salary) "Sum",
round(AVG(salary))"Average"
From EMPLOYEES;

SELECT Job_id, 
COUNT(*) "Count"
FROM EMPLOYEES
GROUP BY Job_id;



SELECT
    job_id AS "Job",
    MAX(CASE WHEN department_id = 20 THEN salary END) AS "Salary (Dept 20)",
    MAX(CASE WHEN department_id = 50 THEN salary END) AS "Salary (Dept 50)",
    MAX(CASE WHEN department_id = 80 THEN salary END) AS "Salary (Dept 80)",
    MAX(CASE WHEN department_id = 90 THEN salary END) AS "Salary (Dept 90)",
    SUM(salary) AS "Total Salary"
FROM employees
WHERE DEPARTMENT_ID IN (20, 50, 80, 90)
GROUP BY job_id;
