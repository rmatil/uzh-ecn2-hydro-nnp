public class TreeBuilder {

	private static final int PARTICLES_PER_BOX = 8;
	
	public static void build(Cell pCell, Particle[] pSsot) {
		// Exit condition -> Cell contains max one particle
		if (pCell.getRightIndex() - pCell.getLeftIndex() <= PARTICLES_PER_BOX) {
			return;
		}

		// Find longer dimension and split (prefer X dim)
		Cell leftChild = null;
		Cell rightChild = null;
		if (getDividingDimension(pCell)) {
			// divide in x
			double newBorder = pCell.getXMin() + (pCell.getXDifference() / 2);
			int splitIndex = sortParticles(pSsot, pCell.getLeftIndex(), pCell.getRightIndex(), newBorder, true);

			leftChild = new Cell(pCell.getXMin(), newBorder, pCell.getYMin(), pCell.getYMax(), pCell.getLeftIndex(), splitIndex);
			rightChild = new Cell(newBorder, pCell.getXMax(), pCell.getYMin(), pCell.getYMax(), splitIndex, pCell.getRightIndex());
		} else {
			// divide in y
			double newBorder = pCell.getYMin() + (pCell.getYDifference() / 2);
			int splitIndex = sortParticles(pSsot, pCell.getLeftIndex(), pCell.getRightIndex(), newBorder, false);

			leftChild = new Cell(pCell.getXMin(), pCell.getXMax(), pCell.getYMin(), newBorder, pCell.getLeftIndex(), splitIndex);
			rightChild = new Cell(pCell.getXMin(), pCell.getXMax(), newBorder, pCell.getYMax(), splitIndex, pCell.getRightIndex());
		}

		// Assign children
		pCell.setLeftChild(leftChild);
		pCell.setRightChild(rightChild);

		// Build new children recursively
		build(leftChild, pSsot);
		build(rightChild, pSsot);
	}

	private static boolean getDividingDimension(Cell pCell) {
		return pCell.getXDifference() >= pCell.getYDifference();
	}

	public static int sortParticles(final Particle[] pSsot,
			final int pLeftIndex, final int pRightIndex,
			final double pSplitValue, final boolean pXDimension) {
		int i = pLeftIndex;
		int j = pRightIndex;

		while (i < j) {
			// look for elements on the left which are greater than the
			// splitValue
			while (i < pRightIndex && (pXDimension ? pSsot[i].getXPos() : pSsot[i].getYPos()) < pSplitValue) {
				i++;
			}

			// look for elements on the right which are smaller than the
			// splitValue
			while (j > pLeftIndex && (pXDimension ? pSsot[j - 1].getXPos() : pSsot[j - 1].getYPos()) >= pSplitValue) {
				j--;
			}

			// swap
			if (i < j) {
				Particle tmp = pSsot[i];
				pSsot[i] = pSsot[j - 1];
				pSsot[j - 1] = tmp;
			}
		}

		return i;
	}

}
