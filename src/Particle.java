public class Particle {

	private double mMass;
	private double mXPos;
	private double mYPos;
	private double mXVelocity;
	private double mYVelocity;
	private double mEnergy;

	
	public Particle() {
	}
	
	public Particle(double pXpos, double pYpos) {
		mXPos = pXpos;
		mYPos = pYpos;
	}

	
	public double getMass() {
		return mMass;
	}

	public void setMass(double pMass) {
		mMass = pMass;
	}

	public double getXPos() {
		return mXPos;
	}

	public void setXPos(double pXPos) {
		mXPos = pXPos;
	}

	public double getYPos() {
		return mYPos;
	}

	public void setYPos(double pYPos) {
		mYPos = pYPos;
	}

	public double getXVelocity() {
		return mXVelocity;
	}

	public void setXVelocity(double pXVelocity) {
		mXVelocity = pXVelocity;
	}

	public double getYVelocity() {
		return mYVelocity;
	}

	public void setYVelocity(double pYVelocity) {
		mYVelocity = pYVelocity;
	}

	public double getEnergy() {
		return mEnergy;
	}

	public void setEnergy(double pEnergy) {
		mEnergy = pEnergy;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Particle { ");
		builder.append("x=").append(mXPos).append(", y=").append(mYPos).append(" }");
		return builder.toString();
	}

}
