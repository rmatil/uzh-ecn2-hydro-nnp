public class Cell {

	private double mXMin;
	private double mXMax;

	private double mYMin;
	private double mYMax;

	private Cell mLeftChild;
	private Cell mRightChild;

	private int mLeftIndex;
	private int mRightIndex;

	public Cell() {
	}

	public Cell(double pXMin, double pXMax, double pYMin, double pYMax) {
		super();
		mXMin = pXMin;
		mXMax = pXMax;
		mYMin = pYMin;
		mYMax = pYMax;
	}
	
	public Cell(double pXMin, double pXMax, double pYMin, double pYMax, int pLeftIndex, int pRightIndex) {
		super();
		mXMin = pXMin;
		mXMax = pXMax;
		mYMin = pYMin;
		mYMax = pYMax;
		mLeftIndex = pLeftIndex;
		mRightIndex = pRightIndex;
	}

	public double getXMin() {
		return mXMin;
	}

	public void setXMin(double pXMin) {
		mXMin = pXMin;
	}

	public double getXMax() {
		return mXMax;
	}

	public void setXMax(double pXMax) {
		mXMax = pXMax;
	}

	public double getYMin() {
		return mYMin;
	}

	public void setYMin(double pYMin) {
		mYMin = pYMin;
	}

	public double getYMax() {
		return mYMax;
	}

	public void setYMax(double pYMax) {
		mYMax = pYMax;
	}

	public Cell getLeftChild() {
		return mLeftChild;
	}

	public void setLeftChild(Cell pLeftChild) {
		mLeftChild = pLeftChild;
	}

	public Cell getRightChild() {
		return mRightChild;
	}

	public void setRightChild(Cell pRightChild) {
		mRightChild = pRightChild;
	}

	public int getLeftIndex() {
		return mLeftIndex;
	}

	public void setLeftIndex(int pLeftIndex) {
		mLeftIndex = pLeftIndex;
	}

	public int getRightIndex() {
		return mRightIndex;
	}

	public void setRightIndex(int pRightIndex) {
		mRightIndex = pRightIndex;
	}

	public double getXDifference() {
		return mXMax - mXMin;
	}

	public double getYDifference() {
		return mYMax - mYMin;
	}

}
