# SQL LEFT JOIN 
# LEFT JOIN 关键字会从左表 (table_name1) 那里返回所有的行，即使在右表 (table_name2) 中没有匹配的行。
# 因为我们的Person未必都会有Address数据，因此我们可以使用LEFT JOIN
# 基本语法：
# SELECT column_name(s)
# FROM table_name1
# LEFT JOIN table_name2 
# ON table_name1.column_name=table_name2.column_name

SELECT Person.FirstName, Person.LastName, Address.City, Address.State
FROM Person 
Left JOIN Address
ON Person.PersonId = Address.PersonId;


SELECT FirstName, LastName, City, State
FROM Person left join Address
ON Person.PersonId = Address.PersonId;