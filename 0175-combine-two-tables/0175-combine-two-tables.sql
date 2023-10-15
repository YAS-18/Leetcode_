# Write your MySQL query statement below
Select firstname, lastname, city, state 
From address 
Right Join
person 
On person.personId = address.personId;