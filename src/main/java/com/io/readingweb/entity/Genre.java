package com.io.readingweb.entity;
import jakarta.persistence.*;
import lombok.*;

import java.text.Normalizer;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private long genreId;

    @Column(name = "name")
    private String name;

    @Column(name = "slug") // name tieng viet khong dau
    private String slug;

    @PrePersist
    @PreUpdate
    public void generateSlug() {
        if (this.name != null) {
            String normalized = Normalizer.normalize(this.name, Normalizer.Form.NFD);
            String withoutDiacritics = normalized.replaceAll("\\p{M}", "");
            this.slug = withoutDiacritics
                    .toLowerCase()
                    .replaceAll("[^a-z0-9\\s]", "")
                    .replaceAll("\\s+", "-");
        }
    }
}
