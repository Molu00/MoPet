package tw.com.MoPet.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface petRepository extends JpaRepository<pet, Integer> {

}
