package knowledge.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import knowledge.dto.request.KnowledgePackageSetRequestDto;
import knowledge.dto.response.KnowledgePackageSetResponseDto;
import knowledge.model.KnowledgePackage;
import knowledge.model.KnowledgePackageSet;
import knowledge.service.KnowledgePackageService;
import knowledge.service.KnowledgePackageSetService;
import knowledge.service.mapper.RequestDtoMapper;
import knowledge.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sets")
public class KnowledgePackageSetController {
    private final KnowledgePackageSetService knowledgePackageSetService;
    private final KnowledgePackageService knowledgePackageService;
    private final RequestDtoMapper<KnowledgePackageSetRequestDto,
            KnowledgePackageSet> requestDtoMapper;
    private final ResponseDtoMapper<KnowledgePackageSetResponseDto,
            KnowledgePackageSet> responseDtoMapper;

    public KnowledgePackageSetController(KnowledgePackageSetService knowledgePackageSetService,
                                         KnowledgePackageService knowledgePackageService,
                                         RequestDtoMapper<KnowledgePackageSetRequestDto,
                                                 KnowledgePackageSet> requestDtoMapper,
                                         ResponseDtoMapper<KnowledgePackageSetResponseDto,
                                                 KnowledgePackageSet> responseDtoMapper) {
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageService = knowledgePackageService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping
    public KnowledgePackageSetResponseDto add(@RequestBody @Valid
                                                  KnowledgePackageSetRequestDto requestDto) {
        KnowledgePackageSet knowledgePackageSet = knowledgePackageSetService
                .add(requestDtoMapper.mapToModel(requestDto));
        return responseDtoMapper.mapToDto(knowledgePackageSet);
    }

    @GetMapping("/{id}")
    public KnowledgePackageSetResponseDto get(@PathVariable Long id) {
        KnowledgePackageSet knowledgePackageSet = knowledgePackageSetService.get(id);
        return responseDtoMapper.mapToDto(knowledgePackageSet);
    }

    @GetMapping
    public List<KnowledgePackageSetResponseDto> getAll() {
        return knowledgePackageSetService.getAll()
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}/kpacs")
    public void addKnowledgePackToSet(@PathVariable Long id, @RequestParam Long packId) {
        KnowledgePackageSet knowledgePackageSet = knowledgePackageSetService.get(id);
        KnowledgePackage knowledgePackage = knowledgePackageService.get(packId);
        knowledgePackageSetService.addKnowledgePack(knowledgePackageSet, knowledgePackage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        knowledgePackageSetService.delete(id);
    }
}
