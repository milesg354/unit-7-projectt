import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;

// public class Enemy extends GameObject {
//     private Gun activeGun;
//     private int speed = 200;
//     private int isPlayer = 2;
//     float jumpTime = 0.5f;
//     float delayCounter = 0;
//     public Enemy(double x, double y){
//         super(x, y, 907, 907, "assets\\toad.png");
//     }

//     @Override
//     public void move(double deltaTime){
//         if(Gdx.input.isKeyPressed(Input.Keys.A)){
//             setX(getX() - (speed * deltaTime));
//         } else if (Gdx.input.isKeyPressed(Input.Keys.D)){
//             setX(getX() + (speed * deltaTime));
//         } 
        

//     }
//     public void jump(double deltaTime){
//         jumpTime = 0.5f;
//         if(delayCounter < jumpTime){
//             delayCounter += Gdx.graphics.getDeltaTime();
//             if(Gdx.input.isKeyPressed(Input.Keys.W)){
//                 setY(getY()+ (speed * deltaTime));
//             }
//             delayCounter = 0;
//         }
        
//     }

//     public void shootGun(){
//         activeGun.shoot();
//     }

// }




public class Enemy extends GameObject {

    private float speed = 200f;
    private float velocityY = 0;
    private final float GRAVITY = -2000f; // Downward force
    private final float JUMP_FORCE = 850f; // Initial upward burst
    private boolean isGrounded = true;

    public Enemy(double x, double y){
        super(x, y, 90, 90, "assets/toad.png", 3);
    }

    @Override
    public void move(double deltaTime){
        // Horizontal Movement
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            setX(getX() - (speed * deltaTime));
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            setX(getX() + (speed * deltaTime));
        }

        // Apply Gravity
        velocityY += GRAVITY * deltaTime;
        setY(getY() + (velocityY * deltaTime));

        // Basic Floor Collision (Assuming Y=100 is your ground)
        if (getY() <= 100) {
            setY(100);
            velocityY = 0;
            isGrounded = true;
        }

        // Handle Jumping
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && isGrounded) {
            velocityY = JUMP_FORCE;
            isGrounded = false;
        }
    }
    public Bullet shoot(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.CONTROL_RIGHT)){
            // Create a new bullet at the player's position
            Bullet newBullet = new Bullet(getX(), getY(), true);
            // Add the bullet to the activeObjects list in MyGame
            return newBullet;
        }
        return null; 
    }
}