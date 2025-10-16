package uz.ssh.springboottesting.service.visitor.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Shokhimardon
 * @since 10/16/25
 */
@Getter
@Setter
public abstract class Entity {
    protected Integer id;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    protected LocalDateTime deletedAt;
    protected Integer version;

    abstract void accept(Visitor visitor);
}
