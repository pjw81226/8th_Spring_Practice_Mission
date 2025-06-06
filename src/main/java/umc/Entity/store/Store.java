package umc.Entity.store;

import jakarta.persistence.*;
import lombok.*;
import umc.Entity.BaseTimeEntity;
import umc.Entity.category.StoreCategory;
import umc.Entity.mission.Mission;
import umc.Entity.review.Review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "store")
@Builder
public class Store extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "store_name", nullable = false, length = 50)
    private String storeName;

    @Column(name = "store_info", nullable = false, columnDefinition = "TEXT")
    private String storeInfo;

    @Column(name = "state", nullable = false, length = 20)
    private String state;

    @Column(name = "address_line1", nullable = false, length = 100)
    private String addressLine1;

    @Column(name = "address_line2", nullable = false, length = 100)
    private String addressLine2;

    @Column(name = "location", nullable = false, length = 20)
    private String location;

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoreCategory> storeCategories = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoreImage> storeImages = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mission> missions = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
