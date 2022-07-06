package knowledge.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "knowledge_pack_set")
public class KnowledgePackageSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany
    @JoinTable(name = "knowledge_pack_sets_knowledge_packs",
            joinColumns = @JoinColumn(name = "knowledge_pack_set_id"),
            inverseJoinColumns = @JoinColumn(name = "knowledge_pack_id"))
    private Set<KnowledgePackage> knowledgePackages;

    public KnowledgePackageSet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<KnowledgePackage> getKnowledgePackages() {
        return knowledgePackages;
    }

    public void setKnowledgePackages(Set<KnowledgePackage> knowledgePackages) {
        this.knowledgePackages = knowledgePackages;
    }

    @Override
    public String toString() {
        return "KnowledgePackageSet{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", knowledgePackage=" + knowledgePackages
                + '}';
    }
}
