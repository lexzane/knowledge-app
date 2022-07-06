package knowledge.dao;

import java.util.List;
import java.util.Optional;
import knowledge.model.KnowledgePackage;

public interface KnowledgePackageDao {
    KnowledgePackage add(KnowledgePackage knowledgePackage);

    Optional<KnowledgePackage> get(Long id);

    List<KnowledgePackage> getAll();

    void delete(Long id);
}
