import org.junit.Test;

public class TreeBuilderTest {

	@Test
	public void test() {
		Particle[] particles = ParticleBuilder.generateParticles(1000);

		Cell root = new Cell(0d, 1d, 0d, 1d, 0, particles.length - 1);

		TreeBuilder.build(root, particles);

		// TODO Do some assertions
		for (Particle p : particles) {
			System.out.println("[" + p.getXPos() + "/" + p.getYPos() + "]");
		}
	}

}
