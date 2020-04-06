package rpg;

public class Character {
	int health;
	int gold;
	String name;
	
	public Character(String name) {
		this.name = name;
		this.health = 100;
		this.gold = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void calcHealth(int health) {
		this.health = this.health + health;
		if(this.health > 100) {
			this.health = 100;
		}
	}
		
	public void addGold(int random) {
		this.gold = this.gold + random;
	}
	
	@Override
	public String toString() {
		return "Character [health=" + health + ", gold=" + gold + ", name=" + name + "]";
	}

}
