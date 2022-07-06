package knowledge.service;

import java.util.List;
import knowledge.model.KnowledgePackage;

public interface KnowledgePackageService {
    KnowledgePackage add(KnowledgePackage knowledgePackage);

    KnowledgePackage get(Long id);

    List<KnowledgePackage> getAll();

    void delete(Long id);
}
