package com.buecoin01.Repositories;

import com.buecoin01.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
public interface BlockRepository extends JpaRepository<Block, Long> {
}
