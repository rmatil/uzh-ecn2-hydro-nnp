import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class TreeBuilderTest {

	@Test
	public void test() {
		// Particle[] particles = ParticleBuilder.generateParticles(1000);
		//
		// Cell root = new Cell(0d, 1d, 0d, 1d, 0, particles.length);
		//
		// TreeBuilder.build(root, particles);
		//
		// // TODO Do some assertions
		// for (Particle p : particles) {
		// System.out.println("[" + p.getXPos() + "/" + p.getYPos() + "]");
		// }
	}

	@Test
	public void testSortParticles1() {
		Particle[] particles = new Particle[5];
		particles[0] = new Particle(1d, 0d);
		particles[1] = new Particle(2d, 0d);
		particles[2] = new Particle(3d, 0d);
		particles[3] = new Particle(4d, 0d);
		particles[4] = new Particle(5d, 0d);

		double splitVal = 5d;
		int idx = TreeBuilder.sortParticles(particles, 0, 5, splitVal, true);

		for (Particle p : particles) {
			System.out.println("[" + p.getXPos() + "/" + p.getYPos() + "]");
		}
		System.out.println("Split index is: " + idx);
		assertEquals(5, idx);

		for (int i = 0; i < particles.length; i++) {
			if (i <= idx) {
				assertTrue(particles[i].getXPos() <= splitVal);
			} else {
				assertTrue(particles[i].getXPos() > splitVal);
			}
		}
		
		System.out.println();
	}
	
	@Test
	public void testSortParticles2() {
		Particle[] particles = new Particle[5];
		particles[0] = new Particle(5d, 0d);
		particles[1] = new Particle(4d, 0d);
		particles[2] = new Particle(3d, 0d);
		particles[3] = new Particle(2d, 0d);
		particles[4] = new Particle(1d, 0d);

		double splitVal = 5d;
		int idx = TreeBuilder.sortParticles(particles, 0, 5, splitVal, true);

		for (Particle p : particles) {
			System.out.println("[" + p.getXPos() + "/" + p.getYPos() + "]");
		}
		System.out.println("Split index is: " + idx);
		assertEquals(5, idx);

		for (int i = 0; i < particles.length; i++) {
			if (i < idx) {
				assertTrue(particles[i].getXPos() <= splitVal);
			} else {
				assertTrue(particles[i].getXPos() > splitVal);
			}
		}
		
		System.out.println();
	}
	
	@Test
	public void testSortParticles3() {
		Particle[] particles = new Particle[5];
		particles[0] = new Particle(5d, 0d);
		particles[1] = new Particle(4d, 0d);
		particles[2] = new Particle(3d, 0d);
		particles[3] = new Particle(2d, 0d);
		particles[4] = new Particle(1d, 0d);

		double splitVal = 0d;
		int idx = TreeBuilder.sortParticles(particles, 0, 5, splitVal, true);

		for (Particle p : particles) {
			System.out.println("[" + p.getXPos() + "/" + p.getYPos() + "]");
		}
		System.out.println("Split index is: " + idx);
		assertEquals(0, idx);

		for (int i = 0; i < particles.length; i++) {
			if (i < idx) {
				assertTrue(particles[i].getXPos() <= splitVal);
			} else {
				assertTrue(particles[i].getXPos() > splitVal);
			}
		}
		
		System.out.println();
	}
	
	@Test
	public void testSortParticles4() {
		Particle[] particles = new Particle[5];
		particles[0] = new Particle(1d, 0d);
		particles[1] = new Particle(2d, 0d);
		particles[2] = new Particle(3d, 0d);
		particles[3] = new Particle(4d, 0d);
		particles[4] = new Particle(5d, 0d);

		double splitVal = 2.5d;
		int idx = TreeBuilder.sortParticles(particles, 0, 5, splitVal, true);

		for (Particle p : particles) {
			System.out.println("[" + p.getXPos() + "/" + p.getYPos() + "]");
		}
		System.out.println("Split index is: " + idx);
		assertEquals(2, idx);

		for (int i = 0; i < particles.length; i++) {
			if (i < idx) {
				assertTrue(particles[i].getXPos() <= splitVal);
			} else {
				assertTrue(particles[i].getXPos() > splitVal);
			}
		}
		
		System.out.println();
	}
	
	@Test
	public void testSortParticles5() {
		List<Particle> particles = new ArrayList<>();
		particles.add(new Particle(23d, 0d));
		particles.add(new Particle(55d, 0d));
		particles.add(new Particle(1d, 0d));
		particles.add(new Particle(3d, 0d));
		particles.add(new Particle(18d, 0d));
		particles.add(new Particle(10d, 0d));
		particles.add(new Particle(9d, 0d));
		particles.add(new Particle(44d, 0d));
		particles.add(new Particle(10d, 0d));
		particles.add(new Particle(35d, 0d));
		particles.add(new Particle(929d, 0d));
		particles.add(new Particle(182d, 0d));
		particles.add(new Particle(7d, 0d));
		
		Particle[] particleArr = particles.toArray(new Particle[] {});

		double splitVal = 10d;
		int idx = TreeBuilder.sortParticles(particleArr, 0, particleArr.length, splitVal, true);

		for (Particle p : particleArr) {
			System.out.println("[" + p.getXPos() + "/" + p.getYPos() + "]");
		}
		System.out.println("Split index is: " + idx);
		assertEquals(6, idx);

		for (int i = 0; i < particleArr.length; i++) {
			if (i < idx) {
				assertTrue(particleArr[i].getXPos() <= splitVal);
			} else {
				assertTrue(particleArr[i].getXPos() > splitVal);
			}
		}
		
		System.out.println();
	}
	
	
}
