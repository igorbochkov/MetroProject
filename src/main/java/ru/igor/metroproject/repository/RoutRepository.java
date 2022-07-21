package ru.igor.metroproject.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.igor.metroproject.model.Rout;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Основной класс репозиторий для работы с Rout
 */
@Slf4j
@AllArgsConstructor
@Repository
public class RoutRepository implements BaseRepository<Integer, Rout> {

    private CrudRoutRepository crudRoutRepository;

    /**
     * возвращает все маршруты.
     * Если маршрутов нет, возвращает пустой List
     */
    @Override
    public List<Rout> getAll() {
        List<Rout> routList = crudRoutRepository.findAll();
        return routList.isEmpty() ? new ArrayList<>() : routList;
    }

    /**
     * Возвращает Rout
     * @param id Integer
     * @return Optional<Rout>
     */
    @Override
    public Optional<Rout> get(Integer id) {
        return crudRoutRepository.findById(id);
    }

    /**
     * если rout.getId() == null cохранят Rout иначи обнавляет
     * @param entity сохраняемый Rout
     * @return сохраненный Rout
     */
    @Override
    public Rout saveOrUpdate(Rout entity) {
        return crudRoutRepository.save(entity);
    }

    /**
     * Удаляет Rout по id
     */
    @Override
    public void delete(Integer id) {
        crudRoutRepository.delete(id);
    }

}
