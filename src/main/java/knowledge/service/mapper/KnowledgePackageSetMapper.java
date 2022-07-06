package knowledge.service.mapper;

import java.util.Collections;
import java.util.stream.Collectors;
import knowledge.dto.request.KnowledgePackageSetRequestDto;
import knowledge.dto.response.KnowledgePackageSetResponseDto;
import knowledge.model.KnowledgePackage;
import knowledge.model.KnowledgePackageSet;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageSetMapper implements
        RequestDtoMapper<KnowledgePackageSetRequestDto, KnowledgePackageSet>,
        ResponseDtoMapper<KnowledgePackageSetResponseDto, KnowledgePackageSet> {

    @Override
    public KnowledgePackageSet mapToModel(KnowledgePackageSetRequestDto dto) {
        KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();
        knowledgePackageSet.setTitle(dto.getTitle());
        knowledgePackageSet.setKnowledgePackages(Collections.emptySet());
        return knowledgePackageSet;
    }

    @Override
    public KnowledgePackageSetResponseDto mapToDto(KnowledgePackageSet model) {
        KnowledgePackageSetResponseDto responseDto = new KnowledgePackageSetResponseDto();
        responseDto.setId(model.getId());
        responseDto.setTitle(model.getTitle());
        responseDto.setKnowledgePackageIds(model.getKnowledgePackages()
                .stream()
                .map(KnowledgePackage::getId)
                .collect(Collectors.toSet()));
        return responseDto;
    }
}
