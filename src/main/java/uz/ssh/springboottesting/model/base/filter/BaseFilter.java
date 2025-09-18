package uz.ssh.springboottesting.model.base.filter;

/**
 * @author Shokhimardon
 * @since 9/18/25
 */
public class BaseFilter<ID> {
    private ID id;
    private String keyword;
    private Boolean active;
    private Integer page = 0;
    private Integer size = 10;
    private String sortName = "id";
    private String sortDir = "DESC";
}
