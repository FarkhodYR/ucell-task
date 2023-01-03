package uz.pdp.ucell_task.controller;

import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.ucell_task.payload.ApiResult;
import uz.pdp.ucell_task.payload.PublicationsDTO;
import uz.pdp.ucell_task.service.PublicationsService;

import java.util.List;

@RestController
public class PublicationsControllerImpl implements PublicationsController{

    @Autowired
    private PublicationsService publicationsService;

    @Override
    public ApiResult add(PublicationsDTO publicationsDTO) {
        return publicationsService.add(publicationsDTO);
    }

    @Override
    public List<PublicationsDTO> getAll() {
        return publicationsService.getAll();
    }

    @Override
    public PublicationsDTO get(Integer id) {
        return publicationsService.get(id);
    }

    @Override
    public List<PublicationsDTO> getAllByCategory(String category) {return publicationsService.getAllByCategory(category); }

    @Override
    public ApiResult edit(Integer id, PublicationsDTO publicationsDTO) {
        return publicationsService.edit(id, publicationsDTO);
    }

    @Override
    public ApiResult delete(Integer id) {
        return publicationsService.delete(id);
    }
}


