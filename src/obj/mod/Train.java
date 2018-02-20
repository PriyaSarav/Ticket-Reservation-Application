package obj.mod;

public class Train {

	private String[] trainName = { "Chennai express", "Chozhan", "Intercity" };
	private int trainNo[] = { 12342, 335633, 75447 };

	public String[] getTrainName() {
		return trainName;
	}

	public void setTrainName(int i, String[] trainName) {
		this.trainName = trainName;
	}

	public int[] getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int[] trainNo) {
		this.trainNo = trainNo;
	}

}
