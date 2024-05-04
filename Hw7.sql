SELECT EMPLOYEES.last_name, EMPLOYEES.job_id, EMPLOYEES.department_id, DEPARTMENTS.department_name, DEPARTMENTS.LOCATION_ID
FROM EMPLOYEES
JOIN DEPARTMENTS ON EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID
WHERE DEPARTMENTS.LOCATION_ID = 1800;





SELECT
    E1.employee_id AS "Employee ID",
    E1.last_name AS "Employee Last Name",
    E1.hire_date AS "Employee Hire Date",
    E2.employee_id AS "Manager ID",
    E2.last_name AS "Manager Last Name",
    E2.hire_date AS "Manager Hire Date"
FROM
    EMPLOYEES E1
JOIN
    EMPLOYEES E2
ON
    E1.manager_id = E2.employee_id
WHERE
    E1.hire_date < E2.hire_date;


SELECT
    E1.last_name AS "Employee",
    E1.department_id AS "Department",
    E2.last_name AS "Colleague"
FROM
    EMPLOYEES E1
JOIN
    EMPLOYEES E2
ON
    E1.department_id = E2.department_id
