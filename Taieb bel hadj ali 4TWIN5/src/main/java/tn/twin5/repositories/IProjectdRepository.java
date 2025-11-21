package tn.twin5.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.twin5.entities.Projects;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IProjectdRepository extends CrudRepository<Projects, Long> {


    List<Projects> findByEndDateAfter(Date enDate);

    List<Projects> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(
            LocalDate endPeriod,
            LocalDate startPeriod
    );






}
