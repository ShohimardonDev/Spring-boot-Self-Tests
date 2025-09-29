package uz.ssh.springboottesting.controller.car;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ssh.springboottesting.model.car.dto.CarDTO;
import uz.ssh.springboottesting.service.car.CarService;

@RequestMapping("/api/@rest")
@RestController
 public class CarController 
{

    private final Logger log = LoggerFactory.getLogger(CarController.class);

    private static final String ENTITY_NAME = "car";

    private final CarService carService;

    @Autowired
    public CarController(CarService carService)
{
        this.carService = carService;
    }

    /**
    * {@code POST  /api/car} : Create a new car.
    *
    * @param carDTO the carDTO to create.
    * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new carDTO, or with status {@code 400 (Bad Request)} if the car has already an ID.
    * @throws URISyntaxException if the Location URI syntax is incorrect.
    */
    @PostMapping
    @Operation(
        summary = "Create a new car", description = "Create a new car"
    )
    @ApiResponses(
        value = {
        @ApiResponse(responseCode = "201", description = "Car created successfully"
    ),
        @ApiResponse(
        responseCode = "400", description = "Invalid input"
    )
    })
    public ResponseEntity<CarDTO> createCar(@Valid @RequestBody CarDTO carDTO) throws URISyntaxException {
        log.debug("REST request to save Car : {}", carDTO);
        if (carDTO.getId() != null)
{
            return ResponseEntity.badRequest().build();
        }
        CarDTO result = carService.save(carDTO);
        return ResponseEntity
            .created(new URI("/api/car/" + result.getId()))
            .body(result);
    }

    /**
    * {@code PUT  /api/car/:id} : Updates an existing car.
    *
    * @param id the id of the carDTO to save.
    * @param carDTO the carDTO to update.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated carDTO,
    * or with status {@code 400 (Bad Request)} if the carDTO is not valid,
    * or with status {@code 500 (Internal Server Error)} if the carDTO couldn't be updated.
    */
    @PutMapping("/{id}")
    @Operation(
        summary = "Update a car", description = "Update an existing car"
    )
    @ApiResponses(
        value = {
        @ApiResponse(responseCode = "200", description = "Car updated successfully"
    ),
        @ApiResponse(
        responseCode = "400", description = "Invalid input"
    ),
        @ApiResponse(
        responseCode = "404", description = "Car not found"
    )
    })
    public ResponseEntity<CarDTO> updateCar(
        @Parameter(
        description = "ID of the car to update"
    ) @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody CarDTO carDTO
    )
{
        log.debug("REST request to update Car : {}, {}", id, carDTO);
        if (carDTO.getId() == null)
{
            return ResponseEntity.badRequest().build();
        }
        if (!Objects.equals(id, carDTO.getId()))
{
            return ResponseEntity.badRequest().build();
        }

        if (!carService.existsById(id))
{
            return ResponseEntity.notFound().build();
        }

        CarDTO result = carService.update(carDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
    * {@code PATCH  /api/car/:id} : Partial updates given fields of an existing car, field will ignore if it is null
    *
    * @param id the id of the carDTO to save.
    * @param carDTO the carDTO to update.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated carDTO,
    * or with status {@code 400 (Bad Request)} if the carDTO is not valid,
    * or with status {@code 404 (Not Found)} if the carDTO is not found,
    * or with status {@code 500 (Internal Server Error)} if the carDTO couldn't be updated.
    */
    @PatchMapping(
        value = "/{id}", consumes = { "application/json", "application/merge-patch+json" }
    )
    @Operation(
        summary = "Partially update a car", description = "Partially update an existing car"
    )
    public ResponseEntity<CarDTO> partialUpdateCar(
        @Parameter(
        description = "ID of the car to update"
    ) @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CarDTO carDTO
    )
{
        log.debug("REST request to partial update Car partially : {}, {}", id, carDTO);
        if (carDTO.getId() == null)
{
            return ResponseEntity.badRequest().build();
        }
        if (!Objects.equals(id, carDTO.getId()))
{
            return ResponseEntity.badRequest().build();
        }

        if (!carService.existsById(id))
{
            return ResponseEntity.notFound().build();
        }

        Optional<CarDTO> result = carService.partialUpdate(carDTO);

        return result
            .map(response -> ResponseEntity.ok().body(response))
            .orElse(ResponseEntity.notFound().build());
    }

    /**
    * {@code GET  /api/car} : get all the cars.
    *
    * @param pageable the pagination information.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cars in body.
    */
    @GetMapping
    @Operation(
        summary = "Get all cars", description = "Get all cars with pagination"
    )
    @ApiResponse(
        responseCode = "200", description = "Successful operation"
    )
    public ResponseEntity<List<CarDTO>> getAllCars(@Parameter(hidden = true) Pageable pageable)
{
        log.debug("REST request to get a page of Cars");
        Page<CarDTO> page = carService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    /**
    * {@code GET  /api/car/:id} : get the "id" car.
    *
    * @param id the id of the carDTO to retrieve.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the carDTO, or with status {@code 404 (Not Found)}.
    */
    @GetMapping("/{id}")
    @Operation(
        summary = "Get a car by ID", description = "Get a specific car by its ID"
    )
    @ApiResponses(
        value = {
        @ApiResponse(responseCode = "200", description = "Car found"
    ),
        @ApiResponse(
        responseCode = "404", description = "Car not found"
    )
    })
    public ResponseEntity<CarDTO> getCar(@Parameter(
        description = "ID of the car to retrieve"
    ) @PathVariable Long id)
{
        log.debug("REST request to get Car : {}", id);
        Optional<CarDTO> carDTO = carService.findOne(id);
        return carDTO
            .map(response -> ResponseEntity.ok().body(response))
            .orElse(ResponseEntity.notFound().build());
    }

    /**
    * {@code DELETE  /api/car/:id} : delete the "id" car.
    *
    * @param id the id of the carDTO to delete.
    * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
    */
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Delete a car", description = "Delete a car by its ID"
    )
    @ApiResponses(
        value = {
        @ApiResponse(responseCode = "204", description = "Car deleted successfully"
    ),
        @ApiResponse(
        responseCode = "404", description = "Car not found"
    )
    })
    public ResponseEntity<Void> deleteCar(@Parameter(
        description = "ID of the car to delete"
    ) @PathVariable Long id)
{
        log.debug("REST request to delete Car : {}", id);
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
