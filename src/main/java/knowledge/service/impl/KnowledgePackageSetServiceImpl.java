package knowledge.service.impl;

import java.util.List;
import knowledge.dao.KnowledgePackageSetDao;
import knowledge.model.KnowledgePackage;
import knowledge.model.KnowledgePackageSet;
import knowledge.service.KnowledgePackageSetService;
import org.springframework.stereotype.Service;

@Service
public class KnowledgePackageSetServiceImpl implements KnowledgePackageSetService {
    private final KnowledgePackageSetDao knowledgePackageSetDao;

    public KnowledgePackageSetServiceImpl(KnowledgePackageSetDao knowledgePackageSetDao) {
        this.knowledgePackageSetDao = knowledgePackageSetDao;
    }

    @Override
    public KnowledgePackageSet add(KnowledgePackageSet knowledgePackageSet) {
        return knowledgePackageSetDao.add(knowledgePackageSet);
    }

    @Override
    public void addKnowledgePack(KnowledgePackageSet knowledgePackageSet,
                                 KnowledgePackage knowledgePackage) {
        knowledgePackageSet.getKnowledgePackages().add(knowledgePackage);
        knowledgePackageSetDao.update(knowledgePackageSet);
    }

    @Override
    public KnowledgePackageSet get(Long id) {
        return knowledgePackageSetDao.get(id).orElseThrow(() -> new RuntimeException("Couldn't get "
                + "knowledge package set by id: " + id));
    }

    @Override
    public List<KnowledgePackageSet> getAll() {
        return knowledgePackageSetDao.getAll();
    }

    @Override
    public void delete(Long id) {
        knowledgePackageSetDao.delete(id);
    }
}
