package ca.utoronto.utm.paint;

public class ShapeFactory {

	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new CircleManipulator();

		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new RectangleManipulator();

		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new SquareManipulator();

		} else if (shapeType.equalsIgnoreCase("TRIANGLE")) {
			return new TriangleManipulator();

		} else if (shapeType.equalsIgnoreCase("OVAL")) {
			return new OvalManipulator();

		} else if (shapeType.equalsIgnoreCase("LINE")) {
			return new LineManipulator();

		} else if (shapeType.equalsIgnoreCase("POLYLINE")) {
			return new PolylineManipulator();

		} else if (shapeType.equalsIgnoreCase("SQUIGGLE")) {
			return new SquiggleManipulator();

		} else if (shapeType.equalsIgnoreCase("ERASER")) {
			return new EraserManipulator();

		}
		return null;
	}
}
