import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;

// public class Player extends GameObject {

//     private int speed = 200;
//     private int jumpSpeed = 4000;
//     float jumpTime = 0.5f;
//     float delayCounter = 0;
//     private int jumpNum = 1;
//     public Player(double x, double y){
//         super(x, y, 20, 40, "assets\\mario.png");
//     }

//     @Override
//     public void move(double deltaTime){
//         if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
//             setX(getX() - (speed * deltaTime));
//         } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
//             setX(getX() + (speed * deltaTime));
//         } 
//     }
//     public void jump(double deltaTime){
//         if(jumpNum < 25){
//             if(Gdx.input.isKeyPressed(Input.Keys.UP)){
//                 setY(getY()+ 5);
//                 jumpNum += 5;
//             }
//         } else if(getY() == 100){
//             jumpNum = 0;
//         } else{
            
//             jumpNum = 0;
//         }
//     }
// }



public class Player extends GameObject {

    private float speed = 200f;
    private float velocityY = 0;
    private final float GRAVITY = -2000f; // Downward force
    private final float JUMP_FORCE = 825f; // Initial upward burst
    private boolean isGrounded = true;
    private int lives = 3;

    public Player(double x, double y){
        super(x, y, 70, 70, "assets/mario.png", 3);
    }

    @Override
    public void move(double deltaTime){
        // Horizontal Movement
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            setX(getX() - (speed * deltaTime));
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)){
            setX(getX() + (speed * deltaTime));
        }

        // Apply Gravity
        velocityY += GRAVITY * deltaTime;
        setY(getY() + (velocityY * deltaTime));
        isGrounded = false;

        // Basic Floor Collision (Assuming Y=100 is your ground)
        // if (getY() <= 100) {
        //     setY(100);
        //     velocityY = 0;
        //     isGrounded = true;
        // }

        for (Platform platform :MyGame.platformsList){
            int platformTop = (int) platform.getY() + (int) platform.getHeight();
            boolean withinX = getX() + getWidth() > platform.getX() && getX() + getWidth() < platform.getX() + platform.getWidth()+70;
            boolean fallingOntoPlatform = getY() <= platformTop && (getY()- velocityY * deltaTime) >= platformTop;
           
            if (withinX && fallingOntoPlatform && velocityY <= 0) {
                setY(platformTop);
                velocityY = 0;
                isGrounded = true;
            }
        }
        


        // Handle Jumping
        if (Gdx.input.isKeyJustPressed(Input.Keys.W) && isGrounded) {
            velocityY = JUMP_FORCE;
            isGrounded = false;
        }
    }

    // private boolean isLandingOnPlatform(Player p, Platform platform) {
    //     boolean withinX = p.getX() + p.getWidth()> platform.getX() && p.getX()< platform.getX() + platform.getWidth();
    //     boolean fallingOntoPlatform = p.getY() >= platform.getY() + platform.getHeight() && p.getY()+5 <= platform.getY() + platform.getHeight() - 10;
    //     boolean falling = velocityY <= 0;
    //     return withinX && fallingOntoPlatform && falling;
   // }



    public Bullet shoot(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.E)){    
            Bullet q = new Bullet(getX(), getY(), true);
            return q;
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.E) && Gdx.input.isKeyPressed(Input.Keys.D)){
            Bullet q = new Bullet(getX(), getY(), false);
            return q;
        }
        return null;
    }
}

