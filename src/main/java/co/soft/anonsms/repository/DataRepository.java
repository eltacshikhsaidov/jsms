package co.soft.anonsms.repository;

import co.soft.anonsms.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
}
