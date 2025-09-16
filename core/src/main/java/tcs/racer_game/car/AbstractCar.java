package tcs.racer_game.car;

public abstract class AbstractCar implements Car{

    protected CarInput carInput;
    protected CarLogic carLogic;
    protected CarRender carRender;
    protected Gearbox carGearbox;

    @Override
    public void input(float delta) {
        carInput.input(delta);
    }

    @Override
    public void logic(float delta) {
        carLogic.logic(delta);
    }

    @Override
    public void draw(float delta) {
        carRender.render(delta);
    }

    @Override
    public Gearbox gearbox() {
        return carGearbox;
    }
}
