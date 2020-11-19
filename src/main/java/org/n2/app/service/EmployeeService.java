package org.n2.app.service;

import java.util.List;

import org.n2.app.persistence.Employee;
import org.n2.app.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.primefaces.PrimeFaces;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployees(){
		return (List<Employee>) employeeRepository.findAll();
	}
	
	public Employee create(Employee employee){	
		if(findByCode(employee.getCode()) == null)
		return employeeRepository.save(employee);
		else return null;
	}
	
	public Employee update(Employee employee){
		Employee emp = findByMail(employee.getMailAddress());
		if(emp == null || emp.getId() == employee.getId())
		return employeeRepository.save(employee);
		else return null;
	}
	
	public Employee find(int id){	
		return employeeRepository.findOne(id);
	}
	
	public Employee findByCode(String  code){	
		return employeeRepository.findByCode(code);
	}
	
	public Employee findByMail(String  mail){	
		return employeeRepository.findByMailAddress(mail);
	}
	
	
/*	public void showSuccessDailog() {
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('success').show();");
		
	}

	public void hideSuccessDailog() {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('success').hide();");
	}*/
	
	
}
