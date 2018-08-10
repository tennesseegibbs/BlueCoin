package com.buecoin01.Repositories;

import com.buecoin01.model.Transactions;
import com.buecoin01.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {


}
