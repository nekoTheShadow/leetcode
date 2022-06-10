SELECT Department, Employee, Salary
FROM (
  SELECT 
    D.name AS Department, 
    E.name AS Employee, 
    E.salary AS Salary, 
    DENSE_RANK() OVER(PARTITION BY E.departmentId ORDER BY E.salary DESC) AS DR
  FROM Employee E
  JOIN Department D ON E.departmentId = D.id
) T
WHERE DR <= 3