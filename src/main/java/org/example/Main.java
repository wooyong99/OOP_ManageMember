package org.example;

public class Main {
    public static void main(String[] args) {
        Member m1 = new Member(1, "홍길동", 2);
        Member m2 = new Member(2, "홍길순", 9);

        System.out.println(m1);
        System.out.println(m2);
        m1.buy();
        System.out.println(m1);
        System.out.println(Member.getBestMember());

        m2.buy();
        System.out.println(m2);
        m2.refund();
        System.out.println(m2);
    }
}