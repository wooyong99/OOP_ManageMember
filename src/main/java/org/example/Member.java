package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private static List<Member> memberList = new ArrayList<>();
    private static long maxPoint;
    private long m_id;
    private String name;
    private LocalDate regDate;
    private long buyCnt;
    private long totalPoint;
    private MemberShip memberShip;


    public Member(long m_id, String name, long buyCnt) {
        this.m_id = m_id;
        this.name = name;
        this.regDate = LocalDate.now();
        this.buyCnt = buyCnt;
        initTotalPoint();   // 누적 포인트 합계
        resetMaxPoint();    // 최고 포인트 초기화
        memberShip = new MemberShip(buyCnt);
        memberList.add(this);
    }

    private void resetMaxPoint() {
        if (maxPoint < totalPoint) {
            maxPoint = totalPoint;
        }
    }

    public static Member getBestMember() {
        for (Member m : memberList) {
            if (m.totalPoint == maxPoint) {
                return m;
            }
        }
        return null;
    }

    public void increaseBuyCnt() {
        buyCnt++;
        initTotalPoint();
    }

    public void decreaseBuyCnt() {
        buyCnt--;
        initTotalPoint();
    }

    private void initTotalPoint() {
        if (buyCnt < 3) {
            this.totalPoint = buyCnt * 20;
            return;
        } else if (buyCnt < 6) {
            this.totalPoint = buyCnt * 30;
            return;
        } else if (buyCnt < 10) {
            this.totalPoint = buyCnt * 50;
            return;
        }
        this.totalPoint = buyCnt * 100;
    }

    @Override
    public String toString() {
        return "==="
                       + "\n회원 아이디 : " + m_id
                       + "\n회원 이름 : " + name
                       + "\n가입일 : " + regDate
                       + "\n구매 횟수 : " + buyCnt
                       + "\n누적 포인트 점수 : " + totalPoint
                       + "\n회원 등급 : " + memberShip.getMemberShip();
    }
}
