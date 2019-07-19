
public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		/** returns distance between two planets */
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		double r = Math.sqrt(dx * dx + dy * dy);
		return r;
	}

	public double calcForceExertedBy(Planet n) {
		/** returns total force exerted on this planet m by the given planet n */
		double G = 6.67 * 1e-11;
		double r = calcDistance(n);
		double F = (G * this.mass * n.mass) / (r * r);
		return F;
	}

	public double calcForceExertedByX(Planet n) {
		/**
		 * returns force exerted on this planet m by the given planet n in X direction
		 */
		double dx = n.xxPos - this.xxPos;
		double r = calcDistance(n);
		double Fx = calcForceExertedBy(n) * dx / r;
		return Fx;
	}

	public double calcForceExertedByY(Planet n) {
		/**
		 * returns force exerted on this planet m by the given planet n in Y direction
		 */
		double dy = n.yyPos - this.yyPos;
		double r = calcDistance(n);
		double Fy = calcForceExertedBy(n) * dy / r;
		return Fy;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double FnetX = 0;
		for (int i = 0; i <= allPlanets.length - 1; i++) {
			if (allPlanets[i].equals(this) != true) {
				FnetX += calcForceExertedByX(allPlanets[i]);
			}
		}
		return FnetX;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double FnetY = 0;
		for (int i = 0; i <= allPlanets.length - 1; i++) {
			if (allPlanets[i].equals(this) != true) {
				FnetY += calcForceExertedByY(allPlanets[i]);
			}
		}
		return FnetY;
	}

	public void update(double dt, double fX, double fY) {
		double aNetX = fX / this.mass;
		double aNetY = fY / this.mass;
		double vNewX = this.xxVel + dt * aNetX;
		double vNewY = this.yyVel + dt * aNetY;
		double pNewX = this.xxPos + dt * vNewX;
		double pNewY = this.yyPos + dt * vNewY;
		this.xxVel = vNewX;
		this.yyVel = vNewY;
		this.xxPos = pNewX;
		this.yyPos = pNewY;
	}
	
	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos,"images/" + this.imgFileName); 
	}
}
