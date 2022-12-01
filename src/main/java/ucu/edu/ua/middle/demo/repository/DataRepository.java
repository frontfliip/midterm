package ucu.edu.ua.middle.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucu.edu.ua.middle.demo.allData.AllData;

@Repository
public interface DataRepository extends JpaRepository<AllData, Integer> {
    AllData getByDomain(String domain);
}
