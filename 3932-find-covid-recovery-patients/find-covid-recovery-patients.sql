WITH FirstPositive AS (
    SELECT 
        patient_id,
        MIN(test_date) AS first_positive_date
    FROM covid_tests
    WHERE result = 'Positive'
    GROUP BY patient_id
),
FirstNegativeAfterPositive AS (
    SELECT 
        c.patient_id,
        MIN(c.test_date) AS first_negative_date
    FROM covid_tests c
    JOIN FirstPositive fp 
        ON c.patient_id = fp.patient_id 
       AND c.test_date > fp.first_positive_date
    WHERE c.result = 'Negative'
    GROUP BY c.patient_id
)
SELECT 
    p.patient_id,
    p.patient_name,
    p.age,
    DATEDIFF(fn.first_negative_date, fp.first_positive_date) AS recovery_time
FROM patients p
JOIN FirstPositive fp 
    ON p.patient_id = fp.patient_id
JOIN FirstNegativeAfterPositive fn 
    ON p.patient_id = fn.patient_id
ORDER BY recovery_time ASC, p.patient_name ASC;
