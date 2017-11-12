package ca.utoronto.utm.paint;

public class ShapeFactory {

	public ShapeManipulator getShape(PaintPanel pp, String shapeType) {
		if (shapeType == null) {
			return null;
		}
		switch (shapeType.toLowerCase()) {
		
		case "circle":
			return new CircleManipulator(pp);

		case "rectangle":
			return new RectangleManipulator(pp);

		case "square":
			return new SquareManipulator(pp);

		case "triangle":
			return new TriangleManipulator(pp);

		case "oval":
			return new OvalManipulator(pp);

		case "line":
			return new LineManipulator(pp);

		case "polyline":
			return new PolylineManipulator(pp);

		case "squiggle":
			return new SquiggleManipulator(pp);

		case "eraser":
			return new EraserManipulator(pp);

		case "rightangletriangle":
			return new RightATriangleManipulator(pp);

		}
		return null;
	}
}
