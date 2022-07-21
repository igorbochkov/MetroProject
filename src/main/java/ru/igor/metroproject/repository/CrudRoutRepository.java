package ru.igor.metroproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.igor.metroproject.model.Rout;

@Transactional(readOnly = true)
public interface CrudRoutRepository extends JpaRepository<Rout, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Rout r WHERE r.id=:id")
    void delete(@Param("id") Integer id);

}
