CREATE PROCEDURE getEmpNameById(
	IN  empId INT,
	OUT eName VARCHAR(25)
)
BEGIN
		 select concat(e.first_name,' ',e.last_name) as fullName into eName from demo.employee e where e.id =empId; 

END