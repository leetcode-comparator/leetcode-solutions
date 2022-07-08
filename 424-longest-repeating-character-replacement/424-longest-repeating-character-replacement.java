class Solution {
    public int characterReplacement(String answerKey, int k) {
        int t = 0;
        int x=0, key=k, ans = 0;

        if(answerKey.length()==1) return 1;

        char ch[] = answerKey.toCharArray();

        x = 0;
        Queue<Integer> q = new LinkedList<>();
        for(char i='A';i<='Z' ;i++) {
            x=0;
            k = key;
            for (int r = 0; r < ch.length; r++) {
                if (ch[r] == i) {
                    x++;
                } else {
                    if (k > 0) {
                        x++;
                        q.add(r);
                        k--;
                    } else {
                        if(q.isEmpty()){
                            if (x > t)
                                t = x;
                            x=0;
                        }
                        else{
                        x = r - q.remove();
                        q.add(r);
                        }
                    }
                }
                if (x > t)
                    t = x;
            }
            if(t>ans)
                ans = t;
            q.clear();
        }


        return ans;
    }
}