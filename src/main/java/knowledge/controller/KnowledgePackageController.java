package knowledge.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import knowledge.dto.request.KnowledgePackageRequestDto;
import knowledge.dto.response.KnowledgePackageResponseDto;
import knowledge.model.KnowledgePackage;
import knowledge.service.KnowledgePackageService;
import knowledge.service.mapper.RequestDtoMapper;
import knowledge.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kpacs")
public class KnowledgePackageController {
    private final KnowledgePackageService knowledgePackageService;
    private final RequestDtoMapper<KnowledgePackageRequestDto,
            KnowledgePackage> requestDtoMapper;
    private final ResponseDtoMapper<KnowledgePackageResponseDto,
            KnowledgePackage> responseDtoMapper;

    public KnowledgePackageController(KnowledgePackageService knowledgePackageService,
                                      RequestDtoMapper<KnowledgePackageRequestDto,
                                              KnowledgePackage> requestDtoMapper,
                                      ResponseDtoMapper<KnowledgePackageResponseDto,
                                              KnowledgePackage> responseDtoMapper) {
        this.knowledgePackageService = knowledgePackageService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping
    public KnowledgePackageResponseDto add(@RequestBody @Valid
                                               KnowledgePackageRequestDto requestDto) {
        KnowledgePackage knowledgePackage = knowledgePackageService
                .add(requestDtoMapper.mapToModel(requestDto));
        return responseDtoMapper.mapToDto(knowledgePackage);
    }

    @GetMapping("/{id}")
    public KnowledgePackageResponseDto get(@PathVariable Long id) {
        KnowledgePackage knowledgePackage = knowledgePackageService.get(id);
        return responseDtoMapper.mapToDto(knowledgePackage);
    }

    @GetMapping
    public List<KnowledgePackageResponseDto> getAll() {
        return knowledgePackageService.getAll()
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        knowledgePackageService.delete(id);
    }
}
