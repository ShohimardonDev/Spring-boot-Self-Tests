package uz.ssh.springboottesting.mapper.car;


import java.util.List;
import java.util.Set;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import uz.ssh.springboottesting.model.car.dto.CarDTO;
import uz.ssh.springboottesting.model.car.entity.Car;

@Mapper(componentModel = "spring")
 public interface CarMapper {


    /**
    * Convert entity to DTO
    * @param entity the entity to convert
    * @return the DTO
    */
    CarDTO toDto(Car entity);

    /**
    * Convert list of entities to list of DTOs
    * @param entityList the list of entities
    * @return the list of DTOs
    */
    List<CarDTO> toDto(List<Car> entityList);

    /**
    * Convert set of entities to set of DTOs
    * @param entitySet the set of entities
    * @return the set of DTOs
    */
    Set<CarDTO> toDto(Set<Car> entitySet);

    /**
    * Convert DTO to entity
    * @param entityDTO the DTO to convert
    * @return the entity
    */
    Car toEntity(CarDTO entityDTO);

    /**
    * Convert list of DTOs to list of entities
    * @param dtoList the list of DTOs
    * @return the list of entities
    */
    List<Car> toEntity(List<CarDTO> dtoList);

    /**
    * Convert set of DTOs to set of entities
    * @param dtoSet the set of DTOs
    * @return the set of entities
    */
    Set<Car> toEntity(Set<CarDTO> dtoSet);

    /**
    * Convert page of entities to page of DTOs
    * @param page the page of entities
    * @return the page of DTOs
    */
    default Page<CarDTO> toDto(Page<Car> page)
{
        return page.map(this::toDto);
    }

    /**
    * Partial update method
    * @param entity the entity to update
    * @param dto the DTO with new values
    */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Car entity, CarDTO dto);

}
