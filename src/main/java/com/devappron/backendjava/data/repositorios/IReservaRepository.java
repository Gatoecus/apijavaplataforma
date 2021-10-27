package com.devappron.backendjava.data.repositorios;

import java.util.List;

import com.devappron.backendjava.data.entidades.ReservaEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservaRepository extends PagingAndSortingRepository<ReservaEntity, Long>{
    
    List<ReservaEntity> getByUsuarioEntityIdOrderByCreatedAtDesc(long usuarioEntityId);

    @Query(value = "SELECT * FROM reservas ORDER BY created_at DESC LIMIT 20",
            nativeQuery = true)
    List<ReservaEntity> getUltimosReservas();

    ReservaEntity findByReservaId(String id);




    
}
