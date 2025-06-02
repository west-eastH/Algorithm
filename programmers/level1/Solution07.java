package programmers.level1;

//프로그래머스 Level1 붕대 감기
class Solution07 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int lastAttackTime = attacks[attacks.length - 1][0];
        int seq = 0;
        int attackIdx = 0;
        int maxHP = health;
        for (int i = 1; i <= lastAttackTime; i++) {
            if (attacks[attackIdx][0] == i) {
                health -= attacks[attackIdx][1];
                attackIdx++;
                seq = 0;
            } else {
                health = Math.min(maxHP, health + bandage[1]);
                seq++;
                if (seq == bandage[0]) {
                    seq = 0;
                    health = Math.min(maxHP, health + bandage[2]);
                }
            }
            if (health <= 0) {
                return -1;
            }
        }
        return health;
    }
}