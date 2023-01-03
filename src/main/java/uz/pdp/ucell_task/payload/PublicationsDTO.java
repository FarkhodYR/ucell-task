package uz.pdp.ucell_task.payload;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PublicationsDTO {

    private Integer id;

    private String title;

    private String category;

    private Boolean status;

    private String description;

    private String publish_date;

    private Integer fkID;


}
