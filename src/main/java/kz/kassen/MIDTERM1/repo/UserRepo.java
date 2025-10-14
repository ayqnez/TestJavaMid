package kz.kassen.MIDTERM1.repo;

import kz.kassen.MIDTERM1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
