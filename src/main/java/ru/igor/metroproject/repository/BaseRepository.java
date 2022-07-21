package ru.igor.metroproject.repository;

import ru.igor.metroproject.model.AbstractBaseEntity;
import ru.igor.metroproject.model.Rout;

import java.util.List;
import java.util.Optional;

/**
 * Базовый интерфейс для работы с репозиторием
 * @param <ID> Тип ключа сущности
 * @param <T> тип Сущности
 */

public interface BaseRepository<ID, T extends AbstractBaseEntity> {

    List<T> getAll();

    Optional<T> get(ID id);

    T saveOrUpdate(T entity);

    void delete(ID id);


}
