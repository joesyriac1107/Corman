package corman.divideandconquer.maxsumsubarray;

public class MaxSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] intArray = { 2,-3,-1,5,4,-8,-7};
//		ResultSubArray result = maxSumSubArray(intArray, 0, intArray.length-1);
		
		ResultSubArray result = maxSumSubArrayLinear2(intArray);
		System.out.println(result);

	}

	private static ResultSubArray maxSumSubArray(int[] input,int low, int high) {
		ResultSubArray leftSubArray; 
		ResultSubArray rightSubArray;
		ResultSubArray crossSubArray;

		if(high==low)
			return new ResultSubArray(low, high, input[low]);
		else {
			int mid = (low+high)/2;
			leftSubArray = maxSumSubArray(input, low, mid);
			rightSubArray = maxSumSubArray(input, mid+1, high);
			crossSubArray= maxCrossOverSubArray(input, low, mid, high);

			if(leftSubArray.getMaxSum()>rightSubArray.getMaxSum() && leftSubArray.getMaxSum()>crossSubArray.getMaxSum())
				return leftSubArray;

			if(rightSubArray.getMaxSum()>leftSubArray.getMaxSum() && rightSubArray.getMaxSum()>crossSubArray.getMaxSum()) 
				return rightSubArray;

			return crossSubArray;
		}

	}

	private static ResultSubArray maxCrossOverSubArray(int[] input,int low, int mid, int high) {
		int leftSum = Integer.MIN_VALUE;
		int rightSum =  Integer.MIN_VALUE;
		int sum=0;
		int leftLow=0;
		int rightHigh=0;
		ResultSubArray result;

		for(int i=mid;i>=low;i--) {
			sum=sum+input[i];
			if(sum>leftSum) {
				leftSum=sum;
				leftLow=i;
			}

		}

		sum=0;

		for(int j=mid+1;j<=high;j++) {
			sum=sum+input[j];
			if(sum>rightSum) {
				rightSum=sum;
				rightHigh=j;
			}
		}

		result = new ResultSubArray(leftLow,rightHigh,leftSum+rightSum);

		return result;


	}

	//non linear quadratic
	private static ResultSubArray maxSumSubArrayQuadratic(int[] input) {
		ResultSubArray result = new ResultSubArray(0, 0, input[0]);
		ResultSubArray crossArray;

		for(int i=1;i<input.length;i++) {
			crossArray=maxCrossOverSubArray(input, 0, i-1, i);
			if(crossArray.getMaxSum()>result.getMaxSum())
				result=crossArray;

		}

		return result;

	}

	private static ResultSubArray maxSumSubArrayLinear2(int[] input) {

		int maxSum = Integer.MIN_VALUE;
		int low=0;
		int high=0;
		int sum=0;
		int lowInter=0;
		
		for(int i=0;i<input.length;i++) {
			sum=sum+input[i];
			if(sum>maxSum) {
				low=lowInter;
				high=i;
				maxSum=sum;
			}
			
			if(sum<0) {
				sum=0;
				lowInter=i+1;
			}
		}
		
		return new ResultSubArray(low, high, maxSum);

	}
}
