package knowledge.dto.request;

import java.time.LocalDate;
import javax.validation.constraints.Size;

public class KnowledgePackageRequestDto {
    @Size(max = 250)
    private String title;
    @Size(max = 2000)
    private String description;
    private LocalDate creationDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
