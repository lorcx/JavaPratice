package design_model.code2017_enhance.furit_shop;

/**
 * Created by lx on 2017/9/16.
 */
public class Orange extends Furit{
    public String getName() {
        return "橘子";
    }

    @Override
    float getPrice() {
        return 6.0f;
    }

    public float getUnitPrice() {
        return 6.0f;
    }

}
