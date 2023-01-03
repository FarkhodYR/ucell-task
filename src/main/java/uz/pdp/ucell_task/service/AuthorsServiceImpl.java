package uz.pdp.ucell_task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.ucell_task.entity.Authors;
import uz.pdp.ucell_task.payload.ApiResult;
import uz.pdp.ucell_task.payload.AuthorsDTO;
import uz.pdp.ucell_task.repository.AuthorsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsServiceImpl implements AuthorsService{
    @Autowired
    private AuthorsRepository authorsRepository;

    @Override
    public ApiResult add(AuthorsDTO authorsDTO) {
        Authors authors = new Authors();
        authors.setUsername(authorsDTO.getUsername());
        authors.setFirst_name(authorsDTO.getFirst_name());
        authors.setLast_name(authorsDTO.getLast_name());
        authorsRepository.save(authors);
        return new ApiResult(true, "Successfully added.");
    }

    @Override
    public List<Authors> getAll() {
        return authorsRepository.findAll();
    }

    @Override
    public Authors get(Integer id) {
        Optional<Authors> optionalAuthors = authorsRepository.findById(id);
        if (optionalAuthors.isEmpty()) {
            return null;
        }
        return optionalAuthors.get();
    }

    @Override
    public ApiResult edit(Integer id, AuthorsDTO authorsDTO) {
        Optional<Authors> optionalAuthors = authorsRepository.findById(id);
        if (optionalAuthors.isEmpty()) {
            return new ApiResult(false, "No such author has been found.");
        }
        Authors authors = optionalAuthors.get();
        authors.setUsername(authorsDTO.getUsername());
        authors.setFirst_name(authorsDTO.getFirst_name());
        authors.setLast_name(authorsDTO.getLast_name());
        authorsRepository.save(authors);
        return new ApiResult(true, "Edited successfully.");
    }

    @Override
    public ApiResult delete(Integer id) {
        Optional<Authors> optionalAuthors = authorsRepository.findById(id);
        if (optionalAuthors.isEmpty()) {
            return new ApiResult(false, "No such author has been found.");
        }
        authorsRepository.delete(optionalAuthors.get());
        return new ApiResult(true, "Author has been deleted.");
    }
}
