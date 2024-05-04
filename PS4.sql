/*For these problems you will only need to use tables including:
course, takes, instructor, teaches, advisor, section.
*/

/*problem 1*/
WITH CourseGrades AS (
    SELECT
        c.course_id,
        c.title AS course_name,
        c.dept_name AS department_name,
        ROUND(AVG(
            CASE
                WHEN t.grade IN ('A', 'A+', 'A-') THEN 4
                WHEN t.grade IN ('B', 'B+', 'B-') THEN 3
                WHEN t.grade IN ('C', 'C+', 'C-') THEN 2
                WHEN t.grade IN ('D', 'D+', 'D-') THEN 1
                ELSE 0
            END
        ), 3) AS course_average
    FROM
        Course c
    JOIN
        Section s ON c.course_id = s.course_id
    JOIN
        Takes t ON s.sec_id = t.sec_id
    GROUP BY
        c.course_id, c.title, c.dept_name
    HAVING
        COUNT(DISTINCT t.id) > 100
),

UniversityAverage AS (
    SELECT
        ROUND(AVG(
            CASE
                WHEN t.grade IN ('A', 'A+', 'A-') THEN 4
                WHEN t.grade IN ('B', 'B+', 'B-') THEN 3
                WHEN t.grade IN ('C', 'C+', 'C-') THEN 2
                WHEN t.grade IN ('D', 'D+', 'D-') THEN 1
                ELSE 0
            END
        ), 3) AS university_average
    FROM
        Takes t
)

SELECT
    cg.course_id,
    cg.course_name,
    cg.department_name,
    cg.course_average,
    ua.university_average,
    ROUND((cg.course_average / ua.university_average) * 100, 3) AS percentage_of_university_average
FROM
    CourseGrades cg
CROSS JOIN
    UniversityAverage ua
ORDER BY
    cg.course_average;

/*problem 2*/
/*
WITH AdvisorAdviseeCounts AS (
    SELECT
        advisor.i_id AS advisor_id,
        COUNT(advisor.s_id) AS num_advisees
    FROM
        advisor
    GROUP BY
        advisor.i_id
)

SELECT
    student.id || ' - ' || student.name AS student,
    student.tot_cred AS credits,
    instructor.name AS advisor_name,
    instructor.dept_name AS advisor_department,
    AAC.num_advisees AS num_advisees,
    CASE
        WHEN AAC.num_advisees > 1.3 * AVG(AAC.num_advisees) OVER () THEN 'Eligible for Help'
        ELSE 'Satisfactory'
    END AS help_status
FROM
    advisor
JOIN
    instructor ON instructor.ID = advisor.i_id
JOIN
    student ON student.id = advisor.s_id
JOIN
    AdvisorAdviseeCounts AAC ON AAC.advisor_id = advisor.i_id
GROUP BY
    student.id, student.name, student.tot_cred, instructor.name, instructor.dept_name, AAC.num_advisees
ORDER BY
    instructor.name;



*/
/*question 3*/
/*
SELECT
    course.dept_name,
    COUNT(DISTINCT course.course_id) AS "Count by Department",
    SUM(CASE WHEN section.year = 2010 THEN 1 ELSE 0 END) AS count_2010,
    SUM(CASE WHEN section.year = 2011 THEN 1 ELSE 0 END) AS count_2011,
    SUM(CASE WHEN section.year = 2012 THEN 1 ELSE 0 END) AS count_2012,
    SUM(CASE WHEN section.year = 2013 THEN 1 ELSE 0 END) AS count_2013,
    SUM(CASE WHEN section.year = 2014 THEN 1 ELSE 0 END) AS count_2014
FROM
    section
JOIN
    course ON section.course_id=course.course_id
WHERE
    section.year IN (2010, 2011, 2012, 2013, 2014)
GROUP BY
    course.dept_name
    Order BY course.dept_name


*/