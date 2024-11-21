package com.example.demo.repository;

import com.example.demo.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {

    @Query(value = "SELECT * FROM tb_entrega e WHERE DATE(e.fech_entrega) = DATE(:fechEntrega)", nativeQuery = true)
    List<Entrega> listarEntregaPorfecha(@Param("fechEntrega") Date fechEntrega);


}
