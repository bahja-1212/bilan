package justAssigment.CA226demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Staff {
    private Long id;
    private String name;
    private String role;

    public Long getId() {
        return 0L;
    }

    public Object getName() {
        return null;
    }

    public void setId(Long staffid) {
    }

    public Object getRole() {
        return null;
    }

    public void setRole(Object role) {
    }

    public void clone(Object name) {
    }
}