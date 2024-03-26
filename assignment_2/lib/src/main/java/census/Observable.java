package census;

public interface Observable {
	
	boolean addObserver(Observer ob);
	boolean removeObserver(Observer ob);
	boolean hasObservers();

}
