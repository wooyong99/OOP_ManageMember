package org.example;

import java.time.LocalDate;

public class Member {
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
        initTotalPoint();
        memberShip = new MemberShip(buyCnt);
    }

    public void display() {
        System.out.println("==="
                                   + "\n회원 아이디 : " + m_id
                                   + "\n회원 이름 : " + name
                                   + "\n가입일 : " + regDate
                                   + "\n구매 횟수 : " + buyCnt
                                   + "\n누적 포인트 점수 : " + totalPoint
                                   + "\n회원 등급 : " + memberShip.getMemberShip());

    }

    public void initTotalPoint() {
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
}
