package uz.pdp.ucell_task.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.ucell_task.payload.ApiResult;
import uz.pdp.ucell_task.payload.PublicationsDTO;

import java.util.List;

@RequestMapping("/publications")
public interface PublicationsController {


    @PostMapping
    ApiResult add(@RequestBody PublicationsDTO publicationsDTO);

    @GetMapping
    List<PublicationsDTO> getAll();

    @GetMapping("/{id}")
    PublicationsDTO get(@PathVariable Integer id);

    @GetMapping(value = "category/{category}")
    List<PublicationsDTO> getAllByCategory(@PathVariable String category);

    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Integer id,
                   @RequestBody PublicationsDTO publicationsDTO);

    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Integer id);

}
