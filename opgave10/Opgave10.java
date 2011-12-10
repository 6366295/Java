/*
 * Naam:		Mike Trieu
 * Studentennummer:	10105093 / 6366295
 * Studie:		Informatica
 *
 * Programma functie:
 * - Het programma maakt geometrische berekeningen
 *    - De geometrische objecten zijn: afstanden, punten, lijnen, rechthoeken en cirkels
 *       - Afstanden kan zijn waarden printen en kan worden opgeteld bij een andere Afstand object
 *       - Punten, lijnen, rechthoeken en cirkels kan zijn eigenschappen printen, omtrek printen en
 *         oppervlakte printen.
 * - Het programma werkt met de volgende eenheden: mm, cm, dc, m, km
 *    - De standaart eenheid is m. Getallen met een andere eenheid wordt hierin omgezet
 *
 * - Gebruik: java Opgave10
 */

public class Opgave10 {
	public static void main(String[] args) {
		Distance d1 = new Distance(10, "mm");
		Distance d2 = new Distance(2.5, "cm");
		Distance d3 = d1.add(d2);

		Point p1 = new Point(new Distance(10, "mm"), new Distance(15, "mm"));
		Point p2 = new Point(new Distance(30, "mm"), new Distance(50, "mm"));
		Point p3 = new Point(new Distance(10, "mm"), new Distance(50, "mm"));

		Distance d4 = p1.distanceTo(p2);

		Shape[] list = new Shape[3];
		list[0] = new Line(p1, p2);
		list[1] = new Rectangle(p1, d2, d3);
		list[2] = new Circle(p3, d2);

		System.out.println("d1: " + d1);
		System.out.println("d2: " + d2);
		System.out.println("d3: " + d3);
		System.out.println("d4: " + d4);

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("p3: " + p3);

		for(int i = 0; i < list.length; i++) {
			System.out.println("List[" + i + "]; " + list[i]);
			System.out.println("Perimeter: " + list[i].perimeter());
			System.out.println("Area: " + list[i].area() + " m^2");
		}
	}
}


/*
 * Klasse voor afstanden. Bevat een nummer met een meeteenheid
 * Deze klasse zet alle eenheden om naar meter
 * Deze klasse bevat een add methode die twee afstanden bij elkaar optelt
 * Deze klasse bevat een toString methode die de default versie vervangt
 */
class Distance {
	double number;
	String unit;

	Distance() { }

	Distance(double number, String unit) {
		if(unit.equals("mm")) {
			this.number = number/1000;
			this.unit = "m";
		} else if(unit.equals("cm")) {
			this.number = number/100;
			this.unit = "m";
		} else if(unit.equals("dm")) {
			this.number = number/10;
			this.unit = "m";
		} else if(unit.equals("km")) {
			this.number = number*1000;
			this.unit = "m";
		} else {
			this.number = number;
			this.unit = "m";
		}
	}

	public Distance add(Distance second) {
		double sum = number + second.number;

		return new Distance(sum, unit);
	}
	
	public String toString() {
		return(this.number + " " + unit);
	}
}

/*
 * Klasse voor vorm. Bevat een positie(x,y) en een meeteenheid
 * Deze klasse bevat methodes die leeg zijn, om die methodes van de kind klasse te kunnen oproepen
 * Deze klasse bevat een toString methode die de default versie vervangt
 */
class Shape {
	double x, y;
	String unit;

	Shape() { }

	Shape(Distance a, Distance b) {
		 x = a.number;
		 y = b.number;
		unit = a.unit;
	}

	public Distance perimeter() {
		return null;
	}

	public double area() {
		return 0.0;
	}

	public String toString() {
		return("(" + x + " " + unit + "; " + y + " " + unit + ")");
	}
}

/*
 * Klasse voor een punt. Bevat een positie(x,y) en een meeteenheid
 * positie(x,y) = punt(x,y)
 * Deze klasse erft alles van vorm
 * Deze klasse bevat een distanceTo methode die de afstand van 2 punten berekend
 * Deze klasse bevat een toString methode die de default versie vervangt
 */
class Point extends Shape {
	Point(Distance a, Distance b) {
		super(a,b);
	}

	public Distance distanceTo(Point second) {
		double dx, dy, difference;

		dx = x - second.x;
		dy = y - second.y;
		difference = Math.sqrt(dx * dx + dy * dy);

		return new Distance(difference, unit);
	}
}

/*
 * Klasse voor een lijn. Bevat een twee punten en een meeteenheid
 * Deze klasse erft alles van vorm
 * Deze klasse bevat methode voor omtrek, die dezelfde methode in vorm klasse vervangt
 * Deze klasse bevat een toString methode die de default versie vervangt
 */
class Line extends Shape {
	double x2, y2;

	Line(Point p0, Point p1) {
		x = p0.x;
		y = p0.y;
		x2 = p1.x;
		y2 = p1.y;
		unit = p0.unit;
	}

	public Distance perimeter() {
		double dx, dy, length;

		dx = x - x2;
		dy = y - y2;

		length = Math.sqrt(dx * dx + dy * dy);

		return new Distance(length, unit);
	}

	public String toString() {
		return("Line[p0: (" + x + " " + unit + "; " + y + " " + unit + ");"
			+ " P1: (" + x2 + " " + unit + "; " + y2 + " " + unit + ")]");
	}
}

/*
 * Klasse voor een rechthoek. Bevat een middelpunt(x,y), lengte, breedte en meeteenheid
 * Deze klasse erft alles van vorm
 * Deze klasse bevat methode voor omtrek, die dezelfde methode in vorm klasse vervangt
 * Deze klasse bevat methode voor oppervlakte, die dezelfde methode in vorm klasse vervangt
 * Deze klasse bevat een toString methode die de default versie vervangt
 */
class Rectangle extends Shape {
	double xCenter, yCenter;

	Rectangle(Point p0, Distance a, Distance b) {
		super(a,b);
		xCenter = p0.x;
		yCenter = p0.y;
	}
	
	public Distance perimeter() {
		double result;
		
		result = x + x + y + y;

		return new Distance(result, unit);
	}

	public double area() {
		return x * y;
	}

	public String toString() {
		return("Rectangle[center: (" + xCenter + " " + unit + "; " + yCenter + " " + unit
			+ "); width: " + x + " " + unit + "; length: " + y + " " + unit + "]");
	}
}

/*
 * Klasse voor een cirkel. Bevat een middelpunt(x,y), radius en meeteenheid
 * Deze klasse erft alles van vorm
 * Deze klasse bevat methode voor omtrek, die dezelfde methode in vorm klasse vervangt
 * Deze klasse bevat methode voor oppervlakte, die dezelfde methode in vorm klasse vervangt
 * Deze klasse bevat een toString methode die de default versie vervangt
 */
class Circle extends Shape {
	double xCenter, yCenter, radius;

	Circle(Point p0, Distance a) {
		xCenter = p0.x;
		yCenter = p0.y;
		radius = a.number;
		unit = a.unit;
	}

	public Distance perimeter() {
		double result;
		
		result = 2 * Math.PI * radius;

		return new Distance(result, unit);
	}

	public double area() {
		return Math.PI * radius * radius;
	}
	
	public String toString() {
		return("Circle[radius:" + radius + " " + unit + "; center: (" + xCenter + " "
			+ unit + "; " + yCenter + " " + unit + ")]");
	}
}
