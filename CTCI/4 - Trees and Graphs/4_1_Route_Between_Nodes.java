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


//Recursive solution (untested)
public boolean checkRoute(GraphNode source, GraphNode target) {
	if (source.equals(target)) return true;
	Set<GraphNode> visited = new HashSet<>();
	
	return checkRoute(source, target, visited);
}

private boolean checkRoute(GraphNode source, GraphNode target, Set<GraphNode> visited) {
	if (!visited.add(source)) return false;
	if (source.equals(target)) return true;
	
	for (GraphNode child : source.children) {
		checkRoute(child, target, visited);
	}
	
	return false;
}