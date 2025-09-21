package uz.ssh.springboottesting.service.base;

/**
 * @author Shokhimardon
 * @since 9/18/25
 */

import org.springframework.stereotype.Component;
import uz.ssh.springboottesting.model.base.filter.BaseFilter;
import uz.ssh.springboottesting.service.validation.strategy.base.ValidationStrategy;

import java.awt.print.Pageable;
import java.util.List;

/**
 *
 * @param <I> Input
 * @param <R> Response
 * @param <E> Entity
 * @param <F> Filter
 */
@Component
public abstract class BaseTemplateService<I, R, E, ID, F extends BaseFilter<ID>> {
    private final ValidationStrategy<I> validationStrategy;

    protected BaseTemplateService(ValidationStrategy<I> validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public final R create(I input) {
        preCreate(input);                  // 🔹 hook
        validate(input);
        E entity = mapToEntity(input);
        entity = save(entity);
        R response = mapToResponse(entity);
        postCreate(entity, response);      // 🔹 hook
        return response;
    }

    public final void delete(ID id) {
        preDelete(id);                     // 🔹 hook
        deleteEntity(id);
        postDelete(id);                    // 🔹 hook
    }

    public final R getById(ID id) {
        E entity = findById(id);
        return mapToResponse(entity);
    }

    public final List<R> getAll(F f) {

        return getAll(f, null);
    }

    public final List<R> getAll(F f, Pageable pageable) {
        preGetAll(f, pageable);
        var res = filter(f, pageable);
        postGetAll(f, pageable);
        return res;
    }

    // --- Default hooks (can be ignored) ---

    protected void validate(I input) {
        validationStrategy.validate(input);
    }

    protected void preCreate(I input) {
    }

    protected void postCreate(E entity, R response) {
    }

    protected void preDelete(ID id) {
    }

    protected void postDelete(ID id) {
    }

    protected void preGetAll(F f, Pageable pageable) {
    }

    protected void postGetAll(F f, Pageable pageable) {
    }


    // --- Must implement ---

    protected abstract E mapToEntity(I input);

    protected abstract E save(E entity);

    protected abstract R mapToResponse(E entity);

    protected abstract void deleteEntity(ID id);

    protected abstract E findById(ID id);

    protected abstract List<R> filter(F f, Pageable pageable);
}
