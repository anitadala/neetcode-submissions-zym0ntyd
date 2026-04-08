class Solution {
    private Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)  return null;
        map.clear();
        return dfs(node);
    }
    private Node dfs(Node node){
        if(map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val);
        map.put(node,clone);
        for(Node nei : node.neighbors){
            clone.neighbors.add(dfs(nei));
        }
        return clone;
    }
}