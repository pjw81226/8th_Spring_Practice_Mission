package umc.Entity.user;


import jakarta.persistence.*;
import lombok.*;
import umc.Entity.BaseTimeEntity;
import umc.Entity.category.UserCategory;
import umc.Entity.mission.UserMission;
import umc.Entity.review.Review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "user")
@Builder
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "name", nullable = false, unique = true, length = 30)
    private String name;

    @Column(name = "pw", nullable = false, length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private UserState state = UserState.ACTIVE;

    @Builder.Default
    @Column(name = "point")
    private Integer point = 0;

    @Builder.Default
    @Column(name = "phone_num", nullable = false, length = 20)
    private String phoneNum = " ";

    @Builder.Default
    @Column(name = "phone_auth", nullable = false)
    private Boolean phoneAuth = false;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserCategory> userCategories = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserMission> userMissions = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
