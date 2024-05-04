/*question 1*/
 SELECT
    b.building,
    SUM(CASE WHEN (s.year) = 2010 THEN 1 ELSE 0 END) AS sections_2010,
    SUM(CASE WHEN (s.year) = 2005 THEN 1 ELSE 0 END) AS sections_2005,
    SUM(CASE WHEN (s.year) = 2010 THEN 1 ELSE 0 END) - SUM(CASE WHEN (s.year) = 2005 THEN 1 ELSE 0 END) AS change,
    CAST((SUM(CASE WHEN (s.year) = 2010 THEN 1 ELSE 0 END) - SUM(CASE WHEN (s.year) = 2005 THEN 1 ELSE 0 END)) AS DECIMAL(10,2)) AS change_decimal,
    CASE
        WHEN SUM(CASE WHEN (s.year) = 2010 THEN 1 ELSE 0 END) > SUM(CASE WHEN (s.year) = 2005 THEN 1 ELSE 0 END) THEN 'Increase'
        WHEN SUM(CASE WHEN (s.year) = 2010 THEN 1 ELSE 0 END) < SUM(CASE WHEN (s.year) = 2005 THEN 1 ELSE 0 END) THEN 'Decrease'
        ELSE 'No Change'
    END AS change_status,
    CASE
        WHEN SUM(CASE WHEN (s.year) = 2005 THEN 1 ELSE 0 END) = 0 THEN 'N/A'
        ELSE CONCAT(
            CAST((CAST(SUM(CASE WHEN (s.year) = 2010 THEN 1 ELSE 0 END) - SUM(CASE WHEN (s.year) = 2005 THEN 1 ELSE 0 END) AS DECIMAL(10,2)) / SUM(CASE WHEN (s.year) = 2005 THEN 1 ELSE 0 END) * 100) AS DECIMAL(10,2)),
            '%'
        )
    END AS change_percentage
FROM CLASSROOM b
LEFT JOIN section s ON b.building = s.building
WHERE (s.year) IN (2005, 2010)
GROUP BY b.building
ORDER BY change DESC;



/*question 2*/



SELECT
    s.id || ' '|| s.name AS student_info,
    s.tot_cred AS total_credits,
    SUM(c.credits) AS total_credits_calculated,
    CASE
        WHEN (s.tot_cred - SUM(c.credits)) > 50 THEN 'Incorrect'
        ELSE 'Needs Examination'
    END AS result_status
FROM student s
 JOIN takes t ON s.id = t.id
JOIN course c ON t.course_id = c.course_id
GROUP BY s.id, s.name, s.tot_cred
HAVING s.tot_cred > SUM(c.credits)
ORDER BY total_credits_calculated DESC;


/*question 3*/
SELECT
    SUBSTR(title, 1, 25) AS truncated_course_name,
    SUM(CASE WHEN grade IN ('C', 'D', 'F') THEN 1 ELSE 0 END) AS students_with_c_or_lower,
    ROUND(AVG(
        CASE
            WHEN grade = 'A' THEN 4.00
            WHEN grade = 'B' THEN 3.00
            WHEN grade = 'C' THEN 2.00
            WHEN grade = 'D' THEN 1.00
            WHEN grade = 'F' THEN 0.00
            ELSE 0.00
        END
    ), 2) AS average_gpa,
    ROUND(MIN(
        CASE
            WHEN grade IN ('A', 'B', 'C', 'D', 'F') THEN
                CASE
                    WHEN grade = 'A' THEN 4.00
                    WHEN grade = 'B' THEN 3.00
                    WHEN grade = 'C' THEN 2.00
                    WHEN grade = 'D' THEN 1.00
                    WHEN grade = 'F' THEN 0.00
                    ELSE 0.00
        END
        end
    ), 2) AS min_course_gpa,
    ROUND(MAX(
        CASE
            WHEN grade IN ('A', 'B', 'C', 'D', 'F') THEN
                CASE
                    WHEN grade = 'A' THEN 4.00
                    WHEN grade = 'B' THEN 3.00
                    WHEN grade = 'C' THEN 2.00
                    WHEN grade = 'D' THEN 1.00
                    WHEN grade = 'F' THEN 0.00
                    ELSE 0.00
                END
        END
    ), 2) AS max_course_gpa
FROM course c
JOIN takes t ON c.course_id = t.course_id
WHERE t.year >= 2001
GROUP BY SUBSTR(title, 1, 25)
ORDER BY students_with_c_or_lower DESC;

