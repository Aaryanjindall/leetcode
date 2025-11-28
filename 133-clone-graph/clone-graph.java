/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)return null;
        HashMap<Node,Node> hm = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        hm.put(node,new Node(node.val));
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node neigh : curr.neighbors){
                if(!hm.containsKey(neigh)){
                hm.put(neigh,new Node(neigh.val));
                q.add(neigh);
            }
            }

        }
        for(Node key : hm.keySet()){
            for(Node neigh : key.neighbors){
                hm.get(key).neighbors.add(hm.get(neigh));
            }
        }
        return hm.get(node);


    }
}