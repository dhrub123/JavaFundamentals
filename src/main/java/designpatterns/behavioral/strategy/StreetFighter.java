package designpatterns.behavioral.strategy;
//Driver class
public class StreetFighter {
	
	public static void main(String[] args) {
		JumpBehaviour shortJump = new ShortJump();
		JumpBehaviour longJump = new LongJump();

		KickBehaviour lightningKick = new LightningKick();
		KickBehaviour tornadoKick = new TornadoKick();

		Fighter ken = new Ken(lightningKick, longJump);
		ken.display();
		ken.jump();
		ken.kick();
		ken.punch();
		ken.roll();
		
		ken.setJumpBehaviour(shortJump);
		ken.jump();
		
		Fighter ryu = new Ryu(tornadoKick, shortJump);
		ryu.display();
		ryu.jump();
		ryu.kick();
		ryu.punch();
		ryu.roll();
		
		Fighter chunli = new Chunli(lightningKick, shortJump);
		chunli.display();
		chunli.jump();
		chunli.kick();
		chunli.punch();
		chunli.roll();
	}

}
