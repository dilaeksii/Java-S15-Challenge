package entity.concrete;

import entity.enums.MemberShipType;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Member {
    private Long memberId;
    private final LocalDateTime memberShipDate = LocalDateTime.now();
    private MemberShipType memberShipType;

    public Member(Long memberId, MemberShipType memberShipType) {
        this.setMemberId(memberId);
        this.setMemberShipType(memberShipType);
    }

    public Long getMemberId() { return memberId; }

    public String getMemberShipDate() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = memberShipDate.format(format);
        return  formattedDate;
    }

    public MemberShipType getMemberShipType() { return memberShipType; }

    private void setMemberId(Long memberId) { this.memberId = memberId; }

    public void setMemberShipType(MemberShipType memberShipType) { this.memberShipType = memberShipType;}

    @Override
    public String toString() {
        return "Member with id: " + memberId + " has been created";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != getClass())
            return false;
        Member member = (Member) obj;
        return member.memberId.equals(memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }
}
