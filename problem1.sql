select title "Course Title",course_id "Course ID",dept_name "Department Name",
CASE
    WHEN credits < 3 Then 'Low Credit Course'
    WHEN credits = 3 Then 'Medium Credit Course'
    WHEN credits > 3 Then 'High Credit Course'
END AS "Credit Category"
from COURSE
Order by dept_name ASC, COURSE_ID ASC, title ASC;


SELECT ID "Student ID", course_id "Course ID", Year, Grade, 
  CASE
    WHEN (Year > 2017 AND grade >= 'A-') OR (Year <= 2017 AND grade <= 'B+') THEN 'Yes'
    ELSE 'No'
  END AS "Correct Research?"
FROM TAKES
ORDER BY year ASC, id DESC;
 





select id "Student ID", name "Student Name"
from student




