package uz.pdp.ucell_task.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "publications")
public class Publications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false,columnDefinition = "text")
    private String description;

    //@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column (nullable = false)
    private String publish_date;

    @ManyToOne(optional = false)
    private Authors authors;
}