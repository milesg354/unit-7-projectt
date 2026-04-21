import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

public class MyGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private ArrayList<GameObject> activeObjects;

    Texture backgroundImage;
        public static ArrayList<Platform> platformsList = new ArrayList<Platform>();

    @Override
    public void create() {
        
        backgroundImage = new Texture("assets\\background.png");
        batch = new SpriteBatch();
        
        activeObjects = new ArrayList<GameObject>();
        
        // TODO 3: Instantiate your Player subclass and add it to activeObjects.
        
        Player playerOne = new Player(500,100);
        activeObjects.add(playerOne);
        Enemy playerTwo = new Enemy(650,100);
        activeObjects.add(playerTwo);


        Platform leftPlatform = new Platform(120,165,184,25);
        activeObjects.add(leftPlatform);
        Platform RightPlatform = new Platform(496,165,184,25);
        activeObjects.add(RightPlatform);
        Platform TopPlatform = new Platform(304,235,192,25);
        activeObjects.add(TopPlatform);
        Platform BottomPlatform = new Platform(40,65,712,35);
        activeObjects.add(BottomPlatform);
        Platform SecretPlatform = new Platform(55,410,150,10);
        activeObjects.add(SecretPlatform);
        Platform AbovePlatform = new Platform(405,430,80,10);
        activeObjects.add(AbovePlatform);
        Platform SunPlatform = new Platform(670,420,50,10);
        activeObjects.add(SunPlatform);
        Platform floorPlatform = new Platform(-4000,0,8000,0);
        activeObjects.add(floorPlatform);
        Bullet bill = new Bullet(200,200, false);
        activeObjects.add(bill);
        GameObject PH1 = new GameObject(10,5,30,30, "assets\\heart.png", 100);
        activeObjects.add(PH1);
        GameObject PH2 = new GameObject(30,5,30,30, "assets\\heart.png", 100);
        activeObjects.add(PH2);
        GameObject PH3 = new GameObject(50,5,30,30, "assets\\heart.png", 100);
        activeObjects.add(PH3);

        GameObject EH1 = new GameObject(770,5,30,30, "assets\\heart.png", 100);
        activeObjects.add(EH1);
        GameObject EH2 = new GameObject(750,5,30,30, "assets\\heart.png", 100);
        activeObjects.add(EH2);
        GameObject EH3 = new GameObject(730,5,30,30, "assets\\heart.png", 100);
        activeObjects.add(EH3);
        
        // TODO 4: Write a for-loop to instantiate 5 Enemy objects at different 
        //         starting Y-coordinates and add them to activeObjects.
        
        platformsList.add(leftPlatform);
        platformsList.add(RightPlatform);
        platformsList.add(TopPlatform);
        platformsList.add(BottomPlatform);
        platformsList.add(SecretPlatform);
        platformsList.add(AbovePlatform);
        platformsList.add(SunPlatform); 
        platformsList.add(floorPlatform);
    }

    //render() is the game loop, called approx 60 times per second
    @Override
    public void render() {
        // Boilerplate: Clear the screen to black each frame
        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // --- AP REVIEW: CASTING ---
        // Gdx.graphics.getDeltaTime() returns a float. 
        // We cast it to a double to stay strictly within the AP CSA Java standards.
        double deltaTime = (double) Gdx.graphics.getDeltaTime();

        // --- AP REVIEW: POLYMORPHISM ---
        // TODO 5: Write a standard or enhanced for-loop to iterate through activeObjects.
        // For each object, call its move() method.
        // for(GameObject q : activeObjects){
        //     if(q.getY() > 100){
        //         q.setY(q.getY()-3);
        //     }
        //     q.move(deltaTime);
        
        // }
        
        //Note: Anything drawn must be between .begin() and .end()
        batch.begin();
        batch.draw(backgroundImage, 0, 0, 800, 500);
        // TODO 6: Write a loop to iterate through activeObjects and call draw(batch).
        for(int i = activeObjects.size()-1; i >= 0 ; i--){
            GameObject q = activeObjects.get(i);
            // if(q.getY() > 100){
            //     q.setY(q.getY() - (170 * Gdx.graphics.getDeltaTime())); // Apply gravity
            // }
            q.move(deltaTime);
            q.jump(deltaTime);
            if(q.shoot() != null){
                activeObjects.add(q.shoot());
            }
            q.draw(batch);
            if(q.getLives() == 0){
                
            }
          //  if(q.shoot().equals(null)){
              //  activeObjects.add(q.shoot());
           // }
        }

        batch.end();

        // --- AP REVIEW: ARRAYLIST TRAVERSAL & REMOVAL ---
        // TODO 7: Write collision logic. 
        // You must iterate through the list to check if the player overlaps with enemies.
        // See the cheat sheet for the overlap method!
        // NOTE: If you are removing items from an ArrayList, how must you structure 
        // your for-loop to avoid skipping elements?
        
        for(int i = activeObjects.size()-1; i >= 0; i--){
            if(activeObjects.get(i) instanceof Bullet){
                for(int j = activeObjects.size()-1; j >= 0 ; j--){
                    if(i != j && !(activeObjects.get(j) instanceof Platform) && activeObjects.get(j).getHitbox().overlaps(activeObjects.get(i).getHitbox())){
                        activeObjects.get(i).setX(100000);
                        activeObjects.get(i).setY(100000);
                        activeObjects.get(j).loseLife();
                        System.out.println(activeObjects.get(j).getLives());
                    }
                }
            }
        }
    }
    
    @Override
    public void dispose() {
        batch.dispose();
    }
}
