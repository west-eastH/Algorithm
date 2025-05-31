package programmers.level1;

//프로그래머스 Level1 동영상 재생기
class Solution03 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int currentTime = timeToSec(pos);
        int opStartTime = timeToSec(op_start);
        int opEndTime = timeToSec(op_end);
        int videoTime = timeToSec(video_len);

        currentTime = skip(currentTime, opStartTime, opEndTime);

        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                currentTime = Math.max(currentTime - 10, 0);
            } else {
                currentTime = Math.min(currentTime + 10, videoTime);
            }
            currentTime = skip(currentTime, opStartTime, opEndTime);
        }

        return secToTime(currentTime);
    }

    public int skip(int cur, int start, int end) {
        if (cur >= start && cur <= end) {
            return end;
        }
        return cur;
    }

    public int timeToSec(String time) {
        String[] parts = time.split(":");

        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public String secToTime(int seconds) {
        int min = seconds / 60;
        int sec = seconds % 60;
        return String.format("%02d:%02d", min, sec);
    }
}