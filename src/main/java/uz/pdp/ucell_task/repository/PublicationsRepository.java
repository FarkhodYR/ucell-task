package uz.pdp.ucell_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.ucell_task.entity.Publications;

import java.util.Date;
import java.util.List;

public interface PublicationsRepository extends JpaRepository<Publications, Integer> {

//    public List<Publications> findAllByCategory(String category);

//    @Query("select a from Publications a where a.publish_date>=:startDate AND a.publish_date>=:endDate")
//    public List<Publications> findByFilteredDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}