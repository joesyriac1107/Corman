package corman.divideandconquer.maxsumsubarray;

public class ResultSubArray {
	
	private int low;
	
	private int high;
	
	private int maxSum;

	
	
	public ResultSubArray(int low, int high, int maxSum) {
		super();
		this.low = low;
		this.high = high;
		this.maxSum = maxSum;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public int getMaxSum() {
		return maxSum;
	}

	public void setMaxSum(int maxSum) {
		this.maxSum = maxSum;
	}

	@Override
	public String toString() {
		return "ResultSubArray [low=" + low + ", high=" + high + ", maxSum=" + maxSum + "]";
	}
	
	

}
