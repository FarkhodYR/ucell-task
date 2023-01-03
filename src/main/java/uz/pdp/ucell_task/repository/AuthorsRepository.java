package uz.pdp.ucell_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ucell_task.entity.Authors;

public interface AuthorsRepository extends JpaRepository<Authors, Integer> {
}