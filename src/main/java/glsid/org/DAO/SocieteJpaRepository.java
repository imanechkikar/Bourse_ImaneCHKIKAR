package glsid.org.DAO;

import java.util.List;

import glsid.org.Entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface SocieteJpaRepository extends JpaRepository<Societe, Long> {

	 @Query("select s from Societe s where s.codeSociete like :code")
     public Societe findSocietebyCode(@Param("code") String code);
}
