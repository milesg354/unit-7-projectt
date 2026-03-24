import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;

public class Player extends GameObject {

    private int speed = 200;
    private int jumpSpeed = 4000;
    float jumpTime = 0.5f;
    float delayCounter = 0;
    private int isPlayer = 1;
    public Player(double x, double y){
        super(x, y, 10, 250, "assets\\mario.png");
    }

    @Override
    public void move(double deltaTime){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            setX(getX() - (speed * deltaTime));
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            setX(getX() + (speed * deltaTime));
        } 
    }
    public void jump(double deltaTime){
        jumpTime = 0.5f;
        if(delayCounter < jumpTime){
            delayCounter += Gdx.graphics.getDeltaTime();
            if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
                setY(getY()+ (jumpSpeed * deltaTime));
            }
            delayCounter = 0;
        }
        
    }
}
