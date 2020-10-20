package falah.falah_api.repository;

import falah.falah_api.model.FridayReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface FridayRegRepository extends JpaRepository<FridayReg, Long> {

    @Query("select r from FridayReg r where r.phoneNum = :mobile AND r.registeredOn= :regDate")
    List<FridayReg> findByMobileNum(String mobile, Timestamp regDate);


    @Query("select r from FridayReg r where r.registeredOn = :registeredOn")
    List<FridayReg> getAllByDate(Timestamp registeredOn);
}
