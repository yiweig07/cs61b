

public class NBody {

	public static double readRadius(String s) {
		In in = new In(s);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		return secondItemInFile;
	}
	public static Planet[] readPlanets(String s) {
		In in = new In(s);
		int planetNumber = in.readInt();
		double secondItemInFile = in.readDouble();
		
		Planet[] allPlanets= new Planet[planetNumber];
		for (int i = 0; i <= allPlanets.length - 1; i++) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String imgFile = in.readString();
			allPlanets[i] = new Planet(xP, yP, xVel, yVel, mass, imgFile);
		} 
		return allPlanets;
	}
	
	public static void main(String[] args) {
		if (args.length != 0){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2]; 
		double universeRadius = readRadius(filename);
		Planet[] allPlanets = readPlanets(filename);
		StdDraw.setScale(-universeRadius, universeRadius);
		StdDraw.picture(0,0, "images/starfield.jpg");
		for(int i=0; i <= allPlanets.length-1; i++) {
			allPlanets[i].draw();
		}
		StdDraw.enableDoubleBuffering();
		int time;
		for (time = 0; time <= T; time+=dt) {
			double[] xForces = new double[allPlanets.length];
			double[] yForces = new double[allPlanets.length];
			for (int i=0; i <= allPlanets.length-1; i++) {
				xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
				yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
				allPlanets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0,0, "images/starfield.jpg");
			for(int i=0; i <= allPlanets.length-1; i++) {
				allPlanets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}
}


