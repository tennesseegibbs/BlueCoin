package com.buecoin01.Repositories;

import com.buecoin01.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    //@Query(value = "SELECT t FROM Wallet as t WHERE t.publicId = ?1", nativeQuery = true)
    List<Wallet> findWalletByPublicId(@Param("id")String id);


}
