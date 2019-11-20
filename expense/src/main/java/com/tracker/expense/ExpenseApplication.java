package com.tracker.expense;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tracker.expense.config.HibernateUtil;
import com.tracker.expense.model.Student;

@SpringBootApplication
public class ExpenseApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ExpenseApplication.class, args);

		ApplicationContext ctx = SpringApplication.run(ExpenseApplication.class, args);
		String[] beans = ctx.getBeanDefinitionNames();
		//Stirng[] definition = ctx.getClassLoader()
//		for(String s : beans) System.out.println(s);
//		System.out.println(beans.length);
//		int definition = ctx.getBeanDefinitionCount();
//		System.out.println(definition);
		
		Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        Student student1 = new Student("John", "Cena", "john@javaguides.com");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(student);
            session.save(student1);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List < Student > students = session.createQuery("from Student", Student.class).list();
            
			
//			students.forEach( s - > System.out.println(s.getFirstName()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
		
}


