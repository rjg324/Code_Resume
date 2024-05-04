select *
from JOB_GRADES

select highest_sal "Maximum Salary",
    grade_level "Grade Level"
from JOB_GRADES


/* determine structure of the table and its contents */


desc departments
describe departments

/* display alll unique java ids from the employyes */

select distinct job_id "job id"
from employees

select unique job_id "job id"
from employees



/* concatination - putting together */
/* employees with job id */

select last_name ||' , '|| job_id || ', '|| first_name "Employee and Title"
from employees