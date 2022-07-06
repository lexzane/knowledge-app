package knowledge.dto.request;

import java.util.Set;
import javax.validation.constraints.Size;

public class KnowledgePackageSetRequestDto {
    @Size(max = 250)
    private String title;
    private Set<Long> knowledgePackageIds;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Long> getKnowledgePackageIds() {
        return knowledgePackageIds;
    }

    public void setKnowledgePackageIds(Set<Long> knowledgePackageIds) {
        this.knowledgePackageIds = knowledgePackageIds;
    }
}
