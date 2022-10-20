package com.example.demo.servicess;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;
    public List<Employee> getallEmployee(){
    	return dao.findAll();
    }
    
    public Employee insert(Employee e) {
    	return dao.save(e);
    }
    public boolean update(Employee e)
    {
    	Optional<Employee> emp=dao.findById(e.getEid());
    	Employee obj=emp.get();
    	if(obj!=null)
    	{
    		dao.save(e);
    		return true;
    	}
    	else
    		return false;   	
    }
    public void delete(int eid)
    {
    	dao.deleteById(eid);
    }
}
