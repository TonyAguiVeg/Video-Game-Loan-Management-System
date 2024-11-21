package com.example.demo.repository;

import com.example.demo.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query(value = "SELECT * FROM tb_reserva e WHERE DATE(e.fech_reserva) = DATE(:fechReserva)", nativeQuery = true)
    List<Reserva> listarReservaPorfecha(@Param("fechReserva") Date fechReserva);
}
