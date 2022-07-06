package knowledge.service;

import java.util.List;
import knowledge.model.KnowledgePackage;
import knowledge.model.KnowledgePackageSet;

public interface KnowledgePackageSetService {
    KnowledgePackageSet add(KnowledgePackageSet knowledgePackageSet);

    void addKnowledgePack(KnowledgePackageSet knowledgePackageSet,
                          KnowledgePackage knowledgePackage);

    KnowledgePackageSet get(Long id);

    List<KnowledgePackageSet> getAll();

    void delete(Long id);
}
