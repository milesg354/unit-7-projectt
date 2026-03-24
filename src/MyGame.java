import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import com.badlogic.gdx.Input;

public class MyGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private ArrayList<GameObject> activeObjects;
    Texture backgroundImage;

    @Override
    public void create() {
        
        backgroundImage = new Texture("assets\\background.png");
        batch = new SpriteBatch();
        
        activeObjects = new ArrayList<GameObject>();

        // TODO 3: Instantiate your Player subclass and add it to activeObjects.
        Player playerOne = new Player(50,100);
        activeObjects.add(playerOne);
        Enemy playerTwo = new Enemy(700,100);
        activeObjects.add(playerTwo);
        // TODO 4: Write a for-loop to instantiate 5 Enemy objects at different 
        //         starting Y-coordinates and add them to activeObjects.
        
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
        for(GameObject q : activeObjects){
            // if(q.getY() > 100){
            //     q.setY(q.getY() - (170 * Gdx.graphics.getDeltaTime())); // Apply gravity
            // }
            q.move(deltaTime);
            if(q.getPlayerNum() == 1){
                if(Gdx.input.isKeyPressed(Input.Keys.UP)){
                    for(int i = 0; i < 25; i++){
                        q.setY(q.getY() + 1);
                        q.draw(batch);
                    }
                }
            }
            if(q.getPlayerNum() == 2){
                if(Gdx.input.isKeyPressed(Input.Keys.W)){
                    for(int i = 0; i < 25; i++){
                        q.setY(q.getY() + 1);
                        q.draw(batch);
                    }
                }
            }
            // q.jump(deltaTime);
            q.draw(batch);
        }

        batch.end();

        // --- AP REVIEW: ARRAYLIST TRAVERSAL & REMOVAL ---
        // TODO 7: Write collision logic. 
        // You must iterate through the list to check if the player overlaps with enemies.
        // See the cheat sheet for the overlap method!
        // NOTE: If you are removing items from an ArrayList, how must you structure 
        // your for-loop to avoid skipping elements?

    }
    
    @Override
    public void dispose() {
        batch.dispose();
    }
}