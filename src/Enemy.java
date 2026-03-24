import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;

public class Enemy extends GameObject {
    private Gun activeGun;
    private int speed = 200;
    private int isPlayer = 2;
    float jumpTime = 0.5f;
    float delayCounter = 0;
    public Enemy(double x, double y){
        super(x, y, 800, 0111, "assets\\toad.png");
    }

    @Override
    public void move(double deltaTime){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            setX(getX() - (speed * deltaTime));
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)){
            setX(getX() + (speed * deltaTime));
        } 
        

    }
    public void jump(double deltaTime){
        jumpTime = 0.5f;
        if(delayCounter < jumpTime){
            delayCounter += Gdx.graphics.getDeltaTime();
            if(Gdx.input.isKeyPressed(Input.Keys.W)){
                setY(getY()+ (speed * deltaTime));
            }
            delayCounter = 0;
        }
        
    }

    public void shootGun(){
        activeGun.shoot();
    }

}