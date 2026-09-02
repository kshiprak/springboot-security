

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Characteristics;

@Repository
public interface IUser extends JpaRepository<Characteristics, Integer>{
	

}
