package uz.pdp.ucell_task.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "authors")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;
}
