package knowledge.dao.impl;

import java.util.List;
import java.util.Optional;
import knowledge.dao.AbstractDao;
import knowledge.dao.KnowledgePackageDao;
import knowledge.exception.DataProcessingException;
import knowledge.model.KnowledgePackage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgePackageDaoImpl extends AbstractDao<KnowledgePackage>
        implements KnowledgePackageDao {
    public KnowledgePackageDaoImpl(SessionFactory factory) {
        super(factory, KnowledgePackage.class);
    }

    public Optional<KnowledgePackage> get(Long id) {
        try (Session session = factory.openSession()) {
            return Optional.ofNullable(session.get(KnowledgePackage.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get knowledge package, id: " + id, e);
        }
    }

    public List<KnowledgePackage> getAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM KnowledgePackage",
                    KnowledgePackage.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get all knowledge packages from DB", e);
        }
    }
}
