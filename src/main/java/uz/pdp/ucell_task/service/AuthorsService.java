package uz.pdp.ucell_task.service;

import uz.pdp.ucell_task.entity.Authors;
import uz.pdp.ucell_task.payload.ApiResult;
import uz.pdp.ucell_task.payload.AuthorsDTO;

import java.util.List;

public interface AuthorsService {
    public ApiResult add(AuthorsDTO authorsDTO);

    public List<Authors> getAll();

    public Authors get(Integer id);

    public ApiResult edit(Integer id, AuthorsDTO authorsDTO);

    public ApiResult delete(Integer id);
}
