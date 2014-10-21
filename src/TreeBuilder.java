public class TreeBuilder {

	public static void build(Cell pCell, Particle[] pSsot) {
		// Exit condition -> Cell contains max one particle
		if (pCell.getRightIndex() - pCell.getLeftIndex() <= 1) {
			return;
		}

		// Find longer dimension and split (prefer X dim)
		Cell leftChild = null;
		Cell rightChild = null;
		if (getDividingDimension(pCell)) {
			// divide in x
			double newBorder = pCell.getXMin() + (pCell.getXDifference() / 2);
			int splitIndex = sortParticles(pSsot, pCell.getLeftIndex(),
					pCell.getRightIndex(), newBorder, true);

			leftChild = new Cell(pCell.getXMin(), newBorder, pCell.getYMin(),
					pCell.getYMax(), pCell.getLeftIndex(), splitIndex);
			rightChild = new Cell(newBorder, pCell.getXMax(), pCell.getYMin(),
					pCell.getYMax(), splitIndex + 1, pCell.getRightIndex());
		} else {
			// divide in y
			double newBorder = pCell.getYMin() + (pCell.getYDifference() / 2);
			int splitIndex = sortParticles(pSsot, pCell.getLeftIndex(),
					pCell.getRightIndex(), newBorder, false);

			leftChild = new Cell(pCell.getXMin(), pCell.getXMax(),
					pCell.getYMin(), newBorder, pCell.getLeftIndex(),
					splitIndex);
			rightChild = new Cell(pCell.getXMin(), pCell.getXMax(), newBorder,
					pCell.getYMax(), splitIndex + 1, pCell.getRightIndex());
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

	private static int sortParticles(final Particle[] pSsot,
			final int pLeftIndex, final int pRightIndex,
			final double pSplitValue, final boolean pXDimension) {
		int i = pLeftIndex;
		int j = pRightIndex;

		while (i < j) {
			// look for elements on the left which are greater than the
			// splitValue
			while ((pXDimension ? pSsot[i].getXPos() : pSsot[i].getYPos()) <= pSplitValue
					&& i <= pRightIndex) {
				i++;
			}

			// look for elements on the right which are smaller than the
			// splitValue
			while ((pXDimension ? pSsot[j].getXPos() : pSsot[j].getYPos()) > pSplitValue
					&& j > pLeftIndex) {
				j--;
			}

			// swap
			if (i < j) {
				Particle tmp = pSsot[i];
				pSsot[i] = pSsot[j];
				pSsot[j] = tmp;
			}
		}

		return i;
	}

}
