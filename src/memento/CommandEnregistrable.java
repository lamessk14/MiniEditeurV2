package memento;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public interface CommandEnregistrable {
		public void execute();
		public Memento getMemento();
		/**
		 * 
		 * @param memento
		 */
		public void setMemento(Memento memento);
}
