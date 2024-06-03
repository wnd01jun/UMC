package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.Join;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory category;

    public void setMember(Member member){
        if(this.member != null)
            member.getMemberPrefersList().remove(this);
        this.member = member;
        member.getMemberPrefersList().add(this);
    }

    public void setFoodCategory(FoodCategory foodCategory){
        this.category = foodCategory;
    }
}
