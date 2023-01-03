package uz.pdp.ucell_task.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.ucell_task.entity.Authors;
import uz.pdp.ucell_task.payload.ApiResult;
import uz.pdp.ucell_task.payload.AuthorsDTO;

import java.util.List;

@RequestMapping("/authors")
public interface AuthorsController {


    @PostMapping
    ApiResult add(@RequestBody AuthorsDTO authorsDTO);

    @GetMapping
    List<Authors> getAll();

    @GetMapping("/{id}")
    Authors get(@PathVariable Integer id);

    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Integer id,
                   @RequestBody AuthorsDTO authorsDTO);

    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Integer id);
}
