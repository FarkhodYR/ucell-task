package uz.pdp.ucell_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ucell_task.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
