package ftt.app.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "interests")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String description;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Interest() {
        this.description = "";
    }
    public Interest(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
