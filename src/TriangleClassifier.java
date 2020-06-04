
public class TriangleClassifier {

	private final int RIGHT_ANGLE = 90;
	private final int ZERO = 0;
	private final int TOTAL_ANGLE = 180;
	
	public String getClassification(int angleA, int angleB, int angleC){
		
		if (angleA == angleB && angleB == angleC && angleC == 60){
			return "equilateral";		
		}else if ((isValidTriangle(angleA, angleB, angleC)) == true){
			return ((classifyAngle(angleA, angleB, angleC)) + " " + (classifySide(angleA, angleB, angleC)));
		}else{
			return "INVALID";
		}
	}

	public boolean isValidTriangle(int angleA, int angleB, int angleC){
		
		if (angleA <= ZERO || angleB <= ZERO || angleC <= ZERO){
			return false;
		}else if(angleA + angleB + angleC != TOTAL_ANGLE){
			return false;
		}else{
			return true;
		}	
	}
	
	public String classifyAngle(int angleA, int angleB, int angleC){
		
		if (angleA == RIGHT_ANGLE || angleB == RIGHT_ANGLE || angleC == RIGHT_ANGLE){
			return "right";
		}else if(angleA > RIGHT_ANGLE || angleB > RIGHT_ANGLE || angleC > RIGHT_ANGLE){
			return "obtuse";
		}else{
			return "acute";
		}
	}
	
	public String classifySide(int angleA, int angleB, int angleC){
		

		if(angleA != angleB && angleB != angleC && angleC != angleA){
			return "scalene";
		}else{
			return "isosceles";
		}
	}
	
}
