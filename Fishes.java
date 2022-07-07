package entity;

public class Fishes {
	
	private int fishId;
	private String name;
	
	public Fishes(int fishId, String name) {
		this.setFishId(fishId);
		this.setName(name);
	}

	public int getFishId() {
		return fishId;
	}

	public void setFishId(int fishId) {
		this.fishId = fishId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
