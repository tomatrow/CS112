abstract class Alien {
	private String _name; 
	private int _damage;
	private int  _health;
	public static final int MAX_HEALTH = 100;
	public static final int MIN_HEALTH = 0;

	Alien() {
		this("?",MIN_HEALTH);
	}
	Alien(String name, int damage) {
		setName(name);
		setDamage(damage);
		setHealth(MAX_HEALTH);
	}
	Alien(Alien alien) {
		setName(alien.name());
		setDamage(alien.damage());
	}

	// setters
	private void setName(String name) {
		_name = name;
	}
	private void setDamage(int damage) {
		if (damage >= MIN_HEALTH) 
			_damage = damage;
	}
	private void setHealth(int health) {
		if (health >= MIN_HEALTH && health <= MAX_HEALTH)
			_health = health;
	}

	// getters
	public String name() {
		return _name;
	}
	public abstract int damage();
	int health() {
		return _health;
	}
	// utility
	public String toString() {
		return String.format("%s:%d",name(),damage());
	}
}