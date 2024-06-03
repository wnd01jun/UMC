package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
    @Column(nullable = false, length = 1000)
    private String body;
    @Column(nullable = false)
    private Double score;

    private String title;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImageList = new ArrayList<>();

    public void setMember(Member member){
        if(this.member != null)
            member.getReviewList().remove(this);
        this.member = member;
        member.getReviewList().add(this);
    }

    public void setStore(Store store){
        if (this.score != null)
            store.getReviewList().remove(this);
        this.store = store;
        store.getReviewList().add(this);
    }
}
