package org.example;

public class MemberShip {
    private MemberShipType memberShipType;

    public MemberShip(long totalPoint) {
        if (totalPoint < 101) {
            memberShipType = MemberShipType.FAMILY;
            return;
        } else if (totalPoint < 300) {
            memberShipType = MemberShipType.GOLD;
            return;
        } else if (totalPoint < 500) {
            memberShipType = MemberShipType.VIP;
            return;
        }
        memberShipType = MemberShipType.VVIP;
    }

    public String getMemberShip() {
        return memberShipType.name();
    }
}
