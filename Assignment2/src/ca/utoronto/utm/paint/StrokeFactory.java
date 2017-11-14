package ca.utoronto.utm.paint;

import java.awt.BasicStroke;

public class StrokeFactory {

	public BasicStroke strokeManipulator(String stroke, int thickness) {

		BasicStroke b = new BasicStroke();
		float[] dash1;

		switch (stroke.toLowerCase()) {

		case "plain":
			b = new BasicStroke(thickness);
			return b;
		case "dashed":
			dash1 = new float[] { 10.0f, 10.0f };
			b = new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, thickness);
			return b;
		
		case "dotted":
			dash1 = new float[] { 2.5f, thickness + 2, 2.5f, thickness + 2 };
			b = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f, dash1, thickness);
			return b;
		
		case "dashed & dotted":
			dash1 = new float[] { 21.0f, 9.0f, 3.0f, 9.0f };
			b = new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, thickness);
			return b;
		
		case "dash dot dot":
			dash1 = new float[] { 3.0f, 9.0f, 21.0f, 9.0f, 3.0f, 9.0f };
			b = new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, thickness);
			return b;
		
		case "lines":
			dash1 = new float[] { 1.0f, 1.0f, 1.0f };
			b = new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, dash1, thickness);
			return b;
		}
		return b;

	}

}
