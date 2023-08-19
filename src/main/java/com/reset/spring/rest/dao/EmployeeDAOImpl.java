package com.reset.spring.rest.dao;


import com.reset.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory; // Используем DI
    private Session session;

    @Override
    public List<Employee> getAllEmployees() {
        session = sessionFactory.getCurrentSession();
        Query<Employee> employeeQueryResult = session.createQuery("from Employee",
                Employee.class);

        return employeeQueryResult.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        session = sessionFactory.getCurrentSession();
        session.merge(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        session = sessionFactory.getCurrentSession();

        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployeeById(int id) {
        session = sessionFactory.getCurrentSession();
        NativeQuery<Void> deleteEmployeeByIdQuery = session.createNativeQuery(
                "delete from employee where id = :id", //":id" - синтаксис, создаём переменную которую отредактируем ниже
                Void.class);

        deleteEmployeeByIdQuery.setParameter("id", id);

        deleteEmployeeByIdQuery.executeUpdate();
    }


}
