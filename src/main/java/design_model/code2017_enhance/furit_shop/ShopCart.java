package design_model.code2017_enhance.furit_shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lx on 2017/9/16.
 */
public class ShopCart {
    List items = new ArrayList<>();

    public void addApple(Apple apple) {
        items.add(apple);
    }

    public void addOrange(Orange orange) {
        items.add(orange);
    }

    /**
     * 此方法在新加一个水果后就要修改
     * @return
     */
    public float calculateTotalPrice() {
        float total = 0.0f;
        for (Object item : items) {
            if (item instanceof Apple) {
                total += ((Apple) item).getPrice();
            }

            if (item instanceof Orange) {
                total += ((Orange) item).getUnitPrice();
            }
        }
        return total;
    }

    /**
     * oo
     * @return
     */
    public float calculateTotalPrice1() {
        float total = 0.0f;
        for (Object item : items) {
            total += ((Furit) item).getPrice();
        }
        return total;
    }
}
