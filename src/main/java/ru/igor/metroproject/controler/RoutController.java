package ru.igor.metroproject.controler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.igor.metroproject.model.Rout;
import ru.igor.metroproject.service.RoutService;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class RoutController {

    private RoutService routService;

    @GetMapping("/trams")
    public List<Rout> getAll() {
        log.info("get all routs");
        return routService.getAll();
    }

    @GetMapping("/trams/{id}")
    public Rout getOne(@PathVariable Integer id) {
        log.info("get rout with id {}",id);
        return routService.get(id);
    }

    @PostMapping("/trams")
    public Integer save(@RequestBody Rout rout) {
        log.info("save rout with code {}", rout.getCode() );
        return routService.save(rout).getId();
    }

    @DeleteMapping("/trams/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        log.info("delete rout with id {}",id);
        routService.delete(id);
    }

    @PutMapping("/trams/{id}")
    public Rout update(@RequestBody Rout updateRout, @PathVariable Integer id) {
        log.info("update rout with id {}",id);
        Rout oldRout = routService.get(id);
        oldRout.setName(updateRout.getName());
        oldRout.setCode(updateRout.getCode());
        return routService.update(oldRout);
    }
}
