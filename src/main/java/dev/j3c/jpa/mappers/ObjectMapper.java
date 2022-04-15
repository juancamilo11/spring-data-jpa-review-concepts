package dev.j3c.jpa.mappers;

import dev.j3c.jpa.model.entities.Student;
import dev.j3c.jpa.web.dto.StudentDto;

import java.util.function.Function;

public interface ObjectMapper {
     default <T,R> R mapFromDtoToEntity(T dto, Function<T,R> executor) {
        return executor.apply(dto);
    }

     default <T,R> R mapFromEntityToDto(T entity, Function<T,R> executor) {
        return executor.apply(entity);
    }
}