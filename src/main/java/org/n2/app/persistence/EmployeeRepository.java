package org.n2.app.persistence;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	Employee findByCode(String code);
	Employee findByMailAddress(String mail);
	
}
