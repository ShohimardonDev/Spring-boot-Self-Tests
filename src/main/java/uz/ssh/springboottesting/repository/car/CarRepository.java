package uz.ssh.springboottesting.repository.car;


import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.ssh.springboottesting.model.car.entity.Car;

@Repository
 public interface CarRepository extends JpaRepository<Car, String> {

    /**
    * Find all entities ordered by ID descending with pagination
    * @param pageable pagination information
    * @return page of entities
    */
    Page<Car> findAllByOrderByIdDesc(Pageable pageable);


}
