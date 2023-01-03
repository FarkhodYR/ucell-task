package uz.pdp.ucell_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.ucell_task.entity.Authors;
import uz.pdp.ucell_task.payload.ApiResult;
import uz.pdp.ucell_task.payload.AuthorsDTO;
import uz.pdp.ucell_task.service.AuthorsService;

import java.util.List;


@RestController
public class AuthorsControllerImpl implements AuthorsController{

    @Autowired
    private AuthorsService authorsService;

    @Override
    public ApiResult add(AuthorsDTO authorsDTO) {
        return authorsService.add(authorsDTO);
    }

    @Override
    public List<Authors> getAll() {
        return authorsService.getAll();
    }

    @Override
    public Authors get(Integer id) {
        return authorsService.get(id);
    }

    @Override
    public ApiResult edit(Integer id, AuthorsDTO authorsDTO) {
        return authorsService.edit(id, authorsDTO);
    }

    @Override
    public ApiResult delete(Integer id) {
        return authorsService.delete(id);
    }
}
