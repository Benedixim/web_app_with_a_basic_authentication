package lesson.demo.repositories;

import lesson.demo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Person, Integer> {
    Person findByUsername(String username);
}
