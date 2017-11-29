package memento;

public abstract class MementoImplem implements Memento {
	
	private String etat;
	protected String type;

	public String getType(){
		return type;
	}
		
	public String getEtat() {
		System.out.println(this.toString() + ":getEtat: " + etat);
		return etat;
	}

	public void setEtat(String etat1) {
		System.out.println(this.toString() + ":setEtat: " + etat);
		etat = etat1;
	}

}
