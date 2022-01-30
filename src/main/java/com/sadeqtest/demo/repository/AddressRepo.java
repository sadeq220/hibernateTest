package com.sadeqtest.demo.repository;

import com.sadeqtest.demo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {
    // one select statement
    @Query("SELECT adr FROM address adr JOIN FETCH adr.lname ln WHERE adr.id=:addressId")
    Address jpqlTestGood(@Param("addressId")Integer addressId);

    // two select statement
    /**
     * Hibernate: select address0_.user_id as user_id1_0_, address0_.city as city2_0_, address0_.location as location3_0_ from address address0_ where address0_.user_id=?
     * Hibernate: select lname0_.id as id1_2_0_, lname0_.gp as gp2_2_0_, lname0_.lname as lname3_2_0_, address1_.user_id as user_id1_0_1_, address1_.city as city2_0_1_, address1_.location as location3_0_1_ from l_name lname0_ left outer join address address1_ on lname0_.id=address1_.user_id where lname0_.id=?
     */
    @Query("SELECT adr FROM address adr WHERE adr.id=:addressId")
    Address jpqlTestBad(@Param("addressId")Integer addressId);
}
