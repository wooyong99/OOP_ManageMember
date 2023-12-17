package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private static List<Member> memberList = new ArrayList<>();
    private long m_id;
    private String name;
    private LocalDate regDate;
    private Point point;
    private MemberShip memberShip;


    public Member(long m_id, String name, long buyCnt) {
        this.m_id = m_id;
        this.name = name;
        this.regDate = LocalDate.now();
        this.point = new Point(buyCnt);
        this.memberShip = new MemberShip(point.getPoint());
        memberList.add(this);
    }

    public static Member getBestMember() {
        for (Member m : memberList) {
            if (m.point.getPoint() == Point.maxPoint) {
                m.point.addPointByBestMember();
                m.memberShip.refresh(m.point.getPoint());
                return m;
            }
        }
        return null;
    }

    public void buy() {
        point.increaseBuyCnt();
        memberShip.refresh(point.getPoint());
    }

    public void refund() {
        point.decreaseBuyCnt();
        memberShip.refresh(point.getPoint());
    }

    @Override
    public String toString() {
        return "==="
                       + "\n회원 아이디 : " + m_id
                       + "\n회원 이름 : " + name
                       + "\n가입일 : " + regDate
                       + "\n구매 횟수 : " + point.getBuyCnt()
                       + "\n누적 포인트 점수 : " + point.getPoint()
                       + "\n회원 등급 : " + memberShip.getMemberShip();
    }
}
