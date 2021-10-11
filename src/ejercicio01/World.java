package ejercicio01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World {
	private List<Being> beings = new ArrayList<>();
	private final int MAXBEINGS = 10;
	private Cornucopia cornucopia = Cornucopia.getInstance();
	private boolean fullWorld = false;
	private WorldView view;

	public World(WorldView view) {
		super();
		this.view = view;
	}

	public void makeHistory() {
		beings.add(new Being(cornucopia));
		do {
			for (int i = 0; i < MAXBEINGS-1; i++) {
				beings.add(new Being(cornucopia));
			}
			for (Iterator iterator = beings.iterator(); iterator.hasNext();) {
				Being being = (Being) iterator.next();
				being.start();
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} while (isAnyoneIn());
		cornucopia.setEnable(false);
		System.out.println("El world is over");
	}

	public boolean isFullWorld() {
		return fullWorld;
	}

	public void setFullWorld(boolean fullWorld) {
		this.fullWorld = fullWorld;
	}

	private boolean isAnyoneIn() {
		return beings.size() > 0;
	}

	public List<Being> getBeings() {
		return beings;
	}

	public long getConsumed() {
		return cornucopia.getConsumed();
	}

	private boolean checkFullBox() {
		return beings.size() >= MAXBEINGS;
	}

}
