package ksc.poc.spring.integration.tests.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ksc.poc.spring.integration.tests.entities.Student;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

}
