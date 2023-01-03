package uz.pdp.ucell_task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.ucell_task.entity.Authors;
import uz.pdp.ucell_task.entity.Publications;
import uz.pdp.ucell_task.payload.ApiResult;
import uz.pdp.ucell_task.payload.PublicationsDTO;
import uz.pdp.ucell_task.repository.AuthorsRepository;
import uz.pdp.ucell_task.repository.PublicationsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PublicationsServiceImpl implements PublicationsService{
    @Autowired
    private PublicationsRepository publicationsRepository;

    @Autowired
    private AuthorsRepository authorsRepository;

    @Override
    public ApiResult add(PublicationsDTO publicationsDTO) {

        Optional<Authors> optionalAuthors = authorsRepository.findById(publicationsDTO.getFkID());
        if (optionalAuthors.isEmpty()) {
            return new ApiResult(false, "No such Author has been found.");
        }
        Publications publications = new Publications();
        publications.setTitle(publicationsDTO.getTitle());
        publications.setStatus(publicationsDTO.getStatus());
        publications.setDescription(publicationsDTO.getDescription());
        publications.setCategory(publicationsDTO.getCategory());
        publications.setPublish_date(publicationsDTO.getPublish_date());
        publications.setAuthors(optionalAuthors.get());
        publicationsRepository.save(publications);
        return new ApiResult(true, "Added successfully");

    }

    @Override
    public List<PublicationsDTO> getAll() {
        List<Publications> allPublications = publicationsRepository.findAll();
        List<PublicationsDTO> publicationsDTOList = new ArrayList<>();

        for (Publications publications : allPublications) {
            if (publications.getStatus()){
            PublicationsDTO publicationsDTO = new PublicationsDTO();
            publicationsDTO.setId(publications.getId());
            publicationsDTO.setCategory(publications.getCategory());
            publicationsDTO.setStatus(publications.getStatus());
            publicationsDTO.setTitle(publications.getTitle());
            publicationsDTO.setDescription(publications.getDescription());
            publicationsDTO.setPublish_date(publications.getPublish_date());
            publicationsDTO.setFkID(publications.getAuthors().getId());
            publicationsDTOList.add(publicationsDTO);
            }
        }
        return publicationsDTOList;
    }

    @Override
    public PublicationsDTO get(Integer id) {
        Optional<Publications> optionalPublications = publicationsRepository.findById(id);
        if (optionalPublications.isEmpty()) {
            return  null;
        }
        Publications publications = optionalPublications.get();
        PublicationsDTO publicationsDTO = new PublicationsDTO();

        publicationsDTO.setId(publications.getId());
        publicationsDTO.setCategory(publications.getCategory());
        publicationsDTO.setStatus(publications.getStatus());
        publicationsDTO.setTitle(publications.getTitle());
        publicationsDTO.setDescription(publications.getDescription());
        publicationsDTO.setPublish_date(publications.getPublish_date());
        publicationsDTO.setFkID(publications.getAuthors().getId());

        return publicationsDTO;
    }

    @Override
    public List<PublicationsDTO> getAllByCategory(String category) {
          List<PublicationsDTO> publicationsDTOList = new ArrayList<>();

        for (Publications publication : publicationsRepository.findAll()) {
            if (publication.getStatus() && publication.getCategory().equals(category)){
        PublicationsDTO publicationsDTO = new PublicationsDTO();

        publicationsDTO.setId(publication.getId());
        publicationsDTO.setCategory(publication.getCategory());
        publicationsDTO.setStatus(publication.getStatus());
        publicationsDTO.setTitle(publication.getTitle());
        publicationsDTO.setDescription(publication.getDescription());
        publicationsDTO.setPublish_date(publication.getPublish_date());
        publicationsDTO.setFkID(publication.getAuthors().getId());

        publicationsDTOList.add(publicationsDTO);
            }
        }
        return publicationsDTOList;
    }

    @Override
    public ApiResult edit(Integer id, PublicationsDTO publicationsDTO) {
        Optional<Publications> optionalPublications = publicationsRepository.findById(id);
        if (optionalPublications.isEmpty()) {
            return new ApiResult(false, "No such Publication is found.");
        }
        Publications publications = optionalPublications.get();

        Optional<Authors> optionalAuthors = authorsRepository.findById(publicationsDTO.getFkID());
        if (optionalAuthors.isEmpty()) {
            return new ApiResult(false, "Author is not found");
        }
        publications.setTitle(publicationsDTO.getTitle());
        publications.setStatus(publicationsDTO.getStatus());
        publications.setDescription(publicationsDTO.getDescription());
        publications.setCategory(publicationsDTO.getCategory());
        publications.setPublish_date(publicationsDTO.getPublish_date());
        publications.setAuthors(optionalAuthors.get());
        publicationsRepository.save(publications);

        return new ApiResult(true, "Successfully added.");
    }

    @Override
    public ApiResult delete(Integer id) {

        Optional<Publications> optionalPublications = publicationsRepository.findById(id);
        if (optionalPublications.isEmpty()) {
            return new ApiResult(false, "Not such Publication is found.");
        }
        publicationsRepository.delete(optionalPublications.get());
        return new ApiResult(true, "Deleted successfully.");
    }
}
