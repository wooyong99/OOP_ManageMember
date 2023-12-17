package org.example;

public class MemberShip {
    private MemberShipType memberShipType;

    public MemberShip(long totalPoint) {
        memberShipType = checkMemberShip(totalPoint);
    }

    public String getMemberShip() {
        return memberShipType.name();
    }

    private MemberShipType checkMemberShip(long totalPoint) {
        if (totalPoint < 101) {
            return MemberShipType.FAMILY;
        } else if (totalPoint < 300) {
            return MemberShipType.GOLD;
        } else if (totalPoint < 500) {
            return MemberShipType.VIP;
        }
        return MemberShipType.VVIP;
    }

    public void refresh(long totalPoint) {
        memberShipType = checkMemberShip(totalPoint);
    }
}
