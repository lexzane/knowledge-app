package knowledge.dao.impl;

import java.util.List;
import java.util.Optional;
import knowledge.dao.AbstractDao;
import knowledge.dao.KnowledgePackageSetDao;
import knowledge.exception.DataProcessingException;
import knowledge.model.KnowledgePackageSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgePackageSetDaoImpl extends AbstractDao<KnowledgePackageSet>
        implements KnowledgePackageSetDao {
    public KnowledgePackageSetDaoImpl(SessionFactory factory) {
        super(factory, KnowledgePackageSet.class);
    }

    @Override
    public Optional<KnowledgePackageSet> get(Long id) {
        try (Session session = factory.openSession()) {
            Query<KnowledgePackageSet> query = session.createQuery("FROM KnowledgePackageSet kps "
                            + "LEFT JOIN FETCH kps.knowledgePackages "
                            + "WHERE kps.id = :id", KnowledgePackageSet.class);
            query.setParameter("id", id);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get"
                    + " the knowledge package set, id: " + id, e);
        }
    }

    public List<KnowledgePackageSet> getAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM KnowledgePackageSet kps "
                    + "LEFT JOIN FETCH kps.knowledgePackages", KnowledgePackageSet.class)
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get all knowledge package sets from DB", e);
        }
    }

    public KnowledgePackageSet update(KnowledgePackageSet knowledgePackageSet) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(knowledgePackageSet);
            transaction.commit();
            return knowledgePackageSet;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Couldn't update a knowledge package set "
                    + knowledgePackageSet, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
