import java.util.Random;

public class ParticleBuilder {

	public static Particle[] generateParticles(int pCount) {
		Particle[] ret = new Particle[pCount];

		Random r = new Random();
		for (int i = 0; i < pCount; i++) {
			Particle p = new Particle();
		
			p.setMass(10d);
			p.setXPos(r.nextDouble());
			p.setYPos(r.nextDouble());
			p.setXVelocity(r.nextDouble());
			p.setYVelocity(r.nextDouble());

			ret[i] = p;
		}

		return ret;
	}

}
