package ru.igor.metroproject.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.igor.metroproject.exception.NotFoundEntity;
import ru.igor.metroproject.model.Rout;
import ru.igor.metroproject.repository.RoutRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class RoutService {

    private RoutRepository repository;

    public List<Rout> getAll() {
        log.info("get all routs");
        return repository.getAll();
    }

    public Rout get(Integer id) {
        Optional<Rout> rout = repository.get(id);
        if (rout.isPresent()) {
            log.info("get rout {}", rout.get());
            return rout.get();
        } else {
            log.error("not found entity with id {}", id);
            throw new NotFoundEntity("not found entity with id" + id);
        }
    }

    public Rout create(Rout rout) {
        Assert.notNull(rout, "rout must not be null");
        log.info("save rout {}", rout);
        return repository.saveOrUpdate(rout);
    }

    public Rout update(Rout rout) {
        Assert.notNull(rout, "rout must not be null");
        log.info("update rout {}", rout);
        return repository.saveOrUpdate(rout);
    }

    public void delete(Integer id) {
        if (get(id) != null) {
            repository.delete(id);
        }
    }


}
