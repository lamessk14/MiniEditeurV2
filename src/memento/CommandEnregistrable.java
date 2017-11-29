package memento;

public interface CommandEnregistrable {
		public void execute();
		public Memento getMemento();
		public void setMemento(Memento memento);
}
