package paquetePrincipal.clasesPrincipales.Naves;

import paquetePrincipal.Objeto;

public class Proyectil extends Objeto
{
	protected float counter;
	protected float speed;
	
	
	
	public Proyectil(float counter, float speed) {
		super();
		this.counter =counter;
		this.speed = speed;
	}
	

    private void initMissile() 
    {    
        this.setImage("src/img/shot.png");  
    }
	
	public void move()
	{
		this.posX+=speed;
	}
	
	
	
	public void timeToLive()
	{
		this.counter--;
	}
}
