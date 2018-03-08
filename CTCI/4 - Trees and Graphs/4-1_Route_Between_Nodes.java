//4.1 - Route Between Nodes
//Given a directed graph, design an algorithm to find out whether there is a route between two nodes

//Iterative solution
public boolean findRoute(Node start, Node end){
	if (start.equals(end)) return true;
	
	Set<Node> visited = new HashSet<>();
	Deque<Node> traversal = new LinkedList<>();
	travesal.addLast(start);
	
	while (!traversal.isEmpty()){
		Node current = traveral.poll();
		visited.add(current);
		
		for (Node neighbor : current.getNeighbors()){
			if (neighbor.equals(end)) return true;
			if (!visited.contains(neighbor)) traversal.addLast(neighbor);
		}
	}
	
	return false;
}