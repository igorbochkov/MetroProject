package ru.igor.metroproject.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Класс Entity который предоставляет сущность маршрут
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "route")
public class Rout extends AbstractBaseEntity {

    @Column(name = "code", nullable = false, unique = true)
    @NotNull
    private Integer code;

    @Column(name = "name", nullable = false)
    @NotNull
    @NotBlank
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rout route = (Rout) o;
        return getId() != null && Objects.equals(getId(), route.getId());
    }

    @Override
    public int hashCode() {
        return getId() == null ? 0 : getId();
    }
}
