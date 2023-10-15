# Write your MySQL query statement below

SELECT IFNULL(
    Null,
   (SELECT DISTINCT salary
    FROM employee 
    where 
    salary < (SELECT DISTINCT salary 
            from employee 
            ORDER BY salary DESC 
            LIMIT 1)
    ORDER BY salary DESC
    LIMIT 1
    )
) as SecondHighestSalary;
