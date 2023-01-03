package uz.pdp.ucell_task.service;

import uz.pdp.ucell_task.entity.Publications;
import uz.pdp.ucell_task.payload.ApiResult;
import uz.pdp.ucell_task.payload.PublicationsDTO;

import java.util.List;

public interface PublicationsService {
    public ApiResult add(PublicationsDTO publicationsDTO);

    public List<PublicationsDTO> getAll();

    public PublicationsDTO get(Integer id);

    public List <PublicationsDTO> getAllByCategory (String category);

    public ApiResult edit(Integer id, PublicationsDTO publicationsDTO);

    public ApiResult delete(Integer id);

}
