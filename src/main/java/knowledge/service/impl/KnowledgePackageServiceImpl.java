package knowledge.service.impl;

import java.time.LocalDate;
import java.util.List;
import knowledge.dao.KnowledgePackageDao;
import knowledge.dao.KnowledgePackageSetDao;
import knowledge.model.KnowledgePackage;
import knowledge.model.KnowledgePackageSet;
import knowledge.service.KnowledgePackageService;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageServiceImpl implements KnowledgePackageService {
    private final KnowledgePackageDao knowledgePackageDao;
    private final KnowledgePackageSetDao knowledgePackageSetDao;

    public KnowledgePackageServiceImpl(KnowledgePackageDao knowledgePackageDao,
                                       KnowledgePackageSetDao knowledgePackageSetDao) {
        this.knowledgePackageDao = knowledgePackageDao;
        this.knowledgePackageSetDao = knowledgePackageSetDao;
    }

    @Override
    public KnowledgePackage add(KnowledgePackage knowledgePackage) {
        KnowledgePackage knowledgePack = new KnowledgePackage();
        knowledgePack.setTitle(knowledgePackage.getTitle());
        knowledgePack.setDescription(knowledgePackage.getDescription());
        knowledgePack.setCreationDate(LocalDate.now());
        return knowledgePackageDao.add(knowledgePack);
    }

    @Override
    public KnowledgePackage get(Long id) {
        return knowledgePackageDao.get(id).orElseThrow(() -> new RuntimeException("Couldn't get "
                + "knowledge package set by id: " + id));
    }

    @Override
    public List<KnowledgePackage> getAll() {
        return knowledgePackageDao.getAll();
    }

    @Override
    public void delete(Long id) {
        KnowledgePackage knowledgePackageFromDb = knowledgePackageDao.get(id).get();
        List<KnowledgePackageSet> allSets = knowledgePackageSetDao.getAll();
        for (KnowledgePackageSet set : allSets) {
            set.getKnowledgePackages().remove(knowledgePackageFromDb);
        }
        knowledgePackageDao.delete(id);
    }
}
