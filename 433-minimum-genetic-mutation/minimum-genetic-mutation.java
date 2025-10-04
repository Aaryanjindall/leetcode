class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> hs = new HashSet<>();
        for(String i : bank){
            hs.add(i);
        }
        if(!hs.contains(endGene)){
            return -1;
        }
        char [] genes = {'A','C','G','T'};
        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        int level = 0;
        HashSet<String> visited = new HashSet<>();
        visited.add(startGene);
        while(!q.isEmpty()){
            int size = q.size();

            for (int s = 0; s < size; s++) {
                String curr = q.poll();

                if (curr.equals(endGene)) return level;

                char[] charArray = curr.toCharArray();

                for (int i = 0; i < charArray.length; i++) {
                    char originalChar = charArray[i];

                    for (char c : genes) {
                        charArray[i] = c;
                        String newGene = new String(charArray);

                        if (hs.contains(newGene) && !visited.contains(newGene)) {
                            q.add(newGene);
                            visited.add(newGene);
                        }
                    }

                    charArray[i] = originalChar;
                }
            }

            level++;
        }

        return -1;

    }
    
}