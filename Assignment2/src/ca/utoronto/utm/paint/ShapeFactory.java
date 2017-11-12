package ca.utoronto.utm.paint;

public class ShapeFactory {

	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		switch (shapeType.toLowerCase()) {
		
		case "circle":
			return new CircleManipulator();

		case "rectangle":
			return new RectangleManipulator();

		case "square":
			return new SquareManipulator();

		case "triangle":
			return new TriangleManipulator();

		case "oval":
			return new OvalManipulator();

		case "line":
			return new LineManipulator();

		case "polyline":
			return new PolylineManipulator();

		case "squiggle":
			return new SquiggleManipulator();

		case "eraser":
			return new EraserManipulator();

		case "rightangletriangle":
			return new RightATriangleManipulator();

		}
		return null;
	}
}
