package knowledge.service.mapper;

import knowledge.dto.request.KnowledgePackageRequestDto;
import knowledge.dto.response.KnowledgePackageResponseDto;
import knowledge.model.KnowledgePackage;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageMapper implements
        RequestDtoMapper<KnowledgePackageRequestDto, KnowledgePackage>,
        ResponseDtoMapper<KnowledgePackageResponseDto, KnowledgePackage> {
    @Override
    public KnowledgePackage mapToModel(KnowledgePackageRequestDto dto) {
        KnowledgePackage knowledgePackage = new KnowledgePackage();
        knowledgePackage.setTitle(dto.getTitle());
        knowledgePackage.setDescription(dto.getDescription());
        knowledgePackage.setCreationDate(dto.getCreationDate());
        return knowledgePackage;
    }

    @Override
    public KnowledgePackageResponseDto mapToDto(KnowledgePackage model) {
        KnowledgePackageResponseDto responseDto = new KnowledgePackageResponseDto();
        responseDto.setId(model.getId());
        responseDto.setTitle(model.getTitle());
        responseDto.setDescription(model.getDescription());
        responseDto.setCreationDate(model.getCreationDate());
        return responseDto;
    }
}
