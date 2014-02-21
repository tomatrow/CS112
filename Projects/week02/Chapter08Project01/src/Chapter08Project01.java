/* Chapter No. 8 - Project No.  1.
    File Name:          Chapter08Project01.java
    Programmer:         Andrew Caldwell
    Date Last Modified: Jan. 30, 2013

    Problem Statement:
	Demonstrate subclassing, polyporphism, abstraction and overriding

    Overall Plan
    * alienPack
        * add three alien sublcasses to alienPack
        * display

    Classes needed and Purpose
    main class - Chapter07Project06
    Alien - abstract base class
    AlienPack - Alien manager/collection
    OgreAlien -  subclass of alien 
    SnakeAlien - subclass of alien 
    MarshmellowAlien - subclass of alien  

*/

class Chapter08Project01 {
	public static void main(String[] args) {
		AlienPack _pack = new AlienPack();
		_pack.setAlienAtIndex(new SnakeAlien(),0);
		_pack.setAlienAtIndex(new OgreAlien(),1);
		_pack.setAlienAtIndex(new MarshmellowManAlien(),2);
		System.out.println("Alien Collection: " + _pack);
		System.out.println("Their damage together: " + _pack.calculateDamage());
	}
}