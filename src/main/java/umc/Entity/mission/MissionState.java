package umc.Entity.mission;

import lombok.Getter;

@Getter
public enum MissionState {
    ING("진행중"),
    COMPLETE("완료"),
    EXPIRED("만료");

    private final String description;

    MissionState(String description) {
        this.description = description;
    }
}
