package serie2;

public class Pair<E1,E2>{
  public E1 first;
  public E2 second;
  
  
  public Pair(E1 first, E2 second){
    this.first = first;
    this.second = second;
  }
  
  @SuppressWarnings("unchecked")
public boolean equals(Object o){
	  if( !(o instanceof Pair)) return false;
	  Pair<E1,E2> pair=(Pair<E1,E2>) o;
	  return this.first.equals(pair.first) && this.second.equals(pair.second); 
  }

  
  public String toString(){
	  return "(" + first.toString() + "," + second.toString() + ")";
  }
  
}
