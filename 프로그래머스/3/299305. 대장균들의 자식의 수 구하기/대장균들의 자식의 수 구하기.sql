SELECT
    P.ID,
    CASE
        WHEN COUNT(*)=1 THEN
            (CASE
                WHEN C.ID IS NULL THEN 0
                ELSE 1
             END)
        ELSE COUNT(*)
    END AS CHILD_COUNT
FROM ECOLI_DATA AS P
LEFT JOIN ECOLI_DATA AS C
    ON P.ID = C.PARENT_ID
GROUP BY P.ID;
