package uz.pdp.ucell_task.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResult{
    private boolean success;
    private String message;
}
