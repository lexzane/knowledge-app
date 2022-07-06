package knowledge.dao;

import java.util.List;
import java.util.Optional;
import knowledge.model.KnowledgePackageSet;

public interface KnowledgePackageSetDao {
    KnowledgePackageSet add(KnowledgePackageSet knowledgePackageSet);

    Optional<KnowledgePackageSet> get(Long id);

    List<KnowledgePackageSet> getAll();

    KnowledgePackageSet update(KnowledgePackageSet knowledgePackageSet);

    void delete(Long id);
}
