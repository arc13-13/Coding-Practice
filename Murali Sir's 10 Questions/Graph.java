import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;

public class Graph<T>{
	private ArrayList<Edge<T>> allEdges;
	private HashMap<Long,Vertex<T>> allVertex;
	private boolean isDirected = false;
	private int weight;


	public Graph(boolean isDirected){
		allEdges = new ArrayList<Edge<T>>();
		allVertex = new HashMap<Long,Vertex<T>>();
		this.isDirected = isDirected;
	}

	public void addEdge(long id1,long id2){
		addEdge(id1,id2,0);
	}

	public void addVertex(Vertex<T> vertex){
		if(allVertex.containsKey(vertex.getId()))
			return;

		else{
			allVertex.put(vertex.getId(),vertex);
			ArrayList<Edge<T>> edges = vertex.getEdges();
			for(Edge<T> e : edges)
				allEdges.add(e);
			
		}
	}

	public void addSingleVertex(long id){
		if(allVertex.containsKey(id))
			return;
		Vertex<T> vertex = new Vertex<T>(id);
		allVertex.put(id,vertex);
	}

	

	public void addEdge(long id1,long id2,int weight){
		Vertex<T> v1 = null;
		if(allVertex.containsKey(id1))
			v1 = allVertex.get(id1);
		else{
			v1 = new Vertex<T>(id1);
			allVertex.put(id1,v1);
		}

		Vertex<T> v2 = null;
		if(allVertex.containsKey(id2))
			v2 = allVertex.get(id2);
		else{
			v2 = new Vertex<T>(id2);
			allVertex.put(id2,v2);
		}

		Edge<T> edge = new Edge<T>(v1,v2,isDirected,weight);
		allEdges.add(edge);

		v1.addAdjacentVertex(edge,v2);
		if(!isDirected){
			v2.addAdjacentVertex(edge,v1);
		}
	}

	public Vertex<T> getVertex(long id){
		return allVertex.get(id);
	}

	public ArrayList<Edge<T>> getAllEdges(){
		return allEdges;
	}

	public Collection<Vertex<T>> getAllVertices(){
		return allVertex.values();
	}

	public void setDataForVertex(long id,T data){
		if(allVertex.containsKey(id)){
			Vertex<T> v = allVertex.get(id);
			v.setData(data);
		}
		
	}

	@Override
	public String toString(){
	    StringBuffer buffer = new StringBuffer();
	    for(Edge<T> edge : getAllEdges()){
	        buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getweight());
            buffer.append("\n");
	    }
	    return buffer.toString();
	}
}

class Vertex<T>{
	T data;
	Long id;
	ArrayList<Edge<T>> edges = new ArrayList<Edge<T>>();
	ArrayList<Vertex<T>> adjacentvertices = new ArrayList<Vertex<T>>();

	public Vertex(long id){
		this.id = id;
	}

	public void setData(T data){
		this.data = data;
	}

	public long getId(){
		return id;
	}

	public T getData(){
		return data;
	}

	public ArrayList<Edge<T>> getEdges(){
		return edges;
	}

	public void addAdjacentVertex(Edge<T> e,Vertex<T> v2){
		adjacentvertices.add(v2);
		edges.add(e);
	}

	public ArrayList<Vertex<T>> getAdjacentVertices(){
		return adjacentvertices;
	}

	public int getDegree(){
		return edges.size();
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

class Edge<T>{
	Vertex<T> vertex1 = null;
	Vertex<T> vertex2 = null;
	boolean isDirected;
	int weight;

	public Edge(Vertex<T> v1,Vertex<T> v2,boolean isDirected,int weight){
		vertex1 = v1;
		vertex2 = v2;
		this.isDirected = isDirected;
		this.weight = weight;
	}

	public Edge(Vertex<T> v1,Vertex<T> v2,boolean isDirected){
		vertex1 = v1;
		vertex2 = v2;
		this.isDirected = isDirected;
	}

	public Edge(Vertex<T> v1,Vertex<T> v2){
		vertex1 = v1;
		vertex2 = v2;
	}

	public Vertex<T> getVertex1(){
		return vertex1;
	}

	public Vertex<T> getVertex2(){
		return vertex2;
	}

	public boolean isDirected(){
		return isDirected;
	}

	public int getweight(){
		return weight;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (vertex1 == null) {
            if (other.vertex1 != null)
                return false;
        } else if (!vertex1.equals(other.vertex1))
            return false;
        if (vertex2 == null) {
            if (other.vertex2 != null)
                return false;
        } else if (!vertex2.equals(other.vertex2))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[vertex1=" + vertex1.getId()
                + ", vertex2=" + vertex2.getId() + ", weight=" + weight+"]";
    }
}