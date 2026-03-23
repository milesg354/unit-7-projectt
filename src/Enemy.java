import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Enemy extends GameObject {
    private Gun activeGun;
    private int speed = 200;
    
    public Enemy(double x, double y){
        super(x, y, 50, 50, "assets\\whale.png");
    }

    @Override
    public void move(double deltaTime){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            setX(getX() - (speed * deltaTime));
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)){
            setX(getX() + (speed * deltaTime));
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)){
            setY(getY() + 25);
        }

    }

    public void shootGun(){
        activeGun.shoot();
    }

}