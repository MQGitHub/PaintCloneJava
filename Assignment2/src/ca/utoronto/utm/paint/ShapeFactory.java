package ca.utoronto.utm.paint;

public class ShapeFactory {

	public ShapeManipulator getShape(View view, String shapeType) {
		if (shapeType == null) {
			return null;
		}
		switch (shapeType.toLowerCase()) {
		
		case "circle":
			return new CircleManipulator(view);

		case "rectangle":
			return new RectangleManipulator(view);

		case "square":
			return new SquareManipulator(view);

		case "triangle":
			return new TriangleManipulator(view);

		case "oval":
			return new OvalManipulator(view);

		case "line":
			return new LineManipulator(view);

		case "polyline":
			return new PolylineManipulator(view);

		case "squiggle":
			return new SquiggleManipulator(view);

		case "eraser":
			return new EraserManipulator(view);

		case "rightangletriangle":
			return new RightATriangleManipulator(view);
		
		case "text":
			return new TextBoxManipulator(view);

		}
		return null;
	}
}
