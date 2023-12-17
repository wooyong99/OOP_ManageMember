package org.example;

public class Point {
    public static long maxPoint;
    private long buyCnt;
    private long point;

    public Point(long buyCnt) {
        this.buyCnt = buyCnt;
        this.point = sumPoint();
        resetMaxPoint();
    }

    private void resetMaxPoint() {
        if (point > maxPoint) {
            maxPoint = point;
        }
    }

    // 이달의 베스트 회원 추가 포인트 적립
    public void addPointByBestMember() {
        if (maxPoint == point) {
            point += 10000;
        }
    }


    public long getBuyCnt() {
        return this.buyCnt;
    }

    public long getPoint() {
        return this.point;
    }

    // 구매 1 증가
    public void increaseBuyCnt() {
        this.point -= sumPoint();
        this.buyCnt++;
        this.point += sumPoint();
    }

    // 구매 1 감소
    public void decreaseBuyCnt() {
        this.point -= sumPoint();
        this.buyCnt--;
        this.point += sumPoint();
    }

    // 누적포인트 합계 초기화
    public long sumPoint() {
        if (buyCnt < 3) {
            return buyCnt * 20;
        } else if (buyCnt < 5) {
            return buyCnt * 30;
        } else if (buyCnt < 10) {
            return buyCnt * 50;
        }
        return buyCnt * 100;
    }
}
